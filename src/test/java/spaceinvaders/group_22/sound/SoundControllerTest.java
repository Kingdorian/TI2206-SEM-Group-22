package spaceinvaders.group_22.sound;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import spaceinvaders.group_22.sound.SoundController;
import spaceinvaders.group_22.sound.SoundLoader;
import spaceinvaders.group_22.ui.JavaFXThreadingRule;
import spaceinvaders.group_22.unit.Soundable;

/**
 * Test for the SoundController.
 * @author Jochem
 *
 */
public class SoundControllerTest {

	/**
	 * Class specifying rule to test JavaFX from GitHub.
	 */
	@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
	
	/**
	 * The SoundController to test.
	 */
	private SoundController controller;
	
	/**
	 * Mocks a soundable object.
	 */
	private Soundable soundMock = Mockito.mock(Soundable.class);
	
	/**
	 * Mocks ab object.
	 */
	private Object objectMock = Mockito.mock(Object.class);
	
	/**
	 * Setup the soundcontroller class.
	 */
	@Before
	public final void setup() {
		controller = SoundController.getInstance();
	}
	
	/**
	 * Test the singleton instance for null.
	 */
	@Test
	public final void testGetInstanceNull() {
		assertNotNull(controller);
	}
	
	/**
	 * Test the singleton instance is equal.
	 */
	@Test
	public final void testGetInstance() {
		assertEquals(SoundController.getInstance(), controller);
	}
	
	/**
	 * Checks if the update method succesfully plays a sound if an object is soundable.
	 */
	@Test
	public final void testUpdate() {
		Mockito.when(soundMock.getAudioClip()).thenReturn(SoundLoader.getInstance().getStartGame());
		controller.update(soundMock);
		Mockito.verify(soundMock).getAudioClip();
	}
	
	/**
	 * Checks if the update method does nothing if an object is not Soundable.
	 */
	@Test
	public final void testUpdateNotSoundable() {
		controller.update(objectMock);
		Mockito.verifyZeroInteractions(objectMock);
	}
	
	

}
