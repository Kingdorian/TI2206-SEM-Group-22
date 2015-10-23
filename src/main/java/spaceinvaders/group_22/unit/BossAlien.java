package spaceinvaders.group_22.unit;

import java.util.ArrayList;

import spaceinvaders.group_22.ui.SpriteLoader;

/**
 * BossAlien for boss levels.
 * @author Ege
 *
 */
@SuppressWarnings("checkstyle:magicnumber") 
public class BossAlien extends Alien {

	/**
	 * Create a large alien with health 20.
	 * @param x location to create alien on
	 * @param y location to create alien on
	 */
	public BossAlien(final double x, final double y) {
		super(x, y);
		setHealth(20);
		increaseShooting();
	}

	@Override
	public final void setSpriteImage() {
		setSprite(SpriteLoader.getInstance().getBossSpaceShip());
		// Set the location of impact close to the center instead of on the border.
		this.setHeight(0.75 * SpriteLoader.getInstance().getBossSpaceShip().getHeight());
	}

	@Override
	public final ArrayList<Bullet> shootBullet(final double velocity) {
		ArrayList<Bullet> list = new ArrayList<Bullet>();
		for (int i = 0; i < 6; i++) {
			Bullet bullet = new AlienBullet((this.getXCoor() + 40 * i) - 100, this.getYCoor());
			bullet.setVelY(velocity);
			list.add(bullet);
		}
		return list;
	}
	
	@Override
	public final void move(final double tickrate) {
		setXCoor(this.getXCoor() + (this.getVelX() * tickrate));
	}
}
