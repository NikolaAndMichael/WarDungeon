package net.naprav.wardungeon.block;

import net.naprav.wardungeon.graphics.BlockSprite;

public class StoneBlock extends Block {

	public StoneBlock(BlockSprite sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}
	
	public void render(int x, int y, BlockSprite sprite) {
	}
}
