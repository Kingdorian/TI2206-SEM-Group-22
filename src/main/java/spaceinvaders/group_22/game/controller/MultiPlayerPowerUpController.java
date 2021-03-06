package spaceinvaders.group_22.game.controller;

import java.util.ArrayList;

import spaceinvaders.group_22.game.MultiPlayerGame;
import spaceinvaders.group_22.game.Player;
import spaceinvaders.group_22.game.powerup.PowerUp;

/**
 * Controls the powerUps in a Multiplayer game.
 * @author Bryan
 *
 */
public class MultiPlayerPowerUpController extends PowerUpController {
	
	/**
	 * Multiplayer game object.
 	*/
	private MultiPlayerGame multiPlayerGame;


	/**
	 * The PowerUpController for a MultiPlayerGame.
	 * @param newgame The new game
	 */
	public MultiPlayerPowerUpController(final MultiPlayerGame newgame) {
		super(newgame);
		multiPlayerGame = newgame;
	}
	

	@Override
	public final void checkPowerUps() {	
		checkMovingPowerUps();
		for (Player player: multiPlayerGame.getPlayers()) {
			checkActivationPowerUps(player);
		
			//Loop over the active powerups and decrease their time.
			ArrayList<PowerUp> activepowerups = new ArrayList<PowerUp>();
			activepowerups.addAll(player.getActivePowerUps());
			for (PowerUp powerUp : activepowerups) {
				powerUp.decreaseTimeLeft(getGame().getTickrate());
			}
		}
	}

}
