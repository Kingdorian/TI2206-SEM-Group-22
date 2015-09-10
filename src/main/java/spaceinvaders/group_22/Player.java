package spaceinvaders.group_22;

import spaceinvaders.group_22.unit.SpaceShip;

/**
 * Class for the player.
 * @author dorian
 *
 */
public class Player {

	/**
	 * Spaceship the player is currently controling.
	 */
	private SpaceShip ship;
	/**
	 * Int that keeps track of the score of the player.
	 */
	private int score;
	
	/**
	 * Amount of lives the player has left.
	 */
	private int lives;
	/**
	 * Game the player "lives" in.
	 */
	private Game game;
	
	/**
	 * Creates new Player object.
	 * @param parentgame the game where the object is part of.
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	public Player(final Game parentgame) {
		game = parentgame;
		ship = new SpaceShip(game.getCanvasWidth() / 2, game.getCanvasHeight() - 40, "spaceship.png");
		score  = 0;
		lives = 3;
	}
	
	/**
	 * Returns the spaceship.
	 * @return the spaceship object this player is controlling.
	 */
	public final SpaceShip getSpaceShip() {
		return ship;
	}
	/**
	 * Sets a new spaceship this player controls.
	 * @param newShip the new spaceship.
	 */
	public final void setSpaceShip(final SpaceShip newShip) {
		ship = newShip;
	}
	/**
	 * Gets the players score.
	 * @return the amount of points the player has scored.
	 */
	public final int getScore() {
		return score;
	}
	/**
	 * Adds an amount of points to the players score.
	 * @param points the amount of points to add
	 */
	public final void addScore(final int points) {
		score += points;
	}
	/**
	 * Resets the amount of points the player has.
	 */
	public final void resetScore() {
		score = 0;
	}
	/**
	 * Respawn the spaceship.
	 */
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void respawnShip() {
		ship = new SpaceShip(game.getCanvasWidth() / 2, ship.getYCoor(), "spaceship.png");
	}
	/**
	 * When the player dies remove one of his lives.
	 */
	public final void die() {
		lives--;
		respawnShip();
		if (lives <= 0) {
			game.gameOver();
		}
	}
	/**
	 * Get the amount of lives the player has left.
	 * @return the amount of lives left for the player.
	 */
	public final int getLives() {
		return lives;
	}
	
}