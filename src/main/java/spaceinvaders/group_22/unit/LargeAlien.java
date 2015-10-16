package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.ui.SpriteLoader;
/**
 * Special alien which is extra large.
 * @author Bryan
 *
 */

@SuppressWarnings("checkstyle:magicnumber") 
public class LargeAlien extends Alien {
	/**
	 * Creates a alien with health 5.
	 * @param x location to create the alien on.
	 * @param y location to create the alien on.
	 */
	public LargeAlien(final double x, final double y) {
		super(x, y);
		setHealth(5);
	}
	
	@Override
	public final void setSpriteImage() {
		setSprite(SpriteLoader.getInstance().getAlienLarge());	
	}

}
