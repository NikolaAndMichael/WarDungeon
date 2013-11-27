package net.naprav.wardungeon.block;

import net.naprav.wardungeon.graphics.BlockTexture;
import net.naprav.wardungeon.graphics.Display;

public class AbyssBlock extends Block {

	public AbyssBlock(BlockTexture sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static AbyssBlock block = new AbyssBlock(BlockTexture.empty, false, true);
	
	public void render(int x, int y, Display display) {
		display.renderBlock(this, x, y);
	}
}
