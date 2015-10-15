package spaceinvaders.group_22;

import java.util.ArrayList;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.unit.Collisions;
import spaceinvaders.group_22.unit.LifePowerUpUnit;
import spaceinvaders.group_22.unit.LifePowerupFactory;
import spaceinvaders.group_22.unit.PowerUpUnit;
import spaceinvaders.group_22.unit.ShootPowerUpUnit;
import spaceinvaders.group_22.unit.ShootPowerupFactory;
import spaceinvaders.group_22.unit.SpeedPowerUpUnit;
import spaceinvaders.group_22.unit.SpeedPowerupFactory;
import spaceinvaders.group_22.unit.Unit;

/**
 * Controls the powerUps in the game.
 * @author Bryan
 *
 */
@SuppressWarnings("checkstyle:magicnumber")
public abstract class PowerUpController {
	
	/**
	 * The game object for which the controller has to control the powerups.
	 */
	private Game game;
	/**
	 * The collisions of units.
	 */
	private Collisions collisions;	
	/**
     * ArrayList of powerUps in the controller.
     */
	private ArrayList<PowerUpUnit> powerups = new ArrayList<PowerUpUnit>();	
	
	/**
	 * Creates a powerUpcontroller for the game object.
	 * @param newgame game to create a powerupcontroller for.
	 */
	public PowerUpController(final Game newgame) {
		game = newgame;
	}

	/**
	 * Creates a random power Up at location X, Y.
	 * @param x coordinate of the new powerUp
	 * @param y coordinate of the new powerUp
	 */
	public final void createPowerUpUnit(final Double x, final Double y) {
		Double random = Math.random();
		PowerUpUnit newPowerUp = null;
		
		if (random < 0.1) {
			newPowerUp = new LifePowerupFactory().create(x, y);
			newPowerUp.setVelY(LifePowerUpUnit.getMaxVely());
		} else if (random >= 0.1 && random < 0.5) {
			newPowerUp = new SpeedPowerupFactory().create(x, y);
			newPowerUp.setVelY(SpeedPowerUpUnit.getMAXVELY());
		} else if (random >= 0.5) {
			newPowerUp = new ShootPowerupFactory().create(x, y);
			newPowerUp.setVelY(ShootPowerUpUnit.getMaxVely());
		}
		
		if (newPowerUp != null) {
			powerups.add(newPowerUp);			
		}
	}

	/**
	 * Method to check a not yet active powerUp.
	 * @param powerUp the powerUp to check
	 */
	public abstract void checkMovingPowerUp(final PowerUpUnit powerUp);
	/**
	 * Checks all the power ups in the game.
	 */
	public final void checkPowerUps() {		
		for (int i = 0; i < powerups.size(); i++) {
			checkMovingPowerUp(powerups.get(i));
		}

	}
	
	/**
	 * Sets the power ups in this Controller.
	 * @param newpowerups the new power ups for this Controller.
	 */
	public final void setPowerUps(final ArrayList<PowerUpUnit> newpowerups) { 
		powerups = newpowerups;
	}
	/**
	 * Returns the power ups in this Controller.
	 * @return the power ups in this Controller.
	 */
	public final  ArrayList<PowerUpUnit> getPowerUps() {
		return powerups;
	}
	/**
	 * @return Collisions.
	 */
	public final Collisions getCollisions() {
		return collisions;
	}

}
