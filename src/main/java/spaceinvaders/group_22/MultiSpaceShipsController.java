package spaceinvaders.group_22;

import java.util.ArrayList;
import javafx.scene.input.KeyCode;

/**
 * 
 * @author Ege
 *
 */
public class MultiSpaceShipsController extends SpaceShipController {

	/**
	 * The SpaceShipController for MultiPlayerGame.
	 * @param parentGame The game
	 */
	public MultiSpaceShipsController(final MultiPlayerGame parentGame) {
		super(parentGame);
	}
	
	/**
	 * Moves the spaceships.
	 * @param pressedKeys the keys pressed since last tick
	 */
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void moveSpaceShip(final ArrayList<KeyCode> pressedKeys) {
		//todo implement moving of the different spaceships
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
