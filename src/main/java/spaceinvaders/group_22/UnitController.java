package spaceinvaders.group_22;

import spaceinvaders.group_22.unit.AlienUnitFactory;
import spaceinvaders.group_22.unit.SpaceShipUnitFactory;

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
	 * A factory responsible for creating aliens.
	 */
	private AlienUnitFactory alienfactory;
	
	/**
	 * A factory responsible for creating aliens.
	 */
	private SpaceShipUnitFactory spaceshipfactory;
	
	/**
	 * Creates a new UnitController.
	 * @param parentgame the game this unitcontroller is part of.
	 */
	public UnitController(final Game parentgame) {
		game = parentgame;
		alienfactory = new AlienUnitFactory();
		spaceshipfactory = new SpaceShipUnitFactory();

		System.out.println(game);
	}
	/**
	 * Creates the units this controller controls.
	 */
	public abstract void create();
	
	/**
	 * @return the spaceshipfactory
	 */
	public final SpaceShipUnitFactory getSpaceshipfactory() {
		return spaceshipfactory;
	}
	
	/**
	 * @return the spaceshipfactory
	 */
	public final AlienUnitFactory getAlienfactory() {
		return alienfactory;
	}

}
