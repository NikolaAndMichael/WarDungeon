package net.naprav.wardungeon.block;

import net.naprav.wardungeon.graphics.BlockTexture;
import net.naprav.wardungeon.graphics.Display;

public class MossBrickBlock extends Block {

	public MossBrickBlock(BlockTexture sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static MossBrickBlock block = new MossBrickBlock(BlockTexture.mossbrick, false, false);
	
	public void render(int x, int y, Display display) {
		display.renderBlock(this, x * 32, y * 32);
	}
}
