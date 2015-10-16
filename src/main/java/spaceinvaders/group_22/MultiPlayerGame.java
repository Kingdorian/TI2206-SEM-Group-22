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
	private ArrayList<Player> players = new ArrayList<Player>();
	/**
	 * List of shootAllowed of the players.
	 */
	private ArrayList<Boolean> shootingAllowed = new ArrayList<Boolean>();
	/**
	 * List of countToShot for the players.
	 */
	private ArrayList<Integer> countToShootMultiPlayer = new ArrayList<Integer>();
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
			Player play = new Player(this, (i + 1) * getCanvasWidth() / 3);
			
			players.add(play);
			shootingAllowed.add(true);
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
		players.clear();
		for (int i = 0; i < 2; i++) {
			Player play = new Player(this, (i + 1) * getCanvasWidth() / 3);
			players.add(play);
			shootingAllowed.add(true);
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
		tickShipShooting(pressedKeys, KeyCode.ENTER, 1);
		mpSpaceShipsController.tick(pressedKeys);
		getBarricadeController().tick();
		getAlienController().tick();
		mpPowerUpController.checkPowerUps();
		tickBullets();
		for (Player player: players) {
			checkAlienHeight(player.getSpaceShip());
		}
		
	}
	
	/**
	 * Will create new bullets.
	 * @param pressedKeys the keys pressed since last tick
	 * @param needKey key needed for player
	 * @param index playerIndex
	 */
	public final void tickShipShooting(final ArrayList<KeyCode> pressedKeys, final KeyCode needKey, final int index) {
		if (pressedKeys.contains(needKey) && shootingAllowed.get(index)) {
			Logger.getInstance().log("Player pressed " + needKey, LogEvent.Type.DEBUG);
			Bullet bullet = players.get(index).getSpaceShip().shootBullet(-getShipBulletVelX());
			getBullets().add(bullet);
			shootingAllowed.set(index, false);
			String logMessage = "Player shot bullet at X: " + bullet.getXCoor() + "\tY: " + bullet.getYCoor();
			Logger.getInstance().log(logMessage, LogEvent.Type.TRACE);
		}
		if (!shootingAllowed.get(index)) {
			if (countToShootMultiPlayer.get(index) < ((1 / getTickrate()) / SpaceShip.getShootTimes())) {
				countToShootMultiPlayer.set(index, countToShootMultiPlayer.get(index) + 1);
			} else if (Double.compare((double) countToShootMultiPlayer.get(index), 
									 ((1 / getTickrate()) / SpaceShip.getShootTimes())) >= 0) {
				shootingAllowed.set(index, true);
				countToShootMultiPlayer.set(index, 0);
			}
		}
	}

	@Override
	public final SpaceShipController getSpaceShipController() {
		return mpSpaceShipsController;
	}

	@Override
	public final PowerUpController getPowerUpController() {
		return mpPowerUpController;
	}

	/**
	 * Returns the players of the game.
	 * @return Players in this game
	 */
	public final ArrayList<Player> getPlayers() {
		return players;
	}
	/**
	 * returns the shootingallowed boolean for every player.
	 * @return arraylist of booleans with shootingallowed.
	 */
	public final ArrayList<Boolean> getShootingAllowed() {
		return shootingAllowed;
	}

	@Override
	public boolean playerAlive() {
		boolean aPlayerAlive = false;
		for(Player p : players) {
			if(p.getLives()>0) {
				return true;
			}
		}
		return false;
	}



}
