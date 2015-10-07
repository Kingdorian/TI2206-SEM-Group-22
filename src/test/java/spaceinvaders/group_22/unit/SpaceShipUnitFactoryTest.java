package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class responsible for executing SpaceShipUnitFactory tests.
 * @author Jochem
 *
 */
public class SpaceShipUnitFactoryTest extends AbstractUnitFactoryTest {

	@Override
	public final AbstractUnitFactory createInstance() {
		return new SpaceShipUnitFactory();
	}
	

	@Override
	@Test
	public final void testBullet() {
		Unit outputBullet = new ShipBullet(1, 1, "alienbullet.png");
		Unit actualBullet = factory.createBullet(1, 1);
		
		assertEquals(outputBullet, actualBullet);	
	}

}
