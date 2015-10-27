package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import spaceinvaders.group_22.ui.JavaFXThreadingRule;
/**
 * Test the movable units.
 * @author Dorian
 *
 */
@RunWith(Parameterized.class)
@SuppressWarnings("checkstyle:magicnumber") 
public class MovableUnitTest {
	
	/**
	 * Class specifying rule to test JavaFX from GitHub.
	 */
	@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
	/**
	 * Unit to test.
	 */
	private static Class<Unit> movableUnitClass;
	/**
	 * Movable unit class to test.
	 */
	private static MovableUnit movableUnit, movableUnit2;
	/**
	 * Create parameters.
	 * @return parameters
	 */
	@Parameters
	public static Collection<Class<Unit>> parameters() {
		Class<Unit>[] data = new Class[]{SpaceShip.class, ShipBullet.class, 
				AlienBullet.class, NormalAlien.class, LargeAlien.class, ShootAlien.class, HealthAlien.class};
		return Arrays.asList(data);
	}
	/**
	 * Test movable unit.
	 * @param cl object to test.
	 */
	public MovableUnitTest(final Class<Unit> cl) {
		movableUnitClass = cl;
	}
	/**
	 * Set up the test.
	 * @throws IllegalArgumentException Exception that could be thrown.
	 * @throws InvocationTargetException Exception that could be thrown.
	 * @throws NoSuchMethodException Exception that could be thrown.
	 * @throws SecurityException Exception that could be thrown.
	 * @throws InstantiationException Exception that could be thrown.
	 * @throws IllegalAccessException Exception that could be thrown.
	 */
	@Before
	public final void setUp() throws  IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
								SecurityException, InstantiationException, IllegalAccessException {
		Constructor<Unit> constructor = movableUnitClass.getConstructor(new Class[]{double.class, double.class});
		movableUnit = (MovableUnit) constructor.newInstance(new Object[] {1.2, 3.0});
		movableUnit2 = (MovableUnit) constructor.newInstance(new Object[] {1.2, 3.0});
	}

	/**
	 * Test the Velocity in the X direction.
	 */
	@Test
	public final void testUnintVelX() {
		assertEquals(0, movableUnit.getVelX(), 0.05);
	}
	
	/**
	 * Test the velocity in the Y direction.
	 */
	@Test
	public final void testUnintVelY() {
		assertEquals(0, movableUnit.getVelY(), 0.05);
	}
	/**
	 * Test the move method with velocity 0 in X and Y.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void testMoveUnitVelocity0() {
		movableUnit.move(60.0);
		Unit unit = (Unit) movableUnit;
		assertEquals(1.2, unit.getXCoor(), 0.05);
		assertEquals(3, unit.getYCoor(), 0.05);
	}
	
	/**
	 * Test the move method with velocity 1 in the X direction.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void testMoveUnit() {
		movableUnit.setVelX(1);
		movableUnit.move(1.0);
		Unit unit = (Unit) movableUnit;
		assertEquals(2.2, unit.getXCoor(), 0.05);
		assertEquals(3.0, unit.getYCoor(), 0.05);
	}
	/**
	 * Test the equals method with a different velX.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testEqualsVelX() {
		movableUnit2.setVelX(4);
		assertNotEquals(movableUnit, movableUnit2);
	}
	/**
	 * Test the equals method with a different velY.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testEqualsVelY() {
		movableUnit2.setVelY(4);
		assertNotEquals(movableUnit, movableUnit2);
	}
	
}
