package spaceinvaders.group_22.unit;

import javafx.scene.media.AudioClip;
import spaceinvaders.group_22.sound.SoundLoader;
import spaceinvaders.group_22.ui.SpriteLoader;

/**
 * An Explosion in the game, extends Unit.
 * @author Jochem
 */

public class Explosion extends Unit implements Soundable {
	
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
	 */
	@SuppressWarnings("checkstyle:magicnumber")    
	public Explosion(final double x, final double y) {
		super(x, y);
		notifyObservers();
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

	/**
	 * Compares two objects and returns if they are equal.
	 * @return true if both objects are the same.
	 * @param other the object to compare.
	 */
	@Override
	public final boolean equals(final Object other) {
		if (other != null && other instanceof Explosion) {
			Explosion that = (Explosion) other;
			return super.equals(that)
					&& this.getXCoor() == that.getXCoor()
					&& this.getYCoor() == that.getYCoor();
		}
		return false;
	}
	/**
	 * HashCode method.
	 * @return hashcode of this object
	 */
	public final int hashCode() {
		  return 0;
	}
	
	/**
	 * Sets the right sprite image.
	 */
	public final void setSpriteImage() {
		setSprite(SpriteLoader.getInstance().getExplosionWithFrame(animationIndex));
	}

	@Override
	public final AudioClip getAudioClip() {
		return SoundLoader.getInstance().getExplosion();
	}

}
