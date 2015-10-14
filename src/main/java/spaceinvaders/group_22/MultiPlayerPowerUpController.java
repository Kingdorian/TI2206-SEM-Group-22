package spaceinvaders.group_22;

import java.util.ArrayList;

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
	 * Creates a multi player powerUp controller.
	 * @param newgame game to create the controller for.
	 */
	public MultiPlayerPowerUpController(final MultiPlayerGame newgame) {
		super(newgame);
		multiPlayerGame = newgame;
	}

	@Override
	public final void checkPowerUps() {		
		for (int i = 0; i < getPowerUps().size(); i++) {
			checkMovingPowerUp(getPowerUps().get(i));
		}	
		//Loop over every player and active powerUps
		for (Player player : multiPlayerGame.getPlayers()) {
			checkActivationPowerUps(player);
			ArrayList<PowerUp> activepowerups = new ArrayList<PowerUp>();
			activepowerups.addAll(player.getActivePowerUps());
			for (PowerUp powerUp : activepowerups) {
				powerUp.decreaseTimeLeft(getGame().getTickrate());
			}
		}
	}

}
