package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test for explosion class extends unitTest.
 * @author Bryan
 *
 */
public class ExplosionTest extends UnitTest {

	@Override
	public final Unit createInstance(final double x, final double y) { 
		return new Explosion(x, y); 
	}
	
	/**
	 * Tests the counter of the explosion.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")  
	public final void counterTest() {
		Explosion explosion = new Explosion(5, 6.2);
		assertEquals(explosion.getCounter(), 0);
	}
	
	/**
	 * Tests the increase counter method of the explosion.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")  
	public final void increaseCounterTest() {
		Explosion explosion = new Explosion(5, 6.2);
		explosion.increaseCounter();
		assertEquals(explosion.getCounter(), 1);
	}

}
