package group22.space_invaders.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public abstract class UnitTest {
	
	private Unit unit;
	
	public abstract Unit createInstance(float X, float Y);
	
	/**
	 * Setup the unit.
	 */
	@Before
	public void setup() {
		unit = createInstance(1, 3);
	}
	
	@Test
	public void TestUnitXCoor(){
		assertTrue(unit.getXCoor() == 1);
	}
	
	@Test
	public void TestUnitYCoor(){
		assertTrue(unit.getYCoor() == 3);
	}
	
	@Test
	public void TestUnintVelX(){
		assertTrue(unit.getVelX() == 0);
	}
	
	@Test
	public void TestUnintVelY(){
		assertTrue(unit.getVelY() == 0);
	}
	
	@Test
	public void TestMoveUnitVelocity0(){
		unit.moveUnit();
		assertTrue(unit.getXCoor() == 1);
		assertTrue(unit.getYCoor() == 3);
	}
	
	@Test
	public void TestMoveUnit(){
		unit.setVelX(1);
		unit.moveUnit();
		assertTrue(unit.getXCoor() == 2);
		assertTrue(unit.getYCoor() == 3);
	}
	

}
