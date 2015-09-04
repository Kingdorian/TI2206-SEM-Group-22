package group22.space_invaders;

import javafx.scene.input.KeyCode;
import java.util.ArrayList;
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
	 * The player of this game
	 */
	private Player player;
	/**
	 * Creates a new instance of game.
	 */
	public Game() {
		player = new Player(this);
	}
	/**
	 * Starts the game.
	 */
	public final void start() {
		inProgress = true;
	}
	/**
	 * Pauses the game.
	 */
	public final void stop() {
		inProgress = false;
	}
	/**
	 * Returns true if the game is in progress.
	 * @return boolean if the game is in progress
	 */
	public final boolean isInProgress() {
		return inProgress;
	}
	/**
	 * Will update all the objects in the game.
	 * @param pressedKeys the keys pressed since last tick
	 */
	public void tick(ArrayList<KeyCode> pressedKeys) {
		if (pressedKeys.size() != 0) {
			if (pressedKeys.contains(KeyCode.SPACE)) {
			
			}
			if (pressedKeys.contains(KeyCode.A)) {
				player.getSpaceShip().setVelX(-10);
			}
			if (pressedKeys.contains(KeyCode.D)) {
				player.getSpaceShip().setVelX(10);
			}
		}
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
	 * @param newscore highscore (int)
	 * @throws IlligalArgumentException if the new highscore is less then the old highscore or highscore is negative.
	 */
	public final void setHighScore(final int newscore) {
		assert newscore >= 0 && newscore > highscore;
		highscore = newscore;
	}
	/**
	 * Sets player for this game.
	 * @param newPlayer new player
	 */
	public final void setPlayer(Player newPlayer) {
		player = newPlayer;
	}
	/**
	 * Gets the player that is playing this game. 
	 * @return player that is playing this game
	 */
	public final Player getPlayer() {
		return player;
	}
}
