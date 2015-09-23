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
import spaceinvaders.group_22.unit.PowerUpUnit;
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
	 * List of aliens in the game.
	 */
	private ArrayList<Alien> aliens;
	/**
	 * ArrayList of all barricades in the game.
	 */
	private ArrayList<Barricade> barricades;
	/**
     * List of explosions in the game.
     */
	private ArrayList<Explosion> explosions;	
	/**
     * List of powerups in the game.
     */
	private ArrayList<PowerUpUnit> powerups;	
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
	 * The controller for the power ups.
	 */
	private PowerUpController powerUpController;
	/**
	 * The collisions of units.
	 */
	private Collisions collisions;
	
	/**
	 * The logger.
	 */
	private static Logger logger;
	/**
	 * Part of the screen (on left and right) that cannot be used when creating aliens. 
	 */
	static final double ALIENBORDERMARIGIN = 0.1;
	/**
	 * Amount of aliens per row.
	 */
	static final int ALIENS_PER_ROW = 10;
	/**
	 * Amount of rows of aliens.
	 */
	static final int AMOUNT_ALIEN_ROWS = 4;
	/**
	 * Amount of pixels/second the speed of the aliens increases per wave.
	 */
	static final int ALIENVELXINCREASE = 10;
	/**
	 * Location of the sprite of the aliens.
	 */
	static final String ALIENSPRITE = "invader.png";
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
		powerups = new ArrayList<PowerUpUnit>();
		barricades = createBarricades();

		alienController = new AlienController(this);
		
		powerUpController = new PowerUpController(this);
		
		collisions = new Collisions(this);
				// Create an alien to use to get the width and height of the aliens used in this game. 
		//(based on their sprite size)
		Alien spriteinfo = new Alien(0, 0, ALIENSPRITE);
		aliens = alienController.createAlienWave(canvasWidth * ALIENBORDERMARIGIN,
					spriteinfo.getWidth(), spriteinfo.getHeight(), ALIENS_PER_ROW, AMOUNT_ALIEN_ROWS);
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
		barricades = createBarricades();
		
		alienController = new AlienController(this);
		powerUpController = new PowerUpController(this);
		Alien spriteinfo = new Alien(0, 0, ALIENSPRITE);
		aliens = alienController.createAlienWave(canvasWidth * ALIENBORDERMARIGIN,
				spriteinfo.getWidth(), spriteinfo.getHeight(), ALIENS_PER_ROW, AMOUNT_ALIEN_ROWS);
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
		barricades = createBarricades();
		// Create an alien to use to get the width and height of the aliens used in this game. 
		//(based on their sprite size)
		Alien spriteinfo = new Alien(0, 0, ALIENSPRITE);
		aliens = alienController.createAlienWave(canvasWidth * ALIENBORDERMARIGIN, 
					spriteinfo.getWidth(), spriteinfo.getHeight(), ALIENS_PER_ROW, AMOUNT_ALIEN_ROWS);
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
			if (countToShoot < ((1 / tickrate) / SpaceShip.shootTimes)) { 
				countToShoot++; 
			} else if (Double.compare((double) countToShoot, ((1 / tickrate) / SpaceShip.shootTimes)) == 0) {
				shootingAllowed = true;
				countToShoot = 0;
			}
		}
		moveSpaceShip(pressedKeys);
		alienController.moveAliens();
		alienController.shootAlienBullets();
		
		powerUpController.checkPowerUps();
		
		//Check if all bullets are still visible
		for (int i = 0; i < bullets.size(); i++) {
			if (bullets.get(i).getXCoor() > canvasWidth || bullets.get(i).getYCoor() < 0 
					|| bullets.get(i).getYCoor() >= canvasHeight) {
				bullets.remove(i);
				logger.log("Removed bullet out of screen", LogEvent.Type.TRACE);
			}
		}
		
		//Move every bullet
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).moveUnit(tickrate);
		}
		logger.log("Moved bullets", LogEvent.Type.TRACE);
		
		collisions.checkCollisions();
		for (int i = 0; i < barricades.size(); i++)  {
			if (barricades.get(i).getHealth() == 0) {
				barricades.remove(i);
				logger.log("Removed barricade", LogEvent.Type.TRACE);
				i--;
			}
		}
		//new wave of aliens
		if (aliens.isEmpty()) {
			logger.log("All aliens died", LogEvent.Type.TRACE);
			//Increase aliens speed and reset direction so they start moving to the right
			alienController.setAlienVelX(Math.abs(alienController.getAlienVelX()) + ALIENVELXINCREASE);
			// Create an alien to use to get the width and height of the aliens used in this game. 
			//(based on their sprite size)
			Alien spriteinfo = new Alien(0, 0, ALIENSPRITE);
			aliens = alienController.createAlienWave(canvasWidth * ALIENBORDERMARIGIN, 
						spriteinfo.getWidth(), spriteinfo.getHeight(), ALIENS_PER_ROW, AMOUNT_ALIEN_ROWS);
			bullets.clear();
			logger.log("Removed all bullets", LogEvent.Type.TRACE);
		}
	}
	/**
	 * Moves the spaceship.
	 * @param pressedKeys the keys pressed since last tick
	 */
	public final void moveSpaceShip(final ArrayList<KeyCode> pressedKeys) {
		double velX = player.getSpaceShip().getVelX() * 0.98;
		SpaceShip playership = player.getSpaceShip();
		if (playership.getXCoor() - (0.5 * playership.getWidth()) <= 0 && velX < 0) {
			velX *= -1;
		} else if (player.getSpaceShip().getXCoor() 
				+ (0.5 * playership.getWidth()) >=  canvasWidth && velX > 0) {
			velX *= -1;
		}
		// Check that the spaceship is still able to move without going off the screen.
		if (player.getSpaceShip().getXCoor() - 0.5 * player.getSpaceShip().getWidth() > 0 
				&& pressedKeys.contains(KeyCode.A)) {
			velX = velX - SpaceShip.MAXVELX * tickrate * 2;
		}
		if (player.getSpaceShip().getXCoor() + 0.5 * player.getSpaceShip().getWidth() < canvasWidth
				&& pressedKeys.contains(KeyCode.D)) {
			velX = velX + SpaceShip.MAXVELX * tickrate * 2;
		}

		if (velX > SpaceShip.MAXVELX) {
			velX = SpaceShip.MAXVELX;
		} else if (velX < -SpaceShip.MAXVELX) {
			velX = -SpaceShip.MAXVELX;
		}
		player.getSpaceShip().setVelX(velX);
		player.getSpaceShip().moveUnit(tickrate);
		if (velX != 0) {
			logger.log("Player moved X: " + velX, LogEvent.Type.TRACE);
		}
	}
	/**
	 * Add a new barricade to this game.
	 * @param barricade to add.
	 */
	public final void addBarricade(final Barricade barricade) {
		barricades.add(barricade);
		logger.log("Created barricade", LogEvent.Type.TRACE);
	}
	
	/**
	 * Creates the barricades for this game.
	 * @return the barricades in this game.
	 */
	private ArrayList<Barricade> createBarricades() {
		int barricadeCount = 4;
		int interval = (int) canvasWidth / (barricadeCount + 1);
		ArrayList<Barricade> bars = new ArrayList<Barricade>();
		for (int i = 1; i <= barricadeCount; i++) {
			bars.add(new Barricade(interval * i, canvasHeight - 110, "barrier.png"));
		}
		logger.log("Created all barricades", LogEvent.Type.DEBUG);
		return bars;
	}
	/**
	 * Sets the barricades in this game.
	 * @param barricade the new barricades for this game.
	 */
	public final void setBarricades(final ArrayList<Barricade> barricade) { 
		barricades = barricade;
	}
	// ONLY SETTERS AND GETTERS BELOW
	/**
	 * Sets the list of Aliens currently in game.
	 * @param alienList The ArrayList of aliens to set.
	 */
	public final void setAliens(final ArrayList<Alien> alienList) {
		this.aliens = alienList;
	}
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
	 * Gets the list of Aliens currently in game.
	 * @return The list of aliens currently in game.
	 */
	public final ArrayList<Alien> getAliens() {
		return aliens;
	}
		/**
	 * Returns the barricades in this game.
	 * @return the barricades in this game.
	 */
	public final  ArrayList<Barricade> getBarricades() {
		return barricades;
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
	 * Returns the powerup list.
	 * @return arraylist of the powerups currently in the game.
	 */
	public final ArrayList<PowerUpUnit> getPowerups() {
		return powerups;
	}
	/**
	 * Sets the list of powerups.
	 * @param newpowerups arraylist of powerups to set.
	 */
	public final void setPowerups(final ArrayList<PowerUpUnit> newpowerups) {
		this.powerups = newpowerups;
	}
	/**
	 * Returns the powerUpcontroller of this game.
	 * @return the powerUpcontroller of this game.
	 */
	public final PowerUpController getPowerUpController() {
		return powerUpController;
	}
}
