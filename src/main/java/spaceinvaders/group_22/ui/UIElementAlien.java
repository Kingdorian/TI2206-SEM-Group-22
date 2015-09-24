package spaceinvaders.group_22.ui;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.Alien;

public class UIElementAlien extends UIElementUnit{
	
	private Game game;
	
	public UIElementAlien(Game newGame) {
		game = newGame;
	}

	@Override
	public void draw() {
		for (Alien unit : game.getAliens()) {
			drawUnit(unit.getXCoor(), unit.getYCoor(), unit.getWidth(),
					unit.getHeight(), unit.getSprite());		
		}
		game.getLogger().log("Drawn aliens", LogEvent.Type.TRACE);
	}

}
