package spaceinvaders.group_22.unit;
/**
 * Class for the baricade units that protect the player
 * @author dorian
 *
 */
public class Barricade extends Unit{
	/**
	 * Var that keeps track of damage taken by this barricade.
	 */
	private int health;
	/**
	 * Creates new Barricade object
	 * @param x X-coordinate of the barricade
	 * @param y Y-coordinate of the barricade
	 * @param spriteFile 
	 */
	public Barricade(double x, double y, String spriteFile) {
		super(x, y, spriteFile);
		health = 10;
	}
	/**
	 * When barricade is hit decrease health. 
	 */
	public void hit() {
		health--;
	}

}
