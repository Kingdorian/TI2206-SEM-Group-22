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
	
	public Player(Game game) {
		ship = new SpaceShip(10.0f, 10.0f);
	}
}