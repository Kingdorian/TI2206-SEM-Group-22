package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.Player;

/**
 * Shoot power up class extends the power Up class.
 * @author Bryan
 *
 */
public class ShootPowerUpUnit extends PowerUpUnit {
	/**
	 * Indicates the duration of this powerUP in seconds.
	 */
	public static double DURATION = 5.0; 
	/**
	 * Indicates the velocity in the Y direction of this powerup type.
	 */
	public static double VELY = 50.0;
	/**
	 * Creates a shoot power Up.
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @param spriteFile The filename of the sprite.
	 * @param time the time left for this powerUp
	 */
	public ShootPowerUpUnit(final double x, final double y, final String spriteFile, final double time) {
		super(x, y, spriteFile, time);
	}

	@Override
	public final void activate(final Player newplayer) {
		super.setPlayer(newplayer);
		SpaceShip.shootTimes = 2;
	}

	@Override
	public final void deactivate() {
		SpaceShip.shootTimes = 1;
	}

	/**
	 * Compares two objects and returns if they are equal.
	 * @return true if both objects are the same.
	 * @param other the object to compare.
	 */
	@Override
	public final boolean equals(final Object other) {
		if (other != null && other instanceof ShootPowerUpUnit) {
			ShootPowerUpUnit that = (ShootPowerUpUnit) other;
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
