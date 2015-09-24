package spaceinvaders.group_22;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.unit.Alien;
import spaceinvaders.group_22.unit.Barricade;
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
	 * The collisions of units.
	 */
	private Collisions collisions;
	
	/**
	 * The logger.
	 */
	private static Logger logger;
	/**
	 * Creates a new instance of game.
	 * @param width of the canvas.
	 * @param height of the canvas.
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	public Game(final double width, final double height) {
		canvasWidth = width;
		canvasHeight = height;
		
		logger = new Logger("log.log", 4);
		
		bullets = new ArrayList<Bullet>();
		explosions = new ArrayList<Explosion>();
		barController = new BarricadeController(this);
		barController.create();
		spaceShipContr = new SpaceShipController(this);
		alienController = new AlienController(this);
		alienController.create();		
		collisions = new Collisions(this);
		player = new Player(this);
		shootingAllowed = true;
		countToShoot = 0;
		logger.log("Created game succesfully", LogEvent.Type.INFO);
	}
	/**
	 * Resets the game.
	 */
	public final void resetGame() {
		bullets = new ArrayList<Bullet>();
		explosions = new ArrayList<Explosion>();
		barController.create();
		alienController.create();
		player = new Player(this);
		
		shootingAllowed = true;
		countToShoot = 0;
		logger.log("Recreated game succesfully", LogEvent.Type.INFO);
	}
	/**
	 * Starts the game.
	 */
	public final void start() {
		inProgress = true;
		hasEnded = false;
		logger.log("Game started", LogEvent.Type.INFO);
	}
	/**
	 * Pauses the game.
	 */
	public final void stop() {
		inProgress = false;
		logger.log("Game stopped", LogEvent.Type.INFO);
	}
	/**
	 * Resets the game.
	 */
	public final void reset() {
		bullets = new ArrayList<Bullet>();
		explosions = new ArrayList<Explosion>();
		barController.create();
		alienController.create();
		player = new Player(this);
		shootingAllowed = true;
		countToShoot = 0;
	}
	/**
	 * Stops the game and marks the game as ended.
	 */
	public final void gameOver() {
		stop();
		if (player.getScore() > highscore) {
			setHighScore(player.getScore());
		}
		hasEnded = true;
		logger.log("Game is over", LogEvent.Type.DEBUG);
	}
	
	/**
	 * Returns true if the game is in progress.
	 * @return boolean if the game is in progress
	 */
	public final boolean isInProgress() {
		return inProgress;
	}
	
	/**
	 * Returns true if the game has ended.
	 * @return boolean if the game is ended.
	 */
	public final boolean hasEnded() {
		return hasEnded;
	}
	/**
	 * Will update all the objects in the game.
	 * @param pressedKeys the keys pressed since last tick
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	public final void tick(final ArrayList<KeyCode> pressedKeys) {
		if (pressedKeys.contains(KeyCode.SPACE) && shootingAllowed) {
			Bullet bullet = player.getSpaceShip().shootBullet(-spaceShipBulletVelX);
			bullets.add(bullet);
			shootingAllowed = false;
			String logMessage = "Player shot bullet at X: " + bullet.getXCoor() + "\tY: " + bullet.getYCoor();
			getLogger().log(logMessage, LogEvent.Type.TRACE);
		}
		if (!shootingAllowed) {
			if (countToShoot < (1 / tickrate)) { 
				countToShoot++; 
			} else if (Double.compare((double) countToShoot, 1 / tickrate) == 0) {
				shootingAllowed = true;
				countToShoot = 0;
			}
		}
		spaceShipContr.moveSpaceShip(pressedKeys);
		alienController.move();
		alienController.shootAlienBullets();
		
		//Check if all bullets are still visible
		for (int i = 0; i < bullets.size(); i++) {
			if (bullets.get(i).getXCoor() > canvasWidth || bullets.get(i).getYCoor() < 0) {
				bullets.remove(i);
				logger.log("Removed bullet out of screen", LogEvent.Type.TRACE);
			}
		}
		logger.log("Moved bullets", LogEvent.Type.TRACE);
		
		collisions.checkCollisions();
		ArrayList<Barricade> barricades = barController.getBarricades();
		for (int i = 0; i < barricades.size(); i++)  {
			if (barricades.get(i).getHealth() == 0) {
				barricades.remove(i);
				logger.log("Removed barricade", LogEvent.Type.TRACE);
				i--;
			}
		}
		//new wave of aliens
		if (alienController.getAliens().isEmpty()) {
			logger.log("All aliens died", LogEvent.Type.INFO);
			//Increase aliens speed and reset direction so they start moving to the right
			alienController.nextRound();
			bullets.clear();
			logger.log("Removed all bullets", LogEvent.Type.TRACE);
		}
	}
	
	// ONLY SETTERS AND GETTERS BELOW

	/**
	 * Set the tickrate for the movement.
	 * @param framerate of the animation.
	 */
	public final void setTickrate(final Double framerate) {
		tickrate = framerate;
	}
	/**
	 * Sets highscore.
	 * @param newscore highscore (int)
	 */
	public final void setHighScore(final int newscore) {
		assert newscore >= 0 && newscore > highscore;
		highscore = newscore;
	}
	/**
	 * Sets player for this game.
	 * @param newPlayer new player
	 */
	public final void setPlayer(final Player newPlayer) {
		player = newPlayer;
	}
	// ONLY GETTERS BELOW
	/**
	 * Gets the bullets currently in this game.
	 * @return Arraylist of bullets in the game.
	 */
	public final ArrayList<Bullet> getBullets() {
		return bullets;
	}
	/**
	 * Gets the shipbullets currently in this game.
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
	 * @return Arraylist of bullets in the game.
	 */
	public final ArrayList<Explosion> getExplosions() {
		return explosions;
	}
	/**
	 * Gets the player that is playing this game. 
	 * @return player that is playing this game
	 */
	public final Player getPlayer() {
		return player;
	}
	/**
	 * Returns the highscore.
	 * @return current highscore
	 */
	public final int getHighScore() {
		return highscore;
	}
	/**
	 * Gets the canvas width.
	 * @return width of the canvas.
	 */
	public final double getCanvasWidth() {
		return canvasWidth;
	}
	/**
	 * Gets the height of the canvas.
	 * @return height of the canvas.
	 */
	public final double getCanvasHeight() {
		return canvasHeight;
	}
	/**
	 * Gets the alien controller.
	 * @return the aliencontroller
	 */
	public final AlienController getAlienController() {
		return alienController;
	}
		/**
	 * Returns the current frame rate.
	 * @return the current frame rate.
	 */
	public final double getTickrate() {
		return tickrate;
	}
	/**
	 * Returns if the player is allowed to shoot at the moment or still in cooldown.
	 * @return true if the player is allowed to shoot, false if player is in cooldown
	 */
	public final boolean getShootingAllowed() {
		return shootingAllowed;
	}
	
	/**
	 * Returns the logger.
	 * @return the logger
	 */
	public static final Logger getLogger() {
		return logger;
	}
	/**
	 * Sets the bullet list.
	 * @param list ArrayList containing the new bullets
	 */
	public final void setBullets(final ArrayList<Bullet> list) {
		bullets = list;
	}
	/**
	 * Returns the barricadecontroller in this game, mostly intended for testing purposes...
	 * @return the barricadeController in this game.
	 */
	public BarricadeController getBarricadeController() {
		return barController;
	}
	/**
	 * Returns the spaceshipcontroller in this game.
	 * @return the spaceshipcontroller in this game.
	 */
	public SpaceShipController getSpaceShipController() {
		return spaceShipContr;
	}
}
