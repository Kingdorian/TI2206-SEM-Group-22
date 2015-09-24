package spaceinvaders.group_22.unit;

/**
 * A SpaceShip in the game extends Unit.
 * 
 * @author Bryan van Wijk
 */

public class SpaceShip extends Unit implements MovableUnit{
	/**
	 * VelX is the velocity in the X direction in pixels per second.
	 */
	double velX = 0.0;
	
	/**
	 * velY is the velocity in the Y direction in pixels per second.
	 */
	double velY = 0.0;
	
	/**
	 * Indicates the max speed at which a spaceship can travel.
	 */
	public static final int MAXVELX = 250; 
	/**
	 * Creates a SpaceShip.
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @param spriteFile filename of the sprite of this unit.
	 */
	public SpaceShip(final double x, final double y, final String spriteFile) {
		super(x, y, spriteFile);
	}
	
	/**
	 * Creates a bullet object on the place of the Ship and shoots it upwards.
	 * @param spaceShipBulletVelX The speed of the Bullet
	 * @return The shot Bullet
	 */
	public final Bullet shootBullet(final double spaceShipBulletVelX) {
		Bullet bullet = new ShipBullet(this.getXCoor(), this.getYCoor(), "spaceshipbullet.png");
		bullet.setVelY(spaceShipBulletVelX);
		return bullet;

	}	
	/**
	 * Compares two objects and returns if they are equal.
	 * @return true if both objects are the same.
	 * @param other the object to compare.
	 */
	@Override
	public final boolean equals(final Object other) {
		if (other != null && other instanceof SpaceShip) {
			SpaceShip that = (SpaceShip) other;
			return super.equals(other)
					&& this.getVelX() == that.getVelX()
					&& this.getVelY() == that.getVelY();
		}
		return false;
	}
	/**
	 * HashCode method.
	 * @return hashcode of this object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(velX);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(velY);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	/**
	 * Move the unit in the direction of this unit and with his velocity.
	 * @param tickrate The rate at which the game ticks.
	 */
	public void move(double tickrate) {
		setXCoor(this.getXCoor() + (this.getVelX() * tickrate));
		setYCoor(this.getYCoor() + (this.getVelY() * tickrate));
	}	
	/**
	 * Returns the current velocity in the X direction.
	 * @return the current velocity in the X direction in pixels per second.
	 */
	public final double getVelX() {
		return velX;
	}
	
	/**
	 * Sets the current velocity in the X direction.
	 * @param newvelX the velocity in the X direction to set in pixels per second.
	 */
	public final void setVelX(final double newvelX) {
		this.velX = newvelX;
	}
	
	/**
	 * Returns the current velocity in the Y direction.
	 * @return the current velocity in the Y direction in pixels per second.
	 */
	public final double getVelY() {
		return velY;
	}
	
	/**
	 * Sets the current velocity in the Y direction.
	 * @param alienVelY the velocity in the Y direction to set in pixels per second.
	 */
	public final void setVelY(final double alienVelY) {
		this.velY = alienVelY;
	}
}
