package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.Player;

/**
 * Interface for Subclasses of the Unit class that can be activated on
 * a player, like a powerup.
 * @author Jochem
 *
 */
public interface ActivatableUnit {

	/**
	 * The activate method creates a new PowerUp object for a player.
	 * It should create a new subclass of PowerUp.
	 * @param newplayer The player the powerup has to be created for.
	 */
	void activate(Player newplayer);
	
}
