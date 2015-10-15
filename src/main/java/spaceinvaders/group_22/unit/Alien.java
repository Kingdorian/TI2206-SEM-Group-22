package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.ui.SpriteLoader;

/**
 * An alien in the game, extends Unit.
 * 
 * @author Ege de Bruin
 */

@SuppressWarnings("checkstyle:magicnumber") 
public class Alien extends Unit implements MovableUnit, ShootingUnit {
	
	/**
	 * Location of the sprite of the aliens.
	 */
	public static final String SPRITE = "invader.png";
	/**
	 * VelX is the velocity in the X direction in pixels per second.
	 */
	private double velX;
	
	/**
	 * velY is the velocity in the Y direction in pixels per second.
	 */
	private double velY;
	
	/**
	 * Chance this aliens shoots a bullet.
	 */
	private double bulletChance = 0.025;
	
	/**
	 * Variable that keeps track of the health left for this alien.
	 */
	private int health = 1;
	/**
	 * Creates an Alien with default health.
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public Alien(final double x, final double y) {
		super(x, y);
	}
	/**
	 * Creates an Alien with specified health.
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @param sethealth health this alien has.
	 */
	public Alien(final double x, final double y, final int sethealth) {
		super(x, y);
		if (sethealth >= 1) {
			health = sethealth;
			setSpriteImage();
		}
	}
	
	/**
	 * Creates a bullet object on the place of the Alien and shoots it downwards.
	 * @param velocity The speed of the Bullet
	 * @return The shot Bullet
	 */
	public final Bullet shootBullet(final double velocity) {
		Bullet bullet = new AlienBullet(this.getXCoor(), this.getYCoor());
		bullet.setVelY(velocity);
		return bullet;
	}
	/**
	 * HashCode method.
	 * @return hashcode of this object
	 */
	@SuppressWarnings("checkstyle:magicnumber")    
	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(velX);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(velY);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
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
			return 	super.equals(that)
					&& this.getVelX() == that.getVelX()
					&& this.getVelY() == that.getVelY();
		}
		return false;
	}	
	/**
	 * Move the unit in the direction of this unit and with his velocity.
	 * @param tickrate The rate at which the game ticks.
	 */
	public final void move(final double tickrate) {
		setXCoor(this.getXCoor() + (this.getVelX() * tickrate));
		setYCoor(this.getYCoor() + (this.getVelY() * tickrate));
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
	/**
	 * Gets the chance this aliens shoots a bullet.
	 * @return the chance this alien shoots a bullet
	 */
	public final double getBulletChance() {
		return bulletChance;
	}
	/**
	 * Sets the chance this aliens shoots a bullet to 0.25.
	 */
	public final void increaseShooting() {
		this.bulletChance = 0.25;
		setSpriteImage();
	}

	/**
	 * @return the health
	 */
	public final int getHealth() {
		return health;
	}
	
	/**
	 * Sets the right sprite image by the health and bullet chance.
	 */
	public final void setSpriteImage() {
		if (getBulletChance() > 0.025) {
			setSprite(SpriteLoader.getInstance().getAlienShooter());

		} else {
			setSprite(SpriteLoader.getInstance().getAlienWithHealth(health));

		}
		
	}
	
	/**
	 * When alien is hit decrease health.
	 */
	public final void hit() {
		health--;
		setSpriteImage();
	}
}
