package spaceinvaders.group_22.MultiPlayerGameUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.MultiPlayerGame;
import spaceinvaders.group_22.SinglePlayerGame;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.ui.GameUIController;
import spaceinvaders.group_22.ui.UIElement;
import spaceinvaders.group_22.ui.UIElementAlien;
import spaceinvaders.group_22.ui.UIElementSpaceShip;
import spaceinvaders.group_22.ui.UIElementBullet;
import spaceinvaders.group_22.ui.UIElementExplosion;
import spaceinvaders.group_22.ui.UIElementBarricade;
import spaceinvaders.group_22.ui.UIElementPowerUp;
import spaceinvaders.group_22.ui.UIElementScore;
import java.util.ArrayList;

public class MultiPlayerGameUIController extends GameUIController {
	
    /**
     * Game object of the current game.
     */
    private MultiPlayerGame game;
	/**
	 * The Label for the other player.
	 */
    private ArrayList<UIElementSpaceShip> UIspaceShips = new ArrayList<UIElementSpaceShip>();
	/**
	 * The Label for the other player.
	 */
    private ArrayList<Score> scores = new ArrayList<Score>();

    /**
     * Label to load the score of the player in.
     */
    @FXML
	private Label scoreLabelPlayer2;
	
	public MultiPlayerGameUIController() {
		Logger.getInstance().log("Created MultiPlayerGameUI Object", LogEvent.Type.DEBUG);
	}
	
    /**
     * Creates a new game.
     */
    public final void newGame() {
    	// If the game does not exist, create a new one.
    	if (getGame() == null) {
        	game = new MultiPlayerGame(getCanvasWidth(), getCanvasHeight());
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
    @Override
    protected void initializeUIElements() {
    	super.uiAlien = new UIElementAlien(getGame(), getGc());
    	UIspaceShips.add(new UIElementSpaceShip(getGame(), getGc(), getGame().getPlayers().get(0)));
    	UIspaceShips.add(new UIElementSpaceShip(getGame(), getGc(), getGame().getPlayers().get(1)));
    	uiBullet = new UIElementBullet(getGame(), getGc());
    	uiExplosion = new UIElementExplosion(getGame(), getGc());
    	uiBarricade = new UIElementBarricade(getGame(), getGc());
    	scores.add(new Score(getGame(), getGc(), getScoreLabel()));
    	scores.add(new Score(getGame(), getGc(), scoreLabelPlayer2));
    	uiLives = new Lives(getGame(), getGc());
    	uiPowerUp = new UIElementPowerUp(getGame(), getGc());
    	
    	Logger.getInstance().log("UIElements initialized.", LogEvent.Type.INFO);
    }
	/**
	 * Returns all UI elements in this class.
	 */
    @Override
	public ArrayList<UIElement> getUIElements() {
		ArrayList<UIElement> list = new ArrayList<UIElement>();
		list.addAll(UIspaceShips);
		list.addAll(scores);
		list.add(uiLives);
		list.add(uiAlien);
		list.add(uiBullet);
		list.add(uiBarricade);
		list.add(uiExplosion);
		list.add(uiPowerUp);
		return list;
	}
    
    @Override
    public MultiPlayerGame getGame() {
    	return game;
    }
}
