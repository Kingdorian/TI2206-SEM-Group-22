package spaceinvaders.group_22.SinglePlayerGameUI;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.ui.UIElement;

/**
 * The drawing of the Score.
 * @author Dorian
 *
 */
@SuppressWarnings("checkstyle:magicnumber")  
public class Score extends spaceinvaders.group_22.ui.Score {
	
	/**
	 * The label to draw the score on.
	 */
	private Label label;
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.	
	 * @param scoreLabel The label on which the score should be drawn. 
	 */
	public Score(final Game newGame, final GraphicsContext gc, final Label scoreLabel) {
		super(newGame, gc, scoreLabel);
	}
	
	public final void draw() {
		int digitsBefore = 8 - Integer.toString(getGame().getPlayer().getScore()).length();
    	StringBuffer scoreString = new StringBuffer();
    	
    	for (int i = 0; i < digitsBefore; i++) {
    		scoreString.append("0");
    	}
    	scoreString.append(getGame().getPlayer().getScore());
    	
    	label.setText(scoreString.toString());	
    	Logger.getInstance().log("Formatted score to UI", LogEvent.Type.TRACE);		
	}

}
