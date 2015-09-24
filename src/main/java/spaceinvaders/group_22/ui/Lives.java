package spaceinvaders.group_22.ui;

import javafx.scene.image.Image;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;

/**
 * The drawing of the lives.
 * @author Ege
 *
 */
@SuppressWarnings("checkstyle:magicnumber")    
public class Lives extends UIElement {
	
	/**
	 * The Game.
	 */
	private Game game;
	
	/**
	 * The UI controller.
	 */
	private GameUIController gameUI;
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gameUIController the UI controller
	 */
	public Lives(final Game newGame, final GameUIController gameUIController) {
		game = newGame;
		gameUI = gameUIController;
	}

	@Override
	public final void draw() {
		Image heartImage = gameUI.getSprite().get("heart.png");
    	for (int i = 1; i <= game.getPlayer().getLives(); i++) {
        	gameUI.getGC().drawImage(heartImage, gameUI.getCanvasWidth() - 10 - heartImage.getWidth() * i, 10);
    	}
    	game.getLogger().log("Formatted hearts to UI", LogEvent.Type.TRACE);
	}

}
