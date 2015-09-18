package spaceinvaders.group_22;

import java.util.ArrayList;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.Alien;
import spaceinvaders.group_22.unit.Bullet;

/**
 * Controls the Aliens.
 * @author Ege
 *
 */
@SuppressWarnings("checkstyle:magicnumber") 
public class AlienController {
	
	/**
	 * The game with the controller.
	 */
	private Game game;
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
		game = newGame;
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
	public final ArrayList<Alien> createAlienWave(final double borderDist, final int spriteWidth, 
			final int spriteHeight, final int alienAmount, final int lines) {
		ArrayList<Alien> alienList = new ArrayList<Alien>();
        
        // Distance to top of the screen.
        double distance = 125;
                
        double interval = (game.getCanvasWidth() - 2 * borderDist - alienAmount * spriteWidth) / (alienAmount + 1);  
        double startPosition = borderDist + interval + 0.5 * spriteWidth;
       
        // Drawing lines of Aliens.
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < alienAmount; j++) {
            	Alien alien = new Alien(startPosition, distance, "invader.png");
            	game.getLogger().log("Created Alien", LogEvent.Type.TRACE);
            	alien.setVelX(alienVelX);
            	alienList.add(alien);
            	startPosition += spriteWidth + interval;
            }
            distance += spriteHeight + 0.1 * spriteHeight;
            startPosition = borderDist + interval + 0.5 * spriteWidth;
        }
        game.getLogger().log("Created alien wave succesfully", LogEvent.Type.DEBUG);
		return alienList;	
	}
	
	/**
	 * Method to move all the aliens in the right direction.
	 */
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void moveAliens() {
		//check if all aliens are still able to move in the window
		if (alienFramesDown == 0) {
			for (Alien unit : game.getAliens()) {
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
		for (Alien unit : game.getAliens()) {
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
			unit.moveUnit(game.getTickrate());
		}
		String velX = String.valueOf(game.getAliens().get(0).getVelX());
		String velY = String.valueOf(game.getAliens().get(0).getVelY());
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
		if (!game.getAliens().isEmpty() && Math.random() 
				< ((game.getAliens().size()) * bulletChance * game.getTickrate()) / 40)   {
			int shootIndex = (int) (Math.random() * game.getAliens().size());
			Bullet bullet = game.getAliens().get(shootIndex).shootBullet(60);
			game.getBullets().add(bullet);
			String logMessage = "Alien shot bullet at X: " + bullet.getXCoor() + "\tY: " + bullet.getYCoor();
			game.getLogger().log(logMessage, LogEvent.Type.TRACE);
		}
	}
}
