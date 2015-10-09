package spaceinvaders.group_22.unit;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import spaceinvaders.group_22.logger.Logger;

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
			InputStream inputStream = 
					getClass().getClassLoader().getResourceAsStream("spaceinvaders/group_22/images/" + spriteFile);
			BufferedImage spriteImage = ImageIO.read(inputStream);
			this.setHeight(spriteImage.getHeight());
			this.setWidth(spriteImage.getWidth());	
		} catch (IOException e) {
			Logger.getInstance().log("Unit sprite image name invalid", e);
			e.printStackTrace();
		}
	}
	/**
	 * Compares two objects and returns if they are equal.
	 * @return true if both objects are the same.
	 * @param other the object to compare.
	 */
	@SuppressWarnings("checkstyle:designforextension")
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;	
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Unit other = (Unit) obj;
		if (height != other.height) {
			return false;
		}
		if (sprite == null) {
			if (other.sprite != null) {
				return false;
			}
		} else if (!sprite.equals(other.sprite)) {
			return false;
		}

		if (width != other.width) {
			return false;
		}
		if (Double.doubleToLongBits(xCoor) != Double.doubleToLongBits(other.xCoor)) {
			return false;
		}
		if (Double.doubleToLongBits(yCoor) != Double.doubleToLongBits(other.yCoor)) {
			return false;
		}
		return true;
	}
	/**
	 * Returns hashcode of this object.
	 * @return hashcode of this object.
	 */
	@SuppressWarnings({"checkstyle:magicnumber", "checkstyle:avoidinlineconditionals", "checkstyle:designforextension"})
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + ((sprite == null) ? 0 : sprite.hashCode());
		result = prime * result + width;
		long temp;
		temp = Double.doubleToLongBits(xCoor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(yCoor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
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
	protected final void setXCoor(final double newxCoor) {
		this.xCoor = newxCoor;
	}
	/**
	 * Sets the current Y coordinate of this unit.
	 * @param newyCoor the current Y coordinate of this unit to set.
	 */
	protected final void setYCoor(final double newyCoor) {
		this.yCoor = newyCoor;
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
