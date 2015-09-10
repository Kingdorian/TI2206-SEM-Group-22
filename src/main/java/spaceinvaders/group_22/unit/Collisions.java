package spaceinvaders.group_22.unit;

import java.util.ArrayList;

import spaceinvaders.group_22.Game;
/**
 * 
 * @author Bryan
 *
 */
public class Collisions {
	
	/**
	 * Game class to check collisions in.
	 */
	private Game game;
	
	/**
	 * Explosion object to remember a space ship explosion.
	 */
	private Explosion spaceShipexplosion;
	
	/**
	 * Create a new collisions class.
	 * @param newgame to check the collisions in.
	 */
	public Collisions(final Game newgame) {
		game = newgame;
	}
	
	/**
	 * Checks if there are collisions between bullets and other units.
	 */
	@SuppressWarnings("checkstyle:magicnumber") 
	public final void checkCollisions() {
		//Composing list of alien bullets
		ArrayList<Unit> alienBullets = new ArrayList<Unit>();
		ArrayList<Unit> shipBullets = new ArrayList<Unit>();
		for (Bullet bullet : game.getBullets()) {
			if (bullet instanceof AlienBullet) {
				alienBullets.add(bullet);
			} else if (bullet instanceof ShipBullet) {
				shipBullets.add(bullet);
			}
		}
		if (spaceShipexplosion != null && spaceShipexplosion.getCounter() == 24) {
			game.getPlayer().die();
		}
		//Checking colissions for spaceship with enemy bullets
		Unit collidingBullet = checkCollisions(game.getPlayer().getSpaceShip(), alienBullets);
		if (collidingBullet != null) {
			spaceShipexplosion = new Explosion(game.getPlayer().getSpaceShip().getXCoor(),
					game.getPlayer().getSpaceShip().getYCoor(), "explosion1.png");
			game.getExplosions().add(spaceShipexplosion);
			game.getBullets().remove(collidingBullet);
		}
		//Checking for colissions between player bullets and aliens
		for (Unit bullet : shipBullets) {
			Unit collidingUnit = checkCollisions(bullet, new ArrayList<Unit>(game.getAliens()));
			if (collidingUnit != null) {
				game.getExplosions().add(new Explosion(collidingUnit.getXCoor(),
						collidingUnit.getYCoor(), "explosion1.png"));
				game.getAliens().remove(collidingUnit);
				game.getBullets().remove(bullet);
				game.getPlayer().addScore(10);
				break;
			}
		}
		// Checking for colissions between bullets and barricades
		for (Barricade bar : game.getBarricades()) {
			Unit collidingUnit = checkCollisions(bar, new ArrayList<Unit>(game.getBullets()));
			if (collidingUnit != null) {
				game.getExplosions().add(new Explosion(collidingUnit.getXCoor(),
						collidingUnit.getYCoor(), "explosion1.png"));
				game.getBullets().remove(collidingUnit);
				bar.hit();
			}
		}
	}
	
	/**
	 * Checks collisions between an unit and a an ArrayList of other units.
	 * @param checkingUnit the unit to check colissions with
	 * @param unitList the list of units to check colission against.
	 * @return The unit the checkingUnit colides with, null if there are no colissions.
	 */
	public final Unit checkCollisions(final Unit checkingUnit, final ArrayList<Unit> unitList) {
		double checkX = checkingUnit.getXCoor();
		double checkY = checkingUnit.getYCoor();
		for (Unit unit : unitList) {
			double unitX = unit.getXCoor();
			double unitY = unit.getYCoor();
			if ((checkX - unitX >= -((unit.getWidth() / 2) + (checkingUnit.getWidth() / 2))  
				&& (checkX - unitX <= (unit.getWidth() / 2) + (checkingUnit.getWidth() / 2))) 
				&& (checkY - unitY >= -(((unit.getHeight()) / 2) + (checkingUnit.getHeight() / 2))) 
				&& (checkY - unitY <= (unit.getHeight() / 2)  + (checkingUnit.getHeight() / 2))) {
					return unit;
			}
		}
		return null;
	}

}
