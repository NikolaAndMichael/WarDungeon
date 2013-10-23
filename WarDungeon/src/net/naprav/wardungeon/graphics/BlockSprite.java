package net.naprav.wardungeon.graphics;

public class BlockSprite {

	private int x, y;
	public final int SIZE;
	private SpriteSheet sheet;

	public int[] pixels;

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

		pixels = new int[SIZE * SIZE];
		loadBlock();
	}

	public static BlockSprite stone = new BlockSprite(SpriteSheet.block, 0, 0, 32);
	public static BlockSprite stonebrick = new BlockSprite(SpriteSheet.block, 1, 0, 32);
	public static BlockSprite mossystonebrick = new BlockSprite(SpriteSheet.block, 2, 0, 32);
	public static BlockSprite cobblestone = new BlockSprite(SpriteSheet.block, 3, 0, 32);
	
	public static BlockSprite lava_1 = new BlockSprite(SpriteSheet.lava, 0, 0, 32);
	public static BlockSprite lava_2 = new BlockSprite(SpriteSheet.lava, 1, 0, 32);
	public static BlockSprite lava_3 = new BlockSprite(SpriteSheet.lava, 2, 0, 32);
	public static BlockSprite lava_4 = new BlockSprite(SpriteSheet.lava, 0, 1, 32);
	public static BlockSprite lava_5 = new BlockSprite(SpriteSheet.lava, 1, 1, 32);
	public static BlockSprite lava_6 = new BlockSprite(SpriteSheet.lava, 2, 1, 32);
	
	/**
	 * Protected method loads the block into the pixels[] array as pixel data.
	 */
	private final void loadBlock() {
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				pixels[x + (y * SIZE)] = sheet.pixels[(this.x + x) + (this.y + y) * sheet.SIZE];
			}
		}
	}
}
