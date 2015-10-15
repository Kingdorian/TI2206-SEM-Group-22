package spaceinvaders.group_22;

public class SpawnProtectionPowerup extends PowerUp {

	public SpawnProtectionPowerup(Player setplayer) {
		super(setplayer);
	}

	@Override
	protected void deactivate() {
		getPlayer().setInvulnerable(false);
	}

	@Override
	protected void activate() {
		getPlayer().setInvulnerable(true);

	}

}
