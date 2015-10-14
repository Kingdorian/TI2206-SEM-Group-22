package spaceinvaders.group_22;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.unit.Bullet;
import spaceinvaders.group_22.unit.Explosion;
import spaceinvaders.group_22.unit.SpaceShip;

/**
 * 
 * @author Ege
 *
 */
public class MultiPlayerGame extends Game {
	
	/**
	 * The players in the multiPlayerGame.
	 */
	private ArrayList<Player> players;
	/**
	 * List of shootAllowed of the players.
	 */
	private ArrayList<Boolean> shootingAllowedMultiPlayer;
	/**
	 * List of countToShot for the players.
	 */
	private ArrayList<Integer> countToShootMultiPlayer;
	/**
	 * The PowerUpController.
	 */
	private MultiPlayerPowerUpController mpPowerUpController;
	/**
	 * The SpaceShipsController.
	 */
	private MultiSpaceShipsController mpSpaceShipsController;
	/**
	 * Creates a MultiPlayerGame.
	 * @param width width of the canvas
	 * @param height height of the canvas
	 */
	public MultiPlayerGame(final double width, final double height) {
		super(width, height);
		for (int i = 0; i < 2; i++) {
			Player play = new Player(this);
			players.add(play);
			shootingAllowedMultiPlayer.add(true);
			countToShootMultiPlayer.add(0);
		}
		mpSpaceShipsController = new MultiSpaceShipsController(this);
		mpPowerUpController = new MultiPlayerPowerUpController(this);
	}
	
	/**
	 * Resets the game.
	 */
	@Override
	public final void resetGame() {
		setBullets(new ArrayList<Bullet>());
		setExplosions(new ArrayList<Explosion>());
		getBarricadeController().create();
		getAlienController().create();
		for (int i = 0; i < 2; i++) {
			Player play = new Player(this);
			players.add(play);
			shootingAllowedMultiPlayer.add(true);
			countToShootMultiPlayer.add(0);
		}
		Logger.getInstance().log("Recreated game succesfully", LogEvent.Type.INFO);
	}
	
	/**
	 * Stops the game and marks the game as ended.
	 */
	@Override
	public final void gameOver() {
		stop();
		for (int i = 0; i < 2; i++) {
			if (players.get(i).getScore() > getHighScore()) {
				setHighScore(players.get(i).getScore());
			}
		}
		setHasEnded(true);
		Logger.getInstance().log("Game is over", LogEvent.Type.DEBUG);
	}
	
	@Override
	public final void tick(final ArrayList<KeyCode> pressedKeys) {
		tickShipShooting(pressedKeys, KeyCode.SPACE, 0);
		tickShipShooting(pressedKeys, KeyCode.SHIFT, 1);
		mpSpaceShipsController.moveSpaceShip(pressedKeys);
		getAlienController().move();
		getAlienController().shootAlienBullets();
		getAlienController().removeDeadAliens();
		mpPowerUpController.checkPowerUps();
		tickBullets();
		getCollisions().checkCollisions();
		getBarricadeController().removeDead();
		getAlienController().checkAllAliensDead();
	}
	
	/**
	 * Will create new bullets.
	 * @param pressedKeys the keys pressed since last tick
	 * @param needKey key needed for player
	 * @param index playerIndex
	 */
	public final void tickShipShooting(final ArrayList<KeyCode> pressedKeys, final KeyCode needKey, final int index) {
		if (pressedKeys.contains(needKey) && shootingAllowedMultiPlayer.get(index)) {
			Logger.getInstance().log("Player pressed " + needKey, LogEvent.Type.DEBUG);
			Bullet bullet = players.get(index).getSpaceShip().shootBullet(-getShipBulletVelX());
			getBullets().add(bullet);
			shootingAllowedMultiPlayer.set(index, false);
			String logMessage = "Player shot bullet at X: " + bullet.getXCoor() + "\tY: " + bullet.getYCoor();
			Logger.getInstance().log(logMessage, LogEvent.Type.TRACE);
		}
		if (!shootingAllowedMultiPlayer.get(index)) {
			if (countToShootMultiPlayer.get(index) < ((1 / getTickrate()) / SpaceShip.getShootTimes())) {
				countToShootMultiPlayer.set(index, countToShootMultiPlayer.get(index) + 1);
			} else if (Double.compare((double) countToShootMultiPlayer.get(index), 
									 ((1 / getTickrate()) / SpaceShip.getShootTimes())) >= 0) {
				shootingAllowedMultiPlayer.set(index, false);
				countToShootMultiPlayer.set(index, 0);
			}
		}
	}
}
