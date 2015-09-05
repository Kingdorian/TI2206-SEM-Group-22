package spaceinvaders.group_22;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import spaceinvaders.group_22.unit.SpaceShip;

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