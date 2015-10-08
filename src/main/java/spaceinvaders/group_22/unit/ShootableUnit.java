package spaceinvaders.group_22.unit;
/**
 * Interface for Subclasses of the Unit class that are able to shoot.
 * @author Jochem
 *
 */
public interface ShootableUnit {

	/**
	 * Method implementing shoot functionality.
	 * @param velocity The velocity of the bullet.
	 * @return A bullet object which the unit shoots.
	 */
	Bullet shootBullet(final double velocity);

}
