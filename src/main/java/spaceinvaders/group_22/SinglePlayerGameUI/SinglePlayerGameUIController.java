package spaceinvaders.group_22.SinglePlayerGameUI;

import spaceinvaders.group_22.MultiPlayerGame;
import spaceinvaders.group_22.SinglePlayerGame;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.ui.GameUIController;
import spaceinvaders.group_22.ui.UIElementAlien;
import spaceinvaders.group_22.ui.UIElementSpaceShip;
import spaceinvaders.group_22.ui.UIElementBullet;
import spaceinvaders.group_22.ui.UIElementExplosion;
import spaceinvaders.group_22.ui.UIElementBarricade;
import spaceinvaders.group_22.ui.UIElementPowerUp;

public class SinglePlayerGameUIController extends GameUIController {
    /**
     * Game object of the current game.
     */
    private SinglePlayerGame game;
	
    
	public SinglePlayerGameUIController() {
		Logger.getInstance().log("Created MultiPlayerGameUI Objec", LogEvent.Type.DEBUG);
	}
    /**
     * Initializes the UI elements.
     */
    protected void initializeUIElements() {
    	super.uiAlien = new UIElementAlien(getGame(), getGc());
    	super.uiSpaceShip = new UIElementSpaceShip(getGame(), getGc(), ((SinglePlayerGame)getGame()).getPlayer());
    	uiBullet = new UIElementBullet(getGame(), getGc());
    	uiExplosion = new UIElementExplosion(getGame(), getGc());
    	uiBarricade = new UIElementBarricade(getGame(), getGc());
    	uiScore = new Score((SinglePlayerGame)getGame(), getGc(), getScoreLabel());
    	uiLives = new Lives((SinglePlayerGame)getGame(), getGc());
    	uiPowerUp = new UIElementPowerUp(getGame(), getGc());
    	
    	Logger.getInstance().log("UIElements initialized.", LogEvent.Type.INFO);
    }
	
    /**
     * Creates a new game.
     */
    public final void newGame() {
    	// If the game does not exist, create a new one.
    	if (game == null) {
        	game = new SinglePlayerGame(getCanvasWidth(), getCanvasHeight());
        	Logger.getInstance().log("Set canvas width to: " + getCanvasWidth(), LogEvent.Type.INFO);
        	Logger.getInstance().log("Set canvas height to: " +  getCanvasHeight(), LogEvent.Type.INFO);
        	Logger.getInstance().log("Show screen Before Play", LogEvent.Type.INFO);
        // Else reset the existing game.
    	} else {
        	game.resetGame();    		
    	}
    	initializeUIElements();
    	startAnimation();
    }
    
    @Override
    public SinglePlayerGame getGame() {
    	return game;
    }
}
