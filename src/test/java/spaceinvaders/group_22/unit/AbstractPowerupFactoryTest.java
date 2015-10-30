package spaceinvaders.group_22.unit;

import org.junit.Before;
import org.junit.Test;

import spaceinvaders.group_22.unit.AbstractPowerupFactory;

/**
 * Template for tests regarding AbstractPowerupFactory and its subclasses.
 * @author Jochem
 *
 */
public abstract class AbstractPowerupFactoryTest {

	/**
	 * The Factory we need to be testing.
	 */
	protected AbstractPowerupFactory factory;

	/**
	 * Method to create an instance of a subclass of the AbstractUnitFactory class.
	 * @return The Factory
	 */
	public abstract AbstractPowerupFactory createInstance();
	
	/**
	 * Setup the factory to be tested.
	 */
	@Before
	public final void setup() {
		factory = createInstance();
	}
	
	/**
	 * Test if the created factory returns the correct Powerup.
	 */
	@Test
	public abstract void testCreate();

}
