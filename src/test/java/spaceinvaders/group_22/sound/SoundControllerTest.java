package spaceinvaders.group_22.sound;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
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
		controller.setSFXEnabled(true);
		controller.setBGMEnabled(true);
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
	public final void testUpdateSFXEnabled() {
		SoundController.getInstance().setSFXEnabled(true);
		Mockito.when(soundMock.getAudioClip()).thenReturn(SoundLoader.getInstance().getStartGame());
		controller.update(soundMock);
		Mockito.verify(soundMock).getAudioClip();
	}
	
	/**
	 * Checks if the update method succesfully plays a sound if an object is soundable.
	 */
	@Test
	public final void testUpdateSFXDisabled() {
		SoundController.getInstance().setSFXEnabled(false);
		Mockito.when(soundMock.getAudioClip()).thenReturn(SoundLoader.getInstance().getStartGame());
		controller.update(soundMock);
		Mockito.verifyZeroInteractions(soundMock);
	}
	
	
	/**
	 * Checks if the update method does nothing if an object is not Soundable.
	 */
	@Test
	public final void testUpdateNotSoundable() {
		controller.update(objectMock);
		Mockito.verifyZeroInteractions(objectMock);
	}
	
	/**
	 * Checks if getClip() returns the correct effect for starting a game.
	 */
	@Test
	public final void testEnumSoundGetClipStartGame() {
		AudioClip expected = SoundLoader.getInstance().getStartGame();
		AudioClip actual = SoundController.Sound.START_GAME.getClip();
		
		assertEquals(expected, actual);
	}
	
	/**
	 * Checks if getClip() returns the correct effect for starting a game.
	 */
	@Test
	public final void testEnumSoundGetClipEndGame() {
		AudioClip expected = SoundLoader.getInstance().getEndGame();
		AudioClip actual = SoundController.Sound.STOP_GAME.getClip();
		
		assertEquals(expected, actual);
	}
	
	/**
	 * Checks if getPlayer() returns the correct effect for starting a game.
	 */
	@Test
	public final void testEnumSoundGetPlayerBGM() {
		MediaPlayer expected = SoundLoader.getInstance().getBGMMusicPlayer();
		MediaPlayer actual = SoundController.Sound.BGM.getPlayer();
		
		assertEquals(expected, actual);
	}
	
	/**
	 * Checks if PlaySFX works if sfx is enabled.
	 */
	@Test
	public final void testEnumSoundPlaySFXEnabled() {
		SoundController.getInstance().setSFXEnabled(true);
		
		AudioClip clip = SoundController.Sound.START_GAME.getClip();
		SoundController.Sound.START_GAME.playSFX(clip);
		
		assertTrue(clip.isPlaying());
	}
	
	/**
	 * Checks if play works on startGame.
	 */
	@Test
	public final void testEnumSoundPlayStartGame() {
		AudioClip clip = SoundController.Sound.START_GAME.getClip();
		SoundController.Sound.START_GAME.play();
		
		assertTrue(clip.isPlaying());
	}
	
	/**
	 * Checks if play works on endGame.
	 */
	@Test
	public final void testEnumSoundPlayStopGame() {
		AudioClip clip = SoundController.Sound.STOP_GAME.getClip();
		SoundController.Sound.STOP_GAME.play();
		
		assertTrue(clip.isPlaying());
	}
	
	/**
	 * Checks if play works on background music.
	 */
	@Test
	public final void testEnumSoundPlayBGMPlayerNull() {
		SoundController.getInstance().setBGMEnabled(true);

		SoundController.Sound.BGM.playBGM(null, 0);
		
		assertFalse(SoundController.Sound.BGM.getPlaying());
	}

}
