package spaceinvaders.group_22;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlienWaveReaderTest {
	
	private AlienWaveReader waveReader;
	
	@Before
	public void init() {
		// We need the logger
		Game game = new Game(10.0, 10.0);
		waveReader = new AlienWaveReader();
	}
	@Test
	public void testReadEmptyFile() {
		System.getProperty("file.separator");
		String sep = System.getProperty("file.separator");
		File file = new File("src" + sep	+ "main" + sep + "resources" + sep
				+ "spaceinvaders" +  sep + "group_22" + sep	+ "testwaves" + sep + "emptytestwave.wave");
		ArrayList<ArrayList<Character>> charList = waveReader.parseFile(file);
		Assert.assertTrue(charList.isEmpty());
	}
	@Test
	public void testReadOneLineFile() {
		System.getProperty("file.separator");
		String sep = System.getProperty("file.separator");
		File file = new File("src" + sep	+ "main" + sep + "resources" + sep
				+ "spaceinvaders" +  sep + "group_22" + sep	+ "testwaves" + sep + "oneline.wave");
		ArrayList<ArrayList<Character>> charList = waveReader.parseFile(file);
		ArrayList<ArrayList<Character>> expectedList = new ArrayList<ArrayList<Character>>();
		ArrayList<Character> tempList = new ArrayList<Character>();
		tempList.add('*');
		tempList.add('&');
		expectedList.add(tempList);
		Assert.assertEquals(expectedList, charList);
	}

}
