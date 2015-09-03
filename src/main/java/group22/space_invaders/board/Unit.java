package group22.space_invaders.board;

/**
 * A unit in the game that has a position.
 * 
 * @author Bryan van Wijk
 */

public abstract class Unit {
	
	/**
	 * The X Coordinate of this unit
	 */
	private float XCoor;
	
	/**
	 * The Y Coordinate of this unit
	 */
	private float YCoor;
	
	/**
	 * The velocity of this unit.
	 */
	private int velocity;
	
	/**
	 * deltaX (width difference) to an element in the direction
	 * in a matrix with 0,0 (x,y) as its top-left element.
	 */
	private int deltaX;
	
	/**
	 * deltaY (height difference) to an element in the direction
	 *  in a matrix with 0,0 (x,y) as its top-left element.
	 */
	private int deltaY;
	
	/**
	 * Creates a unit at Location X, Y with velocity 0 and direction north.
	 * @param X Coordinate of this unit.
	 * @param Y Coordinate of this unit.
	 */
	public Unit(float X, float Y){
		this.setXCoor(X);
		this.setYCoor(Y);
		this.setVelocity(0);
		this.setDeltaX(0);
		this.setDeltaY(1);
	}
	
	/**
	 * Sets this unit to face the new direction.
	 * (0 , 1) : north
	 * (0 , -1): south
	 * (1, 0)  : east
	 * (-1, 0) : west
	 * @param deltaX (width difference) to an element in the direction
	 *            in a matrix with 0,0 (x,y) as its top-left element.
	 * @param deltaY (height difference) to an element in the direction
	 *            in a matrix with 0,0 (x,y) as its top-left element.
	 */
	public void setDirection(int deltaX, int deltaY){
		if(deltaX >= -1 && deltaX <= 1 && deltaY >= -1 && deltaY <= 1){
			this.setDeltaX(deltaX);
			this.setDeltaY(deltaY);	
		}
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getDeltaX() {
		return deltaX;
	}

	public void setDeltaX(int deltaX) {
		this.deltaX = deltaX;
	}

	/**
	 * Returns the current Y coordinate of this unit.
	 * @return the current Y coordinate of this unit.
	 */
	public float getYCoor() {
		return YCoor;
	}
	
	/**
	 * Returns the current X coordinate of this unit.
	 * @return the current Y coordinate of this unit.
	 */
	public float getXCoor() {
		return XCoor;
	}

	public void setXCoor(float xCoor) {
		XCoor = xCoor;
	}

	public void setYCoor(float yCoor) {
		YCoor = yCoor;
	}

	public int getDeltaY() {
		return deltaY;
	}

	public void setDeltaY(int deltaY) {
		this.deltaY = deltaY;
	}

}
