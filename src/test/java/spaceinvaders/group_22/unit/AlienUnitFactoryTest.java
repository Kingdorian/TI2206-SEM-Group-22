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
	
	/**
	 * Test the creation of speed powerup units.
	 */
	@Test
	public final void testSpeedPowerUpUnit() {
		Unit outputSpeedPowerUpUnit = new SpeedPowerUpUnit(1, 1, "powerup_blue.png");
		Unit actualSpeedPowerUpUnit = ((AlienUnitFactory) factory).createSpeedPowerup(1, 1);
		
		assertEquals(outputSpeedPowerUpUnit, actualSpeedPowerUpUnit);	
	}
	
	/**
	 * Test the creation of shoot powerup units.
	 */
	@Test
	public final void testShootPowerUpUnit() {
		Unit outputShootPowerUpUnit = new ShootPowerUpUnit(1, 1, "powerup_orange.png");
		Unit actualShootPowerUpUnit = ((AlienUnitFactory) factory).createShootPowerup(1, 1);
		
		assertEquals(outputShootPowerUpUnit, actualShootPowerUpUnit);	
	}
	
	/**
	 * Test the creation of life powerup units.
	 */
	@Test
	public final void testLifePowerUpUnit() {
		Unit outputLifePowerUpUnit = new LifePowerUpUnit(1, 1, "powerup_red.png");
		Unit actualLifePowerUpUnit = ((AlienUnitFactory) factory).createLifePowerup(1, 1);
		
		assertEquals(outputLifePowerUpUnit, actualLifePowerUpUnit);	
	}
	
}
