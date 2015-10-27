package spaceinvaders.group_22.ui.singleplayergameui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import spaceinvaders.group_22.game.SinglePlayerGame;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.ui.UIElementScore;

/**
 * The drawing of the Score.
 * @author Dorian
 *
 */
@SuppressWarnings("checkstyle:magicnumber")  
public class SinglePlayerGameScore extends UIElementScore {
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.	
	 * @param scoreLabelPlayer The label on which the score of the first player should be drawn. 
	 */
	public SinglePlayerGameScore(final SinglePlayerGame newGame, final GraphicsContext gc,	final Label scoreLabelPlayer) {
		super(newGame, gc, scoreLabelPlayer);
	}
	/**
	 * Draws the score on the screen.
	 */
	public final void draw() {
    	String scoreString = Integer.toString(((SinglePlayerGame) getGame()).getPlayer().getScore());
		int digits = 8 - scoreString.length();
    	for (int i = 0; i < digits; i++) {
    		scoreString = "0" + scoreString;
    	}
    	getLabel().setText(scoreString);
    	Logger.getInstance().log("Formatted score to UI", LogEvent.Type.TRACE);			
	}

}
