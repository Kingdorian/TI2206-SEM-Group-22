package spaceinvaders.group_22.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.unit.Unit;

/**
 * The drawing of the Units.
 * @author Ege
 *
 */
@SuppressWarnings("checkstyle:magicnumber")    
public abstract class UIElementUnit extends UIElement {
	
	/**
	 * Constructor for a UIElementUnit.
	 * @param newGame The game to obtain the data from.
	 * @param gc The GraphicsContext to draw on.
	 */
	public UIElementUnit(final Game newGame, final GraphicsContext gc) {
		super(newGame, gc);
	}

	/**
	 * Method to draw the Units.
	 */
	public final void drawUnit(final Unit unit) {
		Image spriteImage = getSprites().get(unit.getSprite());
		
		double xpos = unit.getXCoor() - 0.5 * unit.getWidth();
		double ypos = unit.getYCoor() - 0.5 * unit.getHeight();
		if (spriteImage != null) {
			getGC().drawImage(spriteImage, xpos, ypos);			
		}	
		Logger.getInstance().log("Drawn " + unit.getClass().getName(), LogEvent.Type.TRACE);
	}

	/**
	 * Draw method for the UIElement.
	 */
	public abstract void draw();
}
