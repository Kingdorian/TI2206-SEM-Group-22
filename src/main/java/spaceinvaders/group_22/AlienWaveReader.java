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
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public final ArrayList<WavePattern> read(final String fileName) throws FileNotFoundException, IOException {
		File dir = new File(fileName);
	    ArrayList<WavePattern> alienWaves = new ArrayList<WavePattern>();
		if(!dir.exists()) {
			Game.getLogger().log("The wave directory:\"" + fileName + "\" does not exist", LogEvent.Type.WARNING);
			return null;
		}else if(dir.listFiles().length==0) {
			Game.getLogger().log("The wave directory:\"" + fileName + "\" is empty", LogEvent.Type.WARNING);
			return null;
		}
		for(final File wave : dir.listFiles()) {
			// Check if file is a wave file.
			String[] nameSplit = wave.getName().split("\\.");
			if (nameSplit[nameSplit.length-1].equals("wave")) {
				alienWaves.add(parseFile(wave));
			}
		}
		return alienWaves;
	}
	
	/**
	 * parses a file and returns Character arraylist accordingly
	 * @return
	 * @throws FileNotFoundException, IOException 
	 */
	public WavePattern parseFile(File wave) throws FileNotFoundException, IOException {
		Game.getLogger().log("Reading wave: " + wave.getName(), LogEvent.Type.DEBUG);
		WavePattern pattern = new WavePattern();
		int lineNum = 0; 
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
			pattern.addRow(lineChars);
			lineNum++;
		}
		bReader.close();
			/**Game.getLogger().log("File:\"" + wave + "\" not found when reading waves", e);
		} catch (IOException e) {
			Game.getLogger().log("Exception occured during reading wave: " + wave.getName() + " on line: " + lineNum, e);
		}*/
		return pattern;
	}

}
