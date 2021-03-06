package spaceinvaders.group_22.game;

import java.util.ArrayList;

import spaceinvaders.group_22.game.powerup.PowerUp;
import spaceinvaders.group_22.game.powerup.SpawnProtectionPowerup;
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
	 * Indicates if player can get damaged by bullets.
	 */
	private boolean invulnerable = false;
	/**
	 * Number of this player.
	 */
	private int playerNumber = 1;
	/**
	 * Starting x coordinate of the ship.
	 */
	private Double startShipX;
	
	/**
	 * Creates new Player object.
	 * @param parentgame the game where the object is part of.
	 * @param shipX X coordinate of the ship.
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	public Player(final Game parentgame, final double shipX) {
		game = parentgame;
		startShipX = shipX;
		ship = new SpaceShip(shipX, game.getCanvasHeight() - 40);
		ship.setPlayer(this);

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
		ship = new SpaceShip(startShipX, ship.getYCoor());
		ship.setPlayer(this);
		ship.setSpriteImage();
		ArrayList<PowerUp> powerups = new ArrayList<PowerUp>();
		powerups.addAll(getActivePowerUps());
		for (PowerUp powerup : powerups) {
			powerup.deactivate();
		}
		SpawnProtectionPowerup spawnprotection = new SpawnProtectionPowerup(this);
		activePowerUps.add(spawnprotection);
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
	/**
	 * Sets if the player is invulnerable.
	 * @param b boolean if the player is invulnerable.
	 */
	public final void setInvulnerable(final boolean b) {
		invulnerable = b;
	}
	/**
	 * Returns player invulnerability.
	 * @return A boolean representng invulnerability.
	 * 
	 */
	public final boolean isInvulnerable() {
		return invulnerable;
	}

	/**
	 * @return the playerNumber
	 */
	public final int getPlayerNumber() {
		return playerNumber;
	}

	/**
	 * @param playerNr the playerNumber to set
	 */
	public final void setPlayerNumber(final int playerNr) {
		this.playerNumber = playerNr;
		ship.setSpriteImage();
	}
	
}