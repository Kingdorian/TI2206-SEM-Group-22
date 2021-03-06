package spaceinvaders.group_22.ui;

import javafx.scene.canvas.GraphicsContext;
import spaceinvaders.group_22.game.Game;
import spaceinvaders.group_22.unit.PowerUpUnit;

/**
 * The drawing of the Bullet.
 * @author Ege
 *
 */
public class UIElementPowerUp extends UIElementUnit {
	
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.	 
	 */
	public UIElementPowerUp(final Game newGame, final GraphicsContext gc) {	
		super(newGame, gc);
	}

	@Override
	public final void draw() {
		for (PowerUpUnit powerup : getGame().getPowerUpController().getPowerUps()) {
			drawUnit(powerup);	
		}
	}

}