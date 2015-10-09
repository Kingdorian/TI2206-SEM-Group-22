package spaceinvaders.group_22;

import static org.junit.Assert.*;

import org.junit.Test;

public class DefaultAlienWaveFactoryTest {

	@Test
	public void testCreateWave() {
		DefaultAlienWaveFactory factory = new DefaultAlienWaveFactory(new Game(1000, 720));
		try {
			ReadAlienWaveFactory readFactory = new ReadAlienWaveFactory(new Game(1000, 720));
			AlienWaveReader reader = new AlienWaveReader();
			String sep = System.getProperty("file.separator");
			AlienWave expWave = readFactory.createWaveFromPattern(reader.read("src" + sep	+ "main" + sep + "resources" + sep
					+ "spaceinvaders" +  sep + "group_22" + sep	+ "testWaves" + sep + "default.wave").get(0));
			assertEquals(expWave, factory.createWave());
			
		} catch (Exception e) {
			return;
		}
	}

}
