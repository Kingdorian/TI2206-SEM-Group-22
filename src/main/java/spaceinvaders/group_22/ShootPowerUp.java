package spaceinvaders.group_22;

import spaceinvaders.group_22.ui.SpriteLoader;

/**
 * Active Shoot power up class.
 * @author Bryan
 *
 */
public class ShootPowerUp extends PowerUp {
		
	/**
	 * Indicates the duration of this powerUP in seconds.
	 */
	static final double DURATION = 5.0; 
		
	/**
	 * Creates a Shoot power up which is active.
	 * @param setPlayer player this powerUp is from.
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	public ShootPowerUp(final Player setPlayer) {
		super(setPlayer);
		getPlayer().getActivePowerUps().add(this);
		setTimeLeft(DURATION);
	}
	/**
	 * Deactivates this power up.
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	protected final void deactivate() {
		getPlayer().getSpaceShip().setShootingMultiplier(1.0);
		super.getPlayer().getActivePowerUps().remove(this);
		getPlayer().getSpaceShip().updateMultiplier();
	}
	@Override
	@SuppressWarnings("checkstyle:magicnumber")
	protected final void activate() {
		getPlayer().getSpaceShip().setShootingMultiplier(2.0);
		getPlayer().getSpaceShip().updateMultiplier();
	}
	
	/**
	 * Sets the correct glow sprite for this powerup.
	 */
	@Override
	public final void setPowerupGlow() {
		setGlow(SpriteLoader.getInstance().getShootPowerUpGlow());
	}

}