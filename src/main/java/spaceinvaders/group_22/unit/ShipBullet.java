package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.ui.SpriteLoader;
import spaceinvaders.group_22.Player;


/**
 * An alienBullet in the game, extends Bullet.
 * @author Ege de Bruin
 */

public class ShipBullet extends Bullet {
	/**
	 * Owner of this bullet.
	 */
	private Player player;

	/**
	 * Creates a ShipBullet.
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 */
	public ShipBullet(final double x, final double y) {
		super(x, y);
	}

	/**
	 * Sets the right sprite image.
	 */
	public final void setSpriteImage() {
		setSprite(SpriteLoader.getInstance().getBulletSpaceShip());
	}

	/**
	 * @return the ship
	 */
	public final Player getPlayer() {
		return player;
	}
	/**
	 * Method to set the player who shoot this bullet.
	 * @param setPlayer player that shot this bullet.
	 */
	public final void setPlayer(final Player setPlayer) {
		player = setPlayer;
	}

}
