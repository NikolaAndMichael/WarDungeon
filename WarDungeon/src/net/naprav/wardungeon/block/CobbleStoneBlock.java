package net.naprav.wardungeon.block;

import net.naprav.wardungeon.graphics.BlockTexture;
import net.naprav.wardungeon.graphics.Display;

public class CobbleStoneBlock extends Block {

	public CobbleStoneBlock(BlockTexture sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static CobbleStoneBlock block = new CobbleStoneBlock(BlockTexture.cobblestone, false, false);
	
	public void render(int x, int y, Display display) {
		display.renderBlock(this, x * 32, y * 32);
	}
}
