package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.Player;
import spaceinvaders.group_22.ui.SpriteLoader;

/**
 * Life powerup class which extends the abstact powerup class.
 * @author Bryan
 */
public class LifePowerUpUnit extends PowerUpUnit {
	
	/**
	 * Indicates the velocity in the Y direction of this powerup type.
	 */
	private static final double MAXVELY = 50.0;
	
	/**
	 * Creates a life power Up.
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public LifePowerUpUnit(final double x, final double y) {
		super(x, y);
	}

	/**
	 * Compares two objects and returns if they are equal.
	 * @return true if both objects are the same.
	 * @param other the object to compare.
	 */
	@Override
	public final boolean equals(final Object other) {
		if (other != null && other instanceof LifePowerUpUnit) {
			LifePowerUpUnit that = (LifePowerUpUnit) other;
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

	@Override
	public final void activate(final Player newplayer) {
		newplayer.addLife();

	}

	/**
	 * Returns the velocity in the Y direction.
	 * @return The velocity in the Y direction.
	 */
	public static double getMaxVely() {
		return MAXVELY;
	}
	
	/**
	 * Sets the right sprite image.
	 */
	public final void setSpriteImage() {
		setSprite(SpriteLoader.getInstance().getLifePowerUp());
	}
}
