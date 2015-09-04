package group22.space_invaders.unit;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the abstract unit class.
 * 
 * @author Bryan van Wijk
 *
 */
public abstract class UnitTest {
	
	private Unit unit;
	
	public abstract Unit createInstance(float X, float Y);
	
	/**
	 * Setup the unit.
	 */
	@Before
	public void setup() {
		unit = createInstance(1.2f, 3);
	}
	
	/**
	 * Test the X coordinate of the unit.
	 */
	@Test
	public void TestUnitXCoor(){
		assertTrue(unit.getXCoor() == 1.2);
	}
	
	/**
	 * Test the Y coordinate of the unit.
	 */
	@Test
	public void TestUnitYCoor(){
		assertTrue(unit.getYCoor() == 3);
	}
	
	/**
	 * Test the Velocity in the X direction
	 */
	@Test
	public void TestUnintVelX(){
		assertTrue(unit.getVelX() == 0);
	}
	
	/**
	 * Test the velocity in the Y direction.
	 */
	@Test
	public void TestUnintVelY(){
		assertTrue(unit.getVelY() == 0);
	}
	
	/**
	 * Test the move method with velocity 0 in X and Y.
	 */
	@Test
	public void TestMoveUnitVelocity0(){
		unit.moveUnit();
		assertTrue(unit.getXCoor() == 1);
		assertTrue(unit.getYCoor() == 3);
	}
	
	/**
	 * Test the move method with velocity 1 in the X direction.
	 */
	@Test
	public void TestMoveUnit(){
		unit.setVelX(1);
		unit.moveUnit();
		assertTrue(unit.getXCoor() == 2);
		assertTrue(unit.getYCoor() == 3);
	}
	

}
