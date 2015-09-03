package spaceinvaders.group_22;
import javafx.animation.AnimationTimer;

public class Animator extends AnimationTimer {

	@Override
	public final void handle(final long curTime) {
		final long startTime = System.nanoTime();
		double t = (curTime - startTime) /	1000000000.0;
		double y = 100 + t;

		
	}

}
