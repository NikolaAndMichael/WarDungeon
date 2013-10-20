package net.naprav.wardungeon.block;

import net.naprav.wardungeon.graphics.BlockSprite;

public class LavaBlock extends Block {

	public LavaBlock(BlockSprite sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static LavaBlock block = new LavaBlock(BlockSprite.lava_1, false, true);
	public static LavaBlock block_2 = new LavaBlock(BlockSprite.lava_2, false, true);
	public static LavaBlock block_3 = new LavaBlock(BlockSprite.lava_3, false, true);
	public static LavaBlock block_4 = new LavaBlock(BlockSprite.lava_4, false, true);
	public static LavaBlock block_5 = new LavaBlock(BlockSprite.lava_5, false, true);
	public static LavaBlock block_6 = new LavaBlock(BlockSprite.lava_6, false, true);
	
	protected void render(int x, int y, BlockSprite sprite) {
	}
}
