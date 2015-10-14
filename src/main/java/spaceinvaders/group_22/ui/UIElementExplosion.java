package spaceinvaders.group_22.ui;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.unit.Explosion;

/**
 * The drawing of an explosion.
 * @author Ege
 *
 */
@SuppressWarnings("checkstyle:magicnumber")  
public class UIElementExplosion extends UIElementUnit {
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.	 
	 */
	public UIElementExplosion(final Game newGame, final GraphicsContext gc) {	
		super(newGame, gc);
	}

	@Override
	public final void draw() {
		// Create a duplicate to loop over, so deletion is possible.
				ArrayList<Explosion> explosionList = new ArrayList<Explosion>();
				explosionList.addAll(getGame().getExplosions());
				
				// For every explosion, draw the explosion.
				for (Explosion explosion : explosionList) {
					drawUnit(explosion);
					
					// Increase the counter maintaining the time one frame of the animation is visible.
					explosion.increaseCounter();

					if (explosion.getCounter() % 5 == 0) {
						// Increase the index of the animation sprite, so the next image is shown.
						explosion.increaseAnimationIndex();
						explosion.setSprite("explosion" + explosion.getAnimationIndex() + ".png");
					}
					if (explosion.getAnimationIndex() == 5) {
						// If we reach the final animation index, 
						// remove the explosion since the animation has ended.
						getGame().getExplosions().remove(explosion);
					}
				}
	}

}
