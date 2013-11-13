package net.naprav.wardungeon.block;

import net.naprav.wardungeon.graphics.BlockTexture;

public class StoneBrickBlock extends Block {

	/**
	 * Main constructor for the StoneBrickBlock.
	 * 
	 * @param sprite
	 * @param isCollidable
	 * @param doesKill
	 */
	public StoneBrickBlock(BlockTexture sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static StoneBrickBlock block = new StoneBrickBlock(BlockTexture.stonebrick, false, false);

	/**
	 * Method for rendering the StoneBrickBlock.
	 */
	protected void render(int x, int y, BlockTexture sprite) {
	}
}
