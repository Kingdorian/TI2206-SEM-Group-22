package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
		Unit outputUnit = new ShootPowerUpUnit(1, 1, "powerup_orange.png");
		Unit actualUnit = factory.create(1, 1);
		
		assertEquals(outputUnit, actualUnit);		
	}

}
