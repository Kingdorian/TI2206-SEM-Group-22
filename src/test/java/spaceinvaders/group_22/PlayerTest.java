package spaceinvaders.group_22;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import spaceinvaders.group_22.unit.SpaceShip;

public class PlayerTest {
	
	/**
	 * Test behavior of the getSpaceShip method for the player.
	 */
	@Test
	public void testGetSetSpaceShip() {
		SpaceShip ship = new SpaceShip(10.0f, 10.0f);
		Player player = new Player(new Game());
		player.setSpaceShip(ship);
		Assert.assertEquals(ship, player.getSpaceShip());
	}
	/**
	 * Test behaviour of the getScore method for the player class.
	 */
	@Test
	public void testGetScore () {
		Player player = new Player(new Game());
		Assert.assertEquals(0, player.getScore());
	}
	/**
	 * Tests the behaviour of the addpoints method for the player class for positive amounts of points.
	 */
	@Test
	public void testAddPositiveScore () {
		Player player = new Player(new Game());
		player.addScore(10);
		Assert.assertEquals(10, player.getScore());
	}
	/**
	 * Tests the behaviour of the addPoints method when adding a negative amount of points to the players score.
	 */
	@Test
	public void testAddNegativeScore () { 
		Player player = new Player(new Game());
		player.addScore(-10);
		Assert.assertEquals(-10, player.getScore());
	}
}