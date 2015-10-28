package spaceinvaders.group_22.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import spaceinvaders.group_22.game.Game;
import spaceinvaders.group_22.game.Player;
import spaceinvaders.group_22.game.powerup.PowerUp;
import spaceinvaders.group_22.unit.SpaceShip;

/**
 * The drawing of the SpaceShip.
 * @author Ege
 *
 */
@SuppressWarnings("checkstyle:magicnumber")
public class UIElementSpaceShip extends UIElementUnit {
	
	/**
	 * The currnet player.
	 */
	private Player player;
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.
	 * @param p the player that controls this SpaceShip	 
	 */
	public UIElementSpaceShip(final Game newGame, final GraphicsContext gc, final Player p) {	
		super(newGame, gc);
		player = p;
	}

	/**
	 * Draws the spaceship on the canvas.
	 */
	@SuppressWarnings("checkstyle:magicnumber")
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
