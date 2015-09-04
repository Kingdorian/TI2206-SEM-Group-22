package group22.space_invaders.unit;

/**
 * A bullet in the game, extends Unit.
 * @author Ege de Bruin
 */

public abstract class Bullet extends Unit {

	/**
	 * Creates a Bullet.
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 */
	public Bullet(final double x, final double y) {
		super(x, y);
	}

}
