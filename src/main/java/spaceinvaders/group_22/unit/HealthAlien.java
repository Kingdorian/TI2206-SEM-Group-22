package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.ui.SpriteLoader;

/**
 * Class for an special type of alien with health 5.
 * @author Bryan
 *
 */

public class HealthAlien extends Alien {
	
	/**
	 * The maximum health.
	 */
	public static final int MAXHEALTH = 5;
	
	/**
	 * Creates a alien with health 5.
	 * @param x location to create the alien on.
	 * @param y location to create the alien on.
	 */
	public HealthAlien(final double x, final double y) {
		super(x, y);
		setHealth(MAXHEALTH);
	}
	
	/**
	 * Method to set the sprite image of the Alien.
	 */
	public final void setSpriteImage() {
		setSprite(SpriteLoader.getInstance().getAlienWithHealth(getHealth()));	
	}

}
