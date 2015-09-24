package spaceinvaders.group_22.unit;

/**
 * An alienBullet in the game, extends Bullet.
 * @author Ege de Bruin
 */

public class ShipBullet extends Bullet {

	/**
	 * Creates a ShipBullet.
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @param spriteFile filename of the sprite of this unit.
	 */
	public ShipBullet(final double x, final double y, final String spriteFile) {
		super(x, y, spriteFile);
	}
	
	/**
	 * Checks if provided object is equal to this object.
	 * @param the object to compare this object to
	 * @return boolean result if provide object is equal to this
	 */
	@Override
	public final boolean equals(final Object other) {
		if (other != null && other instanceof ShipBullet) {
			return 	super.equals(other);
		}
		return false;
	}

}
