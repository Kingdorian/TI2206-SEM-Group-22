package spaceinvaders.group_22;

import java.util.ArrayList;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.Alien;
import spaceinvaders.group_22.unit.Bullet;

/**
 * Controls the Aliens.
 * @author Ege
 * @author Dorian
 *
 */
@SuppressWarnings("checkstyle:magicnumber") 
public class AlienController extends UnitController implements MovableUnitController {
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
	 * List of aliens in the game.
	 */
	private ArrayList<Alien> aliens = new ArrayList<Alien>();
	
	 /**
     * If 0 the aliens don't have to move any frame down.
     */
	private double alienFramesDown = 0;
	/**
	 * Speed of the aliens in the X direction in pixels per second.
	 */
	private double alienVelX = 40;
	
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
	 * Creates a new alien controller.
	 * @param newGame The Game where the AlienController comes.
	 */
	public AlienController(final Game newGame) {
		super(newGame);
	}
	
	/**
	 * Creates the aliens on the correct start positions.
	 * @return an arraylist of Aliens drawn.
	 */
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void create() {
		aliens.clear();
        
        // Distance to top of the screen.
        double distance = 125;
        // Create alien object to make sure we can get the width and height of aliens
        Alien testAlien = new Alien(0.0, 0.0, Alien.SPRITE); 
        double interval = (game.getCanvasWidth() - 2 * ALIENBORDERMARIGIN
        						- ALIENS_PER_ROW * testAlien.getWidth()) / (ALIENS_PER_ROW + 1);  
        double startPosition = ALIENBORDERMARIGIN + interval + 0.5 * testAlien.getWidth();
       
        // Drawing lines of Aliens.
        for (int i = 0; i < AMOUNT_ALIEN_ROWS; i++) {
            for (int j = 0; j < ALIENS_PER_ROW; j++) {
            	Alien alien = new Alien(startPosition, distance, "invader.png");
            	game.getLogger().log("Created Alien", LogEvent.Type.TRACE);
            	alien.setVelX(alienVelX);
            	aliens.add(alien);
            	startPosition += testAlien.getWidth() + interval;
            }
            distance += 1.1 * testAlien.getHeight();
            startPosition = ALIENBORDERMARIGIN + interval + 0.5 * testAlien.getWidth();
        }
        game.getLogger().log("Created alien wave succesfully", LogEvent.Type.DEBUG);
	}
	
	/**
	 * Method to move all the aliens in the right direction.
	 */
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void move() {
		//check if all aliens are still able to move in the window
		if (alienFramesDown == 0) {
			for (Alien unit : aliens) {
				// When this alien is on the right side of the screen change the direction
				if (unit.getXCoor() + 0.5 * unit.getWidth() >= game.getCanvasWidth()) {
					alienFramesDown = (alienFall / alienVelY) * (1 / game.getTickrate());
					// Switch direction
					alienVelX *= -1;
					break;
				}
				// When this alien is at the left side of the screen change the direction
				if (unit.getXCoor() - 0.5 * unit.getWidth() <= 0) {
					alienFramesDown = (alienFall / alienVelY) * (1 / game.getTickrate());
					// Switch direction
					alienVelX *= -1;
					break;
				}
			}
			
		}
		// Decrease the amount of frames the alien needs to be going down.
		if (alienFramesDown > 0) {
			alienFramesDown = alienFramesDown - 1;
		}
		// move every alien
		for (Alien unit : aliens) {
			if (alienFramesDown > 0) {
				unit.setVelY(alienVelY);
				unit.setVelX(0);			
			} else {
				unit.setVelY(0);
				unit.setVelX(alienVelX);
			}

			//Check if there is an alien at the height of the spaceship.
			if (unit.getYCoor() + unit.getHeight() > game.getPlayer().getSpaceShip().getYCoor()) {
				game.gameOver();
			}
			unit.move(game.getTickrate());
		}
		String velX = String.valueOf(aliens.get(0).getVelX());
		String velY = String.valueOf(aliens.get(0).getVelY());
		game.getLogger().log("Aliens moved X: " + velX + "\tY: " + velY, LogEvent.Type.TRACE);
	}

	/**
	 * Getter method for alienVelx.
	 * @return The alien velocity in horizontal direction.
	 */
	public final double getAlienVelX() {
		return alienVelX;
	}

	/**
	 * Setter method for alienVelx.
	 * @param newAlienVelX The new velocity of the alien.
	 */
	public final void setAlienVelX(final double newAlienVelX) {
		this.alienVelX = newAlienVelX;
	}

	/**
	 * Shoots bullets for aliens.
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	public final void shootAlienBullets() {
		if (!aliens.isEmpty() && Math.random() 
				< ((aliens.size()) * bulletChance * game.getTickrate()) / 40)   {
			int shootIndex = (int) (Math.random() * aliens.size());
			Bullet bullet = aliens.get(shootIndex).shootBullet(60);
			game.getBullets().add(bullet);
			String logMessage = "Alien shot bullet at X: " + bullet.getXCoor() + "\tY: " + bullet.getYCoor();
			game.getLogger().log(logMessage, LogEvent.Type.TRACE);
		}
	}
	/**
	 * Go to next round.
	 */
	public final void nextRound() {
		game.getLogger().log("proceding to next round", LogEvent.Type.INFO);
		alienVelX = Math.abs(alienVelX) + AlienController.ALIENVELXINCREASE;
		create();
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
}
