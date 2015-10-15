package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;

/**
 * Class responsible for the creation of Shoot Powerups.
 * @author Jochem
 *
 */
public class ShootPowerupFactory implements AbstractPowerupFactory {

	/**
	 * Constructor for a ShootPowerupFactory.
	 */
	public ShootPowerupFactory() {
		Logger.getInstance().log(getClass().getName() + "  created succesfully", LogEvent.Type.INFO);
	}
	
	/**
	 * Creates a ShootPowerUpUnit on the specified positions.
	 * @return A new ShootPowerUpUnit.
	 * @param x The x position.
 	 * @param y The y position.
	 */
	public final ShootPowerUpUnit create(final double x, final double y) {
		return new ShootPowerUpUnit(x, y);
	}

}
