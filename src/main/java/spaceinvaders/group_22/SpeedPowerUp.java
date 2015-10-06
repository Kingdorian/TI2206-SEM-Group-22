package spaceinvaders.group_22;

/**
 * Active Speed Power Up class.
 * @author Bryan
 *
 */
public class SpeedPowerUp extends PowerUp {
	
	/**
	 * Indicates the duration of this powerUP in seconds.
	 */
	static final double DURATION = 5.0; 
	
	/**
	 * Creates a Speed power up which is active.
	 * @param setPlayer player this powerUp is from.
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	public SpeedPowerUp(final Player setPlayer) {
		super(setPlayer);
		this.setGlow("glow_blue.png");
		super.getPlayer().getActivePowerUps().add(this);
		setTimeLeft(DURATION);
	}
	/**
	 * Deactivates this powerUp.
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	protected final void deactivate() {
		getPlayer().getSpaceShip().setVelMultiplier(1.0);
		super.getPlayer().getActivePowerUps().remove(this);
		getPlayer().getSpaceShip().updateMultiplier();
	}	
	@Override
	@SuppressWarnings("checkstyle:magicnumber")
	protected final void activate() {
		getPlayer().getSpaceShip().setVelMultiplier(2.5);
		getPlayer().getSpaceShip().updateMultiplier();
	}
}