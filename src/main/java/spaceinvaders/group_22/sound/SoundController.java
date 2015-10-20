package spaceinvaders.group_22.sound;


import spaceinvaders.group_22.Observer;
import spaceinvaders.group_22.unit.Soundable;

/**
 * Class handling the playback of sounds.
 * @author Jochem
 *
 */
public final class SoundController implements Observer {

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
