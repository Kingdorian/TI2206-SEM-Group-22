package spaceinvaders.group_22.unit;

/**
 * A bullet in the game, extends Unit.
 * @author Ege de Bruin
 */

public abstract class Bullet extends Unit implements MovableUnit {

	/**
	 * VelX is the velocity in the X direction in pixels per second.
	 */
	private double velX;
	
	/**
	 * velY is the velocity in the Y direction in pixels per second.
	 */
	private double velY;
	
	/**
	 * Creates a Bullet.
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 */
	@SuppressWarnings("checkstyle:magicnumber")    
	public Bullet(final double x, final double y) {
		super(x, y);
	}
	/**
	 * Move the unit in the direction of this unit and with his velocity.
	 * @param tickrate The rate at which the game ticks.
	 */
	public final void move(final double tickrate) {
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
	/**
	 * HashCode method.
	 * @return hashcode of this object
	 */
	@SuppressWarnings("checkstyle:magicnumber")
	@Override
	public final int hashCode() {
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
	 * Compares two objects and returns if they are equal.
	 * @return true if both objects are the same.
	 * @param other the object to compare.
	 */
	@SuppressWarnings("checkstyle:designforextension")
	@Override
	public boolean equals(final Object other) {
		if (other != null && other instanceof Bullet) {
			Bullet that = (Bullet) other;
			return 	super.equals(that)
					&& this.getVelX() == that.getVelX()
					&& this.getVelY() == that.getVelY();
		}
		return false;
	}	
}
