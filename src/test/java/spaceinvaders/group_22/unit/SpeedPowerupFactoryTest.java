package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class responsible for testing the SpeedPowerupFactory.
 * @author Jochem
 *
 */
public class SpeedPowerupFactoryTest extends AbstractPowerupFactoryTest {

	@Override
	public final AbstractPowerupFactory createInstance() {
		return new SpeedPowerupFactory();
	}

	@Override
	@Test
	public final void testCreate() {
		Unit outputUnit = new SpeedPowerUpUnit(1, 1);
		Unit actualUnit = factory.create(1, 1);
		
		assertEquals(outputUnit, actualUnit);		
	}

}
