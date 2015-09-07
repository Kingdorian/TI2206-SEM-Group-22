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
		bullet.setVelY(-velocity);
		return bullet;
	}

}
