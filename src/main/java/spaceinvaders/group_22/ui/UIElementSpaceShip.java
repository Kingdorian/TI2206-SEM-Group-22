package spaceinvaders.group_22.ui;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.SpaceShip;

/**
 * The drawing of the SpaceShip.
 * @author Ege
 *
 */
public class UIElementSpaceShip extends UIElementUnit {
	
	/**
	 * The Game.
	 */
	private Game game;
	
	/**
	 * The UI controller.
	 */
	private GameUIController gameUI;
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gameUIController the UI controller
	 */
	public UIElementSpaceShip(final Game newGame, final GameUIController gameUIController) {
		game = newGame;
		gameUI = gameUIController;
	}

	@Override
	public final void draw() {
		SpaceShip spaceShip = game.getPlayer().getSpaceShip();
		
        // Position the player in the middle, on the bottom of the screen.
		drawUnit(spaceShip.getXCoor(), spaceShip.getYCoor(), spaceShip.getWidth(), 
				spaceShip.getHeight(), spaceShip.getSprite(), gameUI);
		game.getLogger().log("Drawn spaceship", LogEvent.Type.TRACE);
	}

}
