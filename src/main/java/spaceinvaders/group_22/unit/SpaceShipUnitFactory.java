package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;

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
		Game.getLogger().log(getClass().getName() + "  created succesfully", LogEvent.Type.INFO);
	}
	
	@Override 
	public final Unit createUnit(final double x, final double y) {
		return new SpaceShip(x, y, "spaceship.png");
	}

	@Override 
	public final Unit createBullet(final double x, final double y) {
		return new ShipBullet(x, y, "spaceshipbullet.png");
	}

}
