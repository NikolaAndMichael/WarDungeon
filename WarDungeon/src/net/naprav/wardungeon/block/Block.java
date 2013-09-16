package net.naprav.wardungeon.block;

public abstract class Block {

	public boolean isCollidable;
	public boolean doesKill;
	public int width;
	public int height;

	/**
	 * Sets if the block is collidable with entities.
	 * @param isCollidable
	 */
	public void setIsCollidable(boolean isCollidable) {
		this.isCollidable = isCollidable;
	}

	/**
	 * Checks to see if the block is collidable with entities.
	 * @return
	 */
	public boolean getIsCollidable() {
		return isCollidable;
	}

	/**
	 * Sets if the block harms entities.
	 * @param doesKill
	 */
	public void setDoesKill(boolean doesKill) {
		this.doesKill = doesKill;
	}

	/**
	 * Checks to see if the block harms entities.
	 * @return
	 */
	public boolean getDoesKill() {
		return doesKill;
	}

	/**
	 * Sets the width of the block. (Default should be 32)
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Checks the width of the block. (Default should be 32)
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the height of the block. (Default should be 32)
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Checks the height of the block. (Default should be 32)
	 * @return
	 */
	public int getHeight() {
		return height;
	}
}