package net.naprav.wardungeon.block.special;

import net.naprav.wardungeon.graphics.BlockTexture;
import net.naprav.wardungeon.graphics.Display;

public class KeyBlock extends net.naprav.wardungeon.block.Block {

	public KeyBlock(BlockTexture sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static KeyBlock block = new KeyBlock(BlockTexture.key, false, false);
	
	public void render(int x, int y, Display display) {
		if (animation >= 100) animation = 0;
		animation++;

		if (animation < 75 && animation > 10) {
			sprite = BlockTexture.key_2;
		} else {
			sprite = BlockTexture.key;
		}

		display.renderBlock(this, x * 32, y * 32);
	}
}
