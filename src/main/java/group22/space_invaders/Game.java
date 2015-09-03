package group22.space_invaders;
/**
 * 
 * @author Dorian
 *
 */
public class Game {
	/**
	 * Boolean that indicates if the game is inProgress.
	 */
	private Boolean inProgress = false;
	/**
	 * Creates a new instance of game.
	 */
	public Game() {
		
	}
	/**
	 * Starts the game.
	 */
	public void start() {
		inProgress = true;
	}
	/**
	 * Pauses the game.
	 */
	public void stop() {
		inProgress = false;
	}
	/**
	 * Returns true if the game is in progress.
	 * @return boolean if the game is in progress
	 */
	public boolean isInProgress() {
		return inProgress;
	}
	/**
	 * Will update all the objects in the game.
	 */
	public void tick() {
		
	}
}
