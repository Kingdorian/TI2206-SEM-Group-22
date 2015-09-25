package spaceinvaders.group_22.ui;

import javafx.scene.canvas.GraphicsContext;
import spaceinvaders.group_22.Game;
import spaceinvaders.group_22.logger.LogEvent;
import spaceinvaders.group_22.unit.Barricade;

/**
 * The drawing of the barricades.
 * @author Ege
 *
 */
public class UIElementBarricade extends UIElementUnit {
	
	/**
	 * The constructor.
	 * @param newGame the Game
	 * @param gc the GraphicsContext to draw on.	 
	 */
	public UIElementBarricade(final Game newGame, final GraphicsContext gc) {	
		super(newGame, gc);
	}

	@Override
	public final void draw() {
		// Loop over all the barricades 
		for (Barricade bar : getGame().getBarricades()) {
			//Calculate opacity on base of the health of the barricade
			Double opacity = bar.getHealth() * 0.1;
			getGC().setGlobalAlpha(opacity);
			drawUnit(bar.getXCoor(), bar.getYCoor(), bar.getWidth(), bar.getHeight(), bar.getSprite(), getGC());
			getGC().setGlobalAlpha(1);
		}
		getGame().getLogger().log("Drawn barricades", LogEvent.Type.TRACE);
		
	}

}
