package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;

/**
 * Interface for an AbstractPowerupFactory.
 * @author Jochem
 *
 */
public abstract class AbstractPowerupFactory {
	
	/**
	 * Constructor for an AbstractPowerupFactory.
	 */
	public AbstractPowerupFactory() {
		Game.getLogger().log(getClass().getName() + "  created succesfully", LogEvent.Type.INFO);
	}
	
	/**
	 * Responsible for the creation of a powerup.
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @return a PowerUpUnit
	 */
	public abstract PowerUpUnit create(final double x, final double y); 

}
