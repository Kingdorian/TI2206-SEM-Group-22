package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.Player;

/**
 * Abstract powerup class extends the unit class.
 * @author Bryan
 */
public abstract class PowerUp extends Unit {
	
	/**
	 * Player on which this powerup is working.
	 * Null if it is not working on a player.
	 */
	private Player player = null;
	
	/**
	 * Amount of secons this powerup still works on a player.
	 */
	private double timeLeft;

	/**
	 * Creates a power Up.
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @param spriteFile The filename of the sprite.
	 * @param time the time left for this powerUp
	 */
	public PowerUp(final double x, final double y, final String spriteFile, final double time) {
		super(x, y, spriteFile);
		timeLeft = time;
	}
	
	/**
	 * Activates the powerup for player.
	 * @param newplayer the player this powerup has effect on.
	 * 
	 */
	public abstract void activate(Player newplayer);
	/**
	 * Deactivates the powerup for the player.
	 */
	public abstract void deactivate();
	
	/**
	 * Gets the player who this powerup has.
	 * @return the player that has this powerup.
	 */
	public final Player getPlayer() {
		return player;
	}
	
	/**
	 * Sets the player this powerup has effect on.
	 * @param newplayer the player this powerup has effect on.
	 */
	public final void setPlayer(final Player newplayer) {
		this.player = newplayer;
	}
	/**
	 * Returns the time left this powerup is active.
	 * @return the time in seconds this powerUp could be active.
	 */
	public final double getTimeLeft() {
		return timeLeft;
	}
	/**
	 * Sets the time this powerup is active.
	 * @param newTime the powerup is still active.
	 */
	public final void setTimeLeft(final double newTime) {
		timeLeft = newTime;
	}
}
