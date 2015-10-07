package spaceinvaders.group_22.unit;

/**
 * Class responsible for the creation of Shoot Powerups.
 * @author Jochem
 *
 */
public class ShootPowerupFactory extends AbstractPowerupFactory {

	/**
	 * Constructor for a ShootPowerupFactory.
	 */
	public ShootPowerupFactory() {
		super();
	}
	
	@Override
	public final ShootPowerUpUnit create(final double x, final double y) {
		return new ShootPowerUpUnit(x, y, "powerup_orange.png");
	}

}
