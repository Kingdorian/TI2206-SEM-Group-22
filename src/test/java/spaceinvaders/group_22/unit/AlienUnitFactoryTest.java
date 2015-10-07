package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Class responsible for executing AlienUnitFactory tests.
 * @author Jochem
 *
 */
public class AlienUnitFactoryTest extends AbstractUnitFactoryTest {

	@Override
	public final AbstractUnitFactory createInstance() {
		return new AlienUnitFactory();
	}
	

	@Override
	@Test
	public final void testBullet() {
		Unit outputBullet = new AlienBullet(1, 1, "alienbullet.png");
		Unit actualBullet = factory.createBullet(1, 1);
		
		assertEquals(outputBullet, actualBullet);	
	}
	
}
