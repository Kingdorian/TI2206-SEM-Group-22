package spaceinvaders.group_22.unit;

/**
 * An alien in the game, extends Unit.
 * 
 * @author Ege de Bruin
 */

public class Alien extends Unit {
	
	/**
	 * Creates an Alien.
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @param spriteFile The filename of the sprite.
	 */
	public Alien(final double x, final double y, final String spriteFile) {
		super(x, y, spriteFile);
	}
	
	/**
	 * Creates a bullet object on the place of the Alien and shoots it downwards.
	 * @param velocity The speed of the Bullet
	 * @return The shot Bullet
	 */
	public final Bullet shootBullet(final int velocity) {
		Bullet bullet = new AlienBullet(this.getXCoor(), this.getYCoor(), "alienbullet.png");
		bullet.setVelY(velocity);
		return bullet;
	}
	
	/**
	 * Compares two objects and returns if they are equal.
	 * @return true if both objects are the same.
	 * @param other the object to compare.
	 */
	@Override
	public final boolean equals(final Object other) {
		if (other != null && other instanceof Alien) {
			Alien that = (Alien) other;
			return this.getXCoor() == that.getXCoor()
					&& this.getYCoor() == that.getYCoor()
					&& this.getVelX() == that.getVelX()
					&& this.getVelY() == that.getVelY()
					&& this.getHeight() == that.getHeight()
					&& this.getWidth() == that.getWidth();
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

}
