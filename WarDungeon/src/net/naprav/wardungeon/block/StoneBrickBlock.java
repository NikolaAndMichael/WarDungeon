package net.naprav.wardungeon.block;

public class StoneBrickBlock extends Block {

	public StoneBrickBlock(boolean isCollidable, boolean doesKill, int width, int height) {
		this.setIsCollidable(isCollidable);
		this.setDoesKill(doesKill);
		this.setWidth(width);
		this.setHeight(height);
	}
}
