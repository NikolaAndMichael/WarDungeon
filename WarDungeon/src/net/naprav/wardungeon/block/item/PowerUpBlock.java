package net.naprav.wardungeon.block.item;

import net.naprav.wardungeon.block.Block;
import net.naprav.wardungeon.graphics.BlockTexture;
import net.naprav.wardungeon.graphics.Display;

public class PowerUpBlock extends Block {

	private int animation = 0;
	
	public PowerUpBlock(BlockTexture sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static PowerUpBlock block = new PowerUpBlock(BlockTexture.powerup, false, false);
	
	public void render(int x, int y, Display display) {
		if (animation >= 100) animation = 0;
		animation++;

		if (animation < 75 && animation > 10) {
			sprite = BlockTexture.powerup_2;
		} else {
			sprite = BlockTexture.powerup;
		}

		display.renderBlock(this, x * 32, y * 32);
	}
}
