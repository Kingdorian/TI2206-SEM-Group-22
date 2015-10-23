package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import javafx.scene.image.Image;
import spaceinvaders.group_22.ui.SpriteLoader;

/**
 * Test for SpriteLoader.
 * @author Jochem
 *
 */
@SuppressWarnings("checkstyle:magicnumber")   
public class SpriteLoaderTest {

	/**
	 * The spriteloader to test.
	 */
	private SpriteLoader loader;
	
	/**
	 * Setup the spriteloader class.
	 */
	@Before
	public final void setup() {
		loader = SpriteLoader.getInstance();
	}

	/**
	 * Test the singleton instance for null.
	 */
	@Test
	public final void testGetInstanceNull() {
		assertNotNull(loader);
	}
	
	/**
	 * Test the singleton instance is equal.
	 */
	@Test
	public final void testGetInstance() {
		assertEquals(SpriteLoader.getInstance(), loader);
	}
	
	/**
	 * Equals method for testing 2 images.
	 * @param thisimage Image 1
	 * @param thatimage Image 2
	 * @return If the image is equal or not.
	 */
	public final boolean equalsImage(final Image thisimage, final Image thatimage) {
		for (int i = 0; i < thisimage.getWidth(); i++) {
		  for (int j = 0; j < thisimage.getHeight(); j++) {
		    if (!thisimage.getPixelReader().getColor(i, j).equals(thatimage.getPixelReader().getColor(i, j))) {
				return false;
			}
		  }
		}	
		return true;
	}
	
	/**
	 * Test if getBulletAlien() returns the correct image.
	 */
	@Test
	public final void testGetBulletAlien() {
		String filename = "alienbullet.png";
		
		Image expected = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/" + filename).toString());
		assertTrue(equalsImage(expected, loader.getBulletAlien()));
	}
	
	/**
	 * Test if getBulletSpaceShip() returns the correct image.
	 */
	@Test
	public final void testGetBulletSpaceShip() {
		String filename = "spaceshipbullet.png";
		
		Image expected = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/" + filename).toString());
		assertTrue(equalsImage(expected, loader.getBulletSpaceShip()));
	}
	
	/**
	 * Test if getAlienLarge() returns the correct image.
	 */
	@Test
	public final void testGetAlienLarge() {
		String filename = "alien_large.png";
		
		Image expected = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/" + filename).toString());
		assertTrue(equalsImage(expected, loader.getAlienLarge()));
	}
	
	/**
	 * Test if getAlienShooter() returns the correct image.
	 */
	@Test
	public final void testGetAlienShooter() {
		String filename = "alien_shooter.png";
		
		Image expected = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/" + filename).toString());
		assertTrue(equalsImage(expected, loader.getAlienShooter()));
	}
	/**
	 * Test if getAlienWithHealth() returns the correct image.
	 */
	@Test
	public final void testGetAlienWithHealthTooHigh() {
		String filename = "alien_health1.png";
		
		Image expected = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/" + filename).toString());
		assertTrue(equalsImage(expected, loader.getAlienWithHealth(727373)));
	}
	
	/**
	 * Test if getAlienWithHealth() returns the correct image.
	 */
	@Test
	public final void testGetAlienWithHealthNegative() {
		String filename = "alien_health1.png";
		
		Image expected = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/" + filename).toString());
		assertTrue(equalsImage(expected, loader.getAlienWithHealth(-1000)));
	}
	
	/**
	 * Test if getAlienWithHealth() returns the correct image.
	 */
	@Test
	public final void testGetAlienWithHealthThree() {
		String filename = "alien_health3.png";
		
		Image expected = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/" + filename).toString());
		assertTrue(equalsImage(expected, loader.getAlienWithHealth(3)));
	}
	
	/**
	 * Test if testGetSpaceShip() returns the correct image.
	 */
	@Test
	public final void testGetSpaceShip() {
		String filename = "spaceship.png";
		
		Image expected = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/" + filename).toString());
		assertTrue(equalsImage(expected, loader.getSpaceShip(1)));
	}
	
	/**
	 * Test if getHeart() returns the correct image.
	 */
	@Test
	public final void testGetHeart() {
		String filename = "heart.png";
		
		Image expected = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/" + filename).toString());
		assertTrue(equalsImage(expected, loader.getHeart()));
	}
	
	/**
	 * Test if getBarrier() returns the correct image.
	 */
	@Test
	public final void testGetBarrier() {
		String filename = "barrier.png";
		
		Image expected = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/" + filename).toString());
		assertTrue(equalsImage(expected, loader.getBarrier()));
	}
	
	/**
	 * Test if getExplosionWithFrame() returns the correct image.
	 */
	@Test
	public final void testGetExplosionWithFrameTooHigh() {
		String filename = "explosion1.png";
		
		Image expected = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/" + filename).toString());
		assertTrue(equalsImage(expected, loader.getExplosionWithFrame(727373)));
	}
	
	/**
	 * Test if getExplosionWithFrame() returns the correct image.
	 */
	@Test
	public final void testGetExplosionWithFrameNegative() {
		String filename = "explosion1.png";
		
		Image expected = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/" + filename).toString());
		assertTrue(equalsImage(expected, loader.getExplosionWithFrame(-1000)));
	}
	
	/**
	 * Test if getExplosionWithFrame() returns the correct image.
	 */
	@Test
	public final void testGetExplosionWithFrameThree() {
		String filename = "explosion3.png";
		
		Image expected = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/" + filename).toString());
		assertTrue(equalsImage(expected, loader.getExplosionWithFrame(3)));
	}
	
	/**
	 * Test if getSpeedPowerUp() returns the correct image.
	 */
	@Test
	public final void testGetSpeedPowerUp() {
		String filename = "powerup_blue.png";
		
		Image expected = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/" + filename).toString());
		assertTrue(equalsImage(expected, loader.getSpeedPowerUp()));
	}
	
	/**
	 * Test if getShootPowerUp() returns the correct image.
	 */
	@Test
	public final void testGetShootPowerUp() {
		String filename = "powerup_orange.png";
		
		Image expected = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/" + filename).toString());
		assertTrue(equalsImage(expected, loader.getShootPowerUp()));
	}
	
	/**
	 * Test if getSpeedPowerUpGlow() returns the correct image.
	 */
	@Test
	public final void testGetSpeedPowerUpGlow() {
		String filename = "glow_blue.png";
		
		Image expected = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/" + filename).toString());
		assertTrue(equalsImage(expected, loader.getSpeedPowerUpGlow()));
	}
	
	/**
	 * Test if getShootPowerUpGlow() returns the correct image.
	 */
	@Test
	public final void testGetShootPowerUpGlow() {
		String filename = "glow_orange.png";
		
		Image expected = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/" + filename).toString());
		assertTrue(equalsImage(expected, loader.getShootPowerUpGlow()));
	}
	
	/**
	 * Test if getLifePowerUp() returns the correct image.
	 */
	@Test
	public final void testGetLifePowerUp() {
		String filename = "powerup_red.png";
		
		Image expected = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/" + filename).toString());
		assertTrue(equalsImage(expected, loader.getLifePowerUp()));
	}
	
	/**
	 * Test if getLifePowerUp() returns the correct image.
	 */
	@Test
	public final void testGetBossSpaceShip() {
		String filename = "spaceshipbullet.png";
		
		Image expected = new Image(getClass().getClassLoader()
				.getResource("spaceinvaders/group_22/images/" + filename).toString());
		assertTrue(equalsImage(expected, loader.getBossSpaceShip()));
	}
}
