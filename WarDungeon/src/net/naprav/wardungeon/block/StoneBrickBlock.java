package net.naprav.wardungeon.block;

public class StoneBrickBlock extends Block {

	public StoneBrickBlock(String pathway, int size, boolean isCollidable, boolean doesKill) {
		super(pathway, size, isCollidable, doesKill);
		this.loadImageToScreen();
	}
}
