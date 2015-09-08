package spaceinvaders.group_22.ui;
/**
 * Sample Skeleton for "simple.fxml" Controller Class
 * Use copy/paste to copy paste this code into your favorite IDE
 **/

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.unit.Alien;
import spaceinvaders.group_22.unit.Bullet;
import spaceinvaders.group_22.unit.SpaceShip;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.input.KeyCode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
     * Stackpane corresponding to fmxl id.
     */
    @FXML private StackPane stackPane;

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
     * ArrayList of all the keys currently pressed.
     */
    private ArrayList<KeyCode> pressedKeys = new ArrayList<KeyCode>();
    
    /**
     * Game object of the current game.
     */
    private Game game;
    
    /**
     * Hashmap containing all sprites.
     */
    private HashMap<String, Image> sprites;
    
    /**
     * Label to load the score of the player in.
     */
    @FXML
	private Label scoreLabel;
    
    /**
     * Label to load the highscore in.
     */
    @FXML
	private Label highScoreLabel;
    
    /**
     * The game over screen.
     */
    private Node screenGameOver;
    
    /**
     * The game over screen.
     */
    private Node screenBeforePlay;
    
    
    /**
     * The paused screen.
     */
    private Node screenPaused;
    
    /**
     * Called by the FXMLLoader. 
     */
    @Override
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void initialize(final URL fxmlFileLocation, final ResourceBundle resources) {
    	
    	// Get the various screens.
    	// The order in the FXML file matters (!).
    	screenGameOver = stackPane.getChildren().get(0);
    	screenBeforePlay = stackPane.getChildren().get(1);
    	screenPaused = stackPane.getChildren().get(2);

    	// Move press to play to front.
    	screenBeforePlay.toFront();
    	
    	
    	canvasWidth = canvas.getWidth();
    	canvasHeight = canvas.getHeight();
    	game = new Game(canvasWidth, canvasHeight);
    	sprites = getSprites();
    	
    	startAnimation();
    	canvas.setFocusTraversable(true);
    }
    
    /**
     * Method to set the framerate of the animation.
     * @param fps The amount of frames per second.
     */
    public final void setFramerate(final int fps) {
    	framerate = 1.0 / fps;
    }
    
    /**
     * Creates a hashmap of all available sprite images.
     * @return a hashmap containing all available sprite images.
     */
    public final HashMap<String, Image> getSprites() {
    	HashMap<String, Image> spriteMap = new HashMap<String, Image>();
    		
    		spriteMap.put("alienbullet.png", 
    				new Image(getClass().getClassLoader()
    						.getResource("spaceinvaders/group_22/images/alienbullet.png").toString()));
    		spriteMap.put("spaceshipbullet.png", 
    				new Image(getClass().getClassLoader()
    						.getResource("spaceinvaders/group_22/images/spaceshipbullet.png").toString()));
    		spriteMap.put("invader.png", 
    				new Image(getClass().getClassLoader()
    						.getResource("spaceinvaders/group_22/images/invader.png").toString()));
	    	spriteMap.put("spaceship.png", 
	    			new Image(getClass().getClassLoader()
	    					.getResource("spaceinvaders/group_22/images/spaceship.png").toString()));
	    	spriteMap.put("heart.png", 
	    			new Image(getClass().getClassLoader()
	    					.getResource("spaceinvaders/group_22/images/heart.png").toString()));
    		
    	return spriteMap;
    }
    
    /**
     * Starts the animation of the canvas.
     */
	@SuppressWarnings("checkstyle:magicnumber")    
    public final void startAnimation() {
		final GraphicsContext gc = canvas.getGraphicsContext2D();
		
		// Create the animation Timeline, responsible for updating the animation.
		Timeline gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
    	// Set the animation framerate.
    	setFramerate(60);
    	Game.setTickrate(framerate);
    	
		KeyFrame frame = new KeyFrame(
			Duration.seconds(framerate), 
				new EventHandler<ActionEvent>()
				{
					public void handle(final ActionEvent ae) {
						// Clear the canvas.
						gc.clearRect(0, 0, canvasWidth, canvasHeight);
						
						// Testing animation using only the Player.
	                    //double testTranslation = (System.currentTimeMillis() - timeStart) / 10.0; 
						if (game.isInProgress()) {
							
							game.tick(pressedKeys);
						}
									
						SpaceShip spaceShip = game.getPlayer().getSpaceShip();
						
				        // Position the player in the middle, on the bottom of the screen.
						drawUnit(spaceShip.getXCoor(), spaceShip.getYCoor(), spaceShip.getWidth(), 
								spaceShip.getHeight(), spaceShip.getSprite(), gc);

						
						for (Alien unit : game.getAliens()) {
							drawUnit(unit.getXCoor(), unit.getYCoor(), unit.getWidth(),
									unit.getHeight(), unit.getSprite(), gc);
							
						}
						
						if (pressedKeys.contains(KeyCode.SPACE)) {
					    	pressedKeys.remove(KeyCode.SPACE);
					    }
						
						for (Bullet bullet : game.getBullets()) {
							drawUnit(bullet.getXCoor(), bullet.getYCoor(), 
									bullet.getWidth(), bullet.getHeight(), bullet.getSprite(), gc);
						}
						scoreLabel.setText("Score: " + game.getPlayer().getScore());
						formatLives(game.getPlayer().getLives(), gc);
						formatScore(game.getPlayer().getScore());
						
						if (game.hasEnded()) {
							screenGameOver.toFront();
							highScoreLabel.setText("Highscore: " + game.getHighScore());
						} else {
							screenGameOver.toBack();
						}
						
					}
				});
		
		 gameLoop.getKeyFrames().add(frame);
		 gameLoop.play();
    }
	
    /**
     * Method to display the lives on the screen.
     * @param lives The amount of lives the player has.
     * @param gc The GraphicsContext of the canvas to draw on.
     */
	@SuppressWarnings("checkstyle:magicnumber")    
    public final void formatLives(final int lives, final GraphicsContext gc) {
    	Image heartImage = sprites.get("heart.png");
    	for (int i = 1; i <= lives; i++) {
        	gc.drawImage(heartImage, canvas.getWidth() - 10 - heartImage.getWidth() * i, 10);
    	}
    }
	
	/**
	 * Method to display the score on the screen.
	 * @param score The score to be displayed.
	 */
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void formatScore(final int score) {
    	int digitsBefore = 8 - Integer.toString(score).length();
    	String scoreString = "";
    	
    	for (int i = 0; i < digitsBefore; i++) {
    		scoreString += "0";
    	}
    	scoreString += score;
    	
    	scoreLabel.setText(scoreString);	
	}
 
    /**
     * Method to draw the Players Spaceship.
     * @param x The horizontal position of the player to draw.
     * @param y The vertical position of the player to draw.
     * @param spriteWidth The width of the sprite to draw.
     * @param spriteHeight The heifht of the sprite to draw.
     * @param sprite Image containing the sprite to draw.
     * @param gc The GraphicsContext of the canvas to draw on.
     */  
	@SuppressWarnings("checkstyle:magicnumber")    
    public final void drawUnit(final double x, final double y, final double spriteWidth, 
    		final double spriteHeight, final String sprite, final GraphicsContext gc) {
        
        // Draw the player with the X and Y coordinates as center
		Image spriteImage = sprites.get(sprite);
		gc.drawImage(spriteImage, x - 0.5 * spriteWidth, y - 0.5 * spriteHeight);
    }
	
	/**
	 * Handles if a key is pressed.
	 * @param event of a key pressed
	 */
	@FXML
	public final void handleKeyPressed(final KeyEvent event) {
        System.out.println(event.getCode() + " is pressed ");
        if (event.getCode().equals(KeyCode.S) && game.getPlayer().getLives() > 0) {       	
        	screenBeforePlay.toBack();
        	screenPaused.toBack();
        	game.start();
        } else if (event.getCode().equals(KeyCode.P)) {
        	if (game.isInProgress()) {
            	screenPaused.toFront();
            	game.stop();	
        	}
        } else if (!pressedKeys.contains(event.getCode())) {
	    	pressedKeys.add(event.getCode());
	    }
	}
	
	/**
	 * Handles if a key is released.
	 * @param event of a key released.
	 */
	@FXML
	public final void handleKeyReleased(final KeyEvent event) {
	    if (pressedKeys.contains(event.getCode())) {
	    	pressedKeys.remove(event.getCode());
	    }
	}

}