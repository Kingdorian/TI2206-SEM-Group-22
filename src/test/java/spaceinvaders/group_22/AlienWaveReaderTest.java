package spaceinvaders.group_22;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlienWaveReaderTest {
	
	private AlienWaveReader waveReader;
	
	@Before
	public void init() {
		// We need the logger
		Game game = new SinglePlayerGame(10.0, 10.0);
		waveReader = new AlienWaveReader();
	}
	@Test
	public void testReadEmptyFile() throws FileNotFoundException, IOException{
		String sep = System.getProperty("file.separator");
		File file = new File("src" + sep	+ "main" + sep + "resources" + sep
				+ "spaceinvaders" +  sep + "group_22" + sep	+ "testwaves" + sep + "emptytestwave.wave");
		ArrayListWavePattern pattern =  waveReader.parseFile(file);
		Assert.assertEquals(0, pattern.size());
	}
	@Test
	public void testReadOneLineFile() throws FileNotFoundException, IOException {
		String sep = System.getProperty("file.separator");
		File file = new File("src" + sep	+ "main" + sep + "resources" + sep
				+ "spaceinvaders" +  sep + "group_22" + sep	+ "testwaves" + sep + "oneline.wave");
		ArrayListWavePattern pattern = waveReader.parseFile(file);
		ArrayListWavePattern expectedPattern = new ArrayListWavePattern();
		ArrayList<Character> tempList = new ArrayList<Character>();
		tempList.add('*');
		tempList.add('&');
		expectedPattern.addRow(tempList);
		Assert.assertEquals(expectedPattern, pattern);
	}
	@Test
	public void testReadMultiLineFile() throws FileNotFoundException, IOException {
		String sep = System.getProperty("file.separator");
		File file = new File("src" + sep	+ "main" + sep + "resources" + sep
				+ "spaceinvaders" +  sep + "group_22" + sep	+ "testwaves" + sep + "multiline.wave");
		ArrayListWavePattern pattern = waveReader.parseFile(file);
		ArrayListWavePattern expectedPattern = new ArrayListWavePattern();
		char[] chars = {'*', '&'};
		expectedPattern.addRow(chars);
		char[] chars2 = {'^', '*'};
		expectedPattern.addRow(chars2);
		Assert.assertEquals(expectedPattern, pattern);
	}
	@Test(expected = FileNotFoundException.class)  
	public void testTriggerFileNotFound() throws FileNotFoundException, IOException {
		String sep = System.getProperty("file.separator");
		File file = new File("src" + sep	+ "main" + sep + "resources" + sep
				+ "spaceinvaders" +  sep + "group_22" + sep	+ "testwaves" + sep + "notExistingFile.wave");
		waveReader.parseFile(file);
	}
	@Test
	public void testReadMultipleFiles() throws  FileNotFoundException, IOException {
		String sep = System.getProperty("file.separator");
		String file = "src" + sep	+ "main" + sep + "resources" + sep
				+ "spaceinvaders" +  sep + "group_22" + sep	+ "testwaves" + sep + "2testfiles" + sep;
		ArrayList<WavePattern> charPatterns = waveReader.read(file);
		ArrayList<WavePattern> expectedPatterns = new ArrayList<WavePattern>();
		ArrayListWavePattern expectedFile1 = new ArrayListWavePattern();
		ArrayList<Character> expectedLine1 = new ArrayList<Character>();
		expectedLine1.add('*');
		expectedLine1.add('+');
		expectedFile1.addRow(expectedLine1);
		expectedPatterns.add(expectedFile1);
		ArrayListWavePattern expectedFile2 = new ArrayListWavePattern();
		ArrayList<Character> expectedLine2 = new ArrayList<Character>();
		expectedLine2.add('x');
		expectedLine2.add('u');
		expectedFile2.addRow(expectedLine2);
		ArrayList<Character> expectedLine3 = new ArrayList<Character>();
		expectedLine3.add('^');
		expectedLine3.add('%');
		expectedFile2.addRow(expectedLine3);
		expectedPatterns.add(expectedFile2);
		ArrayList<ArrayListWavePattern> otherExpPattern = new ArrayList<ArrayListWavePattern>();
		otherExpPattern.add(expectedFile2);
		otherExpPattern.add(expectedFile1);
		assertTrue(expectedPatterns.equals(waveReader.read(file))||otherExpPattern.equals(waveReader.read(file)));
		
	}

}
