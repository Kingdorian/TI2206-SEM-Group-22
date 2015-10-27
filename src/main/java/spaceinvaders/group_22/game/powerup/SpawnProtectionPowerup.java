package spaceinvaders.group_22.game.powerup;

import spaceinvaders.group_22.game.Player;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
/**
 * Powerup to protect the ship when spawning.
 * @author Dorian
 *
 */
public class SpawnProtectionPowerup extends PowerUp {
	
	/**
	 * Indicates the duration of this powerUP in seconds.
	 */
	static final double DURATION = 2.0; 
	/**
	 * Creator of the spawn protection power up.
	 * @param setplayer of this powerup.
	 */
	public SpawnProtectionPowerup(final Player setplayer) {
		super(setplayer);
		setTimeLeft(DURATION);
		this.activate();
	}

	@Override
	public final void deactivate() {
		Logger.getInstance().log("Deactivating spawn protection", LogEvent.Type.DEBUG);
		getPlayer().setInvulnerable(false);
		super.getPlayer().getActivePowerUps().remove(this);
	}

	@Override
	public final void activate() {
		Logger.getInstance().log("Activating spawn protection", LogEvent.Type.DEBUG);
		getPlayer().setInvulnerable(true);

	}

	@Override
	public void setPowerupGlow() { }

}
