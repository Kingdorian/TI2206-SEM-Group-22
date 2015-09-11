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
	public final Unit createInstance(final double x, final double y, final String spriteFile) { return new Explosion(x, y, spriteFile); }
	
	/**
	 * Tests the counter of the explosion.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")  
	public final void counterTest() {
		Explosion explosion = new Explosion(5, 6.2, "testimage.png");
		assertEquals(explosion.getCounter(), 0);
	}
	
	/**
	 * Tests the increase counter method of the explosion.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")  
	public final void increaseCounterTest() {
		Explosion explosion = new Explosion(5, 6.2, "testimage.png");
		explosion.increaseCounter();
		assertEquals(explosion.getCounter(), 1);
	}

}
