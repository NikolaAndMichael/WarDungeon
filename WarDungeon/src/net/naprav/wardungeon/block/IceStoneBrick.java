package net.naprav.wardungeon.block;

import net.naprav.wardungeon.graphics.BlockTexture;

public class IceStoneBrick extends Block {

	public IceStoneBrick(BlockTexture sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static IceStoneBrick block = new IceStoneBrick(BlockTexture.icestonebrick, false, false);

	protected void render(int x, int y, BlockTexture sprite) {

	}
}
