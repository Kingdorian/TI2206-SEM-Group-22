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
	 * @param width The width of the sprite.
	 * @param height The height of the sprite.
	 */
	public SpaceShip(final double x, final double y, final int width, final int height) {
		super(x, y);
		this.setWidth(width);
		this.setHeight(height);
	}
	
	/**
	 * Creates a bullet object on the place of the Ship and shoots it upwards.
	 * @param spaceShipBulletVelX The speed of the Bullet
	 * @return The shot Bullet
	 */
	public final Bullet shootBullet(final double spaceShipBulletVelX) {
		Bullet bullet = new ShipBullet(this.getXCoor(), this.getYCoor());
		bullet.setVelY(spaceShipBulletVelX);
		return bullet;

	}
	
	/**
	 * Compares two objects and returns if they are equal.
	 * @return true if both objects are the same.
	 * @param other the object to compare.
	 */
	@Override
	public final boolean equals(final Object other) {
		if (other != null && other instanceof SpaceShip) {
			return super.equals(other);
		}
		return false;
	}

}
