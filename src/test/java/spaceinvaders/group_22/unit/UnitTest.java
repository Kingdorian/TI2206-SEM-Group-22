package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import spaceinvaders.group_22.Game;

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
	 * Method to create an instance of a subclass of the Unit class.
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @param spriteFile The filename of the sprite.
	 * @return The Unit
	 */
	public abstract Unit createInstance(double x, double y, String spriteFile);
	
    /**
     * thrown is the exception which is expected to be thrown during a test.
     */
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * Setup the unit.
	 */
	@Before
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void setup() {
		// testImage is a 1x1 png image. 
		unit = createInstance(1.2, 3, "testimage.png");
		Game.setTickrate(1);
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
	 * Test the unit width.
	 */
	@Test
	public final void testUnitWidth() {
		assertTrue(unit.getWidth() == 1);
	}
	
	/**
	 * Test the unit height.
	 */
	@Test
	public final void testUnitHeight() {
		assertTrue(unit.getHeight() == 1);
	}
	
	/**
	 * Test the unit height.
	 */
	@Test
	public final void testUnitSprite() {
		assertTrue(unit.getSprite() == "testimage.png");
	}
	
	/**
	 * Test creating an object with an invalid sprite().
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void testInvalidUnitSprite() {
		thrown.expect(IllegalArgumentException.class);
		createInstance(1.2, 3, "png.png");
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
	
	/**
	 * Test the Equals method.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testEquals() {
		Unit unit2 = createInstance(1.2, 3, "testimage.png");
		assertEquals(unit, unit2);
	}
	
	/**
	 * Test the Equals method.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testEqualsFalse() {
		assertNotEquals(unit, null);
	}
	

}
