package spaceinvaders.group_22.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.PowerUp;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.unit.SpaceShip;

/**
 * The drawing of the SpaceShip.
 * @author Ege
 *
 */
public class UIElementSpaceShip extends UIElementUnit {
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.	 
	 */
	public UIElementSpaceShip(final Game newGame, final GraphicsContext gc) {	
		super(newGame, gc);
	}

	@Override
	public final void draw() {
		SpaceShip spaceShip = getGame().getPlayer().getSpaceShip();
		drawPowerupGlow();
        // Position the player in the middle, on the bottom of the screen.
		drawUnit(spaceShip.getXCoor(), spaceShip.getYCoor(), spaceShip.getWidth(), 
				spaceShip.getHeight(), spaceShip.getSprite(), getGC());
		Logger.getInstance().log("Drawn spaceship", LogEvent.Type.TRACE);
	}
	
	/**
	  * Method to draw the Unit.
	  * @param x The horizontal position of the player to draw.
	  * @param y The vertical position of the player to draw.
	  * @param spriteWidth The width of the sprite to draw.
	  * @param spriteHeight The heifht of the sprite to draw.
	  * @param sprite Image containing the sprite to draw.
	  * @param gc the GraphicsContext to draw on.
	  */  
	public final void drawUnit(final double x, final double y, final double spriteWidth, 
 		final double spriteHeight, final String sprite, final GraphicsContext gc) {
     
     // Draw the player with the X and Y coordinates as center
		Image spriteImage = getSprites().get(sprite);
		if (spriteImage != null) {
			if(getGame().getPlayer().isInvulnerable()) {
				gc.setGlobalAlpha(0.3);	
			}
			gc.drawImage(spriteImage, x - 0.5 * spriteWidth, y - 0.5 * spriteHeight);			
			gc.setGlobalAlpha(1);
		}
 }
	
	/**
	 * Draws the glow of a powerup.
	 */
	@SuppressWarnings("checkstyle:magicnumber")    
	private void drawPowerupGlow() {
		for (PowerUp powerup : getGame().getPlayer().getActivePowerUps()) {
	        // Draw the player glow.
			Image glowImage = getSprites().get(powerup.getGlow());
			if (glowImage != null) {
				//Calculate opacity on base of the time left for this powerUp.
				Double opacity = powerup.getTimeLeft() / PowerUp.getDuration();
				getGC().setGlobalAlpha(opacity);
				getGC().drawImage(glowImage, 
						getGame().getPlayer().getSpaceShip().getXCoor() - 0.5 * glowImage.getWidth(),
						getGame().getPlayer().getSpaceShip().getYCoor() - 0.5 * glowImage.getHeight());	
				getGC().setGlobalAlpha(1);
			}
		}
	}

}
