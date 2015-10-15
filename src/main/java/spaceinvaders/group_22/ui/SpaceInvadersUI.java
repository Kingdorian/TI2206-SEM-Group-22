package spaceinvaders.group_22.ui;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import spaceinvaders.group_22.logger.Logger;

/**
 * Class which creates an object that is used to maintain
 * the User Interface.
 * @author Jochem
 *
 */
public class SpaceInvadersUI {
	/**
	 * Singleotn instance.
	 */
	private static SpaceInvadersUI instance;
	
	/**
	 * Stage object, defining the primary Stage of the program.
	 */
	private Stage primaryStage;
	/**
	 * Default primarystage object used when creating a new instance.
	 */
	private static Stage defaultPrimaryStage;

	/**
	 * Creates a new SpaceInvadersUI singleton object.
	 */
	public static SpaceInvadersUI getInstance() {
		if (instance == null) {
			instance = new SpaceInvadersUI(defaultPrimaryStage);
		}	
		return instance; 
	}
	/**
	 * Constructor for a SpaceInvadersUI object.
	 * @param stage A JavaFX Stage.
	 */
	private SpaceInvadersUI(final Stage stage) {
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
	 * Closes the UI and exit the app.
	 */
	public void quit() {
	  System.exit(1);
	}
	
	/**
	 * Launch the User Interface.
	 */
	public final void launch() {
		primaryStage.show();
	}
	/**
	 * Sets the stage.
	 */
	public final void setStage(Stage s) {
		primaryStage = s;
	}
	/**
	 * Sets the default primary stage.
	 */
	public static final void setDefaultPrimaryStage(Stage s) {
		defaultPrimaryStage = s;
	}

}
