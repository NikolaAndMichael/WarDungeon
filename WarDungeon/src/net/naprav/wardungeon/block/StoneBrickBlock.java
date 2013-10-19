package net.naprav.wardungeon.block;

import net.naprav.wardungeon.graphics.BlockSprite;

public class StoneBrickBlock extends Block {

	public StoneBrickBlock(BlockSprite sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static StoneBrickBlock block = new StoneBrickBlock(BlockSprite.stonebrick, false, false);
	
	protected void render(int x, int y, BlockSprite sprite) {
	}
}
