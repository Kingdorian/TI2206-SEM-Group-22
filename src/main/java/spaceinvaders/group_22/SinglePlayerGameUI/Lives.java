package spaceinvaders.group_22.SinglePlayerGameUI;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import spaceinvaders.group_22.SinglePlayerGame;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.ui.SpriteLoader;
import spaceinvaders.group_22.ui.UIElementLives;

/**
 * The drawing of the lives.
 * @author Ege, Dorian
 *
 */
@SuppressWarnings("checkstyle:magicnumber")    
public class Lives extends UIElementLives {
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.	 
	 */
	public Lives(final SinglePlayerGame newGame, final GraphicsContext gc) {
		super(newGame, gc);
	}


	@Override
	public final void draw() {
		Image heartImage = SpriteLoader.getInstance().getHeart();
    	for (int i = 1; i <= ((SinglePlayerGame) getGame()).getPlayer().getLives(); i++) {

        	getGC().drawImage(heartImage, getGame().getCanvasWidth() - 10 - heartImage.getWidth() * i, 10);
    	}
    	Logger.getInstance().log("Formatted hearts to UI", LogEvent.Type.TRACE);
	}

}
