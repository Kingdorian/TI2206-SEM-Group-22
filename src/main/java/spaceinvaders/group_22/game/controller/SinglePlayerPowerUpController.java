package spaceinvaders.group_22.game.controller;

import java.util.ArrayList;

import spaceinvaders.group_22.game.SinglePlayerGame;
import spaceinvaders.group_22.game.powerup.PowerUp;

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
	@Override
	public final void checkPowerUps() {		
		checkActivationPowerUps(game.getPlayer());
		checkMovingPowerUps();
		//Loop over the active powerups and decrease their time.
		ArrayList<PowerUp> activepowerups = new ArrayList<PowerUp>();
		activepowerups.addAll(game.getPlayer().getActivePowerUps());
		for (PowerUp powerUp : activepowerups) {
			powerUp.decreaseTimeLeft(getGame().getTickrate());
		}
	}
	
	

}
