package spaceinvaders.group_22.ui;

import java.io.IOException;
import org.junit.Before;
import org.junit.Rule;

import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.GraphicsContext;
import spaceinvaders.group_22.game.SinglePlayerGame;
import spaceinvaders.group_22.ui.GameUIController;
import spaceinvaders.group_22.ui.UIElement;

/**
 * Unit tests for the GameUIController class.
 * It uses a separate Class which opens the JavaFX thread to JUnit.
 * @author Jochem
 *
 */
@SuppressWarnings("checkstyle:magicnumber")    
public abstract class UIElementTest {
	
	/**
	 * The UIElement to test.
	 */
	private UIElement uiElement;
	
	/**
	 * Class specifying rule to test JavaFX from GitHub.
	 */
	@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

	/**
	 * Method to create an instance of a subclass of the Unit class.
	 * @param newGame the Game object.
	 * @param gc the GraphicsContext.
	 * @return The UIElement subclass to test.
	 */
	public abstract UIElement createInstance(final SinglePlayerGame newGame, final GraphicsContext gc);
	
	/**
	 * Prepares the test.
	 */
	@Before
	public final void setUp() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SinglePlayerGameUI.fxml"));
		try {
			fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		GameUIController gameUIController = fxmlLoader.getController();
		uiElement = createInstance((SinglePlayerGame) gameUIController.getGame(), gameUIController.getGC());
	}

}
