package spaceinvaders.group_22;

import spaceinvaders.group_22.logger.Logger;

/**
 * Class responsible for loading sound files.
 * @author Jochem
 *
 */
public final class SoundLoader {

	/**
	 * The singleton unique instance of Logger.
	 */
	private static volatile SoundLoader uniqueInstance;
	
	/**
	 * Constructor for a SoundLoader.
	 */
	private SoundLoader() {
		
	}
	
	/**
	 * Returns the singleton instance of Logger.
	 * @return the Loggers unique instance.
	 */
	public static SoundLoader getInstance() {
		if (uniqueInstance == null) {
			synchronized (SoundLoader.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new SoundLoader();
		       }
			}	
		}
		return uniqueInstance; 
	}

}
