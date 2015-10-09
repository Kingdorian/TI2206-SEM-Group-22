package spaceinvaders.group_22;

import java.util.ArrayList;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.unit.SpaceShip;

/**
 * Class for the player.
 * @author dorian
 *
 */
public class Player {
	
	/**
	 * Maximum amount of lives a player can have.
	 */
	static final int MAXLIVES = 5;
	/**
	 * List of active power ups for this player.
	 */
	private ArrayList<PowerUp> activePowerUps;

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
		Logger.getInstance().log("Created spaceship for player", LogEvent.Type.DEBUG);
		score  = 0;
		lives = 3;
		activePowerUps = new ArrayList<PowerUp>();
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
		Logger.getInstance().log("Added " + points + "points", LogEvent.Type.TRACE);
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
		for (int i = 0; i < game.getPlayer().getActivePowerUps().size(); i++) {
			game.getPlayer().getActivePowerUps().get(i).deactivate();
		}
		Logger.getInstance().log("Ship respawned", LogEvent.Type.TRACE);
	}
	/**
	 * When the player dies remove one of his lives.
	 */
	public final void die() {
		Logger.getInstance().log("Player died", LogEvent.Type.DEBUG);
		lives--;
		respawnShip();
		if (lives <= 0) {
			game.gameOver();
		}
		game.getBullets();
	}
	/**
	 * Get the amount of lives the player has left.
	 * @return the amount of lives left for the player.
	 */
	public final int getLives() {
		return lives;
	}
	/**
	 * Adds 1 life to the player if lives is not yet 5.
	 */
	public final void addLife() {
		if (lives < MAXLIVES) {
			lives++;
		}
	}
	/**
	 * Returns a list of all the active power ups of this player.
	 * @return a list of the active power ups of this player.
	 */
	public final ArrayList<PowerUp> getActivePowerUps() {
		return activePowerUps;
	}
	/**
	 * Sets the list of all the active power ups of this player.
	 * @param newactivePowerUps the list of active power ups of this player.
	 */
	public final void setActivePowerUps(final ArrayList<PowerUp> newactivePowerUps) {
		this.activePowerUps = newactivePowerUps;
	}
	
}