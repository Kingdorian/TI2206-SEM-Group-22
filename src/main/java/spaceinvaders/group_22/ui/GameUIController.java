package spaceinvaders.group_22.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.Alien;
import spaceinvaders.group_22.unit.Barricade;
import spaceinvaders.group_22.unit.Bullet;
import spaceinvaders.group_22.unit.Explosion;
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
@SuppressWarnings("checkstyle:magicnumber")    
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
     * The graphicscontext of the Canvas.
     */
    private static GraphicsContext gc;
    
    /**
     * Called by the FXMLLoader. 
     */
    @Override
	public final void initialize(final URL fxmlFileLocation, final ResourceBundle resources) {
    	initializeStackPaneScreens();
    	// Get the GraphicsContext of the canvas, so you can draw on it.
    	gc = canvas.getGraphicsContext2D();
    	
    	canvasWidth = canvas.getWidth();
    	canvasHeight = canvas.getHeight();
    	
    	newGame();
    	game.getLogger().log("Set canvas width to: " + canvasWidth, LogEvent.Type.INFO);
    	game.getLogger().log("Set canvas height to: " + canvasHeight, LogEvent.Type.INFO);
    	game.getLogger().log("Show screen Before Play", LogEvent.Type.INFO);
    	
    	canvas.setFocusTraversable(true);
    }
    
    /**
     * Retruns the canvas Width.
     * @return canvasWidth
     */
    public final double getCanvasWidth() {
    	return canvasWidth;
    }
    
    /**
     * Retruns the canvas Height.
     * @return canvasHeight
     */
    public final double getCanvasHeight() {
    	return canvasHeight;
    }
    
    /**
     * Gets the screens in the GameUI stackpane, and assigns them to the right variables.
     * The order in the FXML file matters (!).
     */
    public final void initializeStackPaneScreens() {
    	screenGameOver = stackPane.getChildren().get(0);
    	screenBeforePlay = stackPane.getChildren().get(1);
    	screenPaused = stackPane.getChildren().get(2);

    	// Move press to play to front.
    	screenBeforePlay.toFront();
    }
    
    /**
     * Creates a new game.
     */
    public final void newGame() {
    	// If the game does not exist, create a new one.
    	if (game == null) {
        	game = new Game(canvasWidth, canvasHeight);
        	sprites = getSprites();
        // Else reset the existing game.
    	} else {
        	game.resetGame();    		
    	}

    	startAnimation();
    }
    
    /**
     * Method to set the framerate of the animation.
     * @param fps The amount of frames per second.
     */
    public final void setFramerate(final int fps) {
    	if (fps > 0) {
        	framerate = 1.0 / (double) fps;
    	} else {
    		framerate = 0.0;
    	}
    	game.getLogger().log("Set framerate to: " + framerate, LogEvent.Type.INFO);
    }
    
    /**
     * Returns the framerate.
     * @return the framerate of the animation.
     */
    public final double getFramerate() {
    	return framerate;
    }
    
    /**
     * Creates a hashmap of all available sprite images.
     * @return a hashmap containing all available sprite images.
     */
    public final HashMap<String, Image> getSprites() {
    	HashMap<String, Image> spriteMap = new HashMap<String, Image>();
    		
    		addSprite(spriteMap, "alienbullet.png");
    		addSprite(spriteMap, "spaceshipbullet.png");
    		addSprite(spriteMap, "invader.png");
    		addSprite(spriteMap, "spaceship.png");
    		addSprite(spriteMap, "heart.png");
    		addSprite(spriteMap, "barrier.png");
    		addSprite(spriteMap, "explosion1.png");
    		addSprite(spriteMap, "explosion2.png");
    		addSprite(spriteMap, "explosion3.png");
    		addSprite(spriteMap, "explosion4.png");
    		addSprite(spriteMap, "explosion5.png");
    		
    	return spriteMap;
    }
    
    /**
     * Adds a sprite to the sprite Hasmap.
     * @param spriteMap The hashmap of sprites to add to.
     * @param filename The filename of the sprite to add.
     */
    public final void addSprite(final HashMap<String, Image> spriteMap, final String filename) {
		spriteMap.put(filename, 
				new Image(getClass().getClassLoader()
						.getResource("spaceinvaders/group_22/images/" + filename).toString()));
		game.getLogger().log("Loaded " + filename, LogEvent.Type.DEBUG);
    }
    
    /**
     * Starts the animation of the canvas.
     */
    public final void startAnimation() {
		
		// Create the animation Timeline, responsible for updating the animation.
		Timeline gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
    	// Set the animation framerate.
    	setFramerate(60);
    	game.setTickrate(framerate);
    	
    	// Create each frame.
		KeyFrame frame = new KeyFrame(
			Duration.seconds(framerate), 
				new EventHandler<ActionEvent>()
				{
					public void handle(final ActionEvent ae) {
						// Clear the canvas.
						gc.clearRect(0, 0, canvasWidth, canvasHeight);
						
						// If the game is in progress, look if any key is pressed.
						if (game.isInProgress()) {
							game.tick(pressedKeys);
						}
						
						// Draw the various units on the screen.
						drawPlayer();
						drawAliens();
						drawExplosions();
						drawBullets();
						drawBarricades();
	
						// Draw the lives and score on the screen.
						formatLives(game.getPlayer().getLives());
						formatScore(game.getPlayer().getScore());
						
						if (pressedKeys.contains(KeyCode.SPACE)) {
					    	pressedKeys.remove(KeyCode.SPACE);
					    }
						
						// If the game has ended, put the Game Over screen to the front.
						if (game.hasEnded()) {
							screenGameOver.toFront();
							highScoreLabel.setText("Highscore: " + game.getHighScore());
							gameLoop.stop();
							game.getLogger().log("Show screen Game Over", LogEvent.Type.INFO);
						} else {
							screenGameOver.toBack();
						}
						
					}
				});
		
		 gameLoop.getKeyFrames().add(frame);
		 gameLoop.play();
    }
	
	/**
	 * Method to draw all the barricades.
	 */
	private void drawBarricades() {
		// Loop over all the barricades 
		for (Barricade bar : game.getBarricades()) {
			//Calculate opacity on base of the health of the barricade
			Double opacity = bar.getHealth() * 0.1;
			gc.setGlobalAlpha(opacity);
			drawUnit(bar.getXCoor(), bar.getYCoor(), bar.getWidth(), bar.getHeight(), bar.getSprite());
			gc.setGlobalAlpha(1);
		}
		game.getLogger().log("Drawn barricades", LogEvent.Type.TRACE);
	}
	
	/**
	 * Method to draw the player spaceship.
	 */
	private void drawPlayer() {
		SpaceShip spaceShip = game.getPlayer().getSpaceShip();
		
        // Position the player in the middle, on the bottom of the screen.
		drawUnit(spaceShip.getXCoor(), spaceShip.getYCoor(), spaceShip.getWidth(), 
				spaceShip.getHeight(), spaceShip.getSprite());
		game.getLogger().log("Drawn spaceship", LogEvent.Type.TRACE);
	}
	
	/**
	 * Method to draw the aliens in game.
	 */
	private void drawAliens() {
		for (Alien unit : game.getAliens()) {
			drawUnit(unit.getXCoor(), unit.getYCoor(), unit.getWidth(),
					unit.getHeight(), unit.getSprite());		
		}
		game.getLogger().log("Drawn aliens", LogEvent.Type.TRACE);
	}
	
	/**
	 * Method to draw the bullets in game.
	 */
	private void drawBullets() {
		for (Bullet bullet : game.getBullets()) {
			drawUnit(bullet.getXCoor(), bullet.getYCoor(), 
					bullet.getWidth(), bullet.getHeight(), bullet.getSprite());
		}
		game.getLogger().log("Drawn bullets", LogEvent.Type.TRACE);
	}
	
	/**
	 * Method to draw the explosions in game.
	 */
	private void drawExplosions() {
		// Create a duplicate to loop over, so deletion is possible.
		ArrayList<Explosion> explosionList = new ArrayList<Explosion>();
		explosionList.addAll(game.getExplosions());
		
		// For every explosion, draw the explosion.
		for (Explosion explosion : explosionList) {
			drawUnit(explosion.getXCoor(), explosion.getYCoor(), 
					explosion.getWidth(), explosion.getHeight(), explosion.getSprite());
			
			// Increase the counter maintaining the time one frame of the animation is visible.
			explosion.increaseCounter();

			if (explosion.getCounter() % 5 == 0) {
				// Increase the index of the animation sprite, so the next image is shown.
				explosion.increaseAnimationIndex();
				explosion.setSprite("explosion" + explosion.getAnimationIndex() + ".png");
			}
			if (explosion.getAnimationIndex() == 5) {
				// If we reach the final animation index, 
				// remove the explosion since the animation has ended.
				game.getExplosions().remove(explosion);
			}
		}
		game.getLogger().log("Drawn explosions", LogEvent.Type.TRACE);
	}
	
    /**
     * Method to display the lives on the screen.
     * @param lives The amount of lives the player has.
     */
    public final void formatLives(final int lives) {
    	Image heartImage = sprites.get("heart.png");
    	for (int i = 1; i <= lives; i++) {
        	gc.drawImage(heartImage, canvas.getWidth() - 10 - heartImage.getWidth() * i, 10);
    	}
    	game.getLogger().log("Formatted hearts to UI", LogEvent.Type.TRACE);
    }
	
	/**
	 * Method to display the score on the screen.
	 * @param score The score to be displayed.
	 */
	public final void formatScore(final int score) {
    	int digitsBefore = 8 - Integer.toString(score).length();
    	StringBuffer scoreString = new StringBuffer();
    	
    	for (int i = 0; i < digitsBefore; i++) {
    		scoreString.append("0");
    	}
    	scoreString.append(score);
    	
    	scoreLabel.setText(scoreString.toString());	
    	game.getLogger().log("Formatted score to UI", LogEvent.Type.TRACE);
	}
	
	/**
	 * Returns the scoreLabel.
	 * @return The scoreLabel of the UI.
	 */
	public final Label getScoreLabel() {
		return scoreLabel;
	}
 
    /**
     * Method to draw the Players Spaceship.
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
	
	/**
	 * Handles if a key is pressed.
	 * @param event of a key pressed
	 */
	@FXML
	public final void handleKeyPressed(final KeyEvent event) {
		game.getLogger().log("Player pressed " + event.getCode().toString(), LogEvent.Type.DEBUG);
        if (event.getCode().equals(KeyCode.S) && game.getPlayer().getLives() > 0) {
        	screenBeforePlay.toBack();
        	screenPaused.toBack();
        	game.start();
        } else if (event.getCode().equals(KeyCode.P)) {
        	if (game.isInProgress()) {
            	screenPaused.toFront();
            	game.getLogger().log("Show screen Paused", LogEvent.Type.INFO);
            	game.stop();
        	}
        } else if (event.getCode().equals(KeyCode.R)) {
        	if (game.hasEnded()) {
            	newGame();
            	game.start();
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