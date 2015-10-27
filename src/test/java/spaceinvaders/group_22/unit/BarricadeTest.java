package spaceinvaders.group_22.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

/**
 * Test for barricades, extends Unit Test.
 * @author Bryan
 *
 */
public class BarricadeTest extends UnitTest {
	
	@Override
	public final Unit createInstance(final double x, final double y) {
		return new Barricade(x, y);
	}
	
	/**
	 * Test the equals method with a different velY.
	 */
	@Test
	@SuppressWarnings("checkstyle:magicnumber")   
	public final void testEqualsHealth() {
		Barricade bar1 = new Barricade(1.2, 3);
		Barricade bar2 = new Barricade(1.2, 3);
		bar2.hit(new AlienBullet(1, 2));
		assertNotEquals(bar1, bar2);
	}
	
	/**
	 * Tests the crumble method.
	 */
	@Test
	public final void testCrumble() {
		Barricade bar = new Barricade(0, 0);
		bar.crumble(20, 5);
		int damagedParts = 0;
		for(boolean[] row : bar.getDamage()) {
			for(int i = 0; i < row.length; i++) {
				if(!row[i]){ 
					damagedParts++;
				}
			}
		}
		assertEquals(5, damagedParts);
	}
}
