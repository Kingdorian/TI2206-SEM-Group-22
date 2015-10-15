package spaceinvaders.group_22.unit;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import javafx.scene.image.Image;
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
	private double height;
	
	/**
	 * width of this unit.
	 */
	private double width;
	
	/**
	 * an Image object containing the sprite.
	 */
	private Image sprite;

	/**
	 * Creates a unit at Location X, Y with velocity 0 and direction north.
	 * @param x Coordinate of this unit.
	 * @param y Coordinate of this unit.
	 */
	public Unit(final double x, final double y) {
		this.setXCoor(x);
		this.setYCoor(y);
		this.setSpriteImage();
		this.setWidth(sprite.getWidth());
		this.setHeight(sprite.getHeight());
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
		result = (int) (prime * result + height);
		result = prime * result + ((sprite == null) ? 0 : sprite.hashCode());
		result = (int) (prime * result + width);
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
	public final double getWidth() {
		return width;
	}
	/**
	 * Sets the width of this unit.
	 * @param d to set as width.
	 */
	public final void setWidth(final double d) {
		this.width = d;
	}
	/**
	 * Get the height of this unit.
	 * @return the height of this unit.
	 */
	public final double getHeight() {
		return height;
	}
	/**
	 * Sets the height of this unit.
	 * @param newheight the height to set.
	 */
	public final void setHeight(final double newheight) {
		this.height = newheight;
	}
	
	/**
	 * Get the Image of the sprite of this unit.
	 * @return the Image of the sprite of this unit.
	 */
	public final Image getSprite() {
		return sprite;
	}
	
	/**
	 * Sets the Image of the sprite.
	 * @param newSprite The new sprite Image of this unit.
	 */
	public final void setSprite(final Image newSprite) {
		sprite = newSprite;
	}
	
	/**
	 * Sets the Image of the sprite of this unit.
	 * It should load the correct sprite from the SpriteLoader.
	 */
	public abstract void setSpriteImage();
}
