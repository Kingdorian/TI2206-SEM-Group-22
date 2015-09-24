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
	public static double MAXVELX;
	
	/**
	 * The default speed at which a spaceship can travel.
	 */
	public static double defaultVel = 250; 
	
	/**
	 * The default speed at which a spaceship can travel.
	 */
	public static double defaultShootSpeed = 1; 
	
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
	public static double shootTimes;
	/**
	 * Creates a SpaceShip.
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @param spriteFile filename of the sprite of this unit.
	 */
	public SpaceShip(final double x, final double y, final String spriteFile) {
		super(x, y, spriteFile);
		shootTimes = defaultShootSpeed * shootingMultiplier;
		MAXVELX = defaultVel * velMultiplier;
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
		shootTimes = (int) (defaultShootSpeed * shootingMultiplier);
		MAXVELX = (int) (defaultVel * velMultiplier);
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
}
