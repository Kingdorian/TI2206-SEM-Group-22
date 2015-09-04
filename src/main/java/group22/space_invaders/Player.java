package group22.space_invaders;
import group22.space_invaders.unit.SpaceShip;
/**
 * Class for the player
 * @author dorian
 *
 */
public class Player {

	/**
	 * Spaceship the player is currently controling
	 */
	private SpaceShip ship;
	
	/**
	 * Creates new spaceship object.
	 * @param game the game where the object is part of.
	 */
	public Player(Game game) {
		ship = new SpaceShip(10.0f, 10.0f);
	}
	
	/**
	 * Returns the spaceship.
	 * @return the spaceship object this player is controlling.
	 */
	public final SpaceShip getSpaceShip() {
		return ship;
	}
	/**
	 * Sets a new spaceship this player controls.
	 * @param the new spaceship.
	 */
	public final void SetSpaceShip(SpaceShip newShip) {
		ship = newShip;
	}
	
	
}