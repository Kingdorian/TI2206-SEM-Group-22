package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;

/**
 * Class responsible for the creation of Speed Powerups.
 * @author Jochem
 *
 */
public class SpeedPowerupFactory implements AbstractPowerupFactory {

	/**
	 * Constructor for a SpeedPowerupFactory.
	 */
	public SpeedPowerupFactory() {
		Logger.getInstance().log(getClass().getName() + "  created succesfully", LogEvent.Type.INFO);
	}
	
	/**
	 * Creates a SpeedPowerUpUnit on the specified positions.
	 * @return A new SpeedPowerUpUnit.
	 * @param x The x position.
 	 * @param y The y position.
	 */
	public final SpeedPowerUpUnit create(final double x, final double y) {
		return new SpeedPowerUpUnit(x, y, "powerup_blue.png");
	}

}
