package spaceinvaders.group_22.ui;

import javafx.scene.control.Label;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;

public class Score extends UIElement{
	
	private Game game;
	private GameUIController gameUI;
	
	public Score(Game newGame, GameUIController gameUIController){
		game = newGame;
		gameUI = gameUIController;
	}

	@Override
	public void draw() {
		int digitsBefore = 8 - Integer.toString(game.getPlayer().getScore()).length();
    	StringBuffer scoreString = new StringBuffer();
    	
    	for (int i = 0; i < digitsBefore; i++) {
    		scoreString.append("0");
    	}
    	scoreString.append(game.getPlayer().getScore());
    	
    	gameUI.getScoreLabel().setText(scoreString.toString());	
    	game.getLogger().log("Formatted score to UI", LogEvent.Type.TRACE);		
	}

}
