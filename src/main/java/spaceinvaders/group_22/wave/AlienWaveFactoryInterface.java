package spaceinvaders.group_22.wave;

/**
 * Interface for creating an alienWave.
 * @author Dorian and Bryan
 *
 */

public interface AlienWaveFactoryInterface {
	/**
	 * Method to create a list of alienwaves.
	 * @return new Alienwave
	 * @throws Exception 
	 */
	AlienWave createWave();
	/**
	 * Method to create a list of bossAlienWaves.
	 * @return new BossAlienWave
	 */
	AlienWave createBossWave();
}
