package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.ui.SpriteLoader;

/**
 * A special alien with faster shooting.
 * @author Bryan
 *
 */
public class ShootAlien extends DefaultAlien {
	/**
	 * Creates a Shooting Alien.
	 * @param x coordinate of the new alien.
	 * @param y coordinate of the new alien.
	 */
	public ShootAlien(final double x, final double y) {
		super(x, y);
		increaseShooting();
	}
	
	@Override
	public final void setSpriteImage() {
		setSprite(SpriteLoader.getInstance().getAlienShooter());	
	}

}
