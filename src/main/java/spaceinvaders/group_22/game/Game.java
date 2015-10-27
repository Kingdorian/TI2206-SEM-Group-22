package spaceinvaders.group_22.game;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

import spaceinvaders.group_22.game.controller.AlienController;
import spaceinvaders.group_22.game.controller.BarricadeController;
import spaceinvaders.group_22.game.controller.PowerUpController;
import spaceinvaders.group_22.game.controller.SpaceShipController;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.unit.Alien;
import spaceinvaders.group_22.unit.AlienBullet;
import spaceinvaders.group_22.unit.Bullet;
import spaceinvaders.group_22.unit.Explosion;
import spaceinvaders.group_22.unit.ShipBullet;
import spaceinvaders.group_22.unit.SpaceShip;

/**
 * 
 * @author Dorian
 *
 */
@SuppressWarnings("checkstyle:magicnumber")
public abstract class Game {
	/**
	 * Boolean that indicates if the game is inProgress.
	 */
	private Boolean inProgress = false;
	/**
	 * The highscore.
	 */
	private int highscore = 0;
	
	/**
	 * List of bullets in the game.
	 */
	private ArrayList<Bullet> bullets;
	/**
	 * List of explosions in the game.
	 */
	private ArrayList<Explosion> explosions;
	/**
	 * The barricadeController.
	 */
	private BarricadeController barController;
	/**
	 * The width of the canvas.
	 */
	private double canvasWidth;
	/**
	 * The height of the canvas.
	 */
	private double canvasHeight;
	/**
	 * Velocity of the bullets of the spaceShip in pixels per second.
	 */
	private double spaceShipBulletVelX = 80;
	/**
	 * The tickrate of the animation.
	 */
	private Double tickrate;
	/**
	 * Marks if the game has been ended.
	 */
	private boolean hasEnded = false;
	/**
	 * The controller of the Aliens.
	 */
	private AlienController alienController;
	/**
	 * The counter for the waves.
	 */
	private int waveCounter;

	/**
	 * Creates a new instance of game.
	 * 
	 * @param width
	 *            of the canvas.
	 * @param height
	 *            of the canvas.
	 */
	public Game(final double width, final double height) {
		canvasWidth = width;
		canvasHeight = height;

		bullets = new ArrayList<Bullet>();
		explosions = new ArrayList<Explosion>();
		barController = new BarricadeController(this);
		barController.create();
		alienController = new AlienController(this);
		alienController.create();
		waveCounter = 1;
		Logger.getInstance().log("Created game succesfully", LogEvent.Type.INFO);
	}

	/**
	 * Resets the game.
	 */
	public abstract void resetGame();

	/**
	 * Starts the game.
	 */
	public final void start() {
		inProgress = true;
		hasEnded = false;
		Logger.getInstance().log("Game started", LogEvent.Type.INFO);
	}

	/**
	 * Pauses the game.
	 */
	public final void stop() {
		inProgress = false;
		Logger.getInstance().log("Game stopped", LogEvent.Type.INFO);
	}
	/**
	 * Stops the game and marks the game as ended.
	 */
	public abstract void gameOver();

	/**
	 * Returns true if the game is in progress.
	 * 
	 * @return boolean if the game is in progress
	 */
	public final boolean isInProgress() {
		return inProgress;
	}

	/**
	 * Returns true if the game has ended.
	 * 
	 * @return boolean if the game is ended.
	 */
	public final boolean hasEnded() {
		return hasEnded;
	}

	/**
	 * Will update all the objects in the game.
	 * 
	 * @param pressedKeys
	 *            the keys pressed since last tick
	 */
	public abstract void tick(final ArrayList<KeyCode> pressedKeys);

	/**
	 * Will update all the bullets.
	 */
	public final void tickBullets() {
		// Check if all bullets are still visible
		for (int i = 0; i < bullets.size(); i++) {
			if (bullets.get(i).getXCoor() > canvasWidth || bullets.get(i).getYCoor() < 0
					|| bullets.get(i).getYCoor() >= canvasHeight) {
				bullets.remove(i);
				Logger.getInstance().log("Removed bullet out of screen", LogEvent.Type.TRACE);
			}
		}
		// Move every bullet
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).move(tickrate);
		}
		Logger.getInstance().log("Moved bullets", LogEvent.Type.TRACE);
	}
	/**
	 * Check if there is a alien at the height of this ship.
	 * @param ship to check for if there is a alien at this height.
	 */
	public final void checkAlienHeight(final SpaceShip ship) {
		//Check if there is an alien at the height of the spaceship
		for (Alien unit : alienController.getAliens()) {
			if (unit.getYCoor() + unit.getHeight() > ship.getYCoor()) {
				gameOver();
			}
		}
	}
	
	/**
	 * Returns if the game has any alive players.
	 * @return true if a player is alive
	 */
	public abstract boolean playerAlive();
	// ONLY SETTERS AND GETTERS BELOW

	/**
	 * Set the tickrate for the movement.
	 * 
	 * @param framerate
	 *            of the animation.
	 */
	public final void setTickrate(final Double framerate) {
		tickrate = framerate;
	}

	/**
	 * Sets highscore.
	 * 
	 * @param newscore
	 *            highscore (int)
	 */
	public final void setHighScore(final int newscore) {
		assert newscore >= 0 && newscore > highscore;
		highscore = newscore;
	}
	
	/**
	 * Sets the explosions for this game.
	 * @param newExplosions the explosions
	 */
	public final void setExplosions(final ArrayList<Explosion> newExplosions) {
		explosions = newExplosions;
	}
	
	/**
	 * Sets if game is ended.
	 * @param ended if game is ended
	 */
	public final void setHasEnded(final boolean ended) {
		hasEnded = ended;
	}
	
	/**
	 * Sets the waveCounter.
	 * @param counter the new waveCounter
	 */
	public final void setWaveCounter(final int counter) {
		waveCounter = counter;
	}

	// ONLY GETTERS BELOW
	/**
	 * Gets the bullets currently in this game.
	 * 
	 * @return Arraylist of bullets in the game.
	 */
	public final ArrayList<Bullet> getBullets() {
		return bullets;
	}

	/**
	 * Gets the shipbullets currently in this game.
	 * 
	 * @return Arraylist of shipbullets in the game.
	 */
	public final ArrayList<Bullet> getShipBullets() {
		ArrayList<Bullet> spaceBullets = new ArrayList<Bullet>();
		for (int i = 0; i < getBullets().size(); i++) {
			if (getBullets().get(i) instanceof ShipBullet) {
				spaceBullets.add(getBullets().get(i));
			}
		}
		return spaceBullets;
	}
	
	/**
	 * Gets the alienbullets currently in this game.
	 * 
	 * @return Arraylist of alienbullets in the game.
	 */
	public final ArrayList<Bullet> getAlienBullets() {
		ArrayList<Bullet> alienBullets = new ArrayList<Bullet>();
		for (int i = 0; i < getBullets().size(); i++) {
			if (getBullets().get(i) instanceof AlienBullet) {
				alienBullets.add(getBullets().get(i));
			}
		}
		return alienBullets;
	}

	/**
	 * Gets the explosions currently in this game.
	 * 
	 * @return Arraylist of bullets in the game.
	 */
	public final ArrayList<Explosion> getExplosions() {
		return explosions;
	}
	
	/**
	 * Returns the highscore.
	 * 
	 * @return current highscore
	 */
	public final int getHighScore() {
		return highscore;
	}

	/**
	 * Gets the canvas width.
	 * 
	 * @return width of the canvas.
	 */
	public final double getCanvasWidth() {
		return canvasWidth;
	}

	/**
	 * Gets the height of the canvas.
	 * 
	 * @return height of the canvas.
	 */
	public final double getCanvasHeight() {
		return canvasHeight;
	}

	/**
	 * Gets the alien controller.
	 * 
	 * @return the aliencontroller
	 */
	public final AlienController getAlienController() {
		return alienController;
	}

	/**
	 * Returns the current frame rate.
	 * 
	 * @return the current frame rate.
	 */
	public final double getTickrate() {
		return tickrate;
	}

	/**
	 * Sets the bullet list.
	 * 
	 * @param list
	 *            ArrayList containing the new bullets
	 */
	public final void setBullets(final ArrayList<Bullet> list) {
		bullets = list;
	}

	/**
	 * Returns the barricadecontroller in this game, mostly intended for testing
	 * purposes...
	 * 
	 * @return the barricadeController in this game.
	 */
	public final BarricadeController getBarricadeController() {
		return barController;
	}

	/**
	 * Returns the spaceshipcontroller in this game.
	 * 
	 * @return the spaceshipcontroller in this game.
	 */
	public abstract SpaceShipController getSpaceShipController();

	/**
	 * Returns the powerUpcontroller of this game.
	 * 
	 * @return the powerUpcontroller of this game.
	 */
	public abstract PowerUpController getPowerUpController();
	
	/**
	 * Returns the ShipBullet velocity.
	 * @return the ShipBullet velocity
	 */
	public final double getShipBulletVelX() {
		return spaceShipBulletVelX;
	}

	/**
	 * Returns the waveCounter.
	 * @return the waveCounter
	 */
	public final int getWaveCounter() {
		return waveCounter;
	}
}
