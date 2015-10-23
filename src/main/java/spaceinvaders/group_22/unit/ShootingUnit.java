package spaceinvaders.group_22.unit;

import java.util.ArrayList;

/**
 * Interface for Subclasses of the Unit class that are able to shoot.
 * @author Jochem
 *
 */
public interface ShootingUnit {

	/**
	 * Method implementing shoot functionality.
	 * @param velocity The velocity of the bullet.
	 * @return A bullet object which the unit shoots.
	 */
	ArrayList<Bullet> shootBullet(final double velocity);

}
