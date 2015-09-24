package spaceinvaders.group_22.ui;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.Barricade;

/**
 * The drawing of the barricades.
 * @author Ege
 *
 */
public class UIElementBarricade extends UIElementUnit {
	
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
	public UIElementBarricade(final Game newGame, final GameUIController gameUIController) {
		game = newGame;
		gameUI = gameUIController;
	}

	@Override
	public final void draw() {
		// Loop over all the barricades 
		for (Barricade bar : game.getBarricades()) {
			//Calculate opacity on base of the health of the barricade
			Double opacity = bar.getHealth() * 0.1;
			gameUI.getGC().setGlobalAlpha(opacity);
			drawUnit(bar.getXCoor(), bar.getYCoor(), bar.getWidth(), bar.getHeight(), bar.getSprite(), gameUI);
			gameUI.getGC().setGlobalAlpha(1);
		}
		game.getLogger().log("Drawn barricades", LogEvent.Type.TRACE);
		
	}

}
