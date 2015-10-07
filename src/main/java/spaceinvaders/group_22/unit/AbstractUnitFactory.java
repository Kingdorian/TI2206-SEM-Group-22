package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;

/**
 * Class defining an Abstract Unit Factory.
 * @author Jochem
 *
 */
public abstract class AbstractUnitFactory {
	
	/**
	 * Abstract Constructor for a Unit Factory.
	 */
	public AbstractUnitFactory() {
		Game.getLogger().log(getClass().getName() + "  created succesfully", LogEvent.Type.INFO);
	}
	
	/**
	 * Abstract method. A subclass implementing this, 
	 * should return a SpaceShip, or an Alien depending on the factory type.
	 * @param x X Coordinate.
	 * @param y Y Coordinate.
	 * @return A Spaceship or an Alien.
	 */
	public abstract Unit createUnit(final double x, final double y);
	
	/**
	 * Abstract method. A subclass implementing this, 
	 * should return the bullet corresponding to the factory type.
	 * @param x X Coordinate.
	 * @param y Y Coordinate.
	 * @return A ShipBullet or an AlienBullet.
	 */
	public abstract Unit createBullet(final double x, final double y);
	
}
