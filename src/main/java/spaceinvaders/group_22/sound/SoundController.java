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
		START_GAME(SoundLoader.getInstance().getStartGame()) {
				
				@Override
				public void play() { 
					playSFX(getClip()); 
				} 
				
				@Override
				public void stop() {
					getClip().stop(); 
				} },
		
		/**
		 * Stop game sound.
		 */
		STOP_GAME(SoundLoader.getInstance().getEndGame()) {
					
				@Override
				public void play() { 
					playSFX(getClip()); 
				} 
				@Override
				public void stop() {
					getClip().stop(); 
				} };
		
		/**
		 * An AudioClip for this enum.
		 */
		private AudioClip clip;
		
		/**
		 * Constructor for a sound enum with an AudioClip.
		 * @param soundClip an AudioClip object.
		 */
		Sound(final AudioClip soundClip) {
			clip = soundClip;
		}
		
		/**
		 * Returns the audioclip of the enum.
		 * @return an AudioClip
		 */
		public AudioClip getClip() {
			return clip;
		}
		
		/**
		 * Plays the ENUM value.
		 */
		public abstract void play();
		
		/**
		 * Stops the ENUM value.
		 */
		public abstract void stop();
		
		/**
		 * Plays the SFX if sfx is enabled.
		 * @param audioClip The clip to play the music for.
		 */
		public void playSFX(final AudioClip audioClip) {
			if (SoundController.getInstance().getSFXEnabled()) {
				audioClip.play();
			}
		};
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
	 * Defines if the background music is enabled.
	 */
	private boolean bgmEnabled = true;
	
	/**
	 * Defines if the sound effects are enabled.
	 */
	private boolean sfxEnabled = true;
	
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
		if (o instanceof Soundable && sfxEnabled) {
			((Soundable) o).getAudioClip().play();				
		}
	}
	
	/**
	 * Getter for the Sound effect boolean.
	 * @return True if enabled, false else.
	 */
	public boolean getSFXEnabled() {
		return sfxEnabled;
	}
	
	/**
	 * Sets if sound effects should be played.
	 * @param b true if enabled, false else.
	 */
	public void setSFXEnabled(final Boolean b) {
		sfxEnabled = b;
	}
	
	/**
	 * Getter for the Background music boolean.
	 * @return True if enabled, false else.
	 */
	public boolean getBGMEnabled() {
		return bgmEnabled;
	}
	
	/**
	 * Sets if background music should be played.
	 * @param b true if enabled, false else.
	 */
	public void setBGMEnabled(final Boolean b) {
		bgmEnabled = b;
	}

}
