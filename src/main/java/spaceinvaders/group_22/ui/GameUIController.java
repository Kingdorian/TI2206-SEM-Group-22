package spaceinvaders.group_22.ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
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
import javafx.util.Duration;

/**
 * Controller for the GameUI.fxml file,
 * controlling the behavior of a game.
 * @author Jochem
 *
 */
@SuppressWarnings("checkstyle:magicnumber")    
public abstract class GameUIController
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
     * Label to display the winning player.
     */
    @FXML
    private Label gameOverLabel;
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
    
    private GraphicsContext gc;
    /**
     * The drawing of the SpaceShip.
     */
    
    private UIElementSpaceShip uiSpaceShip;
    /**
     * The drawing of the Alien.
     */
    
    private UIElementAlien uiAlien;
    /**
     * The drawing of the Bullet.
     */
    
    private UIElementBullet uiBullet;
    /**
     * The drawing of the Explosion.
     */
    
    private UIElementExplosion uiExplosion;
    /**
     * The drawing of the PowerUp.
     */
    
    private UIElementPowerUp uiPowerUp;
    /**
     * The drawing of the Barricade.
     */
    
    private UIElementBarricade uiBarricade;
    
    /**
     * The drawing of the score.
     */
    private UIElementScore uiScore;
    
    /**
     * The drawing of the lives.
     */
    private UIElementLives uiLives;
    
    /**
     * Called by the FXMLLoader. 
     */
    @Override
	public final void initialize(final URL fxmlFileLocation, final ResourceBundle resources) {
    	initializeStackPaneScreens();
    	// Get the GraphicsContext of the canvas, so you can draw on it.
    	setGc(canvas.getGraphicsContext2D());
    	canvasWidth = canvas.getWidth();
    	canvasHeight = canvas.getHeight();
    	
    	newGame();
    	
    	initializeUIElements();
    	canvas.setFocusTraversable(true);
    }
    
    /**
     * Initializes the UI elements.
     */
    protected abstract void initializeUIElements();
    
    /**
     * Returns the canvas Width.
     * @return canvasWidth
     */
    public final double getCanvasWidth() {
    	return canvasWidth;
    }
    
    /**
     * Returns the canvas Height.
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
    public abstract void newGame();
    
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
    	Logger.getInstance().log("Set framerate to: " + framerate, LogEvent.Type.INFO);
    }
    
    /**
     * Returns the framerate.
     * @return the framerate of the animation.
     */
    public final double getFramerate() {
    	return framerate;
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
    	getGame().setTickrate(framerate);
    	
    	// Create each frame.
		KeyFrame frame = new KeyFrame(
			Duration.seconds(framerate), 
				new EventHandler<ActionEvent>()
				{
					public void handle(final ActionEvent ae) {
						// Clear the canvas.
						getGc().clearRect(0, 0, canvasWidth, canvasHeight);
						
						// If the game is in progress, look if any key is pressed.
						if (getGame().isInProgress()) {
							getGame().tick(pressedKeys);
						}
						
						// Draw the various units on the screen.
						for (UIElement uiE : getUIElements()) {
							uiE.draw();
						}
					
						
						if (pressedKeys.contains(KeyCode.SPACE)) {
					    	pressedKeys.remove(KeyCode.SPACE);
					    }
						
						// If the game has ended, put the Game Over screen to the front.
						if (getGame().hasEnded()) {
							screenGameOver.toFront();
							setGameOverScreen();
							gameLoop.stop();
							Logger.getInstance().log("Show screen Game Over", LogEvent.Type.INFO);
						} else {
							screenGameOver.toBack();
						}
						
					}
				});
		
		 gameLoop.getKeyFrames().add(frame);
		 gameLoop.play();
    }
	
	/**
	 * Returns the scoreLabel.
	 * @return The scoreLabel of the UI.
	 */
	public final Label getScoreLabel() {
		return scoreLabel;
	}
	
	/**
	 * Sets the values for the game over screen.
	 */
	public final void setGameOverScreen() {
		gameOverLabel.setText("Game Over");
		highScoreLabel.setText("Highscore: " + getGame().getHighScore());
	}
	/**
	 * Returns the game.
	 * @return The game object of the UI.
	 */
	public final Game getGame() {
		return game;
	}
	
	/**
	 * Returns all UI elements in this class.
	 * @return The UIElements in this class
	 */
	public final ArrayList<UIElement> getUIElements() {
		ArrayList<UIElement> list = new ArrayList<UIElement>();
		list.add(uiSpaceShip);
		list.add(uiAlien);
		list.add(uiBullet);
		list.add(uiBarricade);
		list.add(uiExplosion);
		list.add(uiPowerUp);
		// Draw the lives and score on the screen.
		list.add(uiLives);
		list.add(uiScore);
		return list;
	}
	/**
	 * Sets game to provided game.
	 * @param g game to set game to
	 */
	public final void setGame(final Game g) {
		game = g;
	}
	
	/**
	 * Returns the graphicsContext.
	 * @return The graphicsContext of the UI.
	 */
	public final GraphicsContext getGC() {
		return getGc();
	}
	
	/**
	 * Handles if a key is pressed.
	 * @param event of a key pressed
	 */
	@FXML
	public final void handleKeyPressed(final KeyEvent event) {
        if (event.getCode().equals(KeyCode.S) && !getGame().isInProgress()) {
        	Logger.getInstance().log("Player pressed S", LogEvent.Type.DEBUG);
        	screenBeforePlay.toBack();
        	screenPaused.toBack();
        	getGame().start();
        } else if (event.getCode().equals(KeyCode.P)) {
        	if (getGame().isInProgress()) {
        		Logger.getInstance().log("Player pressed P", LogEvent.Type.DEBUG);
            	screenPaused.toFront();
            	Logger.getInstance().log("Show screen Paused", LogEvent.Type.INFO);
            	getGame().stop();
        	}
        } else if (event.getCode().equals(KeyCode.R)) {
        	Logger.getInstance().log("Player pressed R", LogEvent.Type.DEBUG);
        	if (getGame().hasEnded()) {
            	newGame();
            	getGame().start();
        	}
        } else if (event.getCode().equals(KeyCode.M)) {
        	if (getGame().hasEnded()) {
        		getGame().stop();
        		SpaceInvadersUI.getInstance().loadUIScreen("Menu.fxml");
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
	
	/**
	 * Returns the Graphiccontext object of this object.
	 * @return the GraphicsContext
	 */
	public final GraphicsContext getGc() {
		return gc;
	}

	/**
	 * Sets the current graphicscontext to draw on.
	 * @param newGC The graphicscontext to draw on.
	 */
	public final void setGc(final GraphicsContext newGC) {
		this.gc = newGC;
	}
	
	/**
	 * Returns the UIElement object for the spaceship.
	 * @return a UIElement for the spaceship.
	 */
	public final UIElementSpaceShip getUIElementSpaceShip() {
		return uiSpaceShip;
	}
	
	/**
	 * Sets the UIElement object for the spaceship.
	 * @param newUIElement UIElement for the spaceship.
	 */
	public final void setUIElementSpaceShip(final UIElementSpaceShip newUIElement) {
		this.uiSpaceShip = newUIElement;
	}
	
	/**
	 * Returns the UIElement object for the alien.
	 * @return a UIElement for the alien.
	 */
	public final UIElementAlien getUIElementAlien() {
		return uiAlien;
	}
		
	/**
	 * Sets the UIElement object for the alien.
	 * @param newUIElement UIElement for the alien.
	 */
	public final void setUIElementAlien(final UIElementAlien newUIElement) {
		this.uiAlien = newUIElement;
	}
	
	/**
	 * Returns the UIElement object for the bullet.
	 * @return a UIElement for the bullet.
	 */
	public final UIElementBullet getUIElementBullet() {
		return uiBullet;
	}
	
	/**
	 * Sets the UIElement object for the bullet.
	 * @param newUIElement UIElement for the bullet.
	 */
	public final void setUIElementBullet(final UIElementBullet newUIElement) {
		this.uiBullet = newUIElement;
	}
	
	/**
	 * Returns the UIElement object for the explosion.
	 * @return a UIElement for the explosion.
	 */
	public final UIElementExplosion getUIElementExplosion() {
		return uiExplosion;
	}
	
	/**
	 * Sets the UIElement object for the explosion.
	 * @param newUIElement UIElement for the explosion.
	 */
	public final void setUIElementExplosion(final UIElementExplosion newUIElement) {
		this.uiExplosion = newUIElement;
	}
	
	/**
	 * Returns the UIElement object for the powerup.
	 * @return a UIElement for the powerup.
	 */
	public final UIElementPowerUp getUIElementPowerUp() {
		return uiPowerUp;
	}
	
	/**
	 * Sets the UIElement object for the powerup.
	 * @param newUIElement UIElement for the powerup.
	 */
	public final void setUIElementPowerUp(final UIElementPowerUp newUIElement) {
		this.uiPowerUp = newUIElement;
	}
	
	/**
	 * Returns the UIElement object for the barricade.
	 * @return a UIElement for the barricade.
	 */
	public final UIElementBarricade getUIElementBarricade() {
		return uiBarricade;
	}
	
	/**
	 * Sets the UIElement object for the barricade.
	 * @param newUIElement UIElement for the barricade.
	 */
	public final void setUIElementBarricade(final UIElementBarricade newUIElement) {
		this.uiBarricade = newUIElement;
	}

	/**
	 * Returns the UIElement object for the score.
	 * @return a UIElement for the score.
	 */
	public final UIElementScore getUIElementScore() {
		return uiScore;
	}
	
	/**
	 * Sets the UIElement object for the score.
	 * @param newUIElement UIElement for the score.
	 */
	public final void setUIElementScore(final UIElementScore newUIElement) {
		this.uiScore = newUIElement;
	}

	/**
	 * Returns the UIElement object for the lives.
	 * @return a UIElement for the lives.
	 */
	public final UIElementLives getUIElementLives() {
		return uiLives;
	}

	/**
	 * Sets the UIElement object for the lives.
	 * @param newUIElement UIElement for the lives.
	 */
	public final void setUIElementLives(final UIElementLives newUIElement) {
		this.uiLives = newUIElement;
	}


}