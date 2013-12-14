package net.naprav.wardungeon.block.special;

import net.naprav.wardungeon.block.Block;
import net.naprav.wardungeon.graphics.BlockTexture;
import net.naprav.wardungeon.graphics.Display;

public class HealthPodBlock extends Block {

	private int animation = 0;

	public HealthPodBlock(BlockTexture sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static HealthPodBlock block = new HealthPodBlock(BlockTexture.health, false, false);

	public void render(int x, int y, Display display) {
		if (animation >= 100) animation = 0;
		animation++;

		if (animation < 75 && animation > 10) {
			sprite = BlockTexture.health_2;
		} else {
			sprite = BlockTexture.health;
		}

		display.renderBlock(this, x * 32, y * 32);
	}
}
