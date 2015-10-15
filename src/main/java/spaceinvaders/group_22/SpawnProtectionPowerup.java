package spaceinvaders.group_22;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;

public class SpawnProtectionPowerup extends PowerUp {

	public SpawnProtectionPowerup(Player setplayer) {
		super(setplayer);
		this.activate();
	}

	@Override
	protected void deactivate() {
		Logger.getInstance().log("Deacitvating spawn protection", LogEvent.Type.DEBUG);
		getPlayer().setInvulnerable(false);
		super.getPlayer().getActivePowerUps().remove(this);
	}

	@Override
	protected void activate() {
		Logger.getInstance().log("Activating spawn protection", LogEvent.Type.DEBUG);
		getPlayer().setInvulnerable(true);

	}

}
