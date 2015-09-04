package group22.space_invaders.unit;

/**
 * An alien in the game, extends Unit
 * 
 * @author Ege de Bruin
 */

public class Alien extends Unit {
	
	public Alien(double X, double Y){
		super(X,Y);
	}
	
	/**
	 * Creates a bullet object on the place of the Alien and shoots it downwards.
	 * @param velocity The speed of the Bullet
	 */
	public Bullet shootBullet(int velocity){
		Bullet bullet = new AlienBullet(this.getXCoor(), this.getYCoor());
		bullet.setVelY(-velocity);
		return bullet;
	}

}
