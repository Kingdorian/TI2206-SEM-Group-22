package spaceinvaders.group_22.MultiPlayerGameUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import spaceinvaders.group_22.MultiPlayerGame;
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
import java.util.ArrayList;

/**
 * Controller for a MultiPlayerGameUI.
 *
 */
public class MultiPlayerGameUIController extends GameUIController {
	
	/**
	 * The Label for the other player.
	 */
    private ArrayList<UIElementSpaceShip> uIspaceShips = new ArrayList<UIElementSpaceShip>();
	/**
	 * The Label for the other player.
	 */
    private ArrayList<Score> scores = new ArrayList<Score>();

    /**
     * Label to load the score of the player in.
     */
    @FXML
	private Label scoreLabelPlayer2;
    /**
     * Label to display the winning player.
     */
    @FXML
    private Label gameOverLabel;
    /**
     * Highscore label.
     */
    @FXML 
    private Label highScoreLabel;
	
    /**
     * Constructor for a new MultiPlayerGameUIController.
     */
	public MultiPlayerGameUIController() {
		Logger.getInstance().log("Created MultiPlayerGameUI Object", LogEvent.Type.DEBUG);
	}
	
    /**
     * Creates a new game.
     */
	@Override
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
    	initializeUIElements();
    	startAnimation();
    }
	
    /**
     * Initializes the UI elements.
     */
    protected final void initializeUIElements() {
    	setUIElementAlien(new UIElementAlien(getGame(), getGc()));
    	uIspaceShips.clear();
    	uIspaceShips.add(new UIElementSpaceShip(getGame(), getGc(), ((MultiPlayerGame) getGame()).getPlayers().get(0)));
    	uIspaceShips.add(new UIElementSpaceShip(getGame(), getGc(), ((MultiPlayerGame) getGame()).getPlayers().get(1)));
    	setUIElementBullet(new UIElementBullet(getGame(), getGc()));
    	setUIElementExplosion(new UIElementExplosion(getGame(), getGc()));
    	setUIElementBarricade(new UIElementBarricade(getGame(), getGc()));
    	scores.add(new Score((MultiPlayerGame) getGame(), 
    			getGc(), getScoreLabel(), ((MultiPlayerGame) getGame()).getPlayers().get(0)));
    	scores.add(new Score((MultiPlayerGame) getGame(), 
    			getGc(), scoreLabelPlayer2, ((MultiPlayerGame) getGame()).getPlayers().get(1)));
    	setUIElementLives(new Lives((MultiPlayerGame) getGame(), getGc()));
    	setUIElementPowerUp(new UIElementPowerUp(getGame(), getGc()));
    	
    	Logger.getInstance().log("UIElements initialized.", LogEvent.Type.INFO);
    }
    
    /**
     * Shows gameOverscreen.
     */
    public void showGameOverScreen() {

    }
	/**
	 * Returns all UI elements in this class.
	 */
    @Override
	public final ArrayList<UIElement> getUIElements() {
		ArrayList<UIElement> list = new ArrayList<UIElement>();
		list.addAll(uIspaceShips);
		list.addAll(scores);
		list.add(getUIElementLives());
		list.add(getUIElementAlien());
		list.add(getUIElementBullet());
		list.add(getUIElementBarricade());
		list.add(getUIElementExplosion());
		list.add(getUIElementPowerUp());
		return list;
	}
    
	@Override
	public final void setGameOverScreen() {
		int p1Score = ((MultiPlayerGame) getGame()).getPlayers().get(0).getScore();
		int p2Score = ((MultiPlayerGame) getGame()).getPlayers().get(1).getScore();
		if (p1Score > p2Score) {
			gameOverLabel.setText("Winner: player 1");
		} else if (p1Score < p2Score) {
			gameOverLabel.setText("Winner: player 2");
		// IF both players have equal score.
		} else if (((MultiPlayerGame) getGame()).getPlayers().get(0).getLives() == 0) {
			gameOverLabel.setText("Winner: player 2");
		} else if (((MultiPlayerGame) getGame()).getPlayers().get(1).getLives() == 0) {
			gameOverLabel.setText("Winner: player 1");
		} else {
			gameOverLabel.setText("Draw");
		}
		highScoreLabel.setText("Highscore: " + getGame().getHighScore());
		
	}
}
