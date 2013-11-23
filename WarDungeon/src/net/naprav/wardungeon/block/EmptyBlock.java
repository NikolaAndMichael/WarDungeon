package net.naprav.wardungeon.block;

import net.naprav.wardungeon.graphics.BlockTexture;
import net.naprav.wardungeon.graphics.Display;

public class EmptyBlock extends Block {

	public EmptyBlock(BlockTexture sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static EmptyBlock block = new EmptyBlock(BlockTexture.empty, false, true);
	
	public void render(int x, int y, Display display) {
		display.renderBlock(this, x, y);
	}
}
