package spaceinvaders.group_22;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

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
	 * List of aliens in the game.
	 */
	private ArrayList<Alien> aliens;
	/**
	 * Arraylist of all barricades in the game.
	 */
	private ArrayList<Barricade> barricades;
	/**
     * List of explosions in the game.
     */
	private ArrayList<Explosion> explosions;	
	/**
     * The width of the canvas.
     */
    private int canvasWidth;
    
    /**
     * The height of the canvas.
     */
    private int canvasHeight;
    /**
     * Velocity of the bullets of the spaceShip in pixels per second.
     */
    @SuppressWarnings("checkstyle:magicnumber")
    private double spaceShipBulletVelX = 80;
	/**
	 * The tickrate of the animation.
	 */	
	private static double tickrate;
	/**
	 * To check if it is allowed to move.
	 */
	private boolean shootingAllowed;
	/**
	 * Counter until it is allowed to shoot.
	 */
	private int countToShoot;
	/**
	 * Marks if the game has been ended.
	 */
	private boolean hasEnded = false;
	
	/**
	 * The controller of the Aliens.
	 */
	private AlienController alienController;
	/**
	 * The collisions of units.
	 */
	private Collisions collisions;
	/**
	 * Creates a new instance of game.
	 * @param width of the canvas.
	 * @param height of the canvas.
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	public Game(final int width, final int height) {
		canvasWidth = width;
		canvasHeight = height;
		
		bullets = new ArrayList<Bullet>();
		explosions = new ArrayList<Explosion>();
		barricades = createBarricades();

		alienController = new AlienController(this);
		
		collisions = new Collisions(this);
		
		aliens = alienController.createAlienWave(100, 69, 60, 10, 4);

		player = new Player(this);
		
		shootingAllowed = true;
		countToShoot = 0;
	}
	/**
	 * Starts the game.
	 */
	public final void start() {
		inProgress = true;
		hasEnded = false;
	}
	/**
	 * Pauses the game.
	 */
	public final void stop() {
		inProgress = false;
	}
	/**
	 * Resets the game.
	 */
	public final void reset() {
		bullets = new ArrayList<Bullet>();
		explosions = new ArrayList<Explosion>();
		aliens = alienController.createAlienWave(100, 69, 60, 10, 4);
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
		if (pressedKeys.contains(KeyCode.SPACE)) {
			if (shootingAllowed) {
				bullets.add(player.getSpaceShip().shootBullet(-spaceShipBulletVelX));
				shootingAllowed = false;
			}
		}
		if (!shootingAllowed) {
			if (countToShoot < (1 / tickrate)) { 
				countToShoot++; 
			} else if (countToShoot == (1 / tickrate)) {
				shootingAllowed = true;
				countToShoot = 0;
			}
		}
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
			player.getSpaceShip();
			velX = velX - SpaceShip.maxVelX * tickrate * 2;
		}
		if (player.getSpaceShip().getXCoor() + 0.5 * player.getSpaceShip().getWidth() < canvasWidth
				&& pressedKeys.contains(KeyCode.D)) {
			player.getSpaceShip();
			velX = velX + SpaceShip.maxVelX * tickrate * 2;
		}

		if (velX > SpaceShip.maxVelX) {
			velX = SpaceShip.maxVelX;
		} else if (velX < -SpaceShip.maxVelX) {
			velX = -SpaceShip.maxVelX;
		}
		player.getSpaceShip().setVelX(velX);
		player.getSpaceShip().moveUnit();
		
		alienController.moveAliens();
		alienController.shootAlienBullets();
		
		//Check if all bullets are still visible
		for (int i = 0; i < bullets.size(); i++) {
			if (bullets.get(i).getXCoor() > canvasWidth || bullets.get(i).getYCoor() < 0) {
				bullets.remove(i);
			}
		}
		//Move every bullet
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).moveUnit();
		}
		collisions.checkCollisions();

		for (int i = 0; i < barricades.size(); i++) {
			if (barricades.get(i).getHealth() == 0) {
				barricades.remove(i);
				i--;
			}
		}

		if (aliens.isEmpty()) {
			aliens = alienController.createAlienWave(100, 69, 60, 10, 4);
			bullets.clear();
		}
	}
	/**
	 * Returns the highscore.
	 * @return current highscore
	 */
	public final int getHighScore() {
		return highscore;
	}
	
	/**
	 * Returns the barricades in this game.
	 * @return the barricades in this game.
	 */
	public final  ArrayList<Barricade> getBarricades() {
		return barricades;
	}
	/**
	 * Sets the barricades in this game.
	 * @param barricade the new barricades for this game.
	 */
	public final void setBarricades(final ArrayList<Barricade> barricade) { 
		barricades = barricade;
	}
	/**
	 * Add a new barricade to this game.
	 * @param barricade to add.
	 */
	public final void addBarricade(final Barricade barricade) {
		barricades.add(barricade);
	}
	/**
	 * Returns the current frame rate.
	 * @return the current frame rate.
	 */
	public static double getTickrate() {
		return tickrate;
	}
	/**
	 * Set the tickrate for the movement.
	 * @param newtickrate of the animation.
	 */
	public static void setTickrate(final double newtickrate) {
		tickrate = newtickrate;
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
	
	/**
	 * Gets the bullets currently in this game.
	 * @return Arraylist of bullets in the game.
	 */
	public final ArrayList<Bullet> getBullets() {
		return bullets;
	}
	/**
	 * Sets the bullets currently in this game.
	 * @param newBullets Arraylist of bullets in the game.
	 */
	public final void setBullets(final ArrayList<Bullet> newBullets) {
		bullets = newBullets;
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
	 * Sets the list of Aliens currently in game.
	 * @param alienList The ArrayList of aliens to set.
	 */
	public final void setAliens(final ArrayList<Alien> alienList) {
		this.aliens = alienList;
	}
	/**
	 * Gets the list of Aliens currently in game.
	 * @return The list of aliens currently in game.
	 */
	public final ArrayList<Alien> getAliens() {
		return aliens;
	}
	
	/**
	 * Creates barricades in the game.
	 * @return ArrayList of barricades.
	 */
	private ArrayList<Barricade> createBarricades() {
		int barricadeCount = 4;
		int interval = canvasWidth / (barricadeCount + 1);
		ArrayList<Barricade> bars = new ArrayList<Barricade>();
		for (int i = 1; i <= barricadeCount; i++) {
			bars.add(new Barricade(interval * i, canvasHeight - 110, "barrier.png"));
		}
		return bars;
	}
}
