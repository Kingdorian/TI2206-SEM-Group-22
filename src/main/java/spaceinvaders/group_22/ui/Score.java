package spaceinvaders.group_22.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.SinglePlayerGame;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;

/**
 * The drawing of the Score.
 * @author Ege
 *
 */
@SuppressWarnings("checkstyle:magicnumber")  
public class Score extends UIElement {
	
	/**
	 * The label to draw the score on.
	 */
	private Label label;
	
	SinglePlayerGame game;
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.	
	 * @param scoreLabel The label on which the score should be drawn. 
	 */
	public Score(final SinglePlayerGame newGame, final GraphicsContext gc, final Label scoreLabel) {
		super(newGame, gc);
		label = scoreLabel;
		game = newGame;
	}

	@Override
	public final void draw() {
		int digitsBefore = 8 - Integer.toString(game.getPlayer().getScore()).length();
    	StringBuffer scoreString = new StringBuffer();
    	
    	for (int i = 0; i < digitsBefore; i++) {
    		scoreString.append("0");
    	}
    	scoreString.append(game.getPlayer().getScore());
    	
    	label.setText(scoreString.toString());	
    	Logger.getInstance().log("Formatted score to UI", LogEvent.Type.TRACE);		
	}

}
