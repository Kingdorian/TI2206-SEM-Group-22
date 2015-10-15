package spaceinvaders.group_22.ui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.SinglePlayerGame;
import spaceinvaders.group_22.unit.Unit;

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
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameUI.fxml"));
		try {
			fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		GameUIController gameUIController = fxmlLoader.getController();
		uiElement = createInstance(gameUIController.getGame(), gameUIController.getGC());
	}
	
	/**
	 * Tests adding sprites by comparing width and height of the testimage.
	 */
	@Test
	public final void testAddSprite() {
		Image testImage = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/testimage.png").toString());
		
		HashMap<String, Image> testMap = new HashMap<String, Image>();
		uiElement.addSprite(testMap, "testimage.png");
		
		Image compareImage = testMap.get("testimage.png"); 
		
		ArrayList<Double> result = new ArrayList<Double>();
		result.add(compareImage.getWidth());
		result.add(compareImage.getHeight());

		ArrayList<Double> compare = new ArrayList<Double>();
		compare.add(testImage.getWidth());
		compare.add(testImage.getHeight());
		
		// Compare by width and height.
		assertTrue(result.containsAll(compare));
		
	}


}
