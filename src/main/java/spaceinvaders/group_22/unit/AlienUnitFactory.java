package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;

/**
 * A Factory responsible for Alien related objects.
 * @author Jochem
 *
 */
public class AlienUnitFactory extends AbstractUnitFactory {
	
	/**
	 * Constructor for an AlienUnitFactory.
	 */
	public AlienUnitFactory() {
		Game.getLogger().log(getClass().getName() + "  created succesfully", LogEvent.Type.INFO);
	}
	
	@Override
	final Unit createUnit(final double x, final double y) {
		return new Alien(x, y, "invader.png");
	}

	@Override
	final Unit createBullet(final double x, final double y) {
		return new AlienBullet(x, y, "alienbullet.png");
	}

}
