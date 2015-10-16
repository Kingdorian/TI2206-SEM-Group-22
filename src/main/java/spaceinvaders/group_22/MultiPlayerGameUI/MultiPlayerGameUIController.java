package spaceinvaders.group_22.MultiPlayerGameUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import spaceinvaders.group_22.MultiPlayerGame;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.ui.GameUIController;
import spaceinvaders.group_22.ui.UIElementAlien;
import spaceinvaders.group_22.ui.UIElementSpaceShip;
import spaceinvaders.group_22.ui.UIElementBullet;
import spaceinvaders.group_22.ui.UIElementExplosion;
import spaceinvaders.group_22.ui.UIElementBarricade;
import spaceinvaders.group_22.ui.UIElementPowerUp;

/**
 * Controller for a MultiPlayerGameUI.
 *
 */
public class MultiPlayerGameUIController extends GameUIController {
	
	/**
	 * The Label for the other player.
	 */
    @FXML
	private Label scoreLabelPlayer2;
	
    /**
     * Constructor for a new MultiPlayerGameUIController.
     */
	public MultiPlayerGameUIController() {
		Logger.getInstance().log("Created MultiPlayerGameUI Objec", LogEvent.Type.DEBUG);
	}
	
    /**
     * Creates a new game.
     */
    public final void newGame() {
    	// If the game does not exist, create a new one.
    	if (getGame() == null) {
        	setGame(new MultiPlayerGame(getCanvasWidth(), getCanvasHeight()));
        	Logger.getInstance().log("Set canvas width to: " + getCanvasWidth(), LogEvent.Type.INFO);
        	Logger.getInstance().log("Set canvas height to: " +  getCanvasHeight(), LogEvent.Type.INFO);
        	Logger.getInstance().log("Show screen Before Play", LogEvent.Type.INFO);
        // Else reset the existing game.
    	} else {
        	getGame().resetGame();    		
    	}

    	startAnimation();
    }
	
    /**
     * Initializes the UI elements.
     */
    protected final void initializeUIElements() {
    	setUIElementAlien(new UIElementAlien(getGame(), getGc()));
    	setUIElementSpaceShip(new UIElementSpaceShip(getGame(), 
    			getGc(), ((MultiPlayerGame) getGame()).getPlayers().get(0)));
    	setUIElementSpaceShip(new UIElementSpaceShip(getGame(), 
    			getGc(), ((MultiPlayerGame) getGame()).getPlayers().get(1)));
    	setUIElementBullet(new UIElementBullet(getGame(), getGc()));
    	setUIElementExplosion(new UIElementExplosion(getGame(), getGc()));
    	setUIElementBarricade(new UIElementBarricade(getGame(), getGc()));
    	setUIElementScore(new Score((MultiPlayerGame) getGame(), getGc(), getScoreLabel(), scoreLabelPlayer2));
    	setUIElementLives(new Lives((MultiPlayerGame) getGame(), getGc()));
    	setUIElementPowerUp(new UIElementPowerUp(getGame(), getGc()));
    	
    	Logger.getInstance().log("UIElements initialized.", LogEvent.Type.INFO);
    }
}
