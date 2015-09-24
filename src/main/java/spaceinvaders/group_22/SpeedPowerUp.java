package spaceinvaders.group_22;

import spaceinvaders.group_22.unit.SpaceShip;

/**
 * Active Speed Power Up class.
 * @author Bryan
 *
 */
public class SpeedPowerUp extends PowerUp {
	
	/**
	 * Indicates the duration of this powerUP in seconds.
	 */
	public static double DURATION = 5.0; 
	
	/**
	 * Creates a Speed power up which is active.
	 * @param setPlayer player this powerUp is from.
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	public SpeedPowerUp(final Player setPlayer) {
		super(setPlayer);
		this.setGlow("glow_blue.png");
	}
	/**
	 * Deactivates this powerUp.
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	protected final void deactivate() {
		SpaceShip.MAXVELX = 250;
		super.getPlayer().getActivePowerUps().remove(this);
	}	
	@Override
	@SuppressWarnings("checkstyle:magicnumber")
	protected final void activate() {
		getPlayer().getActivePowerUps().add(this);
		setTimeLeft(DURATION);
		SpaceShip.MAXVELX = 750;
	}
}
