package spaceinvaders.group_22.unit;

/**
 * An alienBullet in the game, extends Bullet.
 * 
 * @author Ege de Bruin
 */

public class AlienBullet extends Bullet {

	/**
	 * Creates an AlienBullet.
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @param spriteFile filename of the sprite of this unit.
	 */
	public AlienBullet(final double x, final double y, final String spriteFile) {
		super(x, y, spriteFile);
	}
	/**
	 * Compares two objects and returns if they are equal.
	 * @return true if both objects are the same.
	 * @param other the object to compare.
	 */
	@Override
	public final boolean equals(final Object other) {
		if (other != null && other instanceof AlienBullet) {
			AlienBullet that = (AlienBullet) other;
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
