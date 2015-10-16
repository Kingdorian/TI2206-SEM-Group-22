package spaceinvaders.group_22;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.unit.Collisions;
import spaceinvaders.group_22.unit.Explosion;
import spaceinvaders.group_22.unit.SpaceShip;
import spaceinvaders.group_22.unit.Unit;

/**
 * Class for controlling the spaceship.
 * @author Dorian
 */
@SuppressWarnings("checkstyle:magicnumber")
public abstract class SpaceShipController extends UnitController implements MovableUnitController {
	/**
	 * Game object of this controller.
	 */
	private Game game;
	/**
	 * Creates a new spaceShipcontroller.
	 * @param parentGame Game this controller works for.
	 */
	public SpaceShipController(final Game parentGame) {
		super(parentGame);
		game = parentGame;
	}
	/**
	 * 
	 * @param ship to check the collisions on.
	 */
	public final void spaceShipCollisions(final SpaceShip ship) {
		if (!ship.getPlayer().isInvulnerable()) {
			//Checking colissions for spaceship with enemy bullets
			ArrayList<Unit> list = new ArrayList<Unit>();
			list.addAll(game.getAlienBullets());
			
			Unit collidingBullet = new Collisions().checkCollisions(ship, list);
			
			if (collidingBullet != null) {
				String logMessage = "Player collided bullet at X:" + ship.getXCoor() 
							+ " Y: " + ship.getYCoor();
				Logger.getInstance().log(logMessage, LogEvent.Type.TRACE);
						
				Explosion spaceShipexplosion = new Explosion(ship.getXCoor(),
								ship.getYCoor());
				ship.setExplosion(spaceShipexplosion);
				game.getExplosions().add(spaceShipexplosion);
				game.getBullets().remove(collidingBullet);
			}
		}
	}
	
	/**
	 * Check if there is a explosion on a spaceship and if he is dead.
	 * @param player The player to check explosions for.
	 */
	public final void checkExplosions(final Player player) {
		if (player.getSpaceShip().getExplosionCounter() == 24) {
			Logger.getInstance().log("Spaceship hit by bullet" , LogEvent.Type.INFO);
			player.die();
		}
	}
	
	/**
	 * Moves the spaceship.
	 * @param pressedKeys the keys pressed since last tick
	 * @param player to move the ship for.
	 */
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void moveSpaceShip(final ArrayList<KeyCode> pressedKeys, final Player player) {
		double velX = player.getSpaceShip().getVelX() * 0.98;
		SpaceShip playership = player.getSpaceShip();
		if (playership.getXCoor() - (0.5 * playership.getWidth()) <= 0 && velX < 0) {
			velX *= -1;
		} else if (player.getSpaceShip().getXCoor() 
				+ (0.5 * playership.getWidth()) >=  game.getCanvasWidth() && velX > 0) {
			velX *= -1;
		}
		// Check that the spaceship is still able to move without going off the screen.
		if (player.getSpaceShip().getXCoor() - 0.5 * player.getSpaceShip().getWidth() > 0 
				&& pressedKeys.contains(KeyCode.A)) {
			Logger.getInstance().log("Player pressed A", LogEvent.Type.DEBUG);
			velX = velX - player.getSpaceShip().getMAXVELX() * game.getTickrate() * 2;
		}
		if (player.getSpaceShip().getXCoor() 
				+ 0.5 * player.getSpaceShip().getWidth() < game.getCanvasWidth()
				&& pressedKeys.contains(KeyCode.D)) {
			Logger.getInstance().log("Player pressed D", LogEvent.Type.DEBUG);
			velX = velX + player.getSpaceShip().getMAXVELX() * game.getTickrate() * 2;
		}

		if (velX > player.getSpaceShip().getMAXVELX()) {
			velX = player.getSpaceShip().getMAXVELX();
		} else if (velX < -player.getSpaceShip().getMAXVELX()) {
			velX = -player.getSpaceShip().getMAXVELX();
		}
		player.getSpaceShip().setVelX(velX);
		player.getSpaceShip().move(game.getTickrate());
		if (velX != 0) {
			Logger.getInstance().log("Player moved X: " + velX, LogEvent.Type.TRACE);
		}
	}
		
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

}
