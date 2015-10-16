package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.ui.SpriteLoader;

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
	 */
	public AlienBullet(final double x, final double y) {
		super(x, y);
	}
	
	/**
	 * Sets the right sprite image.
	 */
	public final void setSpriteImage() {
		setSprite(SpriteLoader.getInstance().getBulletAlien());
	}
}
