package spaceinvaders.group_22.ui;

import javafx.scene.canvas.GraphicsContext;
import spaceinvaders.group_22.game.Game;
import spaceinvaders.group_22.unit.Bullet;

/**
 * The drawing of the Bullet.
 * @author Ege
 *
 */
public class UIElementBullet extends UIElementUnit {
	
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.	 
	 */
	public UIElementBullet(final Game newGame, final GraphicsContext gc) {	
		super(newGame, gc);
	}

	@Override
	public final void draw() {
		for (Bullet bullet : getGame().getBullets()) {
			drawUnit(bullet);
		}		
	}

}
