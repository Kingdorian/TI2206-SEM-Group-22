
package spaceinvaders.group_22.ui;

import javafx.scene.canvas.GraphicsContext;
import spaceinvaders.group_22.Game;

/**
 * The drawing of all the elements.
 * @author Ege
 *
 */
public abstract class UIElement {
	
	/**
	 * The Game.
	 */
	private Game game;
	
	/**
	 * The UI controller.
	 */
	private GraphicsContext graphicsContext;
	
	/**
	 * The constructor for a UIElement object.
	 * @param newGame The game to obtain the data from.
	 * @param gc The GraphicsContext to draw on.
	 */
	public UIElement(final Game newGame, final GraphicsContext gc) { 
		setGame(newGame);
		graphicsContext = gc;
	}
	
	/**
	 * Drawing the elements.
	 */
	public abstract void draw();

	/**
	 * @return Returns the game to obtain data from.
	 */
	public final Game getGame() {
		return game;
	}

	/**
	 * @param newGame The newGame to set.
	 */
	public final void setGame(final Game newGame) {
		this.game = newGame;
	}
	
	/**
	 * @return Returns the game to obtain data from.
	 */
	public final GraphicsContext getGC() {
		return graphicsContext;
	}

	/**
	 * @param newGC The new GraphicsContext to draw on.
	 */
	public final void setGC(final GraphicsContext newGC) {
		this.graphicsContext = newGC;
	}
   
}
