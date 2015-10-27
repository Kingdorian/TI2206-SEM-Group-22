package spaceinvaders.group_22.ui.multiplayergameui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import spaceinvaders.group_22.game.MultiPlayerGame;
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
public class MultiPlayerGameLives extends UIElementLives {
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.	 
	 */
	public MultiPlayerGameLives(final MultiPlayerGame newGame, final GraphicsContext gc) {
		super(newGame, gc);
	}


	@Override
	public final void draw() {
		Image heartImage = SpriteLoader.getInstance().getHeart();
		//Change lives for player 1
		for (int i = 1; i <= ((MultiPlayerGame) getGame()).getPlayers().get(0).getLives(); i++) {
			Logger.getInstance().log("Drawing player 2 lives",  LogEvent.Type.DEBUG);
        	getGC().drawImage(heartImage, 10 + (heartImage.getWidth() * (i - 1)), 50);
    	}
    	// Draw lives for player 2
		for (int i = 1; i <= ((MultiPlayerGame) getGame()).getPlayers().get(1).getLives(); i++) {
			Logger.getInstance().log("Drawing player 1 lives",  LogEvent.Type.DEBUG);
        	getGC().drawImage(heartImage, getGame().getCanvasWidth() - 10 - heartImage.getWidth() * i, 50);
    	}
    	Logger.getInstance().log("Formatted hearts to UI", LogEvent.Type.TRACE);
	}

}
