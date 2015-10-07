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
	
	/**
	 * Test the creation of barricades.
	 */
	@Test
	public final void createBarricadeTest() {
		Unit outputBarricade = new Barricade(1, 1, "barrier.png");
		Unit actualBarricade = factory.createBarricade(1, 1);
		
		assertEquals(outputBarricade, actualBarricade);
	}
	
	/**
	 * Test the creation of explosions.
	 */
	@Test
	public final void createExplosionTest() {
		Unit outputExplosion = new Explosion(1, 1, "explosion1.png");
		Unit actualExplosion = factory.createExplosion(1, 1);
		
		assertEquals(outputExplosion, actualExplosion);
	}

}
