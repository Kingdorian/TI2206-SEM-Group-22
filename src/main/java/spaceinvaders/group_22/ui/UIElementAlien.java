package spaceinvaders.group_22.ui;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.Alien;

public class UIElementAlien extends UIElementUnit{
	
	private Game game;
	private GameUIController gameUI;
	
	public UIElementAlien(Game newGame, GameUIController gameUIController){
		game = newGame;
		gameUI = gameUIController;
	}

	@Override
	public void draw() {
		for (Alien unit : game.getAliens()) {
			gameUI.drawUnit(unit.getXCoor(), unit.getYCoor(), unit.getWidth(),
					unit.getHeight(), unit.getSprite());		
		}
		game.getLogger().log("Drawn aliens", LogEvent.Type.TRACE);
	}

}
