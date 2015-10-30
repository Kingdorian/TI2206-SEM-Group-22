package spaceinvaders.group_22.unit;

import javafx.scene.media.AudioClip;
import spaceinvaders.group_22.game.Player;
import spaceinvaders.group_22.game.powerup.SpeedPowerUp;
import spaceinvaders.group_22.sound.SoundLoader;
import spaceinvaders.group_22.ui.SpriteLoader;
/**
 * Speed power Up class which extends the Power Up class.
 * @author Bryan
 */
public class SpeedPowerUpUnit extends PowerUpUnit {
	
	/**
	 * Creates a speed power Up.
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public SpeedPowerUpUnit(final double x, final double y) {
		super(x, y);
	}

	@Override
	@SuppressWarnings("checkstyle:magicnumber")
	public final void activate(final Player newplayer) {
		new SpeedPowerUp(newplayer);
		notifyObservers();
	}
	
	/**
	 * Sets the right sprite image.
	 */
	public final void setSpriteImage() {
		setSprite(SpriteLoader.getInstance().getSpeedPowerUp());
	}
	
	@Override
	public final AudioClip getAudioClip() {
		return SoundLoader.getInstance().getSpeedPowerUp();
	}
}
