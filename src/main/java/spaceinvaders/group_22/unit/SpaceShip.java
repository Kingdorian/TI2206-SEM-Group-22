package spaceinvaders.group_22.unit;

/**
 * A SpaceShip in the game extends Unit.
 * 
 * @author Bryan van Wijk
 */

public class SpaceShip extends Unit {
	
	/**
	 * Creates a SpaceShip.
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 */
	public SpaceShip(double x, double y) {
		super(x, y);
	}
	
	/**
	 * Creates a bullet object on the place of the Ship and shoots it upwards.
	 * @param velocity The speed of the Bullet
	 * @return The shot Bullet
	 */
	public final Bullet shootBullet(final int velocity) {
		Bullet bullet = new ShipBullet(this.getXCoor(), this.getYCoor());
		bullet.setVelY(velocity);
		return bullet;

	}
	
	public boolean equals(SpaceShip that) {
		if (that == null ) {
			return false;
		} else if(!(that instanceof SpaceShip)) {
			return false;
		}
		return super.equals(that);
	}

}
