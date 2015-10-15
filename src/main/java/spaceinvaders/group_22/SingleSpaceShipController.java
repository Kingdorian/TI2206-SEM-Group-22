package spaceinvaders.group_22;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.unit.SpaceShip;
/**
 * 
 * @author Bryan
 *
 */
public class SingleSpaceShipController extends SpaceShipController {
	/**
	 * The game object.
	 */
	private SinglePlayerGame game;
	
	/**
	 * Creates a new spaceShipcontroller.
	 * @param parentGame Game this controller works for.
	 */
	public SingleSpaceShipController(final SinglePlayerGame parentGame) {
		super(parentGame);
		game = parentGame;
	}
	/**
	 * Method to call every tick for the spaceship.
	 */
	public final void tick() {
		spaceShipCollisions(game.getPlayer().getSpaceShip());
		checkExplosions();
	}
	/**
	 * Check if there is a explosion on a spaceship and if he is dead.
	 */
	public final void checkExplosions() {
		if (game.getPlayer().getSpaceShip().getExplosion() != null 
				&& game.getPlayer().getSpaceShip().getExplosion().getCounter() == 24) {
			Logger.getInstance().log("Spaceship hit by bullet" , LogEvent.Type.INFO);
			game.getBullets().clear();
			game.getPlayer().die();
		}
	}
	
	/**
	 * Moves the spaceship.
	 * @param pressedKeys the keys pressed since last tick
	 */
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void moveSpaceShip(final ArrayList<KeyCode> pressedKeys) {
		double velX = game.getPlayer().getSpaceShip().getVelX() * 0.98;
		SpaceShip playership = game.getPlayer().getSpaceShip();
		if (playership.getXCoor() - (0.5 * playership.getWidth()) <= 0 && velX < 0) {
			velX *= -1;
		} else if (game.getPlayer().getSpaceShip().getXCoor() 
				+ (0.5 * playership.getWidth()) >=  game.getCanvasWidth() && velX > 0) {
			velX *= -1;
		}
		// Check that the spaceship is still able to move without going off the screen.
		if (game.getPlayer().getSpaceShip().getXCoor() - 0.5 * game.getPlayer().getSpaceShip().getWidth() > 0 
				&& pressedKeys.contains(KeyCode.A)) {
			Logger.getInstance().log("Player pressed A", LogEvent.Type.DEBUG);
			velX = velX - SpaceShip.getMAXVELX() * game.getTickrate() * 2;
		}
		if (game.getPlayer().getSpaceShip().getXCoor() 
				+ 0.5 * game.getPlayer().getSpaceShip().getWidth() < game.getCanvasWidth()
				&& pressedKeys.contains(KeyCode.D)) {
			Logger.getInstance().log("Player pressed D", LogEvent.Type.DEBUG);
			velX = velX + SpaceShip.getMAXVELX() * game.getTickrate() * 2;
		}

		if (velX > SpaceShip.getMAXVELX()) {
			velX = SpaceShip.getMAXVELX();
		} else if (velX < -SpaceShip.getMAXVELX()) {
			velX = -SpaceShip.getMAXVELX();
		}
		game.getPlayer().getSpaceShip().setVelX(velX);
		game.getPlayer().getSpaceShip().move(game.getTickrate());
		if (velX != 0) {
			Logger.getInstance().log("Player moved X: " + velX, LogEvent.Type.TRACE);
		}
	}

}
