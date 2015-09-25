package spaceinvaders.group_22;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Assert;
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
		controller.create();
		ArrayList<Alien> aliens = controller.getAliens();
		assertEquals(AlienController.ALIENS_PER_ROW*AlienController.AMOUNT_ALIEN_ROWS, aliens.size());
		for (int i = 0; i < aliens.size(); i++) {
			//Test if every alien has the right sprite
			assertEquals(aliens.get(i).getSprite(), "invader.png");
		}
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
			assertTrue(game.getAlienController().getAliens().get(i).getXCoor() == (xValues.get(i) + 4));
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
		for (int i = 0; i < 30; i++) {
			//Move to the right side of the screen
			controller.move();
		}
		for (int i = 0; i < game.getAlienController().getAliens().size(); i++) {
			assertTrue(game.getAlienController().getAliens().get(i).getYCoor() == (yValues.get(i) + 8));
		}
	}
	/**
	 * Tests if setAliens sets the ArrayList of aliens correctly.
	 */
	@Test
	public final void testSetAliens() {
		ArrayList<Alien> aliens = new ArrayList<Alien>();		
		controller.setAliens(aliens);
		Assert.assertEquals(new ArrayList<Alien>(), aliens);	
		
	}
}
