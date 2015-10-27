package spaceinvaders.group_22.wave;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import spaceinvaders.group_22.ui.JavaFXThreadingRule;
import spaceinvaders.group_22.wave.AlienWaveReader;
import spaceinvaders.group_22.wave.ArrayListWavePattern;
import spaceinvaders.group_22.wave.WavePattern;
/**
 * Test the Alien wave reader.
 * @author Dorian
 *
 */
public class AlienWaveReaderTest {
	/**
	 * Alien Wave Reader object used for testing.
	 */
	private AlienWaveReader waveReader;
	
	/**
	 * Class specifying rule to test JavaFX from GitHub.
	 */
	@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
	/**
	 * Setup the reader for testing.
	 */
	@Before
	public final void init() {
		// We need the logger
		waveReader = new AlienWaveReader();
	}
	/**
	 * Test the read method for an empty file.
	 * @throws FileNotFoundException when file not found.
	 * @throws IOException when exception is thrown.
	 */
	@Test
	public final void testReadEmptyFile() throws FileNotFoundException, IOException {
		String sep = System.getProperty("file.separator");
		File file = new File("src" + sep	+ "main" + sep + "resources" + sep
				+ "spaceinvaders" +  sep + "group_22" + sep	+ "testwaves" + sep + "emptytestwave.wave");
		ArrayListWavePattern pattern =  waveReader.parseFile(file);
		Assert.assertEquals(0, pattern.size());
	}
	/**
	 * Test the read method for only one line.
	 * @throws FileNotFoundException  When the file is not found.
	 * @throws IOException thrown when file can't be read.
	 */
	@Test
	public final void testReadOneLineFile() throws FileNotFoundException, IOException {
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
	/**
	 * Test the read method for multiple lines.
	 * @throws FileNotFoundException  When the file is not found.
	 * @throws IOException thrown when file can't be read.
	 */
	@Test
	public final void testReadMultiLineFile() throws FileNotFoundException, IOException {
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
	/**
	 * Test the read method when the file is not found.
	 * @throws FileNotFoundException  When the file is not found.
	 * @throws IOException thrown when file can't be read.
	 */
	@Test(expected = FileNotFoundException.class)  
	public final void testTriggerFileNotFound() throws FileNotFoundException, IOException {
		String sep = System.getProperty("file.separator");
		File file = new File("src" + sep	+ "main" + sep + "resources" + sep
				+ "spaceinvaders" +  sep + "group_22" + sep	+ "testwaves" + sep + "notExistingFile.wave");
		waveReader.parseFile(file);
	}
	/**
	 * Test the read method for multiple files.
	 * @throws FileNotFoundException  When the file is not found.
	 * @throws IOException thrown when file can't be read.
	 */
	@Test
	public final void testReadMultipleFiles() throws  FileNotFoundException, IOException {
		String sep = System.getProperty("file.separator");
		String file = "src" + sep	+ "main" + sep + "resources" + sep
				+ "spaceinvaders" +  sep + "group_22" + sep	+ "testwaves" + sep + "2testfiles" + sep;
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
		assertTrue(expectedPatterns.equals(waveReader.read(file)) || otherExpPattern.equals(waveReader.read(file)));		
	}
}
