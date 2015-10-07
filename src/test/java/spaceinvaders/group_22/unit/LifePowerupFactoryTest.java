package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class responsible for testing the LifePowerupFactory.
 * @author Jochem
 *
 */
public class LifePowerupFactoryTest extends AbstractPowerupFactoryTest {

	@Override
	public final AbstractPowerupFactory createInstance() {
		return new LifePowerupFactory();
	}

	@Override
	@Test
	public final void testCreate() {
		Unit outputUnit = new LifePowerUpUnit(1, 1, "powerup_red.png");
		Unit actualUnit = factory.create(1, 1);
		
		assertEquals(outputUnit, actualUnit);		
	}

}
