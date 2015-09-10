package spaceinvaders.group_22.ui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import spaceinvaders.group_22.Game;

/**
 * Unit tests for the GameUIController class.
 * It uses a separate Class which opens the JavaFX thread to JUnit.
 * @author Jochem
 *
 */
@SuppressWarnings("checkstyle:magicnumber")    
public class GameUIControllerTest {
	
	/**
	 * The gameUIController to test.
	 */
	private static GameUIController gameUIController;
	
	/**
	 * Class specifying rule to test JavaFX from GitHub.
	 */
	@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

	/**
	 * Prepares the test.
	 */
	@Before
	public final void setUp() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameUI.fxml"));
			fxmlLoader.load();
			gameUIController = fxmlLoader.getController();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Tests the setFrameRate Method for a positive integer.
	 */
	@Test
	public final void testGetSetFrameRatePositive() {
		gameUIController.setFramerate(10);
		assertTrue(gameUIController.getFramerate() == 0.1);
	}
	
	/**
	 * Tests the setFrameRate Method for a negative integer.
	 */
	@Test
	public final void testGetSetFrameRateNegative() {
		gameUIController.setFramerate(-10);
		assertTrue(gameUIController.getFramerate() == 0);
	}
	
	/**
	 * Tests the setFrameRate Method for 0.
	 */
	@Test
	public final void testGetSetFrameRateZero() {
		gameUIController.setFramerate(0);
		assertTrue(gameUIController.getFramerate() == 0);
	}
	
	/**
	 * Checks if the canvas width is set correctly.
	 */
	@Test
	public final void testInitialCanvasWidth() {
		assertTrue(gameUIController.getCanvasWidth() == 1000.0);
	}
	
	/**
	 * Checks if the canvas height is set correctly.
	 */
	@Test
	public final void testInitialCanvasHeight() {
		assertTrue(gameUIController.getCanvasHeight() == 720.0);
	}
	
	/**
	 * Tests adding sprites by comparing width and height of the testimage.
	 */
	@Test
	public final void testAddSprite() {
		Image testImage = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/testimage.png").toString());
		
		HashMap<String, Image> testMap = new HashMap<String, Image>();
		gameUIController.addSprite(testMap, "testimage.png");
		
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
	
	/**
	 * Tests the score formatter.
	 */
	@Test
	public final void testFormatScore() {
		Label scoreLabel = gameUIController.getScoreLabel();
		gameUIController.formatScore(423455); 
		
		assertEquals(scoreLabel.getText(), "00423455");
	}

	/**
	 * Tests creation of a new game if the game is not null.
	 */
	@Test
	public final void testNewGame() {

		
	}

}
