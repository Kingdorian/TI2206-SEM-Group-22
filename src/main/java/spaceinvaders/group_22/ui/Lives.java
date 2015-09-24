package spaceinvaders.group_22.ui;

import javafx.scene.image.Image;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;

public class Lives extends UIElement{
	
	private Game game;
	private GameUIController gameUI;
	
	public Lives(Game newGame, GameUIController gameUIController) {
		game = newGame;
		gameUI = gameUIController;
	}

	@Override
	public void draw() {
		Image heartImage = gameUI.getSprites().get("heart.png");
    	for (int i = 1; i <= game.getPlayer().getLives(); i++) {
        	gameUI.getGC().drawImage(heartImage, gameUI.getCanvasWidth() - 10 - heartImage.getWidth() * i, 10);
    	}
    	game.getLogger().log("Formatted hearts to UI", LogEvent.Type.TRACE);
	}

}
