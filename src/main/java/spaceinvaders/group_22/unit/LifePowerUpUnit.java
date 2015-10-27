package spaceinvaders.group_22.unit;

import javafx.scene.media.AudioClip;
import spaceinvaders.group_22.game.Player;
import spaceinvaders.group_22.sound.SoundLoader;
import spaceinvaders.group_22.ui.SpriteLoader;

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
	 */
	public LifePowerUpUnit(final double x, final double y) {
		super(x, y);
	}

	@Override
	public final void activate(final Player newplayer) {
		newplayer.addLife();
		notifyObservers();
	}

	/**
	 * Returns the velocity in the Y direction.
	 * @return The velocity in the Y direction.
	 */
	public static double getMaxVely() {
		return MAXVELY;
	}
	
	/**
	 * Sets the right sprite image.
	 */
	public final void setSpriteImage() {
		setSprite(SpriteLoader.getInstance().getLifePowerUp());
	}
	
	@Override
	public final AudioClip getAudioClip() {
		return SoundLoader.getInstance().getLifePowerUp();
	}
}
