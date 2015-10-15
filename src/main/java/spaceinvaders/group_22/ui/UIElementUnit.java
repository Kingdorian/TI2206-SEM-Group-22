package spaceinvaders.group_22.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import spaceinvaders.group_22.Game;

/**
 * The drawing of the Units.
 * @author Ege
 *
 */
@SuppressWarnings("checkstyle:magicnumber")    
public abstract class UIElementUnit extends UIElement {
	
	/**
	 * Constructor for a UIElementUnit.
	 * @param newGame The game to obtain the data from.
	 * @param gc The GraphicsContext to draw on.
	 */
	public UIElementUnit(final Game newGame, final GraphicsContext gc) {
		super(newGame, gc);
	}

	/**
	  * Method to draw the Units.
	  * @param x The horizontal position of the player to draw.
	  * @param y The vertical position of the player to draw.
	  * @param spriteWidth The width of the sprite to draw.
	  * @param spriteHeight The heifht of the sprite to draw.
	  * @param spriteImage Image containing the sprite to draw.
	  * @param gc the GraphicsContext to draw on.
	  */  
	public final void drawUnit(final double x, final double y, final double spriteWidth, 
  		final double spriteHeight, final Image spriteImage, final GraphicsContext gc) {
      
		// Draw the player with the X and Y coordinates as center
		if (spriteImage != null) {
			gc.drawImage(spriteImage, x - 0.5 * spriteWidth, y - 0.5 * spriteHeight);			
		}
  }

}
