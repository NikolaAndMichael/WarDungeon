package net.naprav.wardungeon.block;

import net.naprav.wardungeon.ImageSheet;


public abstract class Block {

	private final int SIZE;
	private int x,  y;
	public int allPixels[];
	
	private ImageSheet sheet;
	
	public Block(ImageSheet sheet, int size, int x, int y) {
		this.SIZE = size;
		
	}
	
	public boolean isCollidable;
	public boolean doesKill;

	/**
	 * Sets if the block is collidable with entities.
	 * 
	 * @param isCollidable
	 */
	public void setIsCollidable(boolean isCollidable) {
		this.isCollidable = isCollidable;
	}

	/**
	 * Checks to see if the block is collidable with entities.
	 * 
	 * @return
	 */
	public boolean getIsCollidable() {
		return isCollidable;
	}

	/**
	 * Sets if the block harms entities.
	 * 
	 * @param doesKill
	 */
	public void setDoesKill(boolean doesKill) {
		this.doesKill = doesKill;
	}

	/**
	 * Checks to see if the block harms entities.
	 * 
	 * @return
	 */
	public boolean getDoesKill() {
		return doesKill;
	}
}