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
@SuppressWarnings("checkstyle:magicnumber") 
public class Main extends Application {
	@Override
	public final void start(final Stage stage) {
		SpaceInvadersUI.setDefaultPrimaryStage(stage);
		SpaceInvadersUI userInterface = SpaceInvadersUI.getInstance();
		userInterface.loadUIScreen("Menu.fxml");
		userInterface.launch();
		
	}
	
	/**
	 * Launches the application.
	 * @param args command line arguments.
	 */
	public static void main(final String[] args) {
		Logger.getInstance().setLogFileLocation("log.log");
		Logger.setLogLevel(0);
		
		JavaArgumentReader argumentreader = new JavaArgumentReader(args);
		
		Logger.setLogLevel(argumentreader.parseLogLevel());

		launch(args);
	}
}
