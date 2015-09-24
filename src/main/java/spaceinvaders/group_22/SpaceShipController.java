package spaceinvaders.group_22;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.SpaceShip;

/**
 * Class for controlling the spaceship.
 * @author Dorian
 */
public class SpaceShipController extends UnitController implements MovableUnitController {

	/**
	 * Creates a new spaceShipcontroller.
	 */
	public SpaceShipController(final Game parentGame) {
		super(parentGame);
	}
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
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
			velX = velX - SpaceShip.MAXVELX * game.getTickrate() * 2;
		}
		if (game.getPlayer().getSpaceShip().getXCoor() 
				+ 0.5 * game.getPlayer().getSpaceShip().getWidth() < game.getCanvasWidth()
				&& pressedKeys.contains(KeyCode.D)) {
			velX = velX + SpaceShip.MAXVELX * game.getTickrate() * 2;
		}

		if (velX > SpaceShip.MAXVELX) {
			velX = SpaceShip.MAXVELX;
		} else if (velX < -SpaceShip.MAXVELX) {
			velX = -SpaceShip.MAXVELX;
		}
		game.getPlayer().getSpaceShip().setVelX(velX);
		game.getPlayer().getSpaceShip().moveUnit(game.getTickrate());
		if (velX != 0) {
			game.getLogger().log("Player moved X: " + velX, LogEvent.Type.TRACE);
		}
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

}
