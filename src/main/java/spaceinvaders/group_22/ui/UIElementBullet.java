package spaceinvaders.group_22.ui;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.Bullet;

public class UIElementBullet extends UIElementUnit{
	
	private Game game;
	
	public UIElementBullet(Game newGame) {
		game = newGame;
	}

	@Override
	public void draw() {
		for (Bullet bullet : game.getBullets()) {
			drawUnit(bullet.getXCoor(), bullet.getYCoor(), 
					bullet.getWidth(), bullet.getHeight(), bullet.getSprite());
		}
		game.getLogger().log("Drawn bullets", LogEvent.Type.TRACE);
		
	}

}
