package spaceinvaders.group_22.ui;

import javafx.scene.image.Image;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;

public class Lives extends UIElement{
	
	private Game game;
	
	public Lives(Game newGame){
		game = newGame;
	}

	@Override
	public void draw() {
		Image heartImage = sprites.get("heart.png");
    	for (int i = 1; i <= game.getPlayer().getLives(); i++) {
        	gc.drawImage(heartImage, canvas.getWidth() - 10 - heartImage.getWidth() * i, 10);
    	}
    	game.getLogger().log("Formatted hearts to UI", LogEvent.Type.TRACE);
	}

}
