package spaceinvaders.group_22;

import java.util.ArrayList;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.unit.Collisions;
import spaceinvaders.group_22.unit.PowerUpUnit;
import spaceinvaders.group_22.unit.Unit;

/**
 * 
 * @author bryan_000
 *
 */
public class SinglePlayerPowerUpController extends PowerUpController {
	/**
	 * Single player game object to control.
	 */
	private SinglePlayerGame game;
	/**
	 * Create a single player powerup controller.
	 * @param newgame to create the controller for.
	 */
	public SinglePlayerPowerUpController(final SinglePlayerGame newgame) {
		super(newgame);
		game = newgame;
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
			getPowerUps().remove(powerUp);
			Logger.getInstance().log("Removed PowerUp that was outside screen " , LogEvent.Type.TRACE);
		} else {
			getCollisions();
			if (Collisions.checkCollisions(powerUp, spaceShiplist) != null) {
				
				powerUp.activate(game.getPlayer());
				getPowerUps().remove(powerUp);
				Logger.getInstance().log("PowerUp collided with spaceship" , LogEvent.Type.TRACE);
			} else {
				getCollisions();
				if (Collisions.checkCollisions(powerUp, 
						new ArrayList<Unit>(game.getBarricadeController().getBarricades())) != null) {
					getPowerUps().remove(powerUp);
					Logger.getInstance().log("PowerUp collided with barricade" , LogEvent.Type.TRACE);
				}
			}
		}  
	}

}
