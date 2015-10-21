package spaceinvaders.group_22.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.unit.Barricade;
import spaceinvaders.group_22.unit.Unit;

/**
 * The drawing of the barricades.
 * @author Ege
 *
 */
@SuppressWarnings("checkstyle:magicnumber")   

public class UIElementBarricade extends UIElementUnit {
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.	 
	 */
	public UIElementBarricade(final Game newGame, final GraphicsContext gc) {	
		super(newGame, gc);
	}

	@Override
	public final void draw() {
		// Loop over all the barricades 
		for (Barricade bar : getGame().getBarricadeController().getBarricades()) {
			drawUnit(bar);
		}
		
	}
	@Override
	public final void drawUnit(final Unit barricade) { 
		Logger.getInstance().log("Drawing a barricade", LogEvent.Type.TRACE);
		Image spriteImage = barricade.getSprite();
		if(spriteImage == null) {
			Logger.getInstance().log("Error reading spriteImage barricade", LogEvent.Type.TRACE);
			return;
		}
		Barricade bar = (Barricade)barricade;
		final boolean[][] damage = bar.getDamage();

		int width = (int)spriteImage.getWidth();
		int height =  (int)spriteImage.getHeight();
		PixelReader pixelReader = spriteImage.getPixelReader();
		WritableImage finalSprite = 
				new WritableImage(width, height);
		PixelWriter pixelWriter = finalSprite.getPixelWriter();
		double xInterval = bar.getWidth()/(damage.length);
		double yInterval = bar.getHeight()/(damage[0].length);
	    for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
            	Color color;
            	if (damage[(int)(x/xInterval)][(int)(y/yInterval)]) {
            		color = pixelReader.getColor(x, y);
            	} else {
            		color = new Color(1, 1, 1, 0);
            	}
            	pixelWriter.setColor(x, y, color);
            }
        }
		getGC().drawImage(finalSprite, calculateXposition(bar), calculateYposition(bar));	
			
		Logger.getInstance().log("Drawn " + bar.getClass().getName(), LogEvent.Type.TRACE);
	}

}
