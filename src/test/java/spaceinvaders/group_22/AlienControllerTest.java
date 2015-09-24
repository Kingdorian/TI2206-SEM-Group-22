package spaceinvaders.group_22;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

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
	 * Set up every test with an AlienController.
	 */
	@Before
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void setUpController() {
		game = new Game(1000, 720);
		controller = game.getAlienController();
		game.setTickrate(0.1);
	}
	
	/**
	 * Test the createAlienWave method.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void testCreateAlienWave() {
		ArrayList<Alien> aliens = controller.createAlienWave(0, 0, 0, 5, 5);
		assertEquals(aliens.size(), 25);
		for (int i = 0; i < aliens.size(); i++) {
			//Test if every alien has the right sprite
			assertEquals(aliens.get(i).getSprite(), "invader.png");
		}
	}

	/**
	 * Test the moveAliens method.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void testMoveAliens() {
		ArrayList<Double> xValues = new ArrayList<Double>();
		ArrayList<Double> yValues = new ArrayList<Double>();
		for (int i = 0; i < game.getAlienController().getAliens().size(); i++) {
			xValues.add(game.getAlienController().getAliens().get(i).getXCoor());
			yValues.add(game.getAlienController().getAliens().get(i).getYCoor());
		}
		controller.moveAliens();
		for (int i = 0; i < game.getAlienController().getAliens().size(); i++) {
			assertTrue(game.getAlienController().getAliens().get(i).getXCoor() == (xValues.get(i) + 4));
		}
	}
	
	/**
	 * Test the moveAliens method when Aliens come to the side.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")
	public final void testMoveAliensSide() {
		ArrayList<Double> xValues = new ArrayList<Double>();
		ArrayList<Double> yValues = new ArrayList<Double>();
		for (int i = 0; i < game.getAlienController().getAliens().size(); i++) {
			xValues.add(game.getAlienController().getAliens().get(i).getXCoor());
			yValues.add(game.getAlienController().getAliens().get(i).getYCoor());
		}
		for (int i = 0; i < 30; i++) {
			//Move to the right side of the screen
			controller.moveAliens();
		}
		for (int i = 0; i < game.getAlienController().getAliens().size(); i++) {
			assertTrue(game.getAlienController().getAliens().get(i).getYCoor() == (yValues.get(i) + 8));
		}
	}
}
