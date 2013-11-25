package net.naprav.wardungeon.graphics;

public class BlockTexture {

	private int x, y;
	public final int SIZE;
	private TextureSheet sheet;

	public int[] pixels;

	/**
	 * Basic constructor. We have to get the TextureSheet where the sprite is and we need the x/y coordinates and the size of it. Simple.
	 * 
	 * @param sheet
	 * @param x
	 * @param y
	 * @param size
	 */
	public BlockTexture(TextureSheet sheet, int x, int y, int size) {
		SIZE = size;
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;

		pixels = new int[SIZE * SIZE];
		loadBlock();
	}

	public BlockTexture(int color, int size) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];

		for (int a = 0; a < pixels.length; a++) {
			pixels[a] = color;
		}
	}

	public static BlockTexture stone = new BlockTexture(TextureSheet.block, 0, 0, 32);
	public static BlockTexture stonebrick = new BlockTexture(TextureSheet.block, 1, 0, 32);
	public static BlockTexture mossbrick = new BlockTexture(TextureSheet.block, 2, 0, 32);
	public static BlockTexture cobblestone = new BlockTexture(TextureSheet.block, 3, 0, 32);
	public static BlockTexture icestonebrick = new BlockTexture(TextureSheet.block, 4, 0, 32);

	public static BlockTexture empty = new BlockTexture(0x000000, 32);

	public static BlockTexture lava_1 = new BlockTexture(TextureSheet.lava, 0, 0, 32);
	public static BlockTexture lava_2 = new BlockTexture(TextureSheet.lava, 1, 0, 32);
	public static BlockTexture lava_3 = new BlockTexture(TextureSheet.lava, 2, 0, 32);
	public static BlockTexture lava_4 = new BlockTexture(TextureSheet.lava, 0, 1, 32);
	public static BlockTexture lava_5 = new BlockTexture(TextureSheet.lava, 1, 1, 32);
	public static BlockTexture lava_6 = new BlockTexture(TextureSheet.lava, 2, 1, 32);

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
