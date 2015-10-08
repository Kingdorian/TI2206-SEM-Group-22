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
     * Roughly the amount of bullets that spawn per second.
     */
	private int bulletChance = 1;
	/**
	 * Current alienwave.
	 */
	private AlienWave curWave;
	/**
	 * Factory to create alien waves.
	 */
	private AlienWaveFactoryInterface alienWaveFactory;
	
	/**
	 * Creates a new alien controller.
	 * @param newGame The Game where the AlienController comes.
	 */
	public AlienController(final Game newGame) {
		super(newGame);
		try {
			alienWaveFactory = new ReadAlienWaveFactory(newGame);
			curWave = alienWaveFactory.createWave();
		} catch (Exception e) {
			Game.getLogger().log("Failed reading alienWaves from file using default alien factory", LogEvent.Type.WARNING);
			alienWaveFactory = new DefaultAlienWaveFactory(newGame);
			curWave = alienWaveFactory.createWave();
		}
	}
	
	/**
	 * Method to move all the aliens in the right direction.
	 */
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void move() {
		//check if all aliens are still able to move in the window
        
		if (alienFramesDown == 0) {
			for (Alien unit : curWave.getAliens()) {
				// When this alien is on the right side of the screen change the direction
				if (unit.getXCoor() + 0.5 * unit.getWidth() >= game.getCanvasWidth()) {
					alienFramesDown = (curWave.getAlienFall() / curWave.getAlienVelY()) * (1 / game.getTickrate());
					// Switch direction
					curWave.setAlienVelX(curWave.getAlienVelX() * -1);
					break;
				}
				// When this alien is at the left side of the screen change the direction
				if (unit.getXCoor() - 0.5 * unit.getWidth() <= 0) {
					alienFramesDown = (curWave.getAlienFall() / curWave.getAlienVelY()) * (1 / game.getTickrate());
					// Switch direction
					curWave.setAlienVelX(curWave.getAlienVelX() * -1);
					break;
				}
			}
			
		}
		// Decrease the amount of frames the alien needs to be going down.
		if (alienFramesDown > 0) {
			alienFramesDown = alienFramesDown - 1;
		}
		// move every alien
		for (Alien unit : curWave.getAliens()) {
			if (alienFramesDown > 0) {
				unit.setVelY(curWave.getAlienVelY());
				unit.setVelX(0);			
			} else {
				unit.setVelY(0);
				unit.setVelX(curWave.getAlienVelX());
			}

			//Check if there is an alien at the height of the spaceship.
			if (unit.getYCoor() + unit.getHeight() > game.getPlayer().getSpaceShip().getYCoor()) {
				game.gameOver();
			}
			unit.move(game.getTickrate());
		}
	//	String velX = String.valueOf(curWave.getAliens().get(0).getVelX());
	//	String velY = String.valueOf(curWave.getAliens().get(0).getVelY());
	//	Game.getLogger().log("Aliens moved X: " + velX + "\tY: " + velY, LogEvent.Type.TRACE);
	}

	/**
	 * Shoots bullets for aliens.
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	public final void shootAlienBullets() {
		if (!curWave.getAliens().isEmpty() && Math.random() 
				< ((curWave.getAliens().size()) * bulletChance * game.getTickrate()) / 40)   {
			int shootIndex = (int) (Math.random() * curWave.getAliens().size());
			Bullet bullet = curWave.getAliens().get(shootIndex).shootBullet(60);
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
		curWave = alienWaveFactory.createWave();
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
		return curWave;
	}
	/**
	 * Returns the current aliens.
	 * @return the current aliens
	 */
	public final ArrayList<Alien> getAliens() {
		return curWave.getAliens();
	}
}
