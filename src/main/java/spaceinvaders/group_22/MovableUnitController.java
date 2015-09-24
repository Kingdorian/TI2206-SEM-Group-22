package spaceinvaders.group_22;

import java.util.ArrayList;

import spaceinvaders.group_22.unit.Unit;

/**
 * Class for controlling movable units.
 * @author Dorian
 *
 */
public interface MovableUnitController {
	/**
	 * Moves all units the unitcontroller controls according to their velocity.
	 */
	public void move();
}
