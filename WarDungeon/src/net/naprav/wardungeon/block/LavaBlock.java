package net.naprav.wardungeon.block;

import net.naprav.wardungeon.graphics.BlockTexture;
import net.naprav.wardungeon.graphics.Display;

public class LavaBlock extends Block {

	/**
	 * Main constructor for the LavaBlock.
	 * 
	 * @param sprite
	 * @param isCollidable
	 * @param doesKill
	 */
	public LavaBlock(BlockTexture sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static LavaBlock block = new LavaBlock(BlockTexture.lava_1, false, true);

	private int animation = 0;

	public void render(int x, int y, Display display) {
		animation++;
		
		if (animation >= 2500 && animation <= 5000) {
			sprite = BlockTexture.lava_2;
		} else {
			sprite = BlockTexture.lava_1;
		}
		
		if (animation == 5000) animation = 0;
		display.renderBlock(block, x * 32, y * 32);
	}
}
