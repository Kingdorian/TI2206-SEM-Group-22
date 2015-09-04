package spaceinvaders.group_22;
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
	 * The highscore.
	 */
	private int highscore = 0;
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
	/**
	 * Returns the highscore.
	 * @return current highscore
	 */
	public int getHighScore(){
		return highscore;
	}
	/**
	 * Sets highscore.
	 * @param new highscore (int)
	 * @throws IlligalArgumentException if the new highscore is less then the old highscore or highscore is negative.
	 */
	public void setHighScore(int newscore) {
		assert newscore >= 0 && newscore > highscore;
		highscore = newscore;
	}
}
