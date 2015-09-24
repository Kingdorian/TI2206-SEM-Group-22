package spaceinvaders.group_22.unit;

/**
 * A bullet in the game, extends Unit.
 * @author Ege de Bruin
 */

public abstract class Bullet extends Unit implements MovableUnit{
	/**
	 * VelX is the velocity in the X direction in pixels per second.
	 */
	double velX;
	
	/**
	 * velY is the velocity in the Y direction in pixels per second.
	 */
	double velY;
	
	/**
	 * Creates a Bullet.
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @param spriteFile filename of the sprite of this unit.
	 */
	@SuppressWarnings("checkstyle:magicnumber")    
	public Bullet(final double x, final double y, final String spriteFile) {
		super(x, y, spriteFile);
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
