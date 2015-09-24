package spaceinvaders.group_22.ui;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.Barricade;

public class UIElementBarricade extends UIElementUnit{
	
	private Game game;
	private GameUIController gameUI;
	
	public UIElementBarricade(Game newGame, GameUIController gameUIController) {
		game = newGame;
		gameUI = gameUIController;
	}

	@Override
	public void draw() {
		// Loop over all the barricades 
		for (Barricade bar : game.getBarricades()) {
			//Calculate opacity on base of the health of the barricade
			Double opacity = bar.getHealth() * 0.1;
			gameUI.getGC().setGlobalAlpha(opacity);
			gameUI.drawUnit(bar.getXCoor(), bar.getYCoor(), bar.getWidth(), bar.getHeight(), bar.getSprite());
			gameUI.getGC().setGlobalAlpha(1);
		}
		game.getLogger().log("Drawn barricades", LogEvent.Type.TRACE);
		
	}

}
