package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.Player;
import spaceinvaders.group_22.SinglePlayerGame;

/**
 * Class to test the collisons between units.
 * @author Bryan
 *
 */
public class CollisionsTest {
	
	/**
	 * Game object used to test the collisions.
	 */
	private Game game;
	/**
	 * Player object used for testing.
	 */
	private Player player; 
	
	/**
	 * Setup the collisons class.
	 */
	@Before
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void setup() {
		game = new SinglePlayerGame(700, 1000);
		player = new Player(game, game.getCanvasWidth() / 2);
	}
	
	/**
	 * Tests the collisions between an alien and a bullet.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")  
	public final void alienVSbulletTestNotColliding() {
		ShipBullet bullet = new ShipBullet(100, 200);
		Alien alien = new NormalAlien(5, 6.2);
		ArrayList<Unit> bullets = new ArrayList<Unit>();
		bullets.add(bullet);
		assertEquals(new Collisions().checkCollisions(alien, bullets), null);
	}
	
	/**
	 * Tests the collisions between an alien and a bullet.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")  
	public final void alienVSbulletTestColliding() {
		ShipBullet bullet = new ShipBullet(5, 6.4);
		Alien alien = new NormalAlien(5, 6.2);
		ArrayList<Unit> bullets = new ArrayList<Unit>();
		bullets.add(bullet);
		assertEquals(new Collisions().checkCollisions(alien, bullets), bullet);
	}
	
	/**
	 * Tests the collisions between a ship and a bullet.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")  
	public final void shipVSbulletSpawnProtectionTest() {
		AlienBullet bullet = new AlienBullet(5, 200);
		SpaceShip spaceship = new SpaceShip(5, 6.2);
		ArrayList<Unit> bullets = new ArrayList<Unit>();
		bullets.add(bullet);
		player.die();
		assertEquals(new Collisions().checkCollisions(spaceship, bullets), null);
	}
	/**
	 * Tests the collisions between a ship and a bullet  when the player has spawnprotection.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")  
	public final void shipVSbulletTestNotColliding() {
		AlienBullet bullet = new AlienBullet(5, 200);
		SpaceShip spaceship = new SpaceShip(5, 6.2);
		ArrayList<Unit> bullets = new ArrayList<Unit>();
		bullets.add(bullet);
		assertEquals(new Collisions().checkCollisions(spaceship, bullets), null);
	}
	
	
	/**
	 * Tests the collisions between a ship and a bullet.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")  
	public final void shipVSbulletTestColliding() {
		AlienBullet bullet = new AlienBullet(7, 7);
		SpaceShip spaceship = new SpaceShip(5, 6.2);
		ArrayList<Unit> bullets = new ArrayList<Unit>();
		bullets.add(bullet);
		assertEquals(new Collisions().checkCollisions(spaceship, bullets), bullet);
	}
	
	/**
	 * Tests the collisions between a bullet and an alien.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")  
	public final void collisionTestAlienHit() {
		Alien alien = new NormalAlien(5, 6.2);
		ArrayList<ArrayList<Alien>> alienList = new ArrayList<ArrayList<Alien>>();
		alienList.add(new ArrayList<Alien>());
		alienList.get(0).add(alien);
		ShipBullet bullet = new ShipBullet(5, 6.4);
		bullet.setPlayer(mock(Player.class));

		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		bullets.add(bullet);
		game.getAlienController().getAlienWave().setAliens(alienList);
		game.setBullets(bullets);
		game.getAlienController().alienCollisions();
		assertEquals(alien.getHealth(), 0);
	}
	
	/**
	 * Tests the collisions between a bullet and a barricade.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")  
	public final void collisionTestBarricadeHit() {
		Barricade barricade = new Barricade(5, 6.2);
		ArrayList<Barricade> barricadeList = new ArrayList<Barricade>();
		barricadeList.add(barricade);
		ShipBullet bullet = new ShipBullet(5, 6.4);
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		bullets.add(bullet);
		game.getBarricadeController().setBarricades(barricadeList);
		game.setBullets(bullets);
		game.getBarricadeController().barricadeCollisions();
		assertEquals(61, game.getBarricadeController().getBarricades().get(0).getHealth());
	}

}
