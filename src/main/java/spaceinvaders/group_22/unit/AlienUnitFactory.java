package spaceinvaders.group_22.unit;

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
		super();
	}
	
	@Override
	public final Alien createUnit(final double x, final double y) {
		return new Alien(x, y, "invader.png");
	}

	@Override
	public final AlienBullet createBullet(final double x, final double y) {
		return new AlienBullet(x, y, "alienbullet.png");
	}

}
