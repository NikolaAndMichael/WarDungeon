package net.naprav.wardungeon.block;

import net.naprav.wardungeon.graphics.BlockTexture;
import net.naprav.wardungeon.graphics.Display;

public class StoneBrickBlock extends Block {

	/**
	 * Main constructor for the StoneBrickBlock.
	 * 
	 * @param sprite
	 * @param isCollidable
	 * @param doesKill
	 */
	public StoneBrickBlock(BlockTexture sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static StoneBrickBlock block = new StoneBrickBlock(BlockTexture.stonebrick, false, false);

	public void render(int x, int y, Display display) {
		display.renderBlock(block, x * 32, y * 32);
	}
}
