package spaceinvaders.group_22.sound;

import javafx.animation.Transition;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
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
				} },
		/**
		 * Sets the background music.
		 */
		BGM(SoundLoader.getInstance().getBGMMusicPlayer()) { 	
				/**
				 * The fade of this ENUM.
				 */
				private static final double FADE = 8000;
				
				@Override
				public void play() { 
					playBGM(getPlayer(), FADE);
				} 
				@Override
				public void stop() {
					getPlayer().stop();
				} }; 
		
		/**
		 * An AudioClip for this enum.
		 */
		private AudioClip clip;
		
		/**
		 * A MediaPlayer for this enum.
		 */
		private MediaPlayer player;
		
		/**
		 * Constructor for a sound enum with a mediaplayer.
		 * @param mediaPlayer a MediaPlayer object.
		 */
		Sound(final MediaPlayer mediaPlayer) {
			player = mediaPlayer;
		}
		
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
		 * Returns the player of the enum.
		 * @return a MediaPlayer
		 */
		public MediaPlayer getPlayer() {
			return player;
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
		
		/**
		 * Plays the BGM if bgm is enabled.
		 * @param mediaPlayer The musicPlayer to play the music for.
		 * @param fade The time the fade should take to fade the backgroundmusic in.
		 */
		public void playBGM(final MediaPlayer mediaPlayer, final double fade) {
			if (SoundController.getInstance().getBGMEnabled()) {
				mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
				musicFadeIn(mediaPlayer, fade); 
			}
		};
		
		/**
		 * Fades music on play.
		 * @param mediaPlayer The musicplayer to fade in.
		 * @param fadetime The time for the fade to occur.
		 */
		public void musicFadeIn(final MediaPlayer mediaPlayer, final double fadetime) {
			mediaPlayer.setVolume(0);
			
			mediaPlayer.setOnReady(new Runnable() {

			      @Override
			      public void run() {
			    	  mediaPlayer.play();
			        new Transition() {
			          {
			            setCycleDuration(Duration.millis(fadetime));
			          }
			          
			          @Override
			          protected void interpolate(final double frac) {
			        	  mediaPlayer.setVolume(frac);
			          }
			        }.play();
			      }
			    });
			
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
