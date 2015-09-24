package spaceinvaders.group_22.ui;

import javafx.scene.image.Image;

public abstract class UIElementUnit extends UIElement{
	
	  /**
	  * Method to draw the Units.
	  * @param x The horizontal position of the player to draw.
	  * @param y The vertical position of the player to draw.
	  * @param spriteWidth The width of the sprite to draw.
	  * @param spriteHeight The heifht of the sprite to draw.
	  * @param sprite Image containing the sprite to draw.
	  */  
	public final void drawUnit(final double x, final double y, final double spriteWidth, 
    		final double spriteHeight, final String sprite) {
        
        // Draw the player with the X and Y coordinates as center
		Image spriteImage = sprites.get(sprite);
		if (spriteImage != null) {
			gc.drawImage(spriteImage, x - 0.5 * spriteWidth, y - 0.5 * spriteHeight);			
		}
    }

}
