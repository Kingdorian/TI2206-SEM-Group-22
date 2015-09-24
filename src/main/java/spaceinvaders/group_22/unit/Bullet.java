package spaceinvaders.group_22.unit;

/**
 * A bullet in the game, extends Unit.
 * @author Ege de Bruin
 */

public abstract class Bullet extends Unit implements MovableUnit{

	/**
	 * Creates a Bullet.
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @param spriteFile filename of the sprite of this unit.
	 */
	@SuppressWarnings("checkstyle:magicnumber")    
	public Bullet(final double x, final double y, final String spriteFile) {
		super(x, y, spriteFile);
	}

}
