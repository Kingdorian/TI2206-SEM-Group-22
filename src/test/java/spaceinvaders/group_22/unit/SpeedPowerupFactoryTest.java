package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import spaceinvaders.group_22.unit.AbstractPowerupFactory;
import spaceinvaders.group_22.unit.SpeedPowerUpUnit;
import spaceinvaders.group_22.unit.SpeedPowerupFactory;
import spaceinvaders.group_22.unit.Unit;

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
