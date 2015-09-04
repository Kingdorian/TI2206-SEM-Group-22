package group22.space_invaders.unit;

public class SpaceShipTest extends UnitTest {

	@Override
	public Unit createInstance(float X, float Y) {
		return new SpaceShip(X, Y);
	}

}
