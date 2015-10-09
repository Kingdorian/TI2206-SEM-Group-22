package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;

/**
 * Class responsible for the creation of Life Powerups.
 * @author Jochem
 *
 */
public class LifePowerupFactory implements AbstractPowerupFactory {

	/**
	 * Constructor for a LifePowerupFactory.
	 */
	public LifePowerupFactory() {
		Logger.getInstance().log(getClass().getName() + "  created succesfully", LogEvent.Type.INFO);
	}
	
	/**
	 * Creates a LifePowerUpUnit on the specified positions.
	 * @return A new LifePowerUpUnit.
	 * @param x The x position.
 	 * @param y The y position.
	 */
	public final LifePowerUpUnit create(final double x, final double y) {
		return new LifePowerUpUnit(x, y, "powerup_red.png");
	}

}
