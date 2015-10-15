package spaceinvaders.group_22;

import java.util.ArrayList;

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
		//Checking colissions for spaceship with enemy bullets
		ArrayList<Unit> list = new ArrayList<Unit>();
		list.addAll(game.getAlienBullets());
		Unit collidingBullet = Collisions.checkCollisions(ship, list);
		if (collidingBullet != null) {
			String logMessage = "Player collided bullet at X:" + ship.getXCoor() 
						+ " Y: " + ship.getYCoor();
			Logger.getInstance().log(logMessage, LogEvent.Type.TRACE);
					
			Explosion spaceShipexplosion = new Explosion(ship.getXCoor(),
							ship.getYCoor(), "explosion1.png");
			ship.setExplosion(spaceShipexplosion);
			game.getExplosions().add(spaceShipexplosion);
			game.getBullets().remove(collidingBullet);
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
