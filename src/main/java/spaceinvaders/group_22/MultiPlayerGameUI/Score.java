package spaceinvaders.group_22.MultiPlayerGameUI;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import spaceinvaders.group_22.MultiPlayerGame;
import spaceinvaders.group_22.Player;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.ui.UIElementScore;

/**
 * The drawing of the Score.
 * @author Dorian
 *
 */
@SuppressWarnings("checkstyle:magicnumber")  
public class Score extends UIElementScore {
	
	/**
	 * Store player of which this object draws the score.
	 */
	private Player player;
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.	
	 * @param scoreLabelPlayer The label on which the score of the second player should be drawn.
	 * @param p of wich this score object represents the score.
	 */
	public Score(final MultiPlayerGame newGame, final GraphicsContext gc, 
			final Label scoreLabelPlayer, final Player p) {
		super(newGame, gc, scoreLabelPlayer);
		player = p;
	}
	/**
	 * Draws the score on the screen.
	 */
	@Override
	public final void draw() {
    	String scoreString = Integer.toString(player.getScore());
		int digits = 7 - scoreString.length();
    	for (int i = 0; i < digits; i++) {
    		scoreString = "0" + scoreString;
    	}
    	getLabel().setText(scoreString);
    	Logger.getInstance().log("Formatted score to UI", LogEvent.Type.TRACE);		
	}

}
