package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import spaceinvaders.group_22.unit.Unit;

/**
 * Test the abstract unit class.
 * 
 * @author Bryan van Wijk
 *
 */
public abstract class UnitTest {
	
	/**
	 * The Unit we need to be testing.
	 */
	private Unit unit;
	
	/**
	 * 
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @return The Unit
	 */
	public abstract Unit createInstance(double x, double y);
	
	/**
	 * Setup the unit.
	 */
	@Before
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void setup() {
		unit = createInstance(1.2, 3);
	}
	
	/**
	 * Test the X coordinate of the unit.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void testUnitXCoor() {
		assertTrue(unit.getXCoor() == 1.2);
	}
	
	/**
	 * Test the Y coordinate of the unit.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void testUnitYCoor() {
		assertTrue(unit.getYCoor() == 3);
	}
	
	/**
	 * Test the Velocity in the X direction.
	 */
	@Test
	public final void testUnintVelX() {
		assertTrue(unit.getVelX() == 0);
	}
	
	/**
	 * Test the velocity in the Y direction.
	 */
	@Test
	public final void testUnintVelY() {
		assertTrue(unit.getVelY() == 0);
	}
	
	/**
	 * Test the move method with velocity 0 in X and Y.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void testMoveUnitVelocity0() {
		unit.moveUnit();
		assertTrue(unit.getXCoor() == 1.2);
		assertTrue(unit.getYCoor() == 3);
	}
	
	/**
	 * Test the move method with velocity 1 in the X direction.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void testMoveUnit() {
		unit.setVelX(1);
		unit.moveUnit();
		assertTrue(unit.getXCoor() == 2.2);
		assertTrue(unit.getYCoor() == 3);
	}
	

}
