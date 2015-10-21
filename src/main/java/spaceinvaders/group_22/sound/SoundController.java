package spaceinvaders.group_22.sound;


import javafx.animation.Transition;
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
				@Override
				public void play() { 
					SoundLoader.getInstance().getStartGame().play(); 
				} 
				@Override
				public void stop() {
					SoundLoader.getInstance().getStartGame().stop(); 
				} },
		
		/**
		 * Stop game sound.
		 */
		STOP_GAME { 
				@Override
				public void play() { 
					SoundLoader.getInstance().getEndGame().play(); 
				} 
				@Override
				public void stop() {
					SoundLoader.getInstance().getStartGame().stop(); 
				} },
		/**
		 * Sets the background music.
		 */
		BGM { 
				@Override
				public void play() { 
					MediaPlayer player = SoundLoader.getInstance().getBGMMusicPlayer();
					player.setCycleCount(MediaPlayer.INDEFINITE);
					musicFadeIn(player, 8000); 
				} 
				@Override
				public void stop() {
					MediaPlayer player = SoundLoader.getInstance().getBGMMusicPlayer();
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
