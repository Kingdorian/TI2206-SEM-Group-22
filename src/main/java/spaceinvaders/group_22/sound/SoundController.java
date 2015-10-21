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
		START_GAME {
				/**
				 * AudioClip for this ENUM.
				 */
				private AudioClip clip = SoundLoader.getInstance().getStartGame();
				
				@Override
				public void play() { 
					playSFX(clip); 
				} 
				
				@Override
				public void stop() {
					clip.stop(); 
				} },
		
		/**
		 * Stop game sound.
		 */
		STOP_GAME {
				/**
				 * AudioClip for this ENUM.
				 */
				private AudioClip clip = SoundLoader.getInstance().getEndGame();	
					
					
				@Override
				public void play() { 
					playSFX(clip); 
				} 
				@Override
				public void stop() {
					clip.stop(); 
				} },
		/**
		 * Sets the background music.
		 */
		BGM { 
				/**
				 * MediaPlayer for this ENUM.
				 */
				private MediaPlayer player = SoundLoader.getInstance().getBGMMusicPlayer();	
					
				/**
				 * The fade of this ENUM.
				 */
				private static final double FADE = 8000;
				
				@Override
				public void play() { 
					playBGM(player, FADE);
				} 
				@Override
				public void stop() {
					player.stop();
				} }; 
		
		
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
		 * @param clip The clip to play the music for.
		 */
		public void playSFX(final AudioClip clip) {
			if (SoundController.getInstance().getSFXEnabled()) {
				clip.play();
			}
		};
		
		/**
		 * Plays the BGM if bgm is enabled.
		 * @param player The musicPlayer to play the music for.
		 * @param fade The time the fade should take to fade the backgroundmusic in.
		 */
		public void playBGM(final MediaPlayer player, final double fade) {
			if (SoundController.getInstance().getBGMEnabled()) {
				player.setCycleCount(MediaPlayer.INDEFINITE);
				musicFadeIn(player, fade); 
			}
		};
		
		/**
		 * Fades music on play.
		 * @param player The musicplayer to fade in.
		 * @param fadetime The time for the fade to occur.
		 */
		public void musicFadeIn(final MediaPlayer player, final double fadetime) {
			player.setVolume(0);
			
			player.setOnReady(new Runnable() {

			      @Override
			      public void run() {
			        player.play();
			        new Transition() {
			          {
			            setCycleDuration(Duration.millis(fadetime));
			          }
			          
			          @Override
			          protected void interpolate(final double frac) {
			            player.setVolume(frac);
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
		if (o instanceof Soundable) {
			if (sfxEnabled) {
				((Soundable) o).getAudioClip().play();				
			}
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
