package spaceinvaders.group_22.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import spaceinvaders.group_22.Game;
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
	
	SinglePlayerGame game;
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.	 
	 */
	public UIElementSpaceShip(final SinglePlayerGame newGame, final GraphicsContext gc) {	
		super(newGame, gc);
		game = newGame;
	}

	@Override
	public final void draw() {
		SpaceShip spaceShip = game.getPlayer().getSpaceShip();
		drawPowerupGlow();
        // Position the player in the middle, on the bottom of the screen.
		drawUnit(spaceShip.getXCoor(), spaceShip.getYCoor(), spaceShip.getWidth(), 
				spaceShip.getHeight(), spaceShip.getSprite(), getGC());
		Logger.getInstance().log("Drawn spaceship", LogEvent.Type.TRACE);
	}
	
	/**
	 * Draws the glow of a powerup.
	 */
	@SuppressWarnings("checkstyle:magicnumber")    
	private void drawPowerupGlow() {
		for (PowerUp powerup : game.getPlayer().getActivePowerUps()) {
	        // Draw the player glow.
			Image glowImage = getSprites().get(powerup.getGlow());
			if (glowImage != null) {
				//Calculate opacity on base of the time left for this powerUp.
				Double opacity = powerup.getTimeLeft() / PowerUp.getDuration();
				getGC().setGlobalAlpha(opacity);
				getGC().drawImage(glowImage, 
						game.getPlayer().getSpaceShip().getXCoor() - 0.5 * glowImage.getWidth(),
						game.getPlayer().getSpaceShip().getYCoor() - 0.5 * glowImage.getHeight());	
				getGC().setGlobalAlpha(1);
			}
		}
	}

}
