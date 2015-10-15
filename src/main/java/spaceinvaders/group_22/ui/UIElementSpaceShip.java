package spaceinvaders.group_22.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.Player;
import spaceinvaders.group_22.PowerUp;
import spaceinvaders.group_22.SinglePlayerGame;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.unit.SpaceShip;

/**
 * The drawing of the SpaceShip.
 * @author Ege
 *
 */
public class UIElementSpaceShip extends UIElementUnit {
	
	Game game;
	
	Player player;
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.
	 * @param p the player that controls this SpaceShip	 
	 */
	public UIElementSpaceShip(final Game newGame, final GraphicsContext gc, final Player p) {	
		super(newGame, gc);
		game = newGame;
		player = p;
	}

	@Override
	public final void draw() {
		SpaceShip spaceShip = player.getSpaceShip();
		drawPowerupGlow();
        // Position the player in the middle, on the bottom of the screen.
		if (player.isInvulnerable()) {
			getGC().setGlobalAlpha(0.3);	
		}
		drawUnit(spaceShip);
		getGC().setGlobalAlpha(1);
	}
	
	/**
	 * Draws the glow of a powerup.
	 */
	@SuppressWarnings("checkstyle:magicnumber")    
	private void drawPowerupGlow() {
		for (PowerUp powerup : player.getActivePowerUps()) {
	        // Draw the player glow.
			Image glowImage = powerup.getGlow();
			if (glowImage != null) {
				//Calculate opacity on base of the time left for this powerUp.
				Double opacity = powerup.getTimeLeft() / PowerUp.getDuration();
				getGC().setGlobalAlpha(opacity);
				getGC().drawImage(glowImage, 
						
						player.getSpaceShip().getXCoor() - 0.5 * glowImage.getWidth(),
						player.getSpaceShip().getYCoor() - 0.5 * glowImage.getHeight());	

				getGC().setGlobalAlpha(1);
			}
		}
	}

}
