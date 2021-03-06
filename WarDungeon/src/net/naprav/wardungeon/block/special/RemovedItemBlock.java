package net.naprav.wardungeon.block.special;

import net.naprav.wardungeon.block.Block;
import net.naprav.wardungeon.graphics.BlockTexture;
import net.naprav.wardungeon.graphics.Display;

public class RemovedItemBlock extends Block {

	public RemovedItemBlock(BlockTexture sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static RemovedItemBlock block = new RemovedItemBlock(BlockTexture.removed, false, false);
	
	public void render(int x, int y, Display display) {
		display.renderBlock(this, x * 32, y * 32);
	}
}
