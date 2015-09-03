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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.util.Duration;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javafx.event.EventHandler;

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
     * Draws a simple animation onto the canvas.
     */
	@SuppressWarnings("checkstyle:magicnumber")    
    public final void simpleAnimation() {
		final GraphicsContext gc = canvas.getGraphicsContext2D();
		
		Timeline gameLoop = new Timeline();
	    gameLoop.setCycleCount(Timeline.INDEFINITE);
	        
		final Image player = new Image("testplayer.gif", 100, 0, true, false);
		final long timeStart = System.currentTimeMillis();
		
	    KeyFrame frame = new KeyFrame(Duration.seconds(framerate),
	            new EventHandler<ActionEvent>()
	            {
	                public void handle(final ActionEvent ae) {
	                
	                    double t = (System.currentTimeMillis() - timeStart) / 1000.0; 
	                    // Clear the canvas
	                    gc.clearRect(0, 0, canvasWidth, canvasHeight);
	                    gc.drawImage(player, canvasWidth / 2 - 10 * t, canvasHeight / 2);
	                }
        });
	    
        gameLoop.getKeyFrames().add(frame);
        gameLoop.play();
    }
    
    /**
     * Method to set the framerate of the animation.
     * @param fps The amount of frames per second.
     */
    public final void setFramerate(final int fps) {
    	framerate = 1.0 / fps;
    }

}