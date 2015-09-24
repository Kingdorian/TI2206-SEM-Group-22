package spaceinvaders.group_22;

import java.util.ArrayList;

import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.Barricade;

/**
 * Class for creating and controlling barricades.
 * @author Dorian
 *
 */
public class BarricadeController extends UnitController {
	/**
	 * Game that this controller is part of.
	 */
	private Game game;
	/**
	 * ArrayList of all barricades in the Controller.
	 */
	private ArrayList<Barricade> barricades;
	/**
	 * Creates a new barricadeController Object.
	 * @param parentGame the game where the barricades this controller controls is.
	 */
	public BarricadeController (Game parentGame) {
		this.game = parentGame;
	}
	
	/**
	 * Creates the barricades for this Controller.
	 */
	@SuppressWarnings("checkstyle:MagicNumber")
	public final void create() {
		int barricadeCount = 4;
		// Offset from the bottom in pixels
		int bottomOfset = 110;
		int interval = (int) game.getCanvasWidth() / (barricadeCount + 1);
		barricades.clear();
		for (int i = 1; i <= barricadeCount; i++) {
			barricades.add(new Barricade(interval * i, game.getCanvasHeight() - 110, "barrier.png"));
		}
		game.getLogger().log("Created all barricades", LogEvent.Type.DEBUG);
	}
	/**
	 * Add a new barricade to this Controller.
	 * @param barricade to add.
	 */
	public final void addBarricade(final Barricade barricade) {
		barricades.add(barricade);
		game.getLogger().log("Created barricade", LogEvent.Type.TRACE);
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
}
