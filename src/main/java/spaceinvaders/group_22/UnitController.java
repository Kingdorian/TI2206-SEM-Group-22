package spaceinvaders.group_22;

/**
 * Abstract class for controling units.
 * @author Dorian
 *
 */
public abstract class UnitController {
	/**
	 * The game this controller is part of.
	 */
	protected Game game;
	
	/**
	 * Creates a new UnitController.
	 * @param parentgame the game this unitcontroller is part of.
	 */
	public UnitController(Game parentgame) {
		game = parentgame;
	}
	/**
	 * Creates the units this controller controls.
	 */
	public abstract void create();

}
