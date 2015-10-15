package spaceinvaders.group_22.MultiPlayerGameUI;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.ui.UIElement;

/**
 * The drawing of the lives.
 * @author Ege, Dorian
 *
 */
@SuppressWarnings("checkstyle:magicnumber")    
public class Lives extends spaceinvaders.group_22.ui.Lives {
	
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
		//Change lives for player 1
		//TODO Change when multiple players are actually implemented.
		for (int i = 1; i <= getGame().getPlayer().getLives(); i++) {
        	getGC().drawImage(heartImage, getGame().getCanvasWidth() + 10 + heartImage.getWidth() * i, 10);
    	}
    	// Draw lives for player 2
		//TODO Change so it acutally gets lives of player 2 (when multiple players are implemented)
		for (int i = 1; i <= getGame().getPlayer().getLives(); i++) {
        	getGC().drawImage(heartImage, getGame().getCanvasWidth() - 10 - heartImage.getWidth() * i, 10);
    	}
    	
    	Logger.getInstance().log("Formatted hearts to UI", LogEvent.Type.TRACE);
	}

}