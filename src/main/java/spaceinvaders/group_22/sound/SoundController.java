package spaceinvaders.group_22.sound;


import javafx.scene.media.AudioClip;
import spaceinvaders.group_22.Observer;
import spaceinvaders.group_22.unit.Soundable;

/**
 * Class handling the playback of sounds.
 * @author Jochem
 *
 */
public final class SoundController implements Observer {

	/**
	 * Enum for various sounds which can be triggered from other classes.
	 * @author Jochem
	 *
	 */
	public static enum Sound {
		/**
		 * Start game sound.
		 */
		START_GAME(SoundLoader.getInstance().getStartGame()),
		
		/**
		 * Stop game sound.
		 */
		STOP_GAME(SoundLoader.getInstance().getEndGame());
		
		/**
		 * AudioClip containing the actual sound of this Sound.
		 */
		private final AudioClip soundclip;
		
		/**
		 * Creates a new Sound.
		 * @param clip AudioClip for this sound.
		 */
		Sound(final AudioClip clip) {
			soundclip = clip;
		}
		
		/**
		 * Plays the AudioClip value.
		 */
		public void play() {
			soundclip.play();;
		}
	}
	
	
	/**
	 * The singleton unique instance of SoundController.
	 */
	private static volatile SoundController uniqueInstance;

	/**
	 * Constructor for a SoundController.
	 */
	private SoundController() { }
	
	/**
	 * Returns the singleton instance of Logger.
	 * @return the Loggers unique instance.
	 */
	public static SoundController getInstance() {
		if (uniqueInstance == null) {
			synchronized (SoundController.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new SoundController();
		       }
			}	
		}
		return uniqueInstance; 
	}

	@Override
	public void update(final Object o) {
		if (o instanceof Soundable) {
			((Soundable) o).getAudioClip().play();
		}
	}

}
