package spaceinvaders.group_22.unit;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * A unit in the game that has a position and velocity.
 * 
 * @author Bryan van Wijk
 */

public abstract class Unit {
	
	/**
	 * The X Coordinate of this unit.
	 */
	private double xCoor;
	
	/**
	 * The Y Coordinate of this unit.
	 */
	private double yCoor;
	
	/**
	 * VelX is the velocity in the X direction.
	 */
	private int velX;
	
	/**
	 * velY is the velocity in the Y direction.
	 */
	private int velY;
	
	/**
	 * height of this unit.
	 */
	private int height;
	
	/**
	 * width of this unit.
	 */
	private int width;
	
	/**
	 * an Image object containing the sprite.
	 */
	private String sprite;
	
	/**
	 * Creates a unit at Location X, Y with velocity 0 and direction north.
	 * @param x Coordinate of this unit.
	 * @param y Coordinate of this unit.
	 * @param spriteFile filename of the sprite of this unit.
	 */
	public Unit(final double x, final double y, final String spriteFile) {
		this.setXCoor(x);
		this.setYCoor(y);
		this.setSprite(spriteFile);
		
		try {
			File imageFile = new File("src/main/resources/" + spriteFile);
			BufferedImage spriteImage = ImageIO.read(imageFile);
			this.setHeight(spriteImage.getHeight());
			this.setWidth(spriteImage.getWidth());
		} catch (IOException e) {
			System.out.println("Unit sprite image name invalid");
			e.printStackTrace();
		}
		
		this.setVelX(0);
		this.setVelY(0);
	}
	/**
	 * Compares two objects and returns if they are equal.
	 * @param other the object to compare this object to
	 * @return true if both objects are thesame.
	 */
	@Override
	public boolean equals(final Object other) {
		if (other != null && other instanceof Unit) {
			Unit that = (Unit) other;
			return this.xCoor == that.getXCoor()
						&& this.getYCoor() == that.yCoor
						&& this.velX == that.getVelX()
						&& this.velY == that.getVelY()
						&& this.getHeight() == that.getHeight()
						&& this.getWidth() == that.getWidth();
		}
		return false;
	}
	/**
	 * Move the unit in the direction of this unit and with his velocity.
	 */
	public final void moveUnit() {
		setXCoor(this.getXCoor() + this.getVelX());
		setYCoor(this.getYCoor() + this.getVelY());
	}
	
	/**
	 * Returns the current velocity in the X direction.
	 * @return the current velocity in the X direction.
	 */
	public final int getVelX() {
		return velX;
	}
	
	/**
	 * Sets the current velocity in the X direction.
	 * @param newvelX the velocity in the X direction to set.
	 */
	public final void setVelX(final int newvelX) {
		this.velX = newvelX;
	}

	/**
	 * Returns the current Y coordinate of this unit.
	 * @return the current Y coordinate of this unit.
	 */
	public final double getYCoor() {
		return yCoor;
	}
	
	/**
	 * Returns the current X coordinate of this unit.
	 * @return the current Y coordinate of this unit.
	 */
	public final double getXCoor() {
		return xCoor;
	}
	
	/**
	 * Sets the current X coordinate of this unit.
	 * @param newxCoor the current X coordinate of this unit to set.
	 */
	private void setXCoor(final double newxCoor) {
		this.xCoor = newxCoor;
	}
	
	/**
	 * Sets the current Y coordinate of this unit.
	 * @param newyCoor the current Y coordinate of this unit to set.
	 */
	private void setYCoor(final double newyCoor) {
		this.yCoor = newyCoor;
	}
	
	/**
	 * Returns the current velocity in the Y direction.
	 * @return the current velocity in the Y direction.
	 */
	public final int getVelY() {
		return velY;
	}
	
	/**
	 * Sets the current velocity in the Y direction.
	 * @param newvelY the velocity in the Y direction to set.
	 */
	public final void setVelY(final int newvelY) {
		this.velY = newvelY;
	}
	/**
	 * Get the width of this unit.
	 * @return the width of this unit.
	 */
	public final int getWidth() {
		return width;
	}
	/**
	 * Sets the width of this unit.
	 * @param newWidth to set as width.
	 */
	public final void setWidth(final int newWidth) {
		this.width = newWidth;
	}
	/**
	 * Get the height of this unit.
	 * @return the height of this unit.
	 */
	public final int getHeight() {
		return height;
	}
	/**
	 * Sets the height of this unit.
	 * @param newheight the height to set.
	 */
	public final void setHeight(final int newheight) {
		this.height = newheight;
	}
	
	/**
	 * Get the filename of the sprite of this unit.
	 * @return the filename of the sprite of this unit.
	 */
	public final String getSprite() {
		return sprite;
	}
	/**
	 * Sets the filename of the sprite of this unit.
	 * @param newSprite the filename to set.
	 */
	public final void setSprite(final String newSprite) {
		this.sprite = newSprite;
	}

}
