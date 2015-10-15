package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.Player;

/**
 * Life powerup class which extends the abstact powerup class.
 * @author Bryan
 */
public class LifePowerUpUnit extends PowerUpUnit {
	
	/**
	 * Indicates the velocity in the Y direction of this powerup type.
	 */
	private static final double MAXVELY = 50.0;
	
	/**
	 * Creates a life power Up.
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @param spriteFile The filename of the sprite.
	 */
	public LifePowerUpUnit(final double x, final double y, final String spriteFile) {
		super(x, y, spriteFile);
	}

	@Override
	public final void activate(final Player newplayer) {
		newplayer.addLife();

	}

	/**
	 * Returns the velocity in the Y direction.
	 * @return The velocity in the Y direction.
	 */
	public static double getMaxVely() {
		return MAXVELY;
	}
}
