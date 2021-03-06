package spaceinvaders.group_22.game.controller;

import java.util.ArrayList;

import spaceinvaders.group_22.game.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.unit.Alien;
import spaceinvaders.group_22.unit.Bullet;
import spaceinvaders.group_22.unit.Collisions;
import spaceinvaders.group_22.unit.Explosion;
import spaceinvaders.group_22.unit.Unit;
import spaceinvaders.group_22.wave.AlienWave;
import spaceinvaders.group_22.wave.AlienWaveFactoryInterface;
import spaceinvaders.group_22.wave.DefaultAlienWaveFactory;
import spaceinvaders.group_22.wave.ReadAlienWaveFactory;
import spaceinvaders.group_22.unit.ShipBullet;

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
	public static final double ALIENBORDERMARGIN = 0.15;
	/**
	 * Amount of aliens per row.
	 */
	public static final int ALIENS_PER_ROW = 10;
	/**
	 * Amount of rows of aliens.
	 */
	public static final int AMOUNT_ALIEN_ROWS = 4;
	/**
	 * Amount of pixels/second the speed of the aliens increases per wave.
	 */
	static final int ALIENVELXINCREASE = 10;
	/**
	 * Speed of the aliens in the X direction in pixels per second.
	 */
	private double alienVelX;
	 /**
     * If 0 the aliens don't have to move any frame down.
     */
	private double alienFramesDown = 0;
	/**
	 * Current alienwave.
	 */
	private AlienWave alienWave;
	/**
	 * Factory to create alien waves.
	 */
	private AlienWaveFactoryInterface alienWaveFactory;
	
	/**
	 * The game object.
	 */
	private Game game;
	
	/**
	 * Creates a new alien controller.
	 * @param newGame The Game where the AlienController comes.
	 */
	public AlienController(final Game newGame) {
		super(newGame);
		game = getGame();
		try {
			alienWaveFactory = new ReadAlienWaveFactory(newGame);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getInstance().log("Failed reading alienWaves from file now using default alien factory"
					, e);
			alienWaveFactory = new DefaultAlienWaveFactory(newGame);
		}
	}
	/**
	 * Method to call every tick for the aliens.
	 */
	public final void tick() {
		move();
		shootAlienBullets();
		removeDeadAliens();
		checkAllAliensDead();
		alienCollisions();
	}
	/**
	 * Method to check for the collisions between aliens and bullets.
	 */
	public final void alienCollisions() {
		//Checking for colissions between player bullets and aliens
		for (Unit bullet : game.getShipBullets()) {
			Unit collidingUnit = new Collisions().checkCollisions(bullet, 
					new ArrayList<Unit>(game.getAlienController().getAliens()));
			if (collidingUnit != null) {
				String logMessage = "Alien collided bullet at X:" + bullet.getXCoor() 
						+ " Y: " + bullet.getYCoor();
				Logger.getInstance().log(logMessage, LogEvent.Type.TRACE);
				
				game.getExplosions().add(new Explosion(collidingUnit.getXCoor(),
						collidingUnit.getYCoor()));
				((Alien) collidingUnit).hit();
				if (((Alien) collidingUnit).getHealth() <= 0) {
					((ShipBullet) bullet).getPlayer().addScore(10);
				}
				game.getBullets().remove(bullet);
				break;
			}
		}
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

			unit.move(game.getTickrate());
			String velX = String.valueOf(alienWave.getAliens().get(0).getVelX());
			String velY = String.valueOf(alienWave.getAliens().get(0).getVelY());
			Logger.getInstance().log("Aliens moved X: " + velX + "\tY: " + velY, LogEvent.Type.TRACE);
		}
		
	}
	/**
	 * Remove dead aliens.
	 */
	public final void removeDeadAliens() {
		ArrayList<Alien> list = new ArrayList<Alien>();
		list.addAll(alienWave.getAliens());
		for (Alien alien : list)  {
			if (alien.getHealth() <= 0) {
				alienWave.remove(alien);

				//generate at random a powerup.
				if (Math.random() > 0.6) {
					game.getPowerUpController().createPowerUpUnit(alien.getXCoor(), alien.getYCoor());
				}
				Logger.getInstance().log("Removed Alien", LogEvent.Type.TRACE);
			}
		}	
	}

	/**
	 * Shoots bullets for aliens.
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	public final void shootAlienBullets() {
		for (Alien alien : alienWave.getAliens()) {
			if (Math.random() < (alien.getBulletChance() * game.getTickrate()))   {
				ArrayList<Bullet> list = alien.shootBullet(game.getAlienBulletVelY());
				for (Bullet bullet : list) {
					game.getBullets().add(bullet);
					String logMessage = "Alien shot bullet at X: " + bullet.getXCoor() + "\tY: " + bullet.getYCoor();
					Logger.getInstance().log(logMessage, LogEvent.Type.TRACE);
				}
			}	
		}
	}
	/**
	 * Go to next round.
	 */
	public final void nextRound() {
		Logger.getInstance().log("proceding to next round", LogEvent.Type.INFO);
		alienVelX += ALIENVELXINCREASE;
		alienWave.setAlienVelX(Math.abs(alienWave.getAlienVelX()) + AlienController.ALIENVELXINCREASE);
		game.setWaveCounter(game.getWaveCounter() + 1);
		if (game.getWaveCounter() % 3 == 0) {
			alienWave = alienWaveFactory.createBossWave();
		} else {
			alienWave = alienWaveFactory.createWave();
		}
	}
	
	/**
	 * Checks if all aliens are dead.
	 */
	public final void checkAllAliensDead() {
		if (alienWave.getAliens().isEmpty()) {
			Logger.getInstance().log("All aliens died", LogEvent.Type.INFO);
			// Increase aliens speed and reset direction so they start moving to
			// the right
			nextRound();
			game.getBullets().clear();
			Logger.getInstance().log("Removed all bullets", LogEvent.Type.TRACE);
		}
	}

	@Override
	public final void create() {
		alienWave = alienWaveFactory.createWave();	
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
	/**
	 * Returns alienVelX for this ALiencontroller.
	 * @return alienVelX the alienvelx
	 */
	public final double getAlienVelX() {
		return alienVelX;
	}
	/**
	 * Sets the alienVelX for this alienController.
	 * @param newVelX the new alienvelX
	 */
	public final void setAlienVelX(final double newVelX) {
		alienVelX = newVelX;
	}
}
