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
	 * The duration if the powerUp is activated.
	 */
	private int duration;

	/**
	 * Creates a power Up.
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @param spriteFile The filename of the sprite.
	 */
	public PowerUp(final double x, final double y, final String spriteFile) {
		super(x, y, spriteFile);
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
	 * Gets the duration how long this powerup works when activated.
	 * @return the duration when activated.
	 */
	public final int getDuration() {
		return duration;
	}
	
	/**
	 * Sets the duration of this powerUp.
	 * @param newduration this powerup can be active.
	 */
	public final void setDuration(final int newduration) {
		duration = newduration;
	}


}
