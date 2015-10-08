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
	 * @throws Exception 
	 */
	AlienWave createWave();
}
