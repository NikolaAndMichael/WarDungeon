package net.naprav.wardungeon.block;

import net.naprav.wardungeon.graphics.BlockTexture;
import net.naprav.wardungeon.graphics.Display;

public class StoneBlock extends Block {

	/**
	 * Main constructor for the StoneBlock.
	 * 
	 * @param sprite
	 * @param isCollidable
	 * @param doesKill
	 */
	public StoneBlock(BlockTexture sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static StoneBlock block = new StoneBlock(BlockTexture.stone, false, false);

	public void render(int x, int y, Display display) {
		display.renderBlock(block, x * 32, y * 32);
	}
}
