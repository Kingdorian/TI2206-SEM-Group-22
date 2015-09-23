package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.Player;
/**
 * Speed power Up class which extends the Power Up class.
 * @author Bryan
 */
public class SpeedPowerUpUnit extends PowerUpUnit {
	
	/**
	 * Indicates the duration of this powerUP in seconds.
	 */
	public static double DURATION = 5.0; 
	/**
	 * Indicates the velocity in the Y direction of this powerup type.
	 */
	public static double VELY = 50.0;
	
	/**
	 * Creates a speed power Up.
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @param spriteFile The filename of the sprite.
	 * @param time the time left for this powerUp
	 */
	public SpeedPowerUpUnit(final double x, final double y, final String spriteFile, final double time) {
		super(x, y, spriteFile, time);
	}

	@Override
	@SuppressWarnings("checkstyle:magicnumber")
	public final void activate(final Player newplayer) {
		super.setPlayer(newplayer);
		SpaceShip.MAXVELX = 750;
	}

	@Override
	@SuppressWarnings("checkstyle:magicnumber")
	public final void deactivate() {
		SpaceShip.MAXVELX = 250;
	}

	/**
	 * Compares two objects and returns if they are equal.
	 * @return true if both objects are the same.
	 * @param other the object to compare.
	 */
	@Override
	public final boolean equals(final Object other) {
		if (other != null && other instanceof SpeedPowerUpUnit) {
			SpeedPowerUpUnit that = (SpeedPowerUpUnit) other;
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
