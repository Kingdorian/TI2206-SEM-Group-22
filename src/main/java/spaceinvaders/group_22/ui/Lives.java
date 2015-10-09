package spaceinvaders.group_22.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;

/**
 * The drawing of the lives.
 * @author Ege
 *
 */
@SuppressWarnings("checkstyle:magicnumber")    
public class Lives extends UIElement {
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.	 
	 */
	public Lives(final Game newGame, final GraphicsContext gc) {
		super(newGame, gc);
	}


	@Override
	public final void draw() {
		Image heartImage = getSprites().get("heart.png");
    	for (int i = 1; i <= getGame().getPlayer().getLives(); i++) {
        	getGC().drawImage(heartImage, getGame().getCanvasWidth() - 10 - heartImage.getWidth() * i, 10);
    	}
    	Logger.getInstance().log("Formatted hearts to UI", LogEvent.Type.TRACE);
	}

}
