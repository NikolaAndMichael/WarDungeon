package net.naprav.wardungeon.block;

public class StoneBlock extends Block {

	public StoneBlock(boolean isCollidable, boolean doesKill, int width, int height) {
		this.setIsCollidable(isCollidable);
		this.setDoesKill(doesKill);
		this.setWidth(width);
		this.setHeight(height);
	}
}
