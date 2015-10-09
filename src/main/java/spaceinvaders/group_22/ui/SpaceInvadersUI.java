package spaceinvaders.group_22.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.Logger;

/**
 * Class which creates an object that is used to maintain
 * the User Interface.
 * @author Jochem
 *
 */
public class SpaceInvadersUI {
	
	/**
	 * Stage object, defining the primary Stage of the program.
	 */
	private Stage primaryStage;

	/**
	 * Constructor for a SpaceInvadersUI object.
	 * @param stage A JavaFX Stage.
	 */
	public SpaceInvadersUI(final Stage stage) {
		// Construction the object, setting the title of the application.
		this.primaryStage = stage;
		primaryStage.setTitle("Space Invaders");

		// Loading the root layout.
		try {
			Parent root = FXMLLoader.load(getClass().getResource("SpaceInvadersUI.fxml"));
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);			
		} catch (IOException e) {
			Logger.getInstance().log("Could not find fxml file", e);
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Load a User Interface fxml file into the root layout.
	 * @param fxmlFile Filename of the FXML file containing the layout.
	 */
	public final void loadUIScreen(final String fxmlFile) {
		try {
			Parent screen = FXMLLoader.load(getClass().getResource(fxmlFile));
			primaryStage.getScene().setRoot(screen);
		} catch (IOException e) {
			Logger.getInstance().log("Could not find fxml file", e);
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Launch the User Interface.
	 */
	public final void launch() {
		primaryStage.show();
	}

}
