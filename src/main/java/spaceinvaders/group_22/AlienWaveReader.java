package spaceinvaders.group_22;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
	public static final ArrayList<AlienWave> read(final String fileName, final AlienWaveFactory aWaveFac) {
		ArrayList<AlienWave> alienWaves = new ArrayList<AlienWave>();
		int curLine = 0;
		AlienWave wave = aWaveFac.createWave();
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(fileName));
			// Keep track of current line number (For debugging purposes)
			String line;
			while ((line = bReader.readLine()) != null){
				curLine++;
				//Processing the line
				if(line == "---") {
					alienWaves.add(wave);
					wave = aWaveFac.createWave();
				} else {
					//TODO Do this in a cleaner way.
					wave.getAliens().addAll(processLine());
				}
			}
		}catch(FileNotFoundException e){
			Game.getLogger().log("File:\"" + fileName + "\" not found", e);
		}catch(IOException e){
			Game.getLogger().log("Error reading line " + curLine, e);
		}
		return alienWaves;
	}
	
	/**
	 * Parses a line and creates corresponding aliens.
	 * @return
	 */
	private static ArrayList<Alien> processLine() {
		// TODO Auto-generated method stub
		return null;
	}

}
