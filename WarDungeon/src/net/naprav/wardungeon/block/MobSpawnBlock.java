package net.naprav.wardungeon.block;

import net.naprav.wardungeon.graphics.BlockTexture;
import net.naprav.wardungeon.graphics.Display;

public class MobSpawnBlock extends Block {

	public MobSpawnBlock(BlockTexture sprite, boolean isCollidable, boolean doesKill) {
		super(sprite, isCollidable, doesKill);
	}

	public static MobSpawnBlock block = new MobSpawnBlock(BlockTexture.mob_spawn, false, false);
	
	public void render(int x, int y, Display display) {
		display.renderBlock(this, x * 32, y * 32);
	}
}
