package spaceinvaders.group_22.MultiPlayerGameUI;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.MultiPlayerGame;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.ui.UIElement;

/**
 * The drawing of the lives.
 * @author Ege, Dorian
 *
 */
@SuppressWarnings("checkstyle:magicnumber")    
public class Lives extends spaceinvaders.group_22.ui.UIElementLives {
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.	 
	 */
	public Lives(final MultiPlayerGame newGame, final GraphicsContext gc) {
		super(newGame, gc);
	}


	@Override
	public final void draw() {
		Image heartImage = getSprites().get("heart.png");
		//Change lives for player 1
		for (int i = 1; i <= ((MultiPlayerGame)getGame()).getPlayers().get(0).getLives(); i++) {
        	getGC().drawImage(heartImage, getGame().getCanvasWidth() + 10 + heartImage.getWidth() * i, 10);
    	}
    	// Draw lives for player 2
		for (int i = 1; i <= ((MultiPlayerGame)getGame()).getPlayers().get(1).getLives(); i++) {
        	getGC().drawImage(heartImage, getGame().getCanvasWidth() - 10 - heartImage.getWidth() * i, 10);
    	}
    	
    	Logger.getInstance().log("Formatted hearts to UI", LogEvent.Type.TRACE);
	}

}
