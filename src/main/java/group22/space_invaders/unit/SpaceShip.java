package group22.space_invaders.unit;

/**
 * A SpaceShip in the game extends Unit.
 * 
 * @author Bryan van Wijk
 */

public class SpaceShip extends Unit {

	public SpaceShip(double X, double Y) {
		super(X, Y);
	}
	
	/**
	 * Creates a bullet object on the place of the Ship and shoots it upwards.
	 * @param velocity The speed of the Bullet
	 */
	public Bullet shootBullet(int velocity){
		Bullet bullet = new ShipBullet(this.getXCoor(), this.getYCoor());
		bullet.setVelY(velocity);
		return bullet;
	}

}
