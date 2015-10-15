package spaceinvaders.group_22.SinglePlayerGameUI;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.SinglePlayerGame;
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
	
	SinglePlayerGame game;
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.	 
	 */
	public Lives(final SinglePlayerGame newGame, final GraphicsContext gc) {
		super(newGame, gc);
		game = newGame;
	}


	@Override
	public final void draw() {
		Image heartImage = getSprites().get("heart.png");
    	for (int i = 1; i <= game.getPlayer().getLives(); i++) {
        	getGC().drawImage(heartImage, getGame().getCanvasWidth() - 10 - heartImage.getWidth() * i, 10);
    	}
    	Logger.getInstance().log("Formatted hearts to UI", LogEvent.Type.TRACE);
	}

}