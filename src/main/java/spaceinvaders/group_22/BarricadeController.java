package spaceinvaders.group_22;

import java.util.ArrayList;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.logger.Logger;
import spaceinvaders.group_22.unit.Barricade;
import spaceinvaders.group_22.unit.Collisions;
import spaceinvaders.group_22.unit.Explosion;
import spaceinvaders.group_22.unit.Unit;

/**
 * Class for creating and controlling barricades.
 * @author Dorian
 *
 */
public class BarricadeController extends UnitController {

	/**
	 * The game object.
	 */
	private Game game;
	
	/**
	 * ArrayList of all barricades in the Controller.
	 */
	private ArrayList<Barricade> barricades = new ArrayList<Barricade>();
	/**
	 * Creates a new barricadeController Object.
	 * @param parentGame the game where the barricades this controller controls is.
	 */
	public BarricadeController(final Game parentGame) {
		super(parentGame);
		game = getGame();
	}
	
	/**
	 * Creates the barricades for this Controller.
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	public final void create() {
		int barricadeCount = 4;
		// Offset from the bottom in pixels
		int bottomOfset = 110;
		int interval = (int) game.getCanvasWidth() / (barricadeCount + 1);
		barricades.clear();
		for (int i = 1; i <= barricadeCount; i++) {
			barricades.add(new Barricade(interval * i, game.getCanvasHeight() - bottomOfset));
		}
		Logger.getInstance().log("Created all barricades", LogEvent.Type.DEBUG);
	}
	/**
	 * Add a new barricade to this Controller.
	 * @param barricade to add.
	 */
	public final void addBarricade(final Barricade barricade) {
		barricades.add(barricade);
		Logger.getInstance().log("Created barricade", LogEvent.Type.TRACE);
	}
	/**
	 * Sets the barricades in this Controller.
	 * @param barricade the new barricades for this Controller.
	 */
	public final void setBarricades(final ArrayList<Barricade> barricade) { 
		barricades = barricade;
	}
	/**
	 * Returns the barricades in this Controller.
	 * @return the barricades in this Controller.
	 */
	public final  ArrayList<Barricade> getBarricades() {
		return barricades;
	}
	/**
	 * Remove dead barricades.
	 */
	public final void removeDead() {
		for (int i = 0; i < barricades.size(); i++)  {
			if (barricades.get(i).getHealth() == 0) {
				barricades.remove(i);
				Logger.getInstance().log("Removed barricade", LogEvent.Type.TRACE);
				i--;
			}
		}
	}
	/**
	 * Method to call every tick for the barricades.
	 */
	public final void tick() {
		removeDead();
		barricadeCollisions();
	}
	/**
	 * Method to check the collisions on barricades.
	 */
	public final void barricadeCollisions() {
		// Checking for colissions between bullets and barricades
		for (Barricade bar : barricades) {
			Unit collidingUnit = new Collisions().checkCollisions(bar, new ArrayList<Unit>(game.getBullets()));
			if (collidingUnit != null) {
				String logMessage = "Barricade collided bullet at X:" + bar.getXCoor() + " Y: " + bar.getYCoor();
				Logger.getInstance().log(logMessage, LogEvent.Type.TRACE);
						
				game.getExplosions().add(new Explosion(collidingUnit.getXCoor(), collidingUnit.getYCoor()));
				game.getBullets().remove(collidingUnit);
				bar.hit(collidingUnit);
			}
		}
	}
}
