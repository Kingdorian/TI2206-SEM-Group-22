package spaceinvaders.group_22.unit;

/**
 * Class responsible for the creation of Speed Powerups.
 * @author Jochem
 *
 */
public class SpeedPowerupFactory extends AbstractPowerupFactory {

	/**
	 * Constructor for a SpeedPowerupFactory.
	 */
	public SpeedPowerupFactory() {
		super();
	}
	
	@Override
	public final SpeedPowerUpUnit create(final double x, final double y) {
		return new SpeedPowerUpUnit(x, y, "powerup_blue.png");
	}

}
