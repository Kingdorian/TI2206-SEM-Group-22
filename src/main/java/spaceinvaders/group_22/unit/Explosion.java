package spaceinvaders.group_22.unit;

/**
 * An Explosion in the game, extends Unit.
 * @author Jochem
 */

public class Explosion extends Unit {
	
	/**
	 * Counts the amount of cycles the explosion has been drawn.
	 */
	private int counter;
	
	/**
	 * The index of the animation cycle.
	 */
	private int animationIndex;

	/**
	 * Creates an Explosion.
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @param spriteFile filename of the sprite of this unit.
	 */
	@SuppressWarnings("checkstyle:magicnumber")    
	public Explosion(final double x, final double y, final String spriteFile) {
		super(x, y, spriteFile);
		this.counter = 0;
		this.animationIndex = 0;
	}
	
	/**
	 * Increases the cycle counter with 1.
	 */
	public final void increaseCounter() {
		this.counter += 1;
	}
	
	/**
	 * Gets the counter value.
	 * @return The value of the counter.
	 */
	public final int getCounter() {
		return counter;
	}
	
	/**
	 * Increases the amimation index with 1.
	 */
	public final void increaseAnimationIndex() {
		this.animationIndex += 1;
	}
	
	/**
	 * Gets the animation index value.
	 * @return The value of the animation index.
	 */
	public final int getAnimationIndex() {
		return animationIndex;
	}

}