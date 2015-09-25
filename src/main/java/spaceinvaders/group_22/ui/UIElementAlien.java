package spaceinvaders.group_22.ui;

import javafx.scene.canvas.GraphicsContext;
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
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.	 
	 */
	public UIElementAlien(final Game newGame, final GraphicsContext gc) {	
		super(newGame, gc);
	}

	@Override
	public final void draw() {
		for (Alien unit : getGame().getAliens()) {
			drawUnit(unit.getXCoor(), unit.getYCoor(), unit.getWidth(),
					unit.getHeight(), unit.getSprite(), getGC());		
		}
		Game.getLogger().log("Drawn aliens", LogEvent.Type.TRACE);
	}

}
