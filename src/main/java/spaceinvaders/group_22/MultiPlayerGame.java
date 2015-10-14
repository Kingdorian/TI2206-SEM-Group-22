package spaceinvaders.group_22;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.unit.Bullet;
import spaceinvaders.group_22.unit.Explosion;

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
	 * Creates a MultiPlayerGame.
	 * @param width width of the canvas
	 * @param height height of the canvas
	 */
	public MultiPlayerGame(final double width, final double height) {
		super(width, height);
		setPlayer(null);
		for (int i = 0; i < 2; i++) {
			Player play = new Player(this);
			players.add(play);
		}
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
//		player = new Player(this);
//
//		shootingAllowed = true;
//		countToShoot = 0;
		Logger.getInstance().log("Recreated game succesfully", LogEvent.Type.INFO);
	}
	
	/**
	 * Stops the game and marks the game as ended.
	 */
	@Override
	public final void gameOver() {
		stop();
//		if (player.getScore() > highscore) {
//			setHighScore(player.getScore());
//		}
		setHasEnded(true);
		Logger.getInstance().log("Game is over", LogEvent.Type.DEBUG);
	}
	
	@Override
	public final void tick(final ArrayList<KeyCode> pressedKeys) {
		tickShipShooting(pressedKeys);
		getSpaceShipController().moveSpaceShip(pressedKeys);
		getAlienController().move();
		getAlienController().shootAlienBullets();
		getAlienController().removeDeadAliens();
		getPowerUpController().checkPowerUps();
		tickBullets();
		getCollisions().checkCollisions();
		getBarricadeController().removeDead();
		getAlienController().checkAllAliensDead();
	}

}
