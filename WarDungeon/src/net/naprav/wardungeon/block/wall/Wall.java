package net.naprav.wardungeon.block.wall;

import net.naprav.wardungeon.block.Block;
import net.naprav.wardungeon.graphics.BlockTexture;
import net.naprav.wardungeon.graphics.Display;

public class Wall extends Block {

	public Wall(BlockTexture sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static Wall lowerFlat = new Wall(BlockTexture.bottom_flat, true, false);
	public static Wall rightFlat = new Wall(BlockTexture.right_flat, true, false);
	public static Wall topFlat = new Wall(BlockTexture.top_flat, true, false);
	public static Wall bottomFlat = new Wall(BlockTexture.bottom_flat, true, false);
	
	
	public void render(int x, int y, Display display) {
		display.renderBlock(this, x * 32, y * 32);
	}
}
