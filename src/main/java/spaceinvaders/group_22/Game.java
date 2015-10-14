package spaceinvaders.group_22;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.unit.Bullet;
import spaceinvaders.group_22.unit.Collisions;
import spaceinvaders.group_22.unit.Explosion;
import spaceinvaders.group_22.unit.ShipBullet;
import spaceinvaders.group_22.unit.SpaceShip;

/**
 * 
 * @author Dorian
 *
 */
@SuppressWarnings("checkstyle:magicnumber")
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
	 * The player of this game.
	 */
	private Player player;
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
	 * To check if it is allowed to move.
	 */
	private boolean shootingAllowed;
	/**
	 * Counter until it is allowed to shoot.
	 */
	private double countToShoot;
	/**
	 * Marks if the game has been ended.
	 */
	private boolean hasEnded = false;
	/**
	 * The controller of the Aliens.
	 */
	private AlienController alienController;
	/**
	 * The spaceshipcontroller of this game.
	 */
	private SpaceShipController spaceShipContr;
	/**
	 * The controller for the power ups.
	 */
	private PowerUpController powerUpController;
	/**
	 * The collisions of units.
	 */
	private Collisions collisions;

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
		spaceShipContr = new SpaceShipController(this);
		alienController = new AlienController(this);
		alienController.create();
		powerUpController = new PowerUpController(this);
		collisions = new Collisions(this);
		player = new Player(this);
		shootingAllowed = true;
		countToShoot = 0;
		Logger.getInstance().log("Created game succesfully", LogEvent.Type.INFO);
	}

	/**
	 * Resets the game.
	 */
	public void resetGame() {
		bullets = new ArrayList<Bullet>();
		explosions = new ArrayList<Explosion>();
		barController.create();
		alienController.create();
		player = new Player(this);

		shootingAllowed = true;
		countToShoot = 0;
		Logger.getInstance().log("Recreated game succesfully", LogEvent.Type.INFO);
	}

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
	public void gameOver() {
		stop();
		if (player.getScore() > highscore) {
			setHighScore(player.getScore());
		}
		hasEnded = true;
		Logger.getInstance().log("Game is over", LogEvent.Type.DEBUG);
	}

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
	public void tick(final ArrayList<KeyCode> pressedKeys) {
		tickShipShooting(pressedKeys);
		spaceShipContr.moveSpaceShip(pressedKeys);
		alienController.move();
		alienController.shootAlienBullets();
		alienController.removeDeadAliens();
		powerUpController.checkPowerUps();
		tickBullets();
		collisions.checkCollisions();
		barController.removeDead();
		alienController.checkAllAliensDead();
	}

	/**
	 * Will create new bullets if player presses space.
	 * @param pressedKeys the keys pressed since last tick
	 */
	public void tickShipShooting(final ArrayList<KeyCode> pressedKeys) {
		if (pressedKeys.contains(KeyCode.SPACE) && shootingAllowed) {
			Logger.getInstance().log("Player pressed Space", LogEvent.Type.DEBUG);
			Bullet bullet = player.getSpaceShip().shootBullet(-spaceShipBulletVelX);
			bullets.add(bullet);
			shootingAllowed = false;
			String logMessage = "Player shot bullet at X: " + bullet.getXCoor() + "\tY: " + bullet.getYCoor();
			Logger.getInstance().log(logMessage, LogEvent.Type.TRACE);
		}
		if (!shootingAllowed) {
			if (countToShoot < ((1 / tickrate) / SpaceShip.getShootTimes())) {
				countToShoot++;
			} else if (Double.compare((double) countToShoot, ((1 / tickrate) / SpaceShip.getShootTimes())) >= 0) {
				shootingAllowed = true;
				countToShoot = 0;
			}
		}
	}

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
	 * Sets player for this game.
	 * 
	 * @param newPlayer
	 *            new player
	 */
	public final void setPlayer(final Player newPlayer) {
		player = newPlayer;
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
	 * Gets the explosions currently in this game.
	 * 
	 * @return Arraylist of bullets in the game.
	 */
	public final ArrayList<Explosion> getExplosions() {
		return explosions;
	}

	/**
	 * Gets the player that is playing this game.
	 * 
	 * @return player that is playing this game
	 */
	public final Player getPlayer() {
		return player;
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
	 * Returns if the player is allowed to shoot at the moment or still in
	 * cooldown.
	 * 
	 * @return true if the player is allowed to shoot, false if player is in
	 *         cooldown
	 */
	public final boolean getShootingAllowed() {
		return shootingAllowed;
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
	public final SpaceShipController getSpaceShipController() {
		return spaceShipContr;
	}

	/**
	 * Returns the powerUpcontroller of this game.
	 * 
	 * @return the powerUpcontroller of this game.
	 */
	public final PowerUpController getPowerUpController() {
		return powerUpController;
	}
	
	/**
	 * Returns the collisions of the game.
	 * @return the collisions of the game
	 */
	public final Collisions getCollisions() {
		return collisions;
	}
	
	/**
	 * Returns the ShipBullet velocity.
	 * @return the ShipBulelt velocity
	 */
	public final double getShipBulletVelX() {
		return spaceShipBulletVelX;
	}
}
