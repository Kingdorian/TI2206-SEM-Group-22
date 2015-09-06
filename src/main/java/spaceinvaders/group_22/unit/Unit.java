package spaceinvaders.group_22.unit;

/**
 * A unit in the game that has a position and velocity.
 * 
 * @author Bryan van Wijk
 */

public abstract class Unit {
	
	/**
	 * The X Coordinate of this unit
	 */
	private double XCoor;
	
	/**
	 * The Y Coordinate of this unit
	 */
	private double YCoor;
	
	/**
	 * VelX is the velocity in the X direction
	 */
	private int velX;
	
	/**
	 * velY is the velocity in the Y direction
	 */
	private int velY;
	
	/**
	 * height of this unit.
	 */
	private int height;
	
	/**
	 * width of this unit.
	 */
	private int widht;
	
	/**
	 * Creates a unit at Location X, Y with velocity 0 and direction north.
	 * @param X Coordinate of this unit.
	 * @param Y Coordinate of this unit.
	 */
	public Unit(double X, double Y){
		this.setXCoor(X);
		this.setYCoor(Y);
		this.setVelX(0);
		this.setVelY(0);
		this.setHeight(0);
		this.setWidht(0);
	}
	/**
	 * Compares two objects and returns if they are equal.
	 * @param that the object to compare this object to
	 * @return true if both objects are thesame.
	 */
	public boolean equals(Object other) {
		if (other != null && other instanceof Unit){
			Unit that = (Unit) other;
			return this.XCoor == that.getXCoor()
						&& this.getYCoor() == that.YCoor
						&& this.velX == that.getVelX()
						&& this.velY == that.getVelY()
						&& this.getHeight() == that.getHeight()
						&& this.getWidht() == that.getWidht();
		}
		return false;
	}
	/**
	 * Move the unit in the direction of this unit and with his velocity.
	 */
	public void moveUnit(){
		setXCoor(this.getXCoor() + this.getVelX());
		setYCoor(this.getYCoor() + this.getVelY());
	}
	
	/**
	 * Returns the current velocity in the X direction.
	 * @return the current velocity in the X direction.
	 */
	public int getVelX() {
		return velX;
	}
	
	/**
	 * Sets the current velocity in the X direction.
	 * @param velX the velocity in the X direction to set.
	 */
	public void setVelX(int velX) {
		this.velX = velX;
	}

	/**
	 * Returns the current Y coordinate of this unit.
	 * @return the current Y coordinate of this unit.
	 */
	public double getYCoor() {
		return YCoor;
	}
	
	/**
	 * Returns the current X coordinate of this unit.
	 * @return the current Y coordinate of this unit.
	 */
	public double getXCoor() {
		return XCoor;
	}
	
	/**
	 * Sets the current X coordinate of this unit
	 * @param xCoor the current X coordinate of this unit to set.
	 */
	private void setXCoor(double xCoor) {
		XCoor = xCoor;
	}
	
	/**
	 * Sets the current Y coordinate of this unit
	 * @param yCoor the current Y coordinate of this unit to set.
	 */
	private void setYCoor(double yCoor) {
		YCoor = yCoor;
	}
	
	/**
	 * Returns the current velocity in the Y direction.
	 * @return the current velocity in the Y direction.
	 */
	public int getVelY() {
		return velY;
	}
	
	/**
	 * Sets the current velocity in the Y direction.
	 * @param velY the velocity in the Y direction to set.
	 */
	public void setVelY(int velY) {
		this.velY = velY;
	}
	/**
	 * Get the width of this unit.
	 * @return the width of this unit.
	 */
	public int getWidht() {
		return widht;
	}
	/**
	 * Sets the width of this unit.
	 * @param widht to set as width.
	 */
	public void setWidht(int widht) {
		this.widht = widht;
	}
	/**
	 * Get the height of this unit.
	 * @return the height of this unit.
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * Sets the height of this unit.
	 * @param height the height to set.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

}
