package spaceinvaders.group_22;

import java.util.ArrayList;

/**
 * Interface for creating an alienWave.
 * @author Dorian and Bryan
 *
 */

public interface AlienWaveFactoryInterface {
	/**
	 * Method to create a list of alienwaves.
	 * @return new Alienwave
	 */
	ArrayList<AlienWave> createWaves();
	/**
	 * Method to create a default alienwave.
	 * @return new default alienwave Alienwave
	 */
	AlienWave createDefaultWave();
	/**
	 * Method to create a default alienwave.
	 * @return new default alienwave Alienwave
	 */
	AlienWave createWaveFromPattern(WavePattern w);
}
