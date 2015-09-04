package group22.space_invaders.unit;

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
	 */
	public Alien(final double x, final double y) {
		super(x, y);
	}
	
	/**
	 * Creates a bullet object on the place of the Alien and shoots it downwards.
	 * @param velocity The speed of the Bullet
	 * @return The shot Bullet
	 */
	public final Bullet shootBullet(final int velocity) {
		Bullet bullet = new AlienBullet(this.getXCoor(), this.getYCoor());
		bullet.setVelY(-velocity);
		return bullet;
	}

}
