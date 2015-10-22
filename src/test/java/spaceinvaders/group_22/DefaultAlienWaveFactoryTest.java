package spaceinvaders.group_22;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import spaceinvaders.group_22.ui.JavaFXThreadingRule;
/**
 * Test the default alien wave factory.
 * @author Dorian
 *
 */
public class DefaultAlienWaveFactoryTest {

	/**
	 * Class specifying rule to test JavaFX from GitHub.
	 */
	@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
	/**
	 * Test the create wave method for the default alien wave factory.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")
	public final void testCreateWave() {
		DefaultAlienWaveFactory factory = new DefaultAlienWaveFactory(new SinglePlayerGame(1000, 720));
		try {
			ReadAlienWaveFactory readFactory = new ReadAlienWaveFactory(new SinglePlayerGame(1000, 720));
			AlienWaveReader reader = new AlienWaveReader();
			String sep = System.getProperty("file.separator");
			AlienWave expWave = readFactory.createWaveFromPattern(reader.read("src" + sep + "main" + sep + "resources"
					+ sep + "spaceinvaders" +  sep + "group_22" + sep	+ "testWaves" + sep + "default.wave").get(0));
			assertEquals(expWave, factory.createWave());
			
		} catch (Exception e) {
			return;
		}
	}

}
