package net.naprav.wardungeon.block;

import net.naprav.wardungeon.graphics.BlockSprite;

public class StoneBlock extends Block {

	/**
	 * Main constructor for the StoneBlock.
	 * 
	 * @param sprite
	 * @param isCollidable
	 * @param doesKill
	 */
	public StoneBlock(BlockSprite sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static StoneBlock block = new StoneBlock(BlockSprite.stone, false, false);

	/**
	 * Method for rendering the StoneBlock.
	 */
	public void render(int x, int y, BlockSprite sprite) {
	}
}
