package spaceinvaders.group_22.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.ui.UIElement;

/**
 * Class for drawing  the lives on the screen.
 * @author Dorian
 *
 */   
public abstract class UIElementLives extends UIElement {
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.	 
	 */
	public UIElementLives(final Game newGame, final GraphicsContext gc) {
		super(newGame, gc);
	}

	/**
	 * Draws the Lives on the screen. 
	 */
	@Override
	public abstract void draw();

}