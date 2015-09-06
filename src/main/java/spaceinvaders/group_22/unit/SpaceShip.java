package spaceinvaders.group_22.unit;

/**
 * A SpaceShip in the game extends Unit.
 * 
 * @author Bryan van Wijk
 */

public class SpaceShip extends Unit {
	
	/**
	 * Creates a SpaceShip.
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 */
	public SpaceShip(final double x, final double y) {
		super(x, y);
	}
	
	/**
	 * Creates a bullet object on the place of the Ship and shoots it upwards.
	 * @param velocity The speed of the Bullet
	 * @return The shot Bullet
	 */
	public final Bullet shootBullet(final int velocity) {
		Bullet bullet = new ShipBullet(this.getXCoor(), this.getYCoor());
		bullet.setVelY(velocity);
		return bullet;

	}
	
	/**
	 * Compares two objects and returns if they are equal.
	 * @return true if both objects are the same.
	 * @param other the object to compare.
	 */
	public final boolean equals(final Object other) {
		if (other != null && other instanceof SpaceShip) {
			return super.equals(other);
		}
		return false;
	}

}
