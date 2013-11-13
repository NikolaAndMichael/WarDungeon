package net.naprav.wardungeon.block;

import net.naprav.wardungeon.graphics.BlockTexture;

public class LavaBlock extends Block {

	/**
	 * Main constructor for the LavaBlock.
	 * 
	 * @param sprite
	 * @param isCollidable
	 * @param doesKill
	 */
	public LavaBlock(BlockTexture sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static LavaBlock block = new LavaBlock(BlockTexture.lava_1, false, true);
	public static LavaBlock block_2 = new LavaBlock(BlockTexture.lava_2, false, true);
	public static LavaBlock block_3 = new LavaBlock(BlockTexture.lava_3, false, true);
	public static LavaBlock block_4 = new LavaBlock(BlockTexture.lava_4, false, true);
	public static LavaBlock block_5 = new LavaBlock(BlockTexture.lava_5, false, true);
	public static LavaBlock block_6 = new LavaBlock(BlockTexture.lava_6, false, true);

	/**
	 * Method for rendering the LavaBlock.
	 */
	protected void render(int x, int y, BlockTexture sprite) {
	}
}
