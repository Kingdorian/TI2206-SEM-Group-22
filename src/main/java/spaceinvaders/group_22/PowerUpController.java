package spaceinvaders.group_22;

import java.util.ArrayList;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.Collisions;
import spaceinvaders.group_22.unit.LifePowerUpUnit;
import spaceinvaders.group_22.unit.PowerUpUnit;
import spaceinvaders.group_22.unit.ShootPowerUpUnit;
import spaceinvaders.group_22.unit.SpeedPowerUpUnit;
import spaceinvaders.group_22.unit.Unit;

/**
 * Controls the powerUps in the game.
 * @author Bryan
 *
 */
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
	public final void createPowerUp(final Double x, final Double y) {
		Double random = Math.random();
		PowerUpUnit newPowerUp = new LifePowerUpUnit(x, y, "explosion1.png", 0);
		newPowerUp.setVelY(LifePowerUpUnit.VELY);
		Game.getLogger().log("Power Up is created" , LogEvent.Type.DEBUG);
		if (random < 0.3333333334) {
			newPowerUp = new SpeedPowerUpUnit(x, y, "explosion1.png", SpeedPowerUpUnit.DURATION);
			newPowerUp.setVelY(SpeedPowerUpUnit.VELY);
		} else if (random < 0.6666666666667) {
			newPowerUp = new ShootPowerUpUnit(x, y, "explosion1.png", ShootPowerUpUnit.DURATION);
			newPowerUp.setVelY(ShootPowerUpUnit.VELY);
		}
		game.getPowerups().add(newPowerUp);
	}
	/**
	 * Method to check an active PowerUp.
	 * @param powerUp the powerUp to check.
	 */
	public final void checkActivePowerUp(final PowerUpUnit powerUp) {
		if (powerUp.getTimeLeft() > 0) {
			powerUp.setTimeLeft(powerUp.getTimeLeft() - game.getTickrate());
		} else {
			game.getPowerups().remove(powerUp);
			powerUp.deactivate();
			Game.getLogger().log("Power up is deactivated" , LogEvent.Type.TRACE);
		}
	}
	/**
	 * Method to check a not yet active powerUp.
	 * @param powerUp the powerUp to check
	 */
	public final void checkMovingPowerUp(final PowerUpUnit powerUp) {
		powerUp.moveUnit(game.getTickrate());
		ArrayList<Unit> spaceShiplist = new ArrayList<Unit>();
		spaceShiplist.add(game.getPlayer().getSpaceShip());
		if (powerUp.getYCoor() >= game.getCanvasHeight()) {
			game.getPowerups().remove(powerUp);
			Game.getLogger().log("Removed PowerUp that was outside screen " , LogEvent.Type.TRACE);
		} else if (collisions.checkCollisions(powerUp, spaceShiplist) != null) {
			powerUp.activate(game.getPlayer());
			Game.getLogger().log("PowerUp collided with spaceship" , LogEvent.Type.TRACE);
		}  else if (collisions.checkCollisions(powerUp, new ArrayList<Unit>(game.getBarricades())) != null) {
			game.getPowerups().remove(powerUp);
			Game.getLogger().log("PowerUp collided with barricade" , LogEvent.Type.TRACE);
		}  
	}
	
	/**
	 * Checks all the power ups in the game.
	 */
	public final void checkPowerUps() {		
		for (int i = 0; i < game.getPowerups().size(); i++) {
			PowerUpUnit powerUp = game.getPowerups().get(i);
			if (powerUp.getPlayer() == null) { 
				checkMovingPowerUp(powerUp);
			} else {
				checkActivePowerUp(powerUp);
			}
		}	
	}
}
