package spaceinvaders.group_22.MultiPlayerGameUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.ui.GameUIController;
import spaceinvaders.group_22.ui.UIElementAlien;
import spaceinvaders.group_22.ui.UIElementSpaceShip;
import spaceinvaders.group_22.ui.UIElementBullet;
import spaceinvaders.group_22.ui.UIElementExplosion;
import spaceinvaders.group_22.ui.UIElementBarricade;
import spaceinvaders.group_22.ui.UIElementPowerUp;

public class MultiPlayerGameUIController extends GameUIController {
	
	/**
	 * The Label for the other player.
	 */
    /**
     * Label to load the score of the player in.
     */
    @FXML
	private Label scoreLabelPlayer2;
	
	public void MultiPlayerGameUIController() {
		
	}
	
    /**
     * Initializes the UI elements.
     */
    protected void initializeUIElements() {
    	super.uiAlien = new UIElementAlien(getGame(), getGc());
    	super.uiSpaceShip = new UIElementSpaceShip(getGame(), getGc());
    	uiBullet = new UIElementBullet(getGame(), getGc());
    	uiExplosion = new UIElementExplosion(getGame(), getGc());
    	uiBarricade = new UIElementBarricade(getGame(), getGc());
    	uiScore = new Score(getGame(), getGc(), getScoreLabel(), scoreLabelPlayer2);
    	uiLives = new Lives(getGame(), getGc());
    	uiPowerUp = new UIElementPowerUp(getGame(), getGc());
    	
    	Logger.getInstance().log("UIElements initialized.", LogEvent.Type.INFO);
    }
}
