package spaceinvaders.group_22.ui;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.sound.SoundController;

/**
 * Controller for the Game Menu.
 * @author Dorian
 *
 */
public class GameMenuController {

	/**
	 * Button toggling sound effects.
	 */
    @FXML private ToggleButton toggleSFX;

    /**
     * Button toggling background music.
     */
    @FXML private ToggleButton toggleBGM;
	
	/**
	 * Method to start a single player game.
	 */
	public final void startSinglePlayer() {
		SpaceInvadersUI.getInstance().loadUIScreen("SinglePlayerGameUI.fxml");
		Logger.getInstance().log("Starting a singleplayer game", LogEvent.Type.DEBUG);
	}
	
	/**
	 * Method to start a multiplayer game.
	 */
	public final void startMultiPlayer() {
		SpaceInvadersUI.getInstance().loadUIScreen("MultiPlayerGameUI.fxml");
		Logger.getInstance().log("Starting a multiplayer game", LogEvent.Type.DEBUG);
	}
	
	/**
	 * Method to exit the program.
	 */
	public final void quit() {
		Logger.getInstance().log("Quitting game", LogEvent.Type.DEBUG);
		//Make sure everything in the buffer of the logger is written to the file
		Logger.getInstance().writeLog();
		SpaceInvadersUI.getInstance().quit();
	}
	
	/**
	 * Toggles sound effects.
	 */
	public final void toggleSFX() {
		SoundController controller = SoundController.getInstance();
		
		if (toggleSFX.isSelected()) {
			controller.setSFXEnabled(false);
		} else {
			controller.setSFXEnabled(true);
		}
	}
	
	/**
	 * Toggles background music.
	 */
	public final void toggleBGM() {
		SoundController controller = SoundController.getInstance();
		
		if (toggleBGM.isSelected()) {
			controller.setBGMEnabled(false);
		} else {
			controller.setBGMEnabled(true);
		}
	}
}
