package spaceinvaders.group_22;

import spaceinvaders.group_22.unit.SpaceShip;

/**
 * Class for the player
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
	
	//TODO Add Lives
	
	/**
	 * Creates new Player object.
	 * @param game the game where the object is part of.
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	public Player(Game game) {
		ship = new SpaceShip(10.0f, 10.0f);
		score  = 0;
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
	public final void setSpaceShip(SpaceShip newShip) {
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
	 * @param score the amount of points to add
	 */
	public final void addScore(int score) {
		this.score+=score;
	}
	/**
	 * Resets the amount of points the player has.
	 */
	public final void resetScore() {
		score = 0;
	}
	
	
}