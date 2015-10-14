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
@SuppressWarnings("checkstyle:magicnumber")    
public abstract class Lives extends UIElement {
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.	 
	 */
	public Lives(final Game newGame, final GraphicsContext gc) {
		super(newGame, gc);
	}


	@Override
	public abstract void draw();

}