package spaceinvaders.group_22;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.unit.Bullet;
import spaceinvaders.group_22.unit.Explosion;
import spaceinvaders.group_22.unit.SpaceShip;

/**
 * Single Player game object.
 * @author Bryan
 *
 */
public class SinglePlayerGame extends Game {
	/**
	 * The player of this game.
	 */
	private Player player;
	/**
	 * The spaceshipcontroller of this game.
	 */
	private SingleSpaceShipController spaceShipContr;
	/**
	 * The controller for the power ups.
	 */
	private PowerUpController powerUpController;
	/**
	 * To check if it is allowed to move.
	 */
	private boolean shootingAllowed;
	/**
	 * Counter until it is allowed to shoot.
	 */
	private double countToShoot;
	/**
	 * Creates a MultiPlayerGame.
	 * @param width width of the canvas
	 * @param height height of the canvas
	 */
	public SinglePlayerGame(final double width, final double height) {
		super(width, height);
		powerUpController = new SinglePlayerPowerUpController(this);
		spaceShipContr = new SingleSpaceShipController(this);
		shootingAllowed = true;
		player = new Player(this, getCanvasWidth() / 2);
	}
	@Override
	public final void resetGame() {
		setBullets(new ArrayList<Bullet>());
		setExplosions(new ArrayList<Explosion>());
		getBarricadeController().create();
		getAlienController().create();
		player = new Player(this, getCanvasWidth() / 2);
		shootingAllowed = true;
		countToShoot = 0;
		Logger.getInstance().log("Recreated game succesfully", LogEvent.Type.INFO);
	}
	@Override
	public final void gameOver() {
		stop();
		if (player.getScore() > getHighScore()) {
			setHighScore(player.getScore());
		}
		setHasEnded(true);
		Logger.getInstance().log("Game is over", LogEvent.Type.DEBUG);
	}
	@Override
	public final void tick(final ArrayList<KeyCode> pressedKeys) {
		tickShipShooting(pressedKeys);
		spaceShipContr.tick(pressedKeys);
		powerUpController.checkPowerUps();
		tickBullets();
		getBarricadeController().tick();
		getAlienController().tick();
		checkAlienHeight(player.getSpaceShip());
	}
	/**
	 * Will create new bullets if player presses space.
	 * @param pressedKeys the keys pressed since last tick
	 */
	public final void tickShipShooting(final ArrayList<KeyCode> pressedKeys) {
		if (pressedKeys.contains(KeyCode.SPACE) && shootingAllowed) {
			Logger.getInstance().log("Player pressed Space", LogEvent.Type.DEBUG);
			Bullet bullet = player.getSpaceShip().shootBullet(-getShipBulletVelX());
			getBullets().add(bullet);
			shootingAllowed = false;
			String logMessage = "Player shot bullet at X: " + bullet.getXCoor() + "\tY: " + bullet.getYCoor();
			Logger.getInstance().log(logMessage, LogEvent.Type.TRACE);
		}
		if (!shootingAllowed) {
			if (countToShoot < ((1 / getTickrate()) / SpaceShip.getShootTimes())) {
				countToShoot++;
			} else if (Double.compare((double) countToShoot, ((1 / getTickrate()) / SpaceShip.getShootTimes())) >= 0) {
				shootingAllowed = true;
				countToShoot = 0;
			}
		}
	}
	/**
	 * Sets player for this game.
	 * 
	 * @param newPlayer
	 *            new player
	 */
	public final void setPlayer(final Player newPlayer) {
		player = newPlayer;
	}
	/**
	 * Gets the player that is playing this game.
	 * 
	 * @return player that is playing this game
	 */
	public final Player getPlayer() {
		return player;
	}
	
	/**
	 * Gets the spaceship of the player that is playing this game. 
	 * @return the spaceship of the player that is playing this game.
	 */
	public final SpaceShip getPlayerSpaceship() {
		return player.getSpaceShip();
	}
	
	/**
	 * Returns if the player is allowed to shoot at the moment or still in
	 * cooldown.
	 * 
	 * @return true if the player is allowed to shoot, false if player is in
	 *         cooldown
	 */
	public final boolean getShootingAllowed() {
		return shootingAllowed;
	}
	@Override
	public final SpaceShipController getSpaceShipController() {
		return spaceShipContr;
	}

	@Override
	public final PowerUpController getPowerUpController() {
		return powerUpController;
	}
	
	/**
	 * Returns true if player is alive.
	 * @return true if player is alive
	 */
	public final boolean playerAlive() {
		return player.getLives() > 0;
	}

}
