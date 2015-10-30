package spaceinvaders.group_22.ui;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import javafx.fxml.FXMLLoader;
import spaceinvaders.group_22.ui.GameUIController;
import spaceinvaders.group_22.ui.singleplayergameui.SinglePlayerGameUIController;
import spaceinvaders.group_22.unit.NormalAlien;
import spaceinvaders.group_22.unit.Unit;

/**
 * Unit tests for the GameUIController class.
 * It uses a separate Class which opens the JavaFX thread to JUnit.
 * @author Jochem
 *
 */
@SuppressWarnings("checkstyle:magicnumber")    
public abstract class GameUIControllerTest {
	
	/**
	 * The gameUIController to test.
	 */
	private static GameUIController gameUIController;
	
	/**
	 * Class specifying rule to test JavaFX from GitHub.
	 */
	@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

	/**
	 * Create an instance of a GameUIController.
	 * @return GameUIController object.
	 */
	public abstract GameUIController createInstance();
	
	/**
	 * Prepares the test.
	 */
	@Before
	public final void setUp() {
		gameUIController = createInstance();
	}
	
	/**
	 * Tests the setFrameRate Method for a positive integer.
	 */
	@Test
	public final void testGetSetFrameRatePositive() {
		gameUIController.setFramerate(10);
		assertEquals(gameUIController.getFramerate(), 0.1, 0.0);
	}
	
	/**
	 * Tests the setFrameRate Method for a negative integer.
	 */
	@Test
	public final void testGetSetFrameRateNegative() {
		gameUIController.setFramerate(-10);
		assertEquals(gameUIController.getFramerate(), 0.0, 0.0);
	}
	
	/**
	 * Tests the setFrameRate Method for 0.
	 */
	@Test
	public final void testGetSetFrameRateZero() {
		gameUIController.setFramerate(0);
		assertEquals(gameUIController.getFramerate(), 0.0, 0.0);
	}
	
	/**
	 * Checks if the canvas width is set correctly.
	 */
	@Test
	public final void testInitialCanvasWidth() {
		assertEquals(gameUIController.getCanvasWidth(), 1000.0, 0.0);
	}
	
	/**
	 * Checks if the canvas height is set correctly.
	 */
	@Test
	public final void testInitialCanvasHeight() {
		assertEquals(gameUIController.getCanvasHeight(), 720.0, 0.0);
	}

}
