/**
 * Sample Skeleton for "simple.fxml" Controller Class
 * Use copy/paste to copy paste this code into your favorite IDE
 **/

package spaceinvaders.group_22.ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Controller for the GameUI.fxml file,
 * controlling the behavior of a game.
 * @author Jochem
 *
 */
public class GameUIController
    implements Initializable {

	/**
	 * Canvas corresponding to fxml id.
	 */
    @FXML private Canvas canvas;

    /**
     * The framerate of the animation.
     */
    private Double framerate;
    
    /**
     * The width of the canvas.
     */
    private double canvasWidth;
    
    /**
     * The height of the canvas.
     */
    private double canvasHeight;
    
    /**
     * Called by the FXMLLoader. 
     */
    @Override
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void initialize(final URL fxmlFileLocation, final ResourceBundle resources) {
    	// Set the animation framerate.
    	setFramerate(60);
    	canvasWidth = canvas.getWidth();
    	canvasHeight = canvas.getHeight();
    
    	simpleAnimation();

    }
    
    /**
     * Method to set the framerate of the animation.
     * @param fps The amount of frames per second.
     */
    public final void setFramerate(final int fps) {
    	framerate = 1.0 / fps;
    }
    
    /**
     * Draws a simple animation onto the canvas.
     */
	@SuppressWarnings("checkstyle:magicnumber")    
    public final void simpleAnimation() {
		final GraphicsContext gc = canvas.getGraphicsContext2D();
		
		drawPlayer(gc);
		drawAlienGrid(4, gc);
		
    }
 
    /**
     * Method to draw the Players Spaceship.
     * @param gc The GraphicsContext of the canvas to draw on.
     */  
	@SuppressWarnings("checkstyle:magicnumber")	
    public final void drawPlayer(final GraphicsContext gc) {
        gc.setFill(Color.BLUE);
        
        double playerWidth = 50;
        double playerHeight = 50;
        
        // Position the player in the middle, on the bottom of the screen.
    	gc.fillRect(canvasWidth / 2 - 0.5 * playerWidth, canvasHeight - 100, playerWidth, playerHeight);
    }
    
    /**
     * Method to draw a grid of Aliens.
     * @param lines The amount of lines the grid should have.
     * @param gc The GraphicsContext of the canvas to draw on.
     */
	@SuppressWarnings("checkstyle:magicnumber")    
    public final void drawAlienGrid(final int lines, final GraphicsContext gc) {
        gc.setFill(Color.WHITE);
 
        double distance = 75;
        
        for (int i = 0; i < lines; i++) {
        	drawAlienLine(10, distance, gc);

        	distance += 75;
        }
        
    }
	
	/**
	 * Method to draw a line of Aliens.
	 * @param spriteAmount Amount of sprites per line.
	 * @param spacing Spacing between lines.
     * @param gc The GraphicsContext of the canvas to draw on.
	 */
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void drawAlienLine(final int spriteAmount, final double spacing, final GraphicsContext gc) {
        double borderDist = 100;
        double spriteWidth = 50;
        double spriteHeight = 50;
        
        double interval = (canvasWidth - 2 * borderDist - spriteAmount * spriteWidth) / (spriteAmount + 1);  
        double startPosition = borderDist + interval;
        
        for (int i = 0; i < spriteAmount; i++) {
        	gc.fillRect(startPosition, spacing, spriteWidth, spriteHeight);
        	startPosition = startPosition + spriteWidth + interval;
        }
	}

}