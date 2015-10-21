package spaceinvaders.group_22.unit;

import java.util.ArrayList;

/**
 * A normal alien.
 * @author Ege
 *
 */
public abstract class DefaultAlien extends Alien {

	/**
	 * To create a default alien.
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public DefaultAlien(final double x, final double y) {
		super(x, y);
	}
	
	@Override
	public final ArrayList<Bullet> shootBullet(final double velocity) {
		ArrayList<Bullet> list = new ArrayList<Bullet>();
		Bullet bullet = new AlienBullet(this.getXCoor(), this.getYCoor());
		bullet.setVelY(velocity);
		list.add(bullet);
		return list;
	}
	
	@Override
	public final void move(final double tickrate) {
		setXCoor(this.getXCoor() + (this.getVelX() * tickrate));
		setYCoor(this.getYCoor() + (this.getVelY() * tickrate));
	}

}
