package spaceinvaders.group_22.unit;
/**
 * Class for the baricade units that protect the player.
 * @author dorian
 *
 */

@SuppressWarnings("checkstyle:magicnumber")
public class Barricade extends Unit {
	/**
	 * Var that keeps track of damage taken by this barricade.
	 */
	private int health  = 10;
	/**
	 * Creates new Barricade object.
	 * @param x X-coordinate of the barricade
	 * @param y Y-coordinate of the barricade
	 * @param spriteFile 
	 */
	public Barricade(final double x, final double y, final String spriteFile) {
		super(x, y, spriteFile);
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
	 * Checks if the provided object equeals this Barricade.
	 * @param obj the object to compare to.
	 * @return true if the both objects are thesame.
	 */
	public final boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Barricade that = (Barricade) obj;
		if (this.getXCoor() == that.getXCoor()
					&& this.getYCoor() == that.getYCoor()
					&& this.getVelX() == that.getVelX()
					&& this.getVelY() == that.getVelY()
					&& this.getHeight() == that.getHeight()
					&& this.getWidth() == that.getWidth()) {
				if (health != that.health) {
					return false;
				}
				return true;
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
