package net.naprav.wardungeon.block;

public class StoneBlock extends Block {

	public StoneBlock(String pathway, int size, boolean isCollidable, boolean doesKill) {
		super(pathway, size, isCollidable, doesKill);
		this.loadImageToScreen();
	}	
}
