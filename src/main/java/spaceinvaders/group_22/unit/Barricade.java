package spaceinvaders.group_22.unit;
/**
 * Class for the baricade units that protect the player.
 * @author dorian
 *
 */
public class Barricade extends Unit {
	/**
	 * Var that keeps track of damage taken by this barricade.
	 */
	private int health;
	/**
	 * Creates new Barricade object.
	 * @param x X-coordinate of the barricade
	 * @param y Y-coordinate of the barricade
	 * @param spriteFile 
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	public Barricade(final double x, final double y, final String spriteFile) {
		super(x, y, spriteFile);
		health = 10;
	}
	/**
	 * When barricade is hit decrease health. 
	 */
	public final void hit() {
		health--;
	}
	/**
	 * Return the amount of health the barricade has left.
	 * @return amount of health the barricade has left.
	 */
	public final int getHealth() {
		return health;
	}
	/**
	 * Compares two objects and returns if they are equal.
	 * @return true if both objects are the same.
	 * @param other the object to compare.
	 */
	@Override
	public final boolean equals(final Object other) {
		if (other != null && other instanceof Barricade) {
			Barricade that = (Barricade) other;
			return this.getXCoor() == that.getXCoor()
					&& this.getYCoor() == that.getYCoor()
					&& this.getVelX() == that.getVelX()
					&& this.getVelY() == that.getVelY()
					&& this.getHeight() == that.getHeight()
					&& this.getWidth() == that.getWidth()
					&& this.getHealth() == that.getHealth();
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
