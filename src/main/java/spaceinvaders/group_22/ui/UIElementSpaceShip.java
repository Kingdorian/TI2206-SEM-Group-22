package spaceinvaders.group_22.ui;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.SpaceShip;

public class UIElementSpaceShip extends UIElementUnit{
	
	private Game game;
	
	public UIElementSpaceShip(Game newGame) {
		game = newGame;
	}

	@Override
	public void draw() {
		SpaceShip spaceShip = game.getPlayer().getSpaceShip();
		
        // Position the player in the middle, on the bottom of the screen.
		drawUnit(spaceShip.getXCoor(), spaceShip.getYCoor(), spaceShip.getWidth(), 
				spaceShip.getHeight(), spaceShip.getSprite());
		game.getLogger().log("Drawn spaceship", LogEvent.Type.TRACE);
	}

}
