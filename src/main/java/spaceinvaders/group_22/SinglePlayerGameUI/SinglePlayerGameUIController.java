package spaceinvaders.group_22.SinglePlayerGameUI;

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
     * Initializes the UI elements.
     */
    protected void initializeUIElements() {
    	super.uiAlien = new UIElementAlien(getGame(), getGc());
    	super.uiSpaceShip = new UIElementSpaceShip(getGame(), getGc());
    	uiBullet = new UIElementBullet(getGame(), getGc());
    	uiExplosion = new UIElementExplosion(getGame(), getGc());
    	uiBarricade = new UIElementBarricade(getGame(), getGc());
    	uiScore = new Score(getGame(), getGc(), super.scoreLabel);
    	uiLives = new Lives(getGame(), getGc());
    	uiPowerUp = new UIElementPowerUp(getGame(), getGc());
    	
    	Logger.getInstance().log("UIElements initialized.", LogEvent.Type.INFO);
    }
}
