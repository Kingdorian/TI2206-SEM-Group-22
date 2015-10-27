package spaceinvaders.group_22.game.controller;

import spaceinvaders.group_22.game.Game;

/**
 * Abstract class for controling units.
 * @author Dorian
 *
 */
public abstract class UnitController {
	/**
	 * The game this controller is part of.
	 */
	private Game game;
	
	/**
	 * Creates a new UnitController.
	 * @param parentgame the game this unitcontroller is part of.
	 */
	public UnitController(final Game parentgame) {
		game = parentgame;
	}
	/**
	 * Creates the units this controller controls.
	 */
	public abstract void create();
	
	/**
	 * Getter method for the game.
	 * @return the Game object.
	 */
	public final Game getGame() {
		return game;
	}

}
