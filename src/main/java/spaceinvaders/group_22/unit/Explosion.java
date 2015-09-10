package spaceinvaders.group_22.unit;

/**
 * An Explosion in the game, extends Unit.
 * @author Jochem
 */

public class Explosion extends Unit {
	
	/**
	 * Counts the amount of cycles the explosion has been drawn.
	 */
	private int counter;

	/**
	 * Creates an Explosion.
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @param spriteFile filename of the sprite of this unit.
	 */
	@SuppressWarnings("checkstyle:magicnumber")    
	public Explosion(final double x, final double y, final String spriteFile) {
		super(x, y, spriteFile);
	}
	
	/**
	 * Increases the cycle counter with 1.
	 */
	public final void increaseCounter() {
		this.counter += 1;
	}
	
	/**
	 * Gets the counter value.
	 * @return The value of the counter.
	 */
	public final int getCounter() {
		return counter;
	}

	/**
	 * Compares two objects and returns if they are equal.
	 * @return true if both objects are the same.
	 * @param other the object to compare.
	 */
	@Override
	public final boolean equals(final Object other) {
		if (other != null && other instanceof Explosion) {
			Explosion that = (Explosion) other;
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
