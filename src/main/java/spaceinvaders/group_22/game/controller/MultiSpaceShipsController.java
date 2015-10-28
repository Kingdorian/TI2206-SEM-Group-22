package spaceinvaders.group_22.game.controller;

import java.util.ArrayList;
import javafx.scene.input.KeyCode;
import spaceinvaders.group_22.game.MultiPlayerGame;
import spaceinvaders.group_22.game.Player;

/**
 * 
 * @author Ege
 *
 */
public class MultiSpaceShipsController extends SpaceShipController {
	
	/**
	 * The game object.
	 */
	private MultiPlayerGame game;

	/**
	 * The SpaceShipController for MultiPlayerGame.
	 * @param parentGame The game
	 */
	public MultiSpaceShipsController(final MultiPlayerGame parentGame) {
		super(parentGame);
		game = parentGame;
	}
	/**
	 * Method to call every tick for the spaceship.
	 * @param pressedKeys the keys that are pressed.
	 */
	public final void tick(final ArrayList<KeyCode> pressedKeys) {
		for (Player player: game.getPlayers()) {
			spaceShipCollisions(player.getSpaceShip());
		}
		moveSpaceShip(pressedKeys, game.getPlayers().get(0));
		ArrayList<KeyCode> secondShipKeys = new ArrayList<KeyCode>();
		for (KeyCode key :pressedKeys) {
			if (key.equals(KeyCode.RIGHT)) {
				secondShipKeys.add(KeyCode.D);
			} else if (key.equals(KeyCode.LEFT)) {
				secondShipKeys.add(KeyCode.A);
			}
		}
		moveSpaceShip(secondShipKeys, game.getPlayers().get(1));
	}

}
