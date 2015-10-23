package spaceinvaders.group_22.unit;

import javafx.scene.media.AudioClip;

/**
 * Interface declaring sound implementation for a unit.
 * @author Jochem
 *
 */
public interface Soundable {
	
	/**
	 * Returns the AudioClip belonging to this unit.
	 * @return an AudioClip.
	 */
	AudioClip getAudioClip();

}
