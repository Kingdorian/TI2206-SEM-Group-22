package spaceinvaders.group_22.ui.singleplayergameui;

import java.util.ArrayList;

import spaceinvaders.group_22.game.SinglePlayerGame;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.sound.SoundController;
import spaceinvaders.group_22.ui.GameUIController;
import spaceinvaders.group_22.ui.UIElement;
import spaceinvaders.group_22.ui.UIElementAlien;
import spaceinvaders.group_22.ui.UIElementSpaceShip;
import spaceinvaders.group_22.ui.UIElementBullet;
import spaceinvaders.group_22.ui.UIElementExplosion;
import spaceinvaders.group_22.ui.UIElementBarricade;
import spaceinvaders.group_22.ui.UIElementPowerUp;


/**
 * Controller for a SinglePlayerGameUI.
 *
 */
public class SinglePlayerGameUIController extends GameUIController {
    
    /**
     * Constructor for a new SinglePlayerGameUIController.
     */
	public SinglePlayerGameUIController() {
		Logger.getInstance().log("Created MultiPlayerGameUI Objec", LogEvent.Type.DEBUG);
	}
    /**
     * Initializes the UI elements.
     */
    protected final void initializeUIElements() {
    	setUIElementAlien(new UIElementAlien(getGame(), getGc()));
    	setUIElementSpaceShip(new UIElementSpaceShip(getGame(), getGc(), ((SinglePlayerGame) getGame()).getPlayer()));
    	setUIElementBullet(new UIElementBullet(getGame(), getGc()));
    	setUIElementExplosion(new UIElementExplosion(getGame(), getGc()));
    	setUIElementBarricade(new UIElementBarricade(getGame(), getGc()));
    	setUIElementScore(new SinglePlayerGameScore((SinglePlayerGame) getGame(), getGc(), getScoreLabel()));
    	setUIElementLives(new SinglePlayerGameLives((SinglePlayerGame) getGame(), getGc()));
    	setUIElementPowerUp(new UIElementPowerUp(getGame(), getGc()));
    	
    	Logger.getInstance().log("UIElements initialized.", LogEvent.Type.INFO);
    }
	
    /**
     * Creates a new game.
     */
    public final void newGame() {
    	// If the game does not exist, create a new one.
    	if (getGame() == null) {
        	setGame(new SinglePlayerGame(getCanvasWidth(), getCanvasHeight()));
        	Logger.getInstance().log("Set canvas width to: " + getCanvasWidth(), LogEvent.Type.INFO);
        	Logger.getInstance().log("Set canvas height to: " +  getCanvasHeight(), LogEvent.Type.INFO);
        	Logger.getInstance().log("Show screen Before Play", LogEvent.Type.INFO);
        // Else reset the existing game.
    	} else {
        	getGame().resetGame();    		
    	}
    	initializeUIElements();
    	startAnimation();
    }
    
	/**
	 * Returns all UI elements in this class.
	 * @return The UIElements in this class
	 */
	public final ArrayList<UIElement> getUIElements() {
		ArrayList<UIElement> list = new ArrayList<UIElement>();
		list.add(getUIElementSpaceShip());
		list.add(getUIElementAlien());
		list.add(getUIElementBullet());
		list.add(getUIElementBarricade());
		list.add(getUIElementExplosion());
		list.add(getUIElementPowerUp());
		// Draw the lives and score on the screen.
		list.add(getUIElementLives());
		list.add(getUIElementScore());
		return list;
	}
    
	/**
	 * Sets the values for the game over screen.
	 */
	public final void setGameOverScreen() {
		SoundController.Sound.STOP_GAME.play();
		SoundController.Sound.BGM.stop();

		getGameOverLabel().setText("Game Over");
		getHighscoreLabel().setText("Highscore: " + getGame().getHighScore());
	}
 
}
