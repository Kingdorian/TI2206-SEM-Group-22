package spaceinvaders.group_22.sound;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
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
	 * Checks is getClip() returns the correct effect for starting a game.
	 */
	@Test
	public final void testEnumSoundGetClipStartGame() {
		AudioClip expected = SoundLoader.getInstance().getStartGame();
		AudioClip actual = SoundController.Sound.START_GAME.getClip();
		
		assertEquals(expected, actual);
	}
	
	/**
	 * Checks is getClip() returns the correct effect for starting a game.
	 */
	@Test
	public final void testEnumSoundGetClipEndGame() {
		AudioClip expected = SoundLoader.getInstance().getEndGame();
		AudioClip actual = SoundController.Sound.STOP_GAME.getClip();
		
		assertEquals(expected, actual);
	}
	
	/**
	 * Checks is getPlayer() returns the correct effect for starting a game.
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
		clip.stop();
		SoundController.Sound.START_GAME.playSFX(clip);
		
		assertTrue(clip.isPlaying());
	}
	
	/**
	 * Checks if PlaySFX works if sfx is disabled.
	 */
	@Test
	public final void testEnumSoundPlaySFXDisabled() {
		SoundController.getInstance().setSFXEnabled(false);
		
		AudioClip clip = SoundController.Sound.START_GAME.getClip();
		clip.stop();
		SoundController.Sound.START_GAME.playSFX(clip);
		
		assertFalse(clip.isPlaying());
	}
	
	/**
	 * Checks if play works on startGame.
	 */
	@Test
	public final void testEnumSoundPlayStartGame() {
		SoundController.Sound soundEnum = Mockito.spy(SoundController.Sound.START_GAME);
		AudioClip clip = soundEnum.getClip();
		soundEnum.play();
		
		Mockito.verify(soundEnum).playSFX(clip);
	}
	
	/**
	 * Checks if play works on endGame.
	 */
	@Test
	public final void testEnumSoundPlayStopGame() {
		SoundController.Sound soundEnum = Mockito.spy(SoundController.Sound.STOP_GAME);
		AudioClip clip = soundEnum.getClip();
		soundEnum.play();
		
		Mockito.verify(soundEnum).playSFX(clip);
	}
	
	/**
	 * Checks if play works on background music.
	 */
	@Test
	public final void testEnumSoundPlayBGMEnabled() {
		SoundController.getInstance().setBGMEnabled(true);
		
		SoundController.Sound soundEnum = Mockito.spy(SoundController.Sound.BGM);
		MediaPlayer player = soundEnum.getPlayer();
		soundEnum.play();
		
		Mockito.verify(soundEnum).playBGM(player, 10000);
	}
	
	/**
	 * Checks if play works on background music.
	 */
	@Test
	public final void testEnumSoundPlayBGMDisabled() {
		SoundController.getInstance().setBGMEnabled(false);

		SoundController.Sound soundEnum = Mockito.spy(SoundController.Sound.BGM);
		soundEnum.play();
		
		assertFalse(soundEnum.getPlaying());
	}
	
	/**
	 * Checks if play works on background music.
	 */
	@Test
	public final void testEnumSoundPlayBGMPlayerNull() {
		SoundController.getInstance().setBGMEnabled(true);

		SoundController.Sound soundEnum = Mockito.spy(SoundController.Sound.BGM);
		soundEnum.playBGM(null, 0);
		
		assertFalse(soundEnum.getPlaying());
	}
	
	/**
	 * Checks if stop works on startGame.
	 */
	@Test
	public final void testEnumSoundStopStartGame() {
		SoundController.Sound soundEnum = Mockito.spy(SoundController.Sound.START_GAME);
		
		soundEnum.play();
		soundEnum.stop();
		
		assertFalse(soundEnum.getClip().isPlaying());
	}
	
	/**
	 * Checks if stop works on endGame.
	 */
	@Test
	public final void testEnumSoundStopStopGame() {
		SoundController.Sound soundEnum = Mockito.spy(SoundController.Sound.STOP_GAME);
		
		soundEnum.play();
		soundEnum.stop();
		
		assertFalse(soundEnum.getClip().isPlaying());
	}
	
	/**
	 * Checks if play works on endGame.
	 */
	@Test
	public final void testEnumSoundStopBGM() {
		SoundController.Sound soundEnum = Mockito.spy(SoundController.Sound.BGM);
		
		soundEnum.play();
		soundEnum.stop();
		
		assertFalse(soundEnum.getPlaying());
	}

}
