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
	static final double ALIENBORDERMARIGIN = 0.15;
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
	 * Current alien wave.
	 */
	private AlienWave alienWave;
	/**
	 * Factory to create alien waves.
	 */
	private AlienWaveFactory alienWaveFactory;
	
	/**
	 * Creates a new alien controller.
	 * @param newGame The Game where the AlienController comes.
	 */
	public AlienController(final Game newGame) {
		super(newGame);
		alienWave = alienWaveFactory.createWave();
	}
	
	/**
	 * Method to move all the aliens in the right direction.
	 */
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void move() {
		//check if all aliens are still able to move in the window
		if (alienFramesDown == 0) {
			for (Alien unit : alienWave.getAliens()) {
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
		for (Alien unit : alienWave.getAliens()) {
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

		String velX = String.valueOf(alienWave.getAliens().get(0).getVelX());
		String velY = String.valueOf(alienWave.getAliens().get(0).getVelY());
		Game.getLogger().log("Aliens moved X: " + velX + "\tY: " + velY, LogEvent.Type.TRACE);
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
		if (!alienWave.getAliens().isEmpty() && Math.random() 
				< ((alienWave.getAliens().size()) * bulletChance * game.getTickrate()) / 40)   {
			int shootIndex = (int) (Math.random() * alienWave.getAliens().size());
			Bullet bullet = alienWave.getAliens().get(shootIndex).shootBullet(60);
			game.getBullets().add(bullet);
			String logMessage = "Alien shot bullet at X: " + bullet.getXCoor() + "\tY: " + bullet.getYCoor();
			Game.getLogger().log(logMessage, LogEvent.Type.TRACE);
		}
	}
	/**
	 * Go to next round.
	 */
	public final void nextRound() {
		Game.getLogger().log("proceding to next round", LogEvent.Type.INFO);
		alienVelX = Math.abs(alienVelX) + AlienController.ALIENVELXINCREASE;
		create();
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Returns the current alien wave.
	 * @return the current alien wave.
	 */
	public AlienWave getAlienWave() {
		return alienWave;
	}
}
