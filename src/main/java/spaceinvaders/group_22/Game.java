package spaceinvaders.group_22;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

import spaceinvaders.group_22.unit.Alien;
import spaceinvaders.group_22.unit.AlienBullet;
import spaceinvaders.group_22.unit.Bullet;
import spaceinvaders.group_22.unit.Unit;
import spaceinvaders.group_22.unit.ShipBullet;

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
     * The width of the canvas.
     */
    private double canvasWidth;
    
    /**
     * The height of the canvas.
     */
    private double canvasHeight;
    
    /**
     * Velocity of the spaceShip in pixels per second.
     */
    private double spaceShipVelX = 250;
    
    /**
     * Velocity of the bullets of the spaceShip in pixels per second.
     */
    private double spaceShipBulletVelX = 80;
	/**
	 * The tickrate of the animation.
	 */
	private static double tickrate;
	/**
	 * The controller of the Aliens.
	 */
	private AlienController alienController;
	/**
	 * Creates a new instance of game.
	 * @param width of the canvas.
	 * @param height of the canvas.
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	public Game(final double width, final double height) {
		canvasWidth = width;
		canvasHeight = height;
		
		bullets = new ArrayList<Bullet>();
		
		alienController = new AlienController(this);
		
		aliens = alienController.createAlienWave(100, 69, 60, 10, 4);

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
	@SuppressWarnings("checkstyle:magicnumber")
	public final void tick(final ArrayList<KeyCode> pressedKeys) {
		double velX = 0;
		if (pressedKeys.contains(KeyCode.SPACE)) {
			bullets.add(player.getSpaceShip().shootBullet(-spaceShipBulletVelX));
		}
		// Check that the spaceship is still able to move without going off the screen.
		if (player.getSpaceShip().getXCoor() - 0.5 * player.getSpaceShip().getWidth() > 0 
				&& pressedKeys.contains(KeyCode.A)) {
			velX = velX - spaceShipVelX;
		}
		if (player.getSpaceShip().getXCoor() + 0.5 * player.getSpaceShip().getWidth() < canvasWidth
				&& pressedKeys.contains(KeyCode.D)) {
			velX = velX + spaceShipVelX;
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
		checkCollisions();
		if (aliens.isEmpty()) {
			aliens = alienController.createAlienWave(100, 69, 60, 10, 4);
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
	 * Checks if there are collisions between bullets and other units.
	 */
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void checkCollisions() {
		for (int i = 0; i < this.getBullets().size(); i++) {
			if (this.getBullets().get(i) instanceof ShipBullet) {
				Alien alien = this.checkShipBulletVsAliens(this.getBullets().get(i));
				if (alien != null) {
					this.getAliens().remove(alien);
					this.getBullets().remove(i);
					getPlayer().addScore(10);
				}
			} else if (this.getBullets().get(i) instanceof AlienBullet) {
				if (this.checkAliensBulletVsSpaceShip(this.getBullets().get(i))) {
					this.getPlayer().die();
					this.getBullets().remove(i);
				}
			}
		}
	}
	
	/**
	 * Checks if there is a collision between a ShipBullet and an Alien.
	 * @param bullet The bullet to check
	 * @return The Alien which gets hit, or null if no alien gets hit
	 */
	@SuppressWarnings("checkstyle:magicnumber") 
	public final Alien checkShipBulletVsAliens(final Bullet bullet) {
		int size = this.getAliens().size();
		double bulletX = bullet.getXCoor();
		double bulletY = bullet.getYCoor();
		for (int i = 0; i < size; i++) {
			double alienX = this.getAliens().get(i).getXCoor();
			double alienY = this.getAliens().get(i).getYCoor();
			if ((bulletX - alienX >= -(this.getAliens().get(i).getWidth()) / 2) 
				&& (bulletX - alienX <= this.getAliens().get(i).getWidth() / 2) 
				&& (bulletY - alienY >= -(this.getAliens().get(i).getHeight()) / 2) 
				&& (bulletY - alienY <= this.getAliens().get(i).getHeight() / 2)) {
				return this.getAliens().get(i);
			}
		}
		return null;
	}
	
	/**
	 * Checks if there is a collision between an AlienBullet and the SpaceShip.
	 * @param bullet The bullet to check
	 * @return True if there is a collision, false if there isn't
	 */
	@SuppressWarnings("checkstyle:magicnumber") 
	public final boolean checkAliensBulletVsSpaceShip(final Bullet bullet) {
		double bulletX = bullet.getXCoor();
		double bulletY = bullet.getYCoor();
		double shipX = this.getPlayer().getSpaceShip().getXCoor();
		double shipY = this.getPlayer().getSpaceShip().getYCoor();
		if ((bulletX - shipX >= -(this.getPlayer().getSpaceShip().getWidth()) / 2) 
			&& (bulletX - shipX <= this.getPlayer().getSpaceShip().getWidth() / 2) 
			&& (bulletY - shipY >= -(this.getPlayer().getSpaceShip().getHeight()) / 2) 
			&& (bulletY - shipY <= this.getPlayer().getSpaceShip().getHeight() / 2)) {
			return true;
		}
		return false;
	}

}
