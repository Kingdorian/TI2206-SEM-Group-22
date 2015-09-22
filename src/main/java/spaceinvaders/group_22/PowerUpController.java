package spaceinvaders.group_22;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import spaceinvaders.group_22.unit.Collisions;
import spaceinvaders.group_22.unit.LifePowerUp;
import spaceinvaders.group_22.unit.PowerUp;
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
	 * Hashmap with the powerups and the time they are still active.
	 */
	private LinkedHashMap<PowerUp, Integer> activePowerUps;
	
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
		activePowerUps = new LinkedHashMap<PowerUp, Integer>();
		collisions = new Collisions(game);
	}

	/**
	 * Creates a random powerUp.
	 */
	public final void createPowerUp() {
		//game.getPowerups().add(new LifePowerUp());
	}
	/**
	 * Method to move all the powerUps in the right direction.
	 * And check if they collide or are not in the screen anymore.
	 */
	public final void movePowerUps() {
		ArrayList<Unit> unitlist = new ArrayList<Unit>();
		unitlist.add(game.getPlayer().getSpaceShip());
		for (PowerUp powerUp : game.getPowerups()) {
			powerUp.moveUnit(game.getTickrate());
			if (powerUp.getXCoor() >= game.getCanvasHeight()) {
				game.getPowerups().remove(powerUp);
			} else if (collisions.checkCollisions(powerUp, unitlist) != null) {
				powerUp.activate(game.getPlayer());
				game.getPowerups().remove(powerUp);
				activePowerUps.put(powerUp, powerUp.getDuration());
			}
		}
	}
	
	/**
	 * Checks all the power ups in the game.
	 */
	public final void checkPowerUps() {
		movePowerUps();	
		// Loop over all the active powerups and check if they are still active
		for (PowerUp key : activePowerUps.keySet()) {
			if (activePowerUps.get(key) != null) {
				activePowerUps.replace(key, activePowerUps.get(key) - 1);
				if (activePowerUps.get(key) < 0) {
					activePowerUps.remove(key, activePowerUps.get(key));
					key.deactivate();
				}
			}
		}
	}

}
