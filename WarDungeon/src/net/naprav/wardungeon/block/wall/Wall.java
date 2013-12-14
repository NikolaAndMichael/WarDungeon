package net.naprav.wardungeon.block.wall;

import net.naprav.wardungeon.block.Block;
import net.naprav.wardungeon.graphics.BlockTexture;
import net.naprav.wardungeon.graphics.Display;

public class Wall extends Block {

	public Wall(BlockTexture sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static Wall leftFlat = new Wall(BlockTexture.left_flat, true, false);
	public static Wall rightFlat = new Wall(BlockTexture.right_flat, true, false);
	public static Wall topFlat = new Wall(BlockTexture.top_flat, true, false);
	public static Wall bottomFlat = new Wall(BlockTexture.bottom_flat, true, false);

	public static Wall bottomRightInner = new Wall(BlockTexture.bottom_right_inner, true, false);
	public static Wall bottomLeftInner = new Wall(BlockTexture.bottom_left_inner, true, false);
	public static Wall topRightInner = new Wall(BlockTexture.top_right_inner, true, false);
	public static Wall topLeftInner = new Wall(BlockTexture.top_left_inner, true, false);

	public static Wall bottomRightOuter = new Wall(BlockTexture.bottom_right_outer, true, false);
	public static Wall bottomLeftOuter = new Wall(BlockTexture.bottom_left_outer, true, false);
	public static Wall topRightOuter = new Wall(BlockTexture.top_right_outer, true, false);
	public static Wall topLeftOuter = new Wall(BlockTexture.top_left_outer, true, false);

	public void render(int x, int y, Display display) {
		display.renderBlock(this, x * 32, y * 32);
	}
}
