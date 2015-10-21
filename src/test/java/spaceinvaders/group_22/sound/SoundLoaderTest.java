package spaceinvaders.group_22.sound;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import spaceinvaders.group_22.ui.JavaFXThreadingRule;

/**
 * Test class for the soundloader.
 * @author Jochem
 *
 */
@RunWith(Parameterized.class)
@SuppressWarnings("checkstyle:magicnumber")   
public class SoundLoaderTest {

	/**
	 * Class specifying rule to test JavaFX from GitHub.
	 */
	@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
	
	/**
	 * The spriteloader to test.
	 */
	private SoundLoader loader;
	
	/**
	 * The key to add.
	 */
    private String key;
	
	/**
	 * Method defining soundloader parameters.
	 * @return The soundloader parameters to test.
	 */
	@Parameters
	public static Collection<Object> soundParameters() {
		return Arrays.asList(new Object[] { 
			"end.wav", 
			"explosion.wav", 
			"powerup_life.wav", 
			"powerup_shoot.wav", 
			"powerup_speed.wav", 
			"shoot.wav", 
			"start.wav", 
		});
	}
	
    /**
     * Constructor for a SoundLoaderTest.
     * @param input	The keys to evaluate.
     */
    public SoundLoaderTest(final String input) {
            key = input;
    }
	
	/**
	 * Setup the soundloader class.
	 */
	@Before
	public final void setup() {
		loader = SoundLoader.getInstance();
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
		assertEquals(SoundLoader.getInstance(), loader);
	}
	
	/**
	 * Test if a soundfile is added to the hashmap.
	 */
	@Test
	public final void testAddSoundFile() {
		loader.addSoundFile(key);
		assertNotNull(loader.getSoundHashMap().get(key));		
	}
	
	/**
	 * Test if a soundfile is not added to the hashmap if it does not exist.
	 */
	@Test
	public final void testAddNonExistentSoundFile() {
		loader.addSoundFile("nonexistent.wav");
		assertNull(loader.getSoundHashMap().get("nonexistent.wav"));		
	}

}
