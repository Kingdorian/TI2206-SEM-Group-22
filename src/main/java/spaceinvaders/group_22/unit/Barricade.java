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
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Barricade other = (Barricade) obj;
		if (health != other.health) {
			return false;
		}
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + health;
		return result;
	}
	

}
