package net.naprav.wardungeon.block;

import net.naprav.wardungeon.graphics.BlockSprite;

public class StoneBrickBlock extends Block {

	/**
	 * Main constructor for the StoneBrickBlock.
	 * 
	 * @param sprite
	 * @param isCollidable
	 * @param doesKill
	 */
	public StoneBrickBlock(BlockSprite sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static StoneBrickBlock block = new StoneBrickBlock(BlockSprite.stonebrick, false, false);
	
	/**
	 * Method for rendering the StoneBrickBlock.
	 */
	protected void render(int x, int y, BlockSprite sprite) {
	}
}
