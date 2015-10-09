package spaceinvaders.group_22;
	
import java.util.Arrays;

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
		SpaceInvadersUI userInterface = new SpaceInvadersUI(stage);
		userInterface.loadUIScreen("GameUI.fxml");
		userInterface.launch();
		
	}
	
	/**
	 * Launches the application.
	 * @param args command line arguments.
	 */
	public static void main(final String[] args) {
		
		Logger.getInstance().setLogFileLocation("log.log");
		Logger.getInstance().setLogLevel(0);
		
		for (String arg : Arrays.asList(args)) {
			if (arg.startsWith("-log=")) {
				int i = Integer.parseInt(arg.substring(5));
				
				if (i >= 0 && i <= 5) {
					Logger.getInstance().setLogLevel(i);			
				}
			}
		}

		launch(args);
	}
}
