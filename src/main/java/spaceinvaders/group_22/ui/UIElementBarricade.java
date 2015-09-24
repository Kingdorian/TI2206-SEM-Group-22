package spaceinvaders.group_22.ui;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.Barricade;

public class UIElementBarricade extends UIElementUnit{
	
	private Game game;
	
	public UIElementBarricade(Game newGame) {
		game = newGame;
	}

	@Override
	public void draw() {
		// Loop over all the barricades 
		for (Barricade bar : game.getBarricades()) {
			//Calculate opacity on base of the health of the barricade
			Double opacity = bar.getHealth() * 0.1;
			gc.setGlobalAlpha(opacity);
			drawUnit(bar.getXCoor(), bar.getYCoor(), bar.getWidth(), bar.getHeight(), bar.getSprite());
			gc.setGlobalAlpha(1);
		}
		game.getLogger().log("Drawn barricades", LogEvent.Type.TRACE);
		
	}

}
