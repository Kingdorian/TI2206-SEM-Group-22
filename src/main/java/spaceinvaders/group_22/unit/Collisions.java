package spaceinvaders.group_22.unit;

import java.util.ArrayList;
/**
 * 
 * @author Bryan
 *
 */
public class Collisions {
	
	/**
	 * Checks collisions between an unit and a an ArrayList of other units.
	 * @param checkingUnit the unit to check colissions with
	 * @param unitList the list of units to check colission against.
	 * @return The unit the checkingUnit colides with, null if there are no colissions.
	 */
	public final Unit checkCollisions(final Unit checkingUnit, final ArrayList<Unit> unitList) {

		double checkX = checkingUnit.getXCoor();
		double checkY = checkingUnit.getYCoor();
		for (Unit unit : unitList) {
			double unitX = unit.getXCoor();
			double unitY = unit.getYCoor();
			if (
					checkX - unitX >= -(unit.getWidth() / 2 + checkingUnit.getWidth() / 2)  
				&& checkX - unitX <= unit.getWidth() / 2 + checkingUnit.getWidth() / 2
				&& checkY - unitY >= -(unit.getHeight() / 2 + checkingUnit.getHeight() / 2) 
				&& checkY - unitY <= unit.getHeight() / 2  + checkingUnit.getHeight() / 2) {
					return unit;
			}
		}
		return null;
	}

}
