package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.Player;

/**
 * Life powerup class which extends the abstact powerup class.
 * @author Bryan
 */
public class LifePowerUp extends PowerUp {
	
	/**
	 * Indicates the velocity in the Y direction of this powerup type.
	 */
	public static double VELY = 50.0;
	
	/**
	 * Creates a life power Up.
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @param spriteFile The filename of the sprite.
	 * @param time the time left for this powerUp
	 */
	public LifePowerUp(final double x, final double y, final String spriteFile, final double time) {
		super(x, y, spriteFile, 0);
	}

	/**
	 * Compares two objects and returns if they are equal.
	 * @return true if both objects are the same.
	 * @param other the object to compare.
	 */
	@Override
	public final boolean equals(final Object other) {
		if (other != null && other instanceof LifePowerUp) {
			LifePowerUp that = (LifePowerUp) other;
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
		super.setPlayer(newplayer);
		newplayer.addLife();
	}

	@Override
	public final void deactivate() {
		
	}
}
