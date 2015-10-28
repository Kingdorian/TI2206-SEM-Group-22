package spaceinvaders.group_22.game.controller;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;
import spaceinvaders.group_22.game.SinglePlayerGame;
/**
 * 
 * @author Bryan
 *
 */
public class SingleSpaceShipController extends SpaceShipController {
	/**
	 * The game object.
	 */
	private SinglePlayerGame game;
	
	/**
	 * Creates a new spaceShipcontroller.
	 * @param parentGame Game this controller works for.
	 */
	public SingleSpaceShipController(final SinglePlayerGame parentGame) {
		super(parentGame);
		game = parentGame;
	}
	/**
	 * Method to call every tick for the spaceship.
	 * @param pressedKeys the keys that are pressed.
	 */
	public final void tick(final ArrayList<KeyCode> pressedKeys) {
		moveSpaceShip(pressedKeys, game.getPlayer());
		spaceShipCollisions(game.getPlayer().getSpaceShip());
	}
	
	

}
