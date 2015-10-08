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
	 * Amount of pixels/second the speed of the aliens increases per wave.
	 */
	static final int ALIENVELXINCREASE = 10;
	
	 /**
     * If 0 the aliens don't have to move any frame down.
     */
	private double alienFramesDown = 0;
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
		alienWaveFactory = new AlienWaveFactory(game);
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
					alienFramesDown = (alienWave.getAlienFall() / alienWave.getAlienVelY()) * (1 / game.getTickrate());
					// Switch direction
					alienWave.setAlienVelX(alienWave.getAlienVelX() * -1);
					break;
				}
				// When this alien is at the left side of the screen change the direction
				if (unit.getXCoor() - 0.5 * unit.getWidth() <= 0) {
					alienFramesDown = (alienWave.getAlienFall() / alienWave.getAlienVelY()) * (1 / game.getTickrate());
					// Switch direction
					alienWave.setAlienVelX(alienWave.getAlienVelX() * -1);
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
				unit.setVelY(alienWave.getAlienVelY());
				unit.setVelX(0);			
			} else {
				unit.setVelY(0);
				unit.setVelX(alienWave.getAlienVelX());
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
	 * Shoots bullets for aliens.
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	public final void shootAlienBullets() {
		for (int i = 0; i < alienWave.getAliens().size(); i++) {
			if (Math.random() < (alienWave.getAliens().get(i).getBulletChance() * game.getTickrate()))   {
				Bullet bullet = alienWave.getAliens().get(i).shootBullet(60);
				game.getBullets().add(bullet);
				String logMessage = "Alien shot bullet at X: " + bullet.getXCoor() + "\tY: " + bullet.getYCoor();
				Game.getLogger().log(logMessage, LogEvent.Type.TRACE);
			}	
		}
	}
	/**
	 * Go to next round.
	 */
	public final void nextRound() {
		Game.getLogger().log("proceding to next round", LogEvent.Type.INFO);
		alienWave.setAlienVelX(Math.abs(alienWave.getAlienVelX()) + AlienController.ALIENVELXINCREASE);
		alienWave = alienWaveFactory.createWave();
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Returns the current alien wave.
	 * @return the current alien wave.
	 */
	public final AlienWave getAlienWave() {
		return alienWave;
	}
	/**
	 * Returns the current aliens.
	 * @return the current aliens
	 */
	public final ArrayList<Alien> getAliens() {
		return alienWave.getAliens();
	}
}
