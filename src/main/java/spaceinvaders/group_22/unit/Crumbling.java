package spaceinvaders.group_22.unit;
/**
 * Interface for units that can crumble down. For example when hit by a bullet.
 * @author dorian
 *
 */
public interface Crumbling {
	/**
	 * Crumbles part of the object from the x and y location where it is hit.
	 * @param x
	 * @param y
	 */
	abstract void crumble(double x, double y);
}
