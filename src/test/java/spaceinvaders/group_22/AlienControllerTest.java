package spaceinvaders.group_22;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import spaceinvaders.group_22.ui.JavaFXThreadingRule;
import spaceinvaders.group_22.unit.Alien;
import spaceinvaders.group_22.unit.BossAlien;
import spaceinvaders.group_22.unit.NormalAlien;
import spaceinvaders.group_22.unit.Bullet;
import spaceinvaders.group_22.unit.ShipBullet;

/**
 * Test for the AlienController.
 * @author Ege
 *
 */
public class AlienControllerTest {

	/**
	 * Static game used for testing.
	 */
	private static SinglePlayerGame game;
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
		game.setPlayer(new Player(game, 20.0));
		controller = game.getAlienController();
		game.setTickrate(0.1);
		ArrayList<Alien> row = new ArrayList<Alien>();
		for (int i = 0; i < 10; i++) {
			row.add(new NormalAlien(500, 350));
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
	/**
	 * Test the next round method.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")
	public final void testnextRound() {
		AlienController.setAlienVelX(5.0);
		game.getAlienController().nextRound();
		assertEquals(AlienController.getAlienVelX(), 15.0, 0.2);
	}
	/**
	 * Test the checkallAliensDead method.
	 */
	@Test
	public final void testCheckAllAliensDead() {
		ArrayList<ArrayList<Alien>> aliens = new ArrayList<ArrayList<Alien>>();
		game.getAlienController().getAlienWave().setAliens(aliens);
		game.getAlienController().checkAllAliensDead();
		assertNotEquals(game.getAlienController().getAliens().size(), 0);
	}
	/**
	 * Test the checkallAliensDead method.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")
	public final void testRemoveDeadAliens() {
		ArrayList<ArrayList<Alien>> aliens = new ArrayList<ArrayList<Alien>>();
		game.getAlienController().getAlienWave().setAliens(aliens);
		ArrayList<Alien> row = new ArrayList<Alien>();
		Alien alien = new NormalAlien(20, 20);
		alien.hit();
		alien.hit();
		alien.hit();
		row.add(alien);
		game.getAlienController().getAlienWave().addAlienRow(row);
		game.getAlienController().removeDeadAliens();
		assertEquals(game.getAlienController().getAliens().size(), 0);
	}
	/**
	 * Test the checkallAliensDead method with Tick method.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")
	public final void testRemoveDeadAlienswithTick() {
		ArrayList<ArrayList<Alien>> aliens = new ArrayList<ArrayList<Alien>>();
		game.getAlienController().getAlienWave().setAliens(aliens);
		ArrayList<Alien> row = new ArrayList<Alien>();
		Alien alien = new NormalAlien(20, 20);
		Alien alien2 = new NormalAlien(20, 20);
		alien.hit();
		alien.hit();
		alien.hit();
		row.add(alien);
		row.add(alien2);
		game.getAlienController().getAlienWave().addAlienRow(row);
		game.getAlienController().tick();
		assertEquals(game.getAlienController().getAliens().size(), 1);
	}
	
	/**
	 * Test the alien collisions method.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")
	public final void testAlienCollisions() {
		ArrayList<ArrayList<Alien>> aliens = new ArrayList<ArrayList<Alien>>();
		game.getAlienController().getAlienWave().setAliens(aliens);
		ArrayList<Alien> row = new ArrayList<Alien>();
		Alien alien = new NormalAlien(20, 20);
		Alien alien2 = new NormalAlien(50, 80);
		alien.hit();
		alien.hit();
		row.add(alien);
		row.add(alien2);
		game.getAlienController().getAlienWave().addAlienRow(row);
		ShipBullet b = new ShipBullet(20,20); 
		b.setPlayer(game.getPlayer());
		game.getBullets().add(b);
		game.getAlienController().alienCollisions();
		assertEquals(game.getExplosions().size(), 1);
	}
	
	@Test
	public final void testThirdRoundToBossWave() {
		game.getAlienController().nextRound();
		game.getAlienController().nextRound();
		assertTrue(game.getAlienController().getAliens().get(0) instanceof BossAlien);
	}
	
}
