package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.Player;

/**
 * Abstract powerup class extends the unit class.
 * @author Bryan
 */
public abstract class PowerUpUnit extends Unit implements MovableUnit, ActivatableUnit, Soundable {
	
	/**
	 * VelX is the velocity in the X direction in pixels per second.
	 */
	private double velX;
	
	/**
	 * velY is the velocity in the Y direction in pixels per second.
	 */
	private double velY;
	
	/**
	 * Indicates the velocity in the Y direction of this powerup type.
	 */
	static final double MAXVELY = 150.0;

	/**
	 * Creates a power Up.
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public PowerUpUnit(final double x, final double y) {
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
	 * Compares two objects and returns if they are equal.
	 * @return true if both objects are the same.
	 * @param obj the object to compare.
	 */
	@Override
	public final boolean equals(final Object obj) {
	      if (!super.equals(obj)) {
	         return false;
	      }
	      PowerUpUnit other = (PowerUpUnit) obj;
	      if (this.velX != other.velX) {
	    	 return false;
	      }
	      if (this.velY != other.velY) {
	    	 return false;
	      }	      
	      return true;
	}
	
	/**
	 * HashCode method.
	 * @return hashcode of this object
	 */
	public final int hashCode() {
		  return 0;
	}
	
	/**
	 * Activates the powerup for player.
	 * @param newplayer the player this powerup has effect on.
	 * 
	 */
	public abstract void activate(Player newplayer);
	
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
	 * Returns the velocity in the Y direction.
	 * @return The velocity in the Y direction.
	 */
	public static double getMaxVely() {
		return MAXVELY;
	}
	
}
