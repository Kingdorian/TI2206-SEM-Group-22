package spaceinvaders.group_22;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

import spaceinvaders.group_22.unit.Alien;
import spaceinvaders.group_22.unit.AlienBullet;
import spaceinvaders.group_22.unit.Barricade;
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
	 * Arraylist of all barricades in the game.
	 */
	private ArrayList<Barricade> barricades;
	/**
     * The width of the canvas.
     */
    private int canvasWidth;
    
    /**
     * The height of the canvas.
     */
    private int canvasHeight;
    
    /**
     * Velocity of the spaceShip in pixels per second.
     */
    private double spaceShipVelX = 250;
    
    /**
     * Velocity of the bullets of the spaceShip in pixels per second.
     */
    private double spaceShipBulletVelX = 80;
    
    /**
     * If 0 the aliens don't have to move any frame down.
     */
	private double alienFramesDown = 0;
	
	/**
	 * Speed of the aliens in the X direction in pixels per second.
	 */
	private int alienVelX = 40;
	
	/**
	 * Speed of the aliens in the Y direction in pixels per second.
	 */
	private double alienVelY = 40;
	/**
	 * Amount of pixels the aliens go down per wave.
	 */
	private double alienFall = 10;
    /**
     * Roughly the amount of bullets that spawn per second.
     */
	private int bulletChance = 1;
	/**
	 * The tickrate of the animation.
	 */
	private static double tickrate;
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
		barricades = createBarricades();
		aliens = createAliens(100, 69, 60, 10, 4);

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
		
		moveAliens();
		shootAlienBullets();
		
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
	 * Creates the aliens on the correct start positions.
	 * @return an arraylist of Aliens drawn.
	 * @param borderDist Distance to the left and right border.
	 * @param spriteWidth Width of the sprite.
	 * @param spriteHeight Height of the sprite.
	 * @param alienAmount Amount of aliens per line.
	 * @param lines Amount of alien lines.
	 */
	@SuppressWarnings("checkstyle:magicnumber")    
	public final ArrayList<Alien> createAliens(final double borderDist, final int spriteWidth, 
			final int spriteHeight, final int alienAmount, final int lines) {
		ArrayList<Alien> alienList = new ArrayList<Alien>();
        
        // Distance to top of the screen.
        double distance = 125;
        
        double interval = (canvasWidth - 2 * borderDist - alienAmount * spriteWidth) / (alienAmount + 1);  
        double startPosition = borderDist + interval;
       
        // Drawing lines of Aliens.
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < alienAmount; j++) {
            	alienList.add(new Alien(startPosition, distance, "invader.png"));
            	startPosition += spriteWidth + interval;
            }
            distance += spriteHeight + 0.1 * spriteHeight;
            startPosition = borderDist + interval;
        }
		return alienList;	
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
	 * Method to move all the aliens in the right direction.
	 */
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void moveAliens() {
		//check if all aliens are still able to move in the window
		for (Alien unit : getAliens()) {
			if (unit.getXCoor() + 0.5 * unit.getWidth() >= canvasWidth 
					&& alienVelX >= 0) {
				alienFramesDown = (alienFall / alienVelY) * (1 / tickrate);
				alienVelX = alienVelX * -1;
			}
			if (unit.getXCoor() - 0.5 * unit.getWidth() <= 0
					&& alienVelX <= 0) {
				alienFramesDown = (alienFall / alienVelY) * (1 / tickrate);
				alienVelX = alienVelX * -1;
			}
		}
		if (alienFramesDown > 0) {
			alienFramesDown = alienFramesDown - 1;
		}
		// move every alien
		for (Alien unit : getAliens()) {
			if (alienFramesDown > 0) {
				unit.setVelY(alienVelY);
				unit.setVelX(0);			
			} else {
				unit.setVelY(0);
				unit.setVelX(alienVelX);
			}
			if (unit.getYCoor() > canvasHeight - 100) {
				this.stop();
			}
			unit.moveUnit();
		}
	}
	
	/**
	 * Checks if there are collisions between bullets and other units.
	 */
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void checkCollisions() {
		//Composing list of alien bullets
		ArrayList<Unit> alienBullets = new ArrayList<Unit>();
		ArrayList<Unit> shipBullets = new ArrayList<Unit>();
		for(Bullet bullet : getBullets()) {
			if(bullet instanceof AlienBullet) {
				alienBullets.add(bullet);
			} else if(bullet instanceof ShipBullet) {
				shipBullets.add(bullet);
			}
		}
		//Checking colissions for spaceship with enemy bullets
		Unit collidingBullet = checkColissions(player.getSpaceShip(), alienBullets);
		if (collidingBullet != null ){
			player.die();
			bullets.remove(collidingBullet);
		}
		//Checking for colissions between player bullets and aliens
		for(Unit bullet : shipBullets) {
			Unit collidingUnit = checkColissions(bullet, new ArrayList<Unit>(aliens));
			if(collidingUnit != null) {
				aliens.remove(collidingUnit);
				bullets.remove(bullet);
				break;
			}
		}
		// Checking for colissions between bullets and barricades
		for(Barricade bar : barricades) {
			Unit collidingUnit = checkColissions(bar, new ArrayList<Unit>(bullets));
			if(collidingUnit != null) {
				bullets.remove(collidingUnit);
				bar.hit();
			}
		}
	}
	
	/**
	 * Checks collisions between an unit and a an ArrayList of other units.
	 * @param checkingUnit the unit to check colissions with
	 * @param unitList the list of units to check colission against.
	 * @return The unit the checkingUnit colides with, null if there are no colissions.
	 */
	public final Unit checkColissions(Unit checkingUnit, ArrayList<Unit> unitList) {
		double checkX = checkingUnit.getXCoor();
		double checkY = checkingUnit.getYCoor();
		for(Unit unit : unitList) {
			double unitX = unit.getXCoor();
			double unitY = unit.getYCoor();
			if ((checkX - unitX >= -((unit.getWidth()/ 2) + (checkingUnit.getWidth()/2))  
				&& (checkX - unitX <= (unit.getWidth() / 2) + (checkingUnit.getWidth()/2))) 
				&& (checkY - unitY >= -((unit.getHeight()) / 2) + (checkingUnit.getHeight()/2)) 
				&& (checkY - unitY <= (unit.getHeight() / 2)  + (checkingUnit.getHeight()/2))){
					return unit;
			}
		}
		return null;
	}

	/**
	 * Shoots bullets for aliens.
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	public final void shootAlienBullets() {
		if (!aliens.isEmpty()) {
			if (Math.random() < bulletChance * tickrate)   {
				int shootIndex = (int) (Math.random() * aliens.size());
				bullets.add(aliens.get(shootIndex).shootBullet(60));
			}
		}
	}
	
	private final ArrayList<Barricade> createBarricades() {
		int barricadeCount = 4;
		int interval = canvasWidth/(barricadeCount+1);
		ArrayList<Barricade> bars = new ArrayList<Barricade>();
		for(int i = 1; i <= barricadeCount; i++) {
			bars.add(new Barricade(interval*i, canvasHeight-200, "invader.png"));
		}
		return bars;
	}
}
