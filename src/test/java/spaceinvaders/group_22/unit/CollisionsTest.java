package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import spaceinvaders.group_22.Game;

/**
 * Class to test the collisons between units.
 * @author Bryan
 *
 */
public class CollisionsTest {
	
	/**
	 * Object used to test the collisions.
	 */
	private Collisions collisions;
	/**
	 * Game object used to test the collisions.
	 */
	private Game game;
	
	/**
	 * Setup the collisons class.
	 */
	@Before
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void setup() {
		game = new Game(700, 1000);
		collisions = new Collisions(game);
	}
	
	/**
	 * Tests the collisions between an alien and a bullet.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")  
	public final void alienVSbulletTestNotColliding() {
		ShipBullet bullet = new ShipBullet(100, 200, "spaceshipbullet.png");
		Alien alien = new Alien(5, 6.2, "invader.png");
		ArrayList<Unit> bullets = new ArrayList<Unit>();
		bullets.add(bullet);
		assertEquals(collisions.checkCollisions(alien, bullets), null);
	}
	
	/**
	 * Tests the collisions between an alien and a bullet.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")  
	public final void alienVSbulletTestColliding() {
		ShipBullet bullet = new ShipBullet(5, 6.4, "spaceshipbullet.png");
		Alien alien = new Alien(5, 6.2, "invader.png");
		ArrayList<Unit> bullets = new ArrayList<Unit>();
		bullets.add(bullet);
		assertEquals(collisions.checkCollisions(alien, bullets), bullet);
	}
	
	/**
	 * Tests the collisions between a ship and a bullet.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")  
	public final void shipVSbulletTestNotColliding() {
		AlienBullet bullet = new AlienBullet(5, 200, "alienbullet.png");
		SpaceShip spaceship = new SpaceShip(5, 6.2, "spaceship.png");
		ArrayList<Unit> bullets = new ArrayList<Unit>();
		bullets.add(bullet);
		assertEquals(collisions.checkCollisions(spaceship, bullets), null);
	}
	
	/**
	 * Tests the collisions between a ship and a bullet.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")  
	public final void shipVSbulletTestColliding() {
		AlienBullet bullet = new AlienBullet(7, 7, "alienbullet.png");
		SpaceShip spaceship = new SpaceShip(5, 6.2, "spaceship.png");
		ArrayList<Unit> bullets = new ArrayList<Unit>();
		bullets.add(bullet);
		assertEquals(collisions.checkCollisions(spaceship, bullets), bullet);
	}
	
	/**
	 * Tests the collisions between a bullet and an alien.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")  
	public final void collisionTestAlienHit() {
		Alien alien = new Alien(5, 6.2, "invader.png");
		ArrayList<ArrayList<Alien>> alienList = new ArrayList<ArrayList<Alien>>();
		alienList.add(new ArrayList<Alien>());
		alienList.get(0).add(alien);
		ShipBullet bullet = new ShipBullet(5, 6.4, "spaceshipbullet.png");
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		bullets.add(bullet);
		game.getAlienController().getAlienWave().setAliens(alienList);
		game.setBullets(bullets);
		collisions.checkCollisions();
		assertEquals(alien.getHealth(), 0);
	}
	
	/**
	 * Tests the collisions between a bullet and a barricade.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")  
	public final void collisionTestBarricadeHit() {
		Barricade barricade = new Barricade(5, 6.2, "barrier.png");
		ArrayList<Barricade> barricadeList = new ArrayList<Barricade>();
		barricadeList.add(barricade);
		ShipBullet bullet = new ShipBullet(5, 6.4, "spaceshipbullet.png");
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		bullets.add(bullet);
		game.getBarricadeController().setBarricades(barricadeList);
		game.setBullets(bullets);
		collisions.checkCollisions();
		assertEquals(game.getBarricadeController().getBarricades().get(0).getHealth(), 9);
	}

}
