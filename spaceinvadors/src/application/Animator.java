package application;
import javafx.animation.AnimationTimer;

public class Animator extends AnimationTimer {

	@Override
	public void handle(long curTime) {
		final long startTime = System.nanoTime();
		double t = (curTime - startTime) /	1000000000.0;
		double y = 100 + t;

		
	}

}
