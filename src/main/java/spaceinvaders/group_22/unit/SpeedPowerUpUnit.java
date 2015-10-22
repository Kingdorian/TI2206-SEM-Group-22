package spaceinvaders.group_22.unit;

import javafx.scene.media.AudioClip;
import spaceinvaders.group_22.Player;
import spaceinvaders.group_22.SpeedPowerUp;
import spaceinvaders.group_22.sound.SoundLoader;
import spaceinvaders.group_22.ui.SpriteLoader;
/**
 * Speed power Up class which extends the Power Up class.
 * @author Bryan
 */
public class SpeedPowerUpUnit extends PowerUpUnit {

	/**
	 * Indicates the velocity in the Y direction of this powerup type.
	 */
	static final double MAXVELY = 50.0;
	
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
	 * Get the maximum moving speed.
	 * @return The maximum moving speed.
	 */
	public static double getMAXVELY() {
		return MAXVELY;
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
