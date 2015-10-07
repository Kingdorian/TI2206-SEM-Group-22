package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Template for tests regarding AbstractUnitFactory and its subclasses.
 * @author Jochem
 *
 */
public abstract class AbstractUnitFactoryTest {

	/**
	 * The Unit we need to be testing.
	 */
	protected AbstractUnitFactory factory;
	
	/**
	 * Method to create an instance of a subclass of the AbstractUnitFactory class.
	 * @return The Factory
	 */
	public abstract AbstractUnitFactory createInstance();
	
	/**
	 * Setup the factory to be tested.
	 */
	@Before
	public final void setup() {
		factory = createInstance();
	}
	
	/**
	 * Test if the created unit returns the correct bullet.
	 */
	@Test
	public abstract void testBullet();

}
