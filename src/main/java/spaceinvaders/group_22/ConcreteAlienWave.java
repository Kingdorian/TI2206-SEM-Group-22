package spaceinvaders.group_22;

import java.util.ArrayList;

import spaceinvaders.group_22.unit.Alien;

/**
 * AlienWave class to store the information about an alien wave.
 * @author Dorian and Bryan
 *
 */
@SuppressWarnings("checkstyle:magicnumber") 
public class ConcreteAlienWave implements AlienWave {
	
	/**
	 * List of aliens from this wave.
	 */
	private ArrayList<Alien> aliens = new ArrayList<Alien>();
	
	/**
	 * Speed of the aliens in the X direction in pixels per second.
	 */
	private double alienVelX = 40;
	
	/**
	 * Speed of the aliens in the Y direction in pixels per second.
	 */
	private double alienVelY = 40;
	/**
	 * Amount of pixels the aliens go down per wave.
	 */
	private double alienFall = 10;
	
	/**
	 * Constructor of the alien wave.
	 */
	public ConcreteAlienWave() {
		
	}

	@Override
	public final AlienWave copy() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Returns the Alien velocity in the x direction.
	 * @return the alien velocity in the x direction.
	 */
	public final double getAlienVelX() {
		return alienVelX;
	}
	
	/**
	 * Sets the alien velocity in the x direction.
	 * @param setalienVelX the velocity in the x direction.
	 */
	public final void setAlienVelX(final double setalienVelX) {
		this.alienVelX = setalienVelX;
	}
	
	/**
	 * Returns the alien velocity in the y direction.
	 * @return the alien velocity in the y direction.
	 */
	public final double getAlienVelY() {
		return alienVelY;
	}
	/**
	 * Sets the alien velocity in the y direction.
	 * @param setalienVelY the velocity to set in the y direction.
	 */
	public final void setAlienVelY(final double setalienVelY) {
		this.alienVelY = setalienVelY;
	}
	
	/**
	 * Gets the amount of pixels aliens go down per wave.
	 * @return the amount of pixels aliens go down per wave.
	 */
	public final double getAlienFall() {
		return alienFall;
	}
	/**
	 * Sets the amount of pixels aliens go down per wave.
	 * @param setalienFall the amount of pixels aliens go down per wave to set.
	 */
	public final void setAlienFall(final double setalienFall) {
		this.alienFall = setalienFall;
	}
	@Override
	public final ArrayList<Alien> getAliens() {
		return aliens;
	}
	/**
	 * Sets the aliens in this wave.
	 * @param setaliens to set in this wave.
	 */
	public final void setAliens(final ArrayList<Alien> setaliens) {
		this.aliens = setaliens;
	}

}
