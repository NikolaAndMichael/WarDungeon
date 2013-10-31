package net.naprav.wardungeon.block;

import net.naprav.wardungeon.graphics.BlockSprite;

public class IceStoneBrick extends Block {

	public IceStoneBrick(BlockSprite sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static IceStoneBrick block = new IceStoneBrick(BlockSprite.icestonebrick, false, false);
	
	protected void render(int x, int y, BlockSprite sprite) {

	}
}
