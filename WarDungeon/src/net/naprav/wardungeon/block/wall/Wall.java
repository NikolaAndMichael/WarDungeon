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
	
	public static Wall bottomRightOutCorner = new Wall(BlockTexture.bottom_right_corner, true, false);
	public static Wall bottomLeftOutCorner = new Wall(BlockTexture.bottom_left_corner, true, false);
	public static Wall topRightOutCorner = new Wall(BlockTexture.top_right_corner, true, false);
	public static Wall topLeftOutCorner = new Wall(BlockTexture.top_left_corner, true, false);
	
	public static Wall bottomRightInCorner = new Wall(BlockTexture.bottom_right_inner, true, false);
	public static Wall bottomLeftInCorner = new Wall(BlockTexture.bottom_left_inner, true, false);
	public static Wall topRightInCorner = new Wall(BlockTexture.top_right_inner, true, false);
	public static Wall topLeftInCorner = new Wall(BlockTexture.top_left_inner, true, false);
	
	public void render(int x, int y, Display display) {
		display.renderBlock(this, x * 32, y * 32);
	}
}
