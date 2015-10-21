package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import spaceinvaders.group_22.ui.JavaFXThreadingRule;
import spaceinvaders.group_22.Observer;
import spaceinvaders.group_22.Player;

/**
 * Test the abstract unit class.
 * 
 * @author Bryan van Wijk
 *
 */
@SuppressWarnings("checkstyle:magicnumber")   
public abstract class UnitTest {
	
	/**
	 * Class specifying rule to test JavaFX from GitHub.
	 */
	@Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
	
	/**
	 * The Unit we need to be testing.
	 */
	private Unit unit;
	
	/**
	 * The Unit we need to be testing.
	 */
	private Observer mockedObserver = Mockito.mock(Observer.class);
	
	/**
	 * Method to create an instance of a subclass of the Unit class.
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @return The Unit
	 */
	public abstract Unit createInstance(double x, double y);
	
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
		unit = createInstance(1.2, 3);
		//game.setTickrate(1.0);
	}
	
	/**
	 * Test the X coordinate of the unit.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void testUnitXCoor() {
		assertEquals(1.2, unit.getXCoor(), 0.05);
	}
	
	/**
	 * Test the Y coordinate of the unit.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")    
	public final void testUnitYCoor() {
		assertEquals(3, unit.getYCoor(), 0.05);
	}
	
	/**
	 * Test the Equals method.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testEquals() {
		Unit unit2 = createInstance(1.2, 3);
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

	/**
	 * Test the equals method with a shipbullet.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testEqualsShipBullet() {
		Bullet bullet = new ShipBullet(1.2, 3);

		bullet.setHeight(5);
		assertNotEquals(unit, bullet);
	}
	/**
	 * Test the equals method with a alienbullet.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testEqualsAlienBullet() {
		Bullet bullet = new AlienBullet(1.2, 3);
		bullet.setHeight(5);
		assertNotEquals(unit, bullet);
	}
	/**
	 * Test the equals method with a different X Coordinate.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testEqualsXcoordinate() {
		Unit unit2 = createInstance(1.3, 3);
		assertNotEquals(unit, unit2);
	}
	/**
	 * Test the equals method with a different Y Coordinate.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testEqualsYcoordinate() {
		Unit unit2 = createInstance(1.2, 4);
		assertNotEquals(unit, unit2);
	}
	/**
	 * Test the equals method with a different width.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testEqualsWidth() {
		Unit unit2 = createInstance(1.2, 3);
		unit2.setWidth(12);
		assertNotEquals(unit, unit2);
	}
	/**
	 * Test the equals method with a different height.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testEqualsHeight() {
		Unit unit2 = createInstance(1.2, 3);
		unit2.setHeight(12);
		assertNotEquals(unit, unit2);
	}
	
	/**
	 * Test registering an Observer.
	 */
	@Test
	public final void testRegisterObserver() {
		List<Observer> observers = unit.getObservers();
		unit.registerObserver(mockedObserver);
		
		assertTrue(observers.contains(mockedObserver));
	}
	
	/**
	 * Test removing an Observer.
	 */
	@Test
	public final void testRemoveObserver() {
		List<Observer> observers = unit.getObservers();
		unit.registerObserver(mockedObserver);
		
		unit.removeObserver(mockedObserver);
		assertTrue(!observers.contains(mockedObserver));
	}
	
	/**
	 * Test removing an Observer which is not registred.
	 */
	@Test
	public final void testRemoveObserverNotRegistered() {
		List<Observer> observers = unit.getObservers();
		
		unit.removeObserver(mockedObserver);
		assertTrue(observers.equals(unit.getObservers()));
	}
	
	/**
	 * Test notifying an observer.
	 */
	@Test
	public final void testNotifyObservers() {
		unit.registerObserver(mockedObserver);
		unit.notifyObservers();
		
		Mockito.verify(mockedObserver).update(unit);
		
	}

}
