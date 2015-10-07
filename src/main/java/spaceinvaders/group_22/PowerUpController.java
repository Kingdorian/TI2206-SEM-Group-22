package spaceinvaders.group_22;

import java.util.ArrayList;

import spaceinvaders.group_22.logger.LogEvent;
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
public class PowerUpController {
	
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
		collisions = new Collisions(game);
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
	public final void checkMovingPowerUp(final PowerUpUnit powerUp) {
		powerUp.move(game.getTickrate());
		ArrayList<Unit> spaceShiplist = new ArrayList<Unit>();
		spaceShiplist.add(game.getPlayer().getSpaceShip());
		if (powerUp.getYCoor() >= game.getCanvasHeight()) {
			powerups.remove(powerUp);
			Game.getLogger().log("Removed PowerUp that was outside screen " , LogEvent.Type.TRACE);
		} else if (collisions.checkCollisions(powerUp, spaceShiplist) != null) {
			
			powerUp.activate(game.getPlayer());
			powerups.remove(powerUp);
			Game.getLogger().log("PowerUp collided with spaceship" , LogEvent.Type.TRACE);
		}  else if (collisions.checkCollisions(powerUp, 
				new ArrayList<Unit>(game.getBarricadeController().getBarricades())) != null) {
			powerups.remove(powerUp);
			Game.getLogger().log("PowerUp collided with barricade" , LogEvent.Type.TRACE);
		}  
	}
	
	/**
	 * Checks all the power ups in the game.
	 */
	public final void checkPowerUps() {		
		for (int i = 0; i < powerups.size(); i++) {
			checkMovingPowerUp(powerups.get(i));
		}
		//Loop over the active power ups for the player
		for (int i = 0; i < game.getPlayer().getActivePowerUps().size(); i++) {
			
			game.getPlayer().getActivePowerUps().get(i).decreaseTimeLeft(game.getTickrate());
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

}
