/**
 * Sample Skeleton for "simple.fxml" Controller Class
 * Use copy/paste to copy paste this code into your favorite IDE
 **/

package ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

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

    	canvasWidth = canvas.getWidth();
    	canvasHeight = canvas.getHeight();
    
    	startAnimation();

    }
    
    /**
     * Method to set the framerate of the animation.
     * @param fps The amount of frames per second.
     */
    public final void setFramerate(final int fps) {
    	framerate = 1.0 / fps;
    }
    
    /**
     * Starts the animation of the canvas.
     */
	@SuppressWarnings("checkstyle:magicnumber")    
    public final void startAnimation() {
		final GraphicsContext gc = canvas.getGraphicsContext2D();
		
        double playerWidth = 50;
        double playerHeight = 50;
		
		// Create the animation Timeline, responsible for updating the animation.
		Timeline gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
    	// Set the animation framerate.
    	setFramerate(60);

    	final long timeStart = System.currentTimeMillis();
		KeyFrame frame = new KeyFrame(
			Duration.seconds(framerate), 
				new EventHandler<ActionEvent>()
				{
					public void handle(final ActionEvent ae) {
						// Clear the canvas.
						gc.clearRect(0, 0, canvasWidth, canvasHeight);
						
						// Testing animation using only the Player.
	                    double testTranslation = (System.currentTimeMillis() - timeStart) / 10.0; 
						
				        // Position the player in the middle, on the bottom of the screen.
						drawUnit(canvasWidth / 2 - 0.5 * playerWidth - testTranslation, canvasHeight - 100, 
								playerWidth, playerHeight, gc);
						drawAlienGrid(4, gc);
					}
				});
		
		 gameLoop.getKeyFrames().add(frame);
		 gameLoop.play();
    }
 
    /**
     * Method to draw the Players Spaceship.
     * @param x The horizontal position of the player to draw.
     * @param y The vertical position of the player to draw.
     * @param spriteWidth The width of the sprite to draw.
     * @param spriteHeight The heifht of the sprite to draw.
     * @param gc The GraphicsContext of the canvas to draw on.
     */  
    public final void drawUnit(final double x, final double y, final double spriteWidth, 
    		final double spriteHeight, final GraphicsContext gc) {
        gc.setFill(Color.BLUE);
        
        // Position the player in the middle, on the bottom of the screen.
    	gc.fillRect(x, y, spriteWidth, spriteHeight);
    }
    
    /**
     * Method to draw a grid of Aliens.
     * @param lines The amount of lines the grid should have.
     * @param gc The GraphicsContext of the canvas to draw on.
     */
	@SuppressWarnings("checkstyle:magicnumber")    
    public final void drawAlienGrid(final int lines, final GraphicsContext gc) { 
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
	public final void drawAlienLine(final int spriteAmount, final double spacing, final GraphicsContext gc) {
        gc.setFill(Color.WHITE);
		
		double borderDist = 100;
        double spriteWidth = 50;
        double spriteHeight = 50;
        
        double interval = (canvasWidth - 2 * borderDist - spriteAmount * spriteWidth) / (spriteAmount + 1);  
        double startPosition = borderDist + interval;
        
        for (int i = 0; i < spriteAmount; i++) {
        	drawUnit(startPosition, spacing, spriteWidth, spriteHeight, gc);
        	startPosition = startPosition + spriteWidth + interval;
        }
	}

}