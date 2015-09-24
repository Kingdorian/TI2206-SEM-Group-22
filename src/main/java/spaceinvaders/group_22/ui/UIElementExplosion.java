package spaceinvaders.group_22.ui;

import java.util.ArrayList;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.Explosion;

public class UIElementExplosion extends UIElementUnit{
	
	private Game game;
	
	public UIElementExplosion(Game newGame) {
		game = newGame;
	}

	@Override
	public void draw() {
		// Create a duplicate to loop over, so deletion is possible.
				ArrayList<Explosion> explosionList = new ArrayList<Explosion>();
				explosionList.addAll(game.getExplosions());
				
				// For every explosion, draw the explosion.
				for (Explosion explosion : explosionList) {
					drawUnit(explosion.getXCoor(), explosion.getYCoor(), 
							explosion.getWidth(), explosion.getHeight(), explosion.getSprite());
					
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
						game.getExplosions().remove(explosion);
					}
				}
				game.getLogger().log("Drawn explosions", LogEvent.Type.TRACE);
	}

}
