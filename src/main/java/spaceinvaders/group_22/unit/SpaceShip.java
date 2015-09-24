package spaceinvaders.group_22.unit;

/**
 * A SpaceShip in the game extends Unit.
 * 
 * @author Bryan van Wijk
 */

@SuppressWarnings("checkstyle:magicnumber")
public class SpaceShip extends Unit {
	
	
	/**
	 * Indicates the max speed at which a spaceship can travel.
	 */
	private static double maxVelx;
	
	/**
	 * The default speed at which a spaceship can travel.
	 */
	private static double defaultVel = 250; 
	
	/**
	 * The default speed at which a spaceship can travel.
	 */
	private static double defaultShootSpeed = 1; 
	
	/**
	 * A multiplier for the velocity used by powerups.
	 */
	private double velMultiplier = 1.0;
	
	/**
	 * A multiplier for the shooting speed used by powerups.
	 */
	private double shootingMultiplier = 1.0;
	
	/**
	 * Times allowed to shoot per second.
	 */
	private static double shootTimes;
	/**
	 * Creates a SpaceShip.
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @param spriteFile filename of the sprite of this unit.
	 */
	public SpaceShip(final double x, final double y, final String spriteFile) {
		super(x, y, spriteFile);
		setShootTimes(defaultShootSpeed * shootingMultiplier);
		setMAXVELX(defaultVel * velMultiplier);
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
	 * Updates spaceship attributes by multiplying with the multiplier.
	 */
	public final void updateMultiplier() {
		setShootTimes((int) (defaultShootSpeed * shootingMultiplier));
		setMAXVELX((int) (defaultVel * velMultiplier));
	}
	
	/**
	 * Changes the multiplier of the velocity.
	 * @param newMultiplier The new velocity multiplier.
	 */
	public final void setVelMultiplier(final double newMultiplier) {
		this.velMultiplier = newMultiplier;
	}
	
	/**
	 * returns the multiplier of the velocity.
	 * @return The velocity multiplier.
	 */
	public final double getVelMultiplier() {
		return velMultiplier;
	}
	
	/**
	 * Changes the multiplier of the shooting speed.
	 * @param newMultiplier The new shootin speed multiplier.
	 */
	public final void setShootingMultiplier(final double newMultiplier) {
		this.shootingMultiplier = newMultiplier;
	}
	
	/**
	 * returns the multiplier of the shooting.
	 * @return The velocity multiplier.
	 */
	public final double getShootingMultiplier() {
		return shootingMultiplier;
	}
	
	
	/**
	 * Compares two objects and returns if they are equal.
	 * @return true if both objects are the same.
	 * @param other the object to compare.
	 */
	@Override
	public final boolean equals(final Object other) {
		if (other != null && other instanceof SpaceShip) {
			SpaceShip that = (SpaceShip) other;
			return this.getXCoor() == that.getXCoor()
					&& this.getYCoor() == that.getYCoor()
					&& this.getVelX() == that.getVelX()
					&& this.getVelY() == that.getVelY()
					&& this.getHeight() == that.getHeight()
					&& this.getWidth() == that.getWidth();
		}
		return false;
	}
	/**
	 * HashCode method.
	 * @return hashcode of this object
	 */
	public final int hashCode() {
		  return 0;
	}

	/**
	 * Get the shooting speed.
	 * @return the shooting speed.
	 */
	public static double getShootTimes() {
		return shootTimes;
	}

	/**
	 * Set the shooting speed.
	 * @param newShootTimes the new shooting speed.
	 */
	public static void setShootTimes(final double newShootTimes) {
		SpaceShip.shootTimes = newShootTimes;
	}

	/**
	 * Get the maximum movement speed.
	 * @return the maximum movement speed.
	 */
	public static double getMAXVELX() {
		return maxVelx;
	}

	/**
	 * Set the maximum movement speed.
	 * @param newMaxvel the new maximum movement speed.
	 */
	public static void setMAXVELX(final double newMaxvel) {
		maxVelx = newMaxvel;
	}
}
