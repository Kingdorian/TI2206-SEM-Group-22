package spaceinvaders.group_22.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import spaceinvaders.group_22.Game;

/**
 * The drawing of the Score.
 * @author Ege
 * @author Dorian
 *
 */ 
public abstract class UIElementScore extends UIElement {
	
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
	public UIElementScore(final Game newGame, final GraphicsContext gc, final Label scoreLabel) {
		super(newGame, gc);
		label = scoreLabel;
	}

	@Override
	public abstract void draw();
	
	/**
	 * Returns the score label.
	 * @return a Label for the score.
	 */
	public final Label getLabel() {
		return label;
	}

}
