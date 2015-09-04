package group22.space_invaders.unit;

/**
 * A SpaceShip in the game extends Unit.
 * 
 * @author Bryan van Wijk
 */

public class SpaceShip extends Unit {

	public SpaceShip(float X, float Y) {
		super(X, Y);
	}
	
	public boolean equals(SpaceShip that) {
		if (that == null ) {
			return false;
		} else if(!(that instanceof SpaceShip)) {
			return false;
		}
		return super.equals(that);
	
		
	}

}
