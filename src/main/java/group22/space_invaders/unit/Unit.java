package group22.space_invaders.unit;

/**
 * A unit in the game that has a position and velocity.
 * 
 * @author Bryan van Wijk
 */

public abstract class Unit {
	
	/**
	 * The X Coordinate of this unit.
	 */
	private double xCoor;
	
	/**
	 * The Y Coordinate of this unit.
	 */
	private double yCoor;
	
	/**
	 * VelX is the velocity in the X direction.
	 */
	private int velX;
	
	/**
	 * velY is the velocity in the Y direction.
	 */
	private int velY;
	
	/**
	 * Creates a unit at Location X, Y with velocity 0 and direction north.
	 * @param x Coordinate of this unit.
	 * @param y Coordinate of this unit.
	 */
	public Unit(final double x, final double y) {
		this.setXCoor(x);
		this.setYCoor(y);
		this.setVelX(0);
		this.setVelY(0);
	}
	
	/**
	 * Move the unit in the direction of this unit and with his velocity.
	 */
	public final void moveUnit() {
		setXCoor(this.getXCoor() + this.getVelX());
		setYCoor(this.getYCoor() + this.getVelY());
	}
	
	/**
	 * Returns the current velocity in the X direction.
	 * @return the current velocity in the X direction.
	 */
	public final int getVelX() {
		return velX;
	}
	
	/**
	 * Sets the current velocity in the X direction.
	 * @param newVelX the velocity in the X direction to set.
	 */
	public final void setVelX(final int newVelX) {
		this.velX = newVelX;
	}

	/**
	 * Returns the current Y coordinate of this unit.
	 * @return the current Y coordinate of this unit.
	 */
	public final double getYCoor() {
		return yCoor;
	}
	
	/**
	 * Returns the current X coordinate of this unit.
	 * @return the current Y coordinate of this unit.
	 */
	public final double getXCoor() {
		return xCoor;
	}
	
	/**
	 * Sets the current X coordinate of this unit.
	 * @param x the current X coordinate of this unit to set.
	 */
	private void setXCoor(final double x) {
		xCoor = x;
	}
	
	/**
	 * Sets the current Y coordinate of this unit.
	 * @param y the current Y coordinate of this unit to set.
	 */
	private void setYCoor(final double y) {
		this.yCoor = y;
	}
	
	/**
	 * Returns the current velocity in the Y direction.
	 * @return the current velocity in the Y direction.
	 */
	public final int getVelY() {
		return velY;
	}
	
	/**
	 * Sets the current velocity in the Y direction.
	 * @param newVelY the velocity in the Y direction to set.
	 */
	public final void setVelY(final int newVelY) {
		this.velY = newVelY;
	}

}
