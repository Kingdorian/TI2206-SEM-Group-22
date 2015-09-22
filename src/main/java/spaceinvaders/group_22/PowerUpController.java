package spaceinvaders.group_22;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.Collisions;
import spaceinvaders.group_22.unit.LifePowerUp;
import spaceinvaders.group_22.unit.PowerUp;
import spaceinvaders.group_22.unit.SpeedPowerUp;
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
	private LinkedHashMap<PowerUp, Double> activePowerUps;
	
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
		activePowerUps = new LinkedHashMap<PowerUp, Double>();
		collisions = new Collisions(game);
	}

	/**
	 * Creates a random power Up at location X, Y.
	 * @param x coordinate of the new powerUp
	 * @param y coordinate of the new powerUp
	 */
	public final void createPowerUp(final Double x, final Double y) {
		Double random = Math.random();
		PowerUp newPowerUp = new LifePowerUp(x, y, "explosion1.png");
		Game.getLogger().log("Power Up is created" , LogEvent.Type.DEBUG);
		if (random < 0.3333333334) {
			newPowerUp = new SpeedPowerUp(x, y, "explosion1.png");
		} else if (random < 0.6666666666667) {
			newPowerUp = new SpeedPowerUp(x, y, "explosion1.png");
		}
		newPowerUp.setVelY(50);
		game.getPowerups().add(newPowerUp);
	}
	/**
	 * Method to move all the powerUps in the right direction.
	 * And check if they collide or are not in the screen anymore.
	 */
	public final void movePowerUps() {
		ArrayList<Unit> unitlist = new ArrayList<Unit>();
		unitlist.add(game.getPlayer().getSpaceShip());
		for (int i = 0; i < game.getPowerups().size(); i++) {
			PowerUp powerUp = game.getPowerups().get(i);
			powerUp.moveUnit(game.getTickrate());
			if (powerUp.getXCoor() >= game.getCanvasHeight()) {
				game.getPowerups().remove(powerUp);
				Game.getLogger().log("Removed PowerUp that was outside screen " , LogEvent.Type.TRACE);
			} else if (collisions.checkCollisions(powerUp, unitlist) != null) {
				powerUp.activate(game.getPlayer());
				game.getPowerups().remove(powerUp);
				Game.getLogger().log("PowerUp collided with spaceship" , LogEvent.Type.TRACE);
				if (!(powerUp instanceof LifePowerUp)) {
					activePowerUps.put(powerUp, (1 / game.getTickrate()) * 5);
				}
			}
		}
	}
	
	/**
	 * Checks all the power ups in the game.
	 */
	public final void checkPowerUps() {
		movePowerUps();	
		// Loop over all the active powerups and check if they are still active
		 Collection<PowerUp> c = activePowerUps.keySet();
		 Iterator<PowerUp> itr = c.iterator();
		while (itr.hasNext()) {
			PowerUp key = itr.next();
			if (activePowerUps.get(key) != null) {
				activePowerUps.replace(key, activePowerUps.get(key) - 1);
				if (activePowerUps.get(key) < 0) {
					itr.remove();
					activePowerUps.remove(key, activePowerUps.get(key));
					key.deactivate();
					Game.getLogger().log("Power up is deactivated" , LogEvent.Type.TRACE);
				}
			}
		}
	}

}
