package spaceinvaders.group_22.ui;

import javafx.scene.canvas.GraphicsContext;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
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
			drawUnit(bullet.getXCoor(), bullet.getYCoor(), 
					bullet.getWidth(), bullet.getHeight(), bullet.getSprite(), getGC());
		}
		Game.getLogger().log("Drawn bullets", LogEvent.Type.TRACE);
		
	}

}
