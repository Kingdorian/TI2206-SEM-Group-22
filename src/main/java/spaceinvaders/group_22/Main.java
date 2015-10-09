package spaceinvaders.group_22;
	
import javafx.application.Application;
import javafx.stage.Stage;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.ui.SpaceInvadersUI;

/**
 * Main controller of the application.
 * @author Jochem
 *
 */
public class Main extends Application {
	@Override
	public final void start(final Stage stage) {
		SpaceInvadersUI userInterface = new SpaceInvadersUI(stage);
		userInterface.loadUIScreen("GameUI.fxml");
		userInterface.launch();
		
	}
	
	/**
	 * Launches the application.
	 * @param args command line arguments.
	 */
	public static void main(final String[] args) {
		launch(args);
		
		// Initalize the logger.
		Logger.getInstance().setLogFileLocation("log.log");
		Logger.getInstance().setLogLevel(1);
	}
}
