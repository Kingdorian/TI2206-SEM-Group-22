package spaceinvaders.group_22.unit;

/**
 * Interface for an AbstractPowerupFactory.
 * @author Jochem
 *
 */
public interface AbstractPowerupFactory {
	
	/**
	 * Responsible for the creation of a powerup.
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @return a PowerUpUnit
	 */
	PowerUpUnit create(final double x, final double y); 

}
