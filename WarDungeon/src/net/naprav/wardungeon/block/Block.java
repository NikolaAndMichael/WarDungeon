package net.naprav.wardungeon.block;

import net.naprav.wardungeon.graphics.BlockSprite;

public abstract class Block {

	protected boolean isCollidable;
	protected boolean doesKill;

	public BlockSprite sprite;
	protected int[] pixels;
	
	/**
	 * The default Block constructor. It needs a sprite to be rendered as and a boolean to represent whether it's solid and if it's lethal.
	 * 
	 * @param sprite
	 * @param isCollidable
	 * @param doesKill
	 */
	public Block(BlockSprite sprite, boolean isCollidable, boolean doesKill) {
		this.sprite = sprite;
		this.isCollidable = isCollidable;
		this.doesKill = doesKill;
	}

	/**
	 * Sets the block as collidable or not.
	 */
	protected void setCollidable() {
	}

	/**
	 * Checks to see if the block is collidable or not.
	 */
	protected boolean getIsCollidable() {
		return isCollidable;
	}

	/**
	 * Sets the block as to whether it can kill or not..
	 */
	protected void setDoesKill() {
	}

	/**
	 * Checks to see if the block can kill or not.
	 */
	protected boolean getDoesKill() {
		return doesKill;
	}

	/**
	 * The method responsible for rendering the block to the screen.
	 * 
	 * @param x
	 * @param y
	 * @param sprite
	 */
	protected abstract void render(int x, int y, BlockSprite sprite);
}
