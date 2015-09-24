package spaceinvaders.group_22.ui;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.Alien;

/**
 * The drawing of the Aliens.
 * @author Ege
 *
 */
@SuppressWarnings("checkstyle:magicnumber")  
public class UIElementAlien extends UIElementUnit {
	
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
	public UIElementAlien(final Game newGame, final GameUIController gameUIController) {
		game = newGame;
		gameUI = gameUIController;
	}

	@Override
	public final void draw() {
		for (Alien unit : game.getAliens()) {
			drawUnit(unit.getXCoor(), unit.getYCoor(), unit.getWidth(),
					unit.getHeight(), unit.getSprite(), gameUI);		
		}
		game.getLogger().log("Drawn aliens", LogEvent.Type.TRACE);
	}

}
