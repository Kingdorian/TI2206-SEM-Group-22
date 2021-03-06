package spaceinvaders.group_22.unit;
/**
 * Interface for Subclasses of the Unit class that move.
 * @author Dorian
 *
 */
public interface MovableUnit {

	/**
	 * This method returns the X Velocity of object.
	 * @return Velocity in the x direction.
	 */
	double getVelX();
	/**
	 * This method sets the X velocity of this object.
	 * @param newVelX the new X velocity
	 */
	void setVelX(double newVelX);
	/**
	 * This method returns the velocity in the Y direction of this object.
	 * @return Velocity in the Y direction
	 */
	double getVelY();
	/**
	 * This method sets a new Y velocity for this object.
	 * @param newVelY the new Y velocity
	 */
	void setVelY(double newVelY);
	/**
	 * Moves the Unit according to its velocity.
	 * @param tickrate the amount of ticks per second of the game.
	 */
	 void move(final double tickrate);
}
