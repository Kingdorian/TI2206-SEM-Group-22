package group22.space_invaders.unit;

/**
 * Test for the SpaceShip class which extends UnitTest
 * @author Bryan van Wijk
 *
 */
public class SpaceShipTest extends UnitTest {

	@Override
	public Unit createInstance(float X, float Y) {
		return new SpaceShip(X, Y);
	}

}
