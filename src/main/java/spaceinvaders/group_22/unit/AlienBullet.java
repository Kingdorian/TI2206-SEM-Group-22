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

}
