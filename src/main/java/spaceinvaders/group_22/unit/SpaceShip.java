package spaceinvaders.group_22.unit;

/**
 * A SpaceShip in the game extends Unit.
 * 
 * @author Bryan van Wijk
 */

public class SpaceShip extends Unit {
	
	
	/**
	 * Indicates the max speed at which a spaceship can travel.
	 */
	public static final int maxVelX = 250; 
	/**
	 * Creates a SpaceShip.
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @param spriteFile filename of the sprite of this unit.
	 */
	public SpaceShip(final double x, final double y, final String spriteFile) {
		super(x, y, spriteFile);
	}
	
	/**
	 * Creates a bullet object on the place of the Ship and shoots it upwards.
	 * @param spaceShipBulletVelX The speed of the Bullet
	 * @return The shot Bullet
	 */
	public final Bullet shootBullet(final double spaceShipBulletVelX) {
		Bullet bullet = new ShipBullet(this.getXCoor(), this.getYCoor(), "spaceshipbullet.png");
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
