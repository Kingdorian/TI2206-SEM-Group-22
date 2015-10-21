package spaceinvaders.group_22.unit;

import spaceinvaders.group_22.ui.SpriteLoader;

public class BossAlien extends Alien{

	public BossAlien(double x, double y) {
		super(x, y);
		setHealth(10);
	}

	@Override
	public void setSpriteImage() {
		setSprite(SpriteLoader.getInstance().getAlienLarge());	
	}

}
