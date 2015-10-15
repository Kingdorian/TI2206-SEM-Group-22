package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.Player;
import spaceinvaders.group_22.unit.ShipBullet;

/**
 * A SpaceShip in the game extends Unit.
 * 
 * @author Bryan van Wijk
 * @author Dorian
 */
@SuppressWarnings("checkstyle:magicnumber") 
public class SpaceShip extends Unit implements MovableUnit {
	/**
	 * VelX is the velocity in the X direction in pixels per second.
	 */
	private double velX = 0.0;
	
	/**
	 * velY is the velocity in the Y direction in pixels per second.
	 */
	private double velY = 0.0;
	
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
	 * Explosion if this spaceship is exploding.
	 */
	private Explosion explosion = null;
	
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
	 * @param velocity The speed of the Bullet
	 * @param player 
	 * @return The shot Bullet
	 */
	public final ShipBullet shootBullet(final double velocity, final Player player) {
		ShipBullet bullet = new ShipBullet(this.getXCoor(), this.getYCoor(), "spaceshipbullet.png");
		bullet.setPlayer(player);
		bullet.setVelY(velocity);
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
			return super.equals(other)
					&& this.getVelX() == that.getVelX()
					&& this.getVelY() == that.getVelY();
		}
		return false;
	}
	/**
	 * HashCode method.
	 * @return hashcode of this object
	 */
	@SuppressWarnings({"checkstyle:magicnumber", "checkstyle:designforextension"})
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(velX);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(velY);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	/**
	 * Move the unit in the direction of this unit and with his velocity.
	 * @param tickrate The rate at which the game ticks.
	 */
	public final void move(final double tickrate) {
		setXCoor(this.getXCoor() + (this.getVelX() * tickrate));
		setYCoor(this.getYCoor() + (this.getVelY() * tickrate));
	}	
	/**
	 * Returns the current velocity in the X direction.
	 * @return the current velocity in the X direction in pixels per second.
	 */
	public final double getVelX() {
		return velX;
	}
	
	/**
	 * Sets the current velocity in the X direction.
	 * @param newvelX the velocity in the X direction to set in pixels per second.
	 */
	public final void setVelX(final double newvelX) {
		this.velX = newvelX;
	}
	
	/**
	 * Returns the current velocity in the Y direction.
	 * @return the current velocity in the Y direction in pixels per second.
	 */
	public final double getVelY() {
		return velY;
	}
	
	/**
	 * Sets the current velocity in the Y direction.
	 * @param alienVelY the velocity in the Y direction to set in pixels per second.
	 */
	public final void setVelY(final double alienVelY) {
		this.velY = alienVelY;
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
	/**
	 * 
	 * @param newExplosion to set.
	 */
	public final void setExplosion(final Explosion newExplosion) {
		explosion = newExplosion;
	}
	/**
	 * Returns the explosion if this spaceship is exploding.
	 * @return null if there is no explosion.
	 */
	public final Explosion getExplosion() {
		return explosion;
	}
}
