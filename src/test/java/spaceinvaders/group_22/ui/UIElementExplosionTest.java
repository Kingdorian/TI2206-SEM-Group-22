package spaceinvaders.group_22.ui;

import org.junit.Rule;

import javafx.scene.canvas.GraphicsContext;
import spaceinvaders.group_22.game.SinglePlayerGame;
import spaceinvaders.group_22.ui.UIElement;
import spaceinvaders.group_22.ui.UIElementExplosion;

/**
 * Unit tests for the GameUIController class.
 * It uses a separate Class which opens the JavaFX thread to JUnit.
 * @author Jochem
 *
 */
@SuppressWarnings("checkstyle:magicnumber")    
public class UIElementExplosionTest extends UIElementTest {
	
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
	@Override
	public final UIElement createInstance(final SinglePlayerGame newGame, final GraphicsContext gc) {
		return new UIElementExplosion(newGame, gc);
	}

}
