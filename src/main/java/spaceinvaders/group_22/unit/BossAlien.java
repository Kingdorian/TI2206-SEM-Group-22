package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.ui.SpriteLoader;

/**
 * BossAlien for boss levels.
 * @author Ege
 *
 */
@SuppressWarnings("checkstyle:magicnumber") 
public class BossAlien extends Alien {

	/**
	 * Create a large alien with health 20.
	 * @param x location to create alien on
	 * @param y location to create alien on
	 */
	public BossAlien(final double x, final double y) {
		super(x, y);
		setHealth(20);
	}

	@Override
	public final void setSpriteImage() {
		setSprite(SpriteLoader.getInstance().getAlienLarge());	
	}

}
