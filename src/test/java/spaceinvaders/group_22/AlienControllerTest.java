package spaceinvaders.group_22;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import spaceinvaders.group_22.ui.JavaFXThreadingRule;
import spaceinvaders.group_22.unit.Alien;

/**
 * Test for the AlienController.
 * @author Ege
 *
 */
public class AlienControllerTest {

	/**
	 * Static game used for testing.
	 */
	private static Game game;
	/**
	 * Static Controller used for testing.
	 */
	private static AlienController controller;
	
	/**
	 * Class specifying rule to test JavaFX from GitHub.
	 */
	@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
	
	/**
	 * Set up every test with an AlienController.
	 */
	@Before
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void setUpController() {
		game = new SinglePlayerGame(1000, 720);
		controller = game.getAlienController();
		game.setTickrate(0.1);
		ArrayList<Alien> row = new ArrayList<Alien>();
		for (int i = 0; i < 10; i++) {
			row.add(new Alien(500, 350));
		}
		ArrayList<ArrayList<Alien>> aliens = new ArrayList<ArrayList<Alien>>();
		aliens.add(row);
		game.getAlienController().getAlienWave().setAliens(aliens);
	}

	/**
	 * Test the move method.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void testmove() {
		ArrayList<Double> xValues = new ArrayList<Double>();
		ArrayList<Double> yValues = new ArrayList<Double>();
		for (int i = 0; i < game.getAlienController().getAliens().size(); i++) {
			xValues.add(game.getAlienController().getAliens().get(i).getXCoor());
			yValues.add(game.getAlienController().getAliens().get(i).getYCoor());
		}
		controller.move();
		for (int i = 0; i < game.getAlienController().getAliens().size(); i++) {
			assertEquals(xValues.get(i) + 4, game.getAlienController().getAliens().get(i).getXCoor(), 0.05);
		}
	}

	/**
	 * Test the move method when Aliens come to the side.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")
	public final void testmoveSide() {
		ArrayList<Double> xValues = new ArrayList<Double>();
		ArrayList<Double> yValues = new ArrayList<Double>();
		for (int i = 0; i < game.getAlienController().getAliens().size(); i++) {
			xValues.add(game.getAlienController().getAliens().get(i).getXCoor());
			yValues.add(game.getAlienController().getAliens().get(i).getYCoor());
		}
		for (int i = 0; i < 500; i++) {
			//Move to the right side of the screen
			controller.move();
		}
		for (int i = 0; i < game.getAlienController().getAliens().size(); i++) {
			assertEquals(yValues.get(i) + 8, game.getAlienController().getAliens().get(i).getYCoor(), 0.05);
		}
	}
}
