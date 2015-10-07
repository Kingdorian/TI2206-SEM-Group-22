package spaceinvaders.group_22;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.Alien;

/**
 * Class to read alien wave patterns from a file.
 * @author Dorian and Bryan
 *
 */
public class AlienWaveReader {
	
	/**
	 * Constructor of the alien wave reader.
	 */
	public AlienWaveReader() {
		
	}
	
	
	/**
	 * Method for reading the alienwaves from a file.
	 * @param fileName location to read from.
	 * @return arraylist of read alienwaves.
	 */
	public static final ArrayList<ArrayList<ArrayList<Character>>> 	read(final String fileName) {
		File dir = new File(fileName);
	    ArrayList<ArrayList<ArrayList<Character>>> alienWaves = new ArrayList<ArrayList<ArrayList<Character>>>();
		if(dir == null) {
			Game.getLogger().log("The wave directory:\"" + fileName + "\" is not found", LogEvent.Type.WARNING);
			return null;
		}
		for(final File wave : dir.listFiles()) {
			// Check if file is a wave file.
			String[] nameSplit = wave.getName().split(".");
			if (nameSplit[nameSplit.length-1].equals("wave")) {
				alienWaves.add(parseFile(wave));
			}
		}
		return alienWaves;
	}
	
	/**
	 * parses a file and returns Character arraylist accordingly
	 * @return
	 */
	private static ArrayList<ArrayList<Character>> parseFile(File wave) {
		Game.getLogger().log("Reading wave: " + wave.getName(), LogEvent.Type.DEBUG);
		ArrayList<ArrayList<Character>> charList = new ArrayList<ArrayList<Character>>();
		int lineNum = 0; 
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(wave));
			String line;
			//Keep track of current line num (For debugging purposes)
			while ((line = bReader.readLine()) != null){
				ArrayList<Character> lineChars = new ArrayList<Character>();
				// Convert from Array to ArrayList 
				//(We cannot use the standard method because the ArrayList uses the Character wrapper class)
				for(char c : line.toCharArray()) {
					lineChars.add(c);
				}
				charList.add(lineChars);
 				lineNum++;
			}
			bReader.close();
		} catch (FileNotFoundException e) {
			Game.getLogger().log("File:\"" + wave + "\" not found when reading waves", e);
		} catch (IOException e) {
			Game.getLogger().log("Exception occured during reading wave: " + wave.getName() + " on line: " + lineNum, e);
		}
		return charList;
	}

}
