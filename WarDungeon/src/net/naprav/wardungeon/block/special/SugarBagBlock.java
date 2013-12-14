package net.naprav.wardungeon.block.special;

import net.naprav.wardungeon.block.Block;
import net.naprav.wardungeon.graphics.BlockTexture;
import net.naprav.wardungeon.graphics.Display;

public class SugarBagBlock extends Block {

	public SugarBagBlock(BlockTexture sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static SugarBagBlock block = new SugarBagBlock(BlockTexture.sugarbag, false, false);
	
	public void render(int x, int y, Display display) {
		if (animation >= 100) animation = 0;
		animation++;

		if (animation < 75 && animation > 10) {
			// Add more sprites for this!
			//sprite = BlockTexture.sugarbag_2;
		} else {
			sprite = BlockTexture.sugarbag;
		}

		display.renderBlock(this, x * 32, y * 32);
	}
}
