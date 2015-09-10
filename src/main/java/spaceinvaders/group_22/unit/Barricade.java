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
	/**
	 * Return the amount of health the barricade has left.
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * Checks if the provided object equeals this Barricade.
	 * @param the object to compare to.
	 * @return true if the both objects are thesame.
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Barricade that = (Barricade)obj;
		if(this.getXCoor() == that.getXCoor()
					&& this.getYCoor() == that.getYCoor()
					&& this.getVelX() == that.getVelX()
					&& this.getVelY() == that.getVelY()
					&& this.getHeight() == that.getHeight()
					&& this.getWidth() == that.getWidth()){
				if (health != that.health){
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
