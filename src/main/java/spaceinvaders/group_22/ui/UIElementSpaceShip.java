package spaceinvaders.group_22.ui;

import javafx.scene.canvas.GraphicsContext;
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
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.	 
	 */
	public UIElementSpaceShip(final Game newGame, final GraphicsContext gc) {	
		super(newGame, gc);
	}

	@Override
	public final void draw() {
		SpaceShip spaceShip = getGame().getPlayer().getSpaceShip();
		
        // Position the player in the middle, on the bottom of the screen.
		drawUnit(spaceShip.getXCoor(), spaceShip.getYCoor(), spaceShip.getWidth(), 
				spaceShip.getHeight(), spaceShip.getSprite(), getGC());
		Game.getLogger().log("Drawn spaceship", LogEvent.Type.TRACE);
	}

}
