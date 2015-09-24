package spaceinvaders.group_22.ui;

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
	 * The Game.
	 */
	private Game game;
	
	/**
	 * The UI controller.
	 */
	private GameUIController gameUI;
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gameUIController the UI controller
	 */
	public UIElementBullet(final Game newGame, final GameUIController gameUIController) {
		game = newGame;
		gameUI = gameUIController;
	}

	@Override
	public final void draw() {
		for (Bullet bullet : game.getBullets()) {
			drawUnit(bullet.getXCoor(), bullet.getYCoor(), 
					bullet.getWidth(), bullet.getHeight(), bullet.getSprite(), gameUI);
		}
		game.getLogger().log("Drawn bullets", LogEvent.Type.TRACE);
		
	}

}
