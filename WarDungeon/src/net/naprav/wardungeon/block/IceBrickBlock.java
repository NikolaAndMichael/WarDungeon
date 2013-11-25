package net.naprav.wardungeon.block;

import net.naprav.wardungeon.graphics.BlockTexture;
import net.naprav.wardungeon.graphics.Display;

public class IceBrickBlock extends Block {

	public IceBrickBlock(BlockTexture sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static IceBrickBlock block = new IceBrickBlock(BlockTexture.icestonebrick, false, false);

	public void render(int x, int y, Display display) {
		display.renderBlock(block, x * 32, y * 32);
	}
}
