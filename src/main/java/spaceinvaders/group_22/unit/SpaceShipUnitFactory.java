package spaceinvaders.group_22.unit;

/**
 * A Factory responsible for Spaceship related objects.
 * @author Jochem
 *
 */
public class SpaceShipUnitFactory extends AbstractUnitFactory {

	/**
	 * Constructor for a SpaceShipUnitFactory.
	 */
	public SpaceShipUnitFactory() {
		super();
	}
	
	@Override 
	public final SpaceShip createUnit(final double x, final double y) {
		return new SpaceShip(x, y, "spaceship.png");
	}

	@Override 
	public final ShipBullet createBullet(final double x, final double y) {
		return new ShipBullet(x, y, "spaceshipbullet.png");
	}

}
