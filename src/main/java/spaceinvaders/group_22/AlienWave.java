package spaceinvaders.group_22;

import java.util.ArrayList;

import spaceinvaders.group_22.unit.Alien;

/**
 * Interface for an AlienWave.
 * @author Dorian and Bryan
 *
 */
public interface AlienWave {
	/**
	 * Method to create a copy of this alienWave.
	 * @return a copy of this.
	 */
	AlienWave copy();
	/**
	 * Returns the aliens of this wave.
	 * @return arraylist of the aliens of this wave.
	 */
	ArrayList<Alien> getAliens();
	
	

}
