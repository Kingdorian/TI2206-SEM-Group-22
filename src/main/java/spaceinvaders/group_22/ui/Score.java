package spaceinvaders.group_22.ui;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;

/**
 * The drawing of the Score.
 * @author Ege
 *
 */
@SuppressWarnings("checkstyle:magicnumber")  
public class Score extends UIElement {
	
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
	public Score(final Game newGame, final GameUIController gameUIController) {
		game = newGame;
		gameUI = gameUIController;
	}

	@Override
	public final void draw() {
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
