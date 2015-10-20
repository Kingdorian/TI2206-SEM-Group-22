package spaceinvaders.group_22.sound;

import java.util.HashMap;

import javafx.scene.media.AudioClip;
import spaceinvaders.group_22.logger.LogEvent;
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
	 * The path to the sound folder.
	 */
	private String soundFolderPath;
	
	/**
	 * Hashmap containing all audio fragments.
	 */
	private HashMap<String, AudioClip> sounds;
	
	/**
	 * Constructor for a SoundLoader.
	 * @param sFP the path to the sound folder.
	 */
	private SoundLoader(final String sFP) {
		soundFolderPath = sFP;
    	sounds = new HashMap<String, AudioClip>();
    	
    	addSoundFile("end.wav");
    	addSoundFile("explosion.wav");
    	addSoundFile("powerup_life.wav");
    	addSoundFile("powerup_shoot.wav");
    	addSoundFile("powerup_speed.wav");
    	addSoundFile("shoot.wav");
    	addSoundFile("start.wav");
    	
    	Logger.getInstance().log("Initialized " + getClass().getName(), LogEvent.Type.INFO);
	}
	
	/**
	 * Returns the singleton instance of Logger.
	 * @return the Loggers unique instance.
	 */
	public static SoundLoader getInstance() {
		if (uniqueInstance == null) {
			synchronized (SoundLoader.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new SoundLoader("spaceinvaders/group_22/sound/");
		       }
			}	
		}
		return uniqueInstance; 
	}
	
	/**
	 * Method to load and add sound files to the sounds hashmap.
	 * @param filename A sound filename.
	 */
	private void addSoundFile(final String filename) {
		sounds.put(filename, 
				new AudioClip(getClass().getClassLoader()
						.getResource(soundFolderPath + filename).toString()));
		Logger.getInstance().log("Loaded Sound " + filename, LogEvent.Type.DEBUG);
	}
	
    /**
     * Getter method for the end game sound.
     * @return An AudioClip.
     */
    public AudioClip getEndGame() {
    	return sounds.get("end.wav");
    }
    
    /**
     * Getter method for an explosion sound.
     * @return An AudioClip.
     */
    public AudioClip getExplosion() {
    	return sounds.get("explosion.wav");
    }
    
    /**
     * Getter method for a shooting spaceship sound.
     * @return An AudioClip.
     */
    public AudioClip getShot() {
    	return sounds.get("shoot.wav");
    }
    
    /**
     * Getter method for a Life powerup sound.
     * @return An AudioClip.
     */
    public AudioClip getLifePowerUp() {
    	return sounds.get("powerup_life.wav");
    }
    
    /**
     * Getter method for a Speed powerup sound.
     * @return An AudioClip.
     */
    public AudioClip getSpeedPowerUp() {
    	return sounds.get("powerup_speed.wav");
    }
    
    /**
     * Getter method for a Shoot powerup sound.
     * @return An AudioClip.
     */
    public AudioClip getShootPowerUp() {
    	return sounds.get("powerup_shoot.wav");
    }

    /**
     * Getter method for the start game sound.
     * @return An AudioClip.
     */
    public AudioClip getStartGame() {
    	return sounds.get("start.wav");
    }
    

}