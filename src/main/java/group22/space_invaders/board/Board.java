package group22.space_invaders.board;

import java.util.ArrayList;

public class Board {
	
	private int height;
	
	private int width;
	
	private ArrayList<Unit> units;
	
	public Board(int height, int width){
		this.height = height;
		this.width = width;
		this.units = new ArrayList<Unit>();
	}
	
	/**
	 * Move the unit in the direction of this unit and with his velocity.
	 * @param time to move the unit.
	 * @param unit the unit to move
	 */
	public void moveUnit(Unit unit, int time){
		float xCoor = unit.getXCoor() + time * unit.getVelocity() * unit.getDeltaX();
		float yCoor = unit.getYCoor() + time * unit.getVelocity() * unit.getDeltaY();
		if(xCoor < width && yCoor < height){
			unit.setXCoor(xCoor);
			unit.setYCoor(yCoor);
		}
	}

}
