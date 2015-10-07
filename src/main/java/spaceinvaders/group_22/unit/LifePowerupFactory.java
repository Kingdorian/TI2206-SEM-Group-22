package spaceinvaders.group_22.unit;

/**
 * Class responsible for the creation of Life Powerups.
 * @author Jochem
 *
 */
public class LifePowerupFactory extends AbstractPowerupFactory {

	/**
	 * Constructor for a LifePowerupFactory.
	 */
	public LifePowerupFactory() {
		super();
	}
	
	@Override
	public final LifePowerUpUnit create(final double x, final double y) {
		return new LifePowerUpUnit(x, y, "powerup_red.png");
	}

}
