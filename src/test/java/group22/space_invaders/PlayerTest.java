package group22.space_invaders;

import static org.junit.Assert.*;
import group22.space_invaders.unit.SpaceShip;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {
	
	/**
	 * Test behavior of the getSpaceShip method for the player.
	 */
	public void testGetSetSpaceShip() {
		SpaceShip ship = new SpaceShip(10.0f, 10.0f);
		Player player = new Player(new Game());
		player.setSpaceShip(ship);
		Assert.assertEquals(ship, player.getSpaceShip());
	}
}