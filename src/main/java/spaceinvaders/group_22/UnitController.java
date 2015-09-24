package spaceinvaders.group_22;

import java.util.ArrayList;

import spaceinvaders.group_22.unit.Unit;

/**
 * Abstract class for controling units.
 * @author Dorian
 *
 */
public abstract class UnitController {
	/**
	 * The game this controller is part of;
	 */
	protected Game game;
	
	/**
	 * Creates a new UnitController.
	 * @param parentgame the game this unitcontroller is part of.
	 */
	public UnitController(Game parentgame) {
		game = parentgame;
		System.out.println(game);
	}
	
	public abstract void create();

}
