package spaceinvaders.group_22.wave;

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
	/**
	 * Returns the alien vel x of this wave.
	 * @return the alien velocity in the x direction.
	 */
	double getAlienVelX();
	/**
	 * returns the alien velocity in the y direction.
	 * @return the alien velocity in the y direction.
	 */
	double getAlienVelY();
	/**
	 * Returns the amount of pixels aliens go down per wave.
	 * @return the amount of pixels aliens go down per wave.
	 */
	double getAlienFall();
	/**
	 * Sets the alien velocity in the x direction.
	 * @param d velocity in the x direction.
	 */
	void setAlienVelX(double d);
	/**
	 * Sets the aliens of this wave.
	 * @param aliens list of the aliens of this wave.
	 */
	void setAliens(ArrayList<ArrayList<Alien>> aliens);
	/**
	 * Sets aliens in a specific row of the alienwave.
	 * @param rowIndex the index of the row to set the given row to
	 * @param row the new row to set the row at the index to
	 */
	void setAlienRow(int rowIndex, ArrayList<Alien> row);
	/**
	 * Adds a row of aliens to the alienwave.
	 * @param row the row to add to this wave.
	 */
	void addAlienRow(ArrayList<Alien> row);
	/**
	 * Removes alien from wave.
	 * @param alien the alien to remove from this wave.
	 */
	void remove(Alien alien);
	
}
