package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import spaceinvaders.group_22.unit.AbstractPowerupFactory;
import spaceinvaders.group_22.unit.ShootPowerUpUnit;
import spaceinvaders.group_22.unit.ShootPowerupFactory;
import spaceinvaders.group_22.unit.Unit;

/**
 * Test class responsible for testing the ShootPowerupFactory.
 * @author Jochem
 *
 */
public class ShootPowerupFactoryTest extends AbstractPowerupFactoryTest {

	@Override
	public final AbstractPowerupFactory createInstance() {
		return new ShootPowerupFactory();
	}

	@Override
	@Test
	public final void testCreate() {
		Unit outputUnit = new ShootPowerUpUnit(1, 1);
		Unit actualUnit = factory.create(1, 1);
		
		assertEquals(outputUnit, actualUnit);		
	}

}
