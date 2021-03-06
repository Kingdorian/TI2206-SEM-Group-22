package spaceinvaders.group_22.game.powerup;


import javafx.scene.image.Image;
import spaceinvaders.group_22.game.Player;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;

/**
 * Abstract clas for an active power Up.
 * @author Bryan
 *
 */
public abstract class PowerUp {
	
	/**
	 * Indicates the duration of this powerUP in seconds.
	 */
	private static final double DURATION = 5.0; 
	
	/**
	 * Time left in seconds this Power Up can be active.
	 */
	private Double timeLeft;
	/**
	 * Player that has this power up.
	 */
	private Player player;
	
	/**
	 * The Image of the glow that has to be applied.
	 */
	private Image glow;
	
	/**
	 * Makes a power up for this player.
	 * @param setplayer to which this power up belongs.
	 */
	public PowerUp(final Player setplayer) {
		setPlayer(setplayer);
		setPowerupGlow();
		activate();
	}
	
	/**
	 * Method to deactivate this power up.
	 */
	public abstract void deactivate();
	
	/**
	 * Method to actived this power up.
	 */
	public abstract void activate();
	
	/**
	 * Method to decreate the time left.
	 * If the time left is less as 0 it is deactivated
	 * @param timePast The time past.
	 */
	public final void decreaseTimeLeft(final Double timePast) {
		this.timeLeft = this.timeLeft - timePast;
		activate();
		if (timeLeft <= 0) {
			Logger.getInstance().log("Time left for powerup: " + timeLeft, LogEvent.Type.DEBUG);
			deactivate();
		}
	}
	/**
	 * Method to get the time left this power up is active.
	 * @return the time in seconds left for this power Up.
	 */
	/**
	 * 
	 * @return the time left for this powerUp
	 */
	public final Double getTimeLeft() {
		return timeLeft;
	}
	/**
	 * Sets the time left.
	 * @param time the time to set.
	 */
	public final void setTimeLeft(final Double time) {
		timeLeft = time;
	}
	/**
	 * Returns the player of this power up.
	 * @return the player who this power up owns.
	 */
	public final Player getPlayer() {
		return player;
	}
	/**
	 * Sets the player this power up owns.
	 * @param setplayer to set.
	 */
	public final void setPlayer(final Player setplayer) {
		this.player = setplayer;
	}
	
	/**
	 * Returns the glow of this power up.
	 * @return the glow filename of this powerup.
	 */
	public final Image getGlow() {
		return glow;
	}
	/**
	 * Sets the glow of this power up.
	 * @param setglow The glow to set.
	 */
	public final void setGlow(final Image setglow) {
		this.glow = setglow;
	}

	/**
	 * Returns the duration of the powerup.
	 * @return The powerup duration.
	 */
	public static double getDuration() {
		return DURATION;
	}
	
	/**
	 * Sets the Image of the glow of this powerup.
	 * It should load the correct sprite from the SpriteLoader.
	 */
	public abstract void setPowerupGlow();

}
