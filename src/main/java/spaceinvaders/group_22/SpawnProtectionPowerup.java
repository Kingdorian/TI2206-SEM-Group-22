package spaceinvaders.group_22;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;

/**
 * Active Spawn Protection Power Up class.
 *
 */
public class SpawnProtectionPowerup extends PowerUp {

	/**
	 * Constructor for a spawnprotectionpowerup.
	 * @param setplayer The player to activate the powerup for.
	 */
	public SpawnProtectionPowerup(final Player setplayer) {
		super(setplayer);
		this.activate();
	}

	@Override
	protected final void deactivate() {
		Logger.getInstance().log("Deacitvating spawn protection", LogEvent.Type.DEBUG);
		getPlayer().setInvulnerable(false);
		super.getPlayer().getActivePowerUps().remove(this);
	}

	@Override
	protected final void activate() {
		Logger.getInstance().log("Activating spawn protection", LogEvent.Type.DEBUG);
		getPlayer().setInvulnerable(true);

	}

	@Override
	public void setPowerupGlow() { }

}
