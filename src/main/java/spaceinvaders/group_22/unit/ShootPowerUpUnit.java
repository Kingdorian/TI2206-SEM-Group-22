package spaceinvaders.group_22.unit;

import javafx.scene.media.AudioClip;
import spaceinvaders.group_22.game.Player;
import spaceinvaders.group_22.game.powerup.ShootPowerUp;
import spaceinvaders.group_22.sound.SoundLoader;
import spaceinvaders.group_22.ui.SpriteLoader;

/**
 * Shoot power up class extends the power Up class.
 * @author Bryan
 *
 */
public class ShootPowerUpUnit extends PowerUpUnit {
	/**
	 * Indicates the velocity in the Y direction of this powerup type.
	 */
	static final double MAXVELY = 50.0;
	/**
	 * Creates a shoot power Up.
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public ShootPowerUpUnit(final double x, final double y) {
		super(x, y);
	}

	@Override
	public final void activate(final Player newplayer) {
		new ShootPowerUp(newplayer);
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
		setSprite(SpriteLoader.getInstance().getShootPowerUp());
	}
	
	@Override
	public final AudioClip getAudioClip() {
		return SoundLoader.getInstance().getShootPowerUp();
	}

}
