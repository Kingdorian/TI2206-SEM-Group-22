package spaceinvaders.group_22.ui;

import javafx.scene.image.Image;

/**
 * The drawing of the Units.
 * @author Ege
 *
 */
@SuppressWarnings("checkstyle:magicnumber")    
public abstract class UIElementUnit extends UIElement {
	
	/**
	  * Method to draw the Units.
	  * @param x The horizontal position of the player to draw.
	  * @param y The vertical position of the player to draw.
	  * @param spriteWidth The width of the sprite to draw.
	  * @param spriteHeight The heifht of the sprite to draw.
	  * @param sprite Image containing the sprite to draw.
	  * @param gameUI the GameUIController.
	  */  
	public final void drawUnit(final double x, final double y, final double spriteWidth, 
  		final double spriteHeight, final String sprite, final GameUIController gameUI) {
      
      // Draw the player with the X and Y coordinates as center
		Image spriteImage = gameUI.getSprite().get(sprite);
		if (spriteImage != null) {
			gameUI.getGC().drawImage(spriteImage, x - 0.5 * spriteWidth, y - 0.5 * spriteHeight);			
		}
  }

}
