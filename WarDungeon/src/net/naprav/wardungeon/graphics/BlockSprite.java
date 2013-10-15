package net.naprav.wardungeon.graphics;

public class BlockSprite {

	private int x, y;
	public final int SIZE;
	public int[] pixels;

	private SpriteSheet sheet;

	/**
	 * Basic constructor. We have to get the SpriteSheet where the sprite is and we need the x/y coordinates and the size of it. Simple.
	 * 
	 * @param sheet
	 * @param x
	 * @param y
	 * @param size
	 */
	public BlockSprite(SpriteSheet sheet, int x, int y, int size) {
		SIZE = size;
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;

		loadBlock();
	}

	public static BlockSprite stone = new BlockSprite(SpriteSheet.block, 0, 0, 32);
	
	/**
	 * Protected method loads the block into the pixels[] array as pixel data.
	 */
	protected void loadBlock() {
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				pixels[x + (y * SIZE)] = ((this.x + x) + (this.y + y)) * sheet.SIZE;
			}
		}
	}
}
