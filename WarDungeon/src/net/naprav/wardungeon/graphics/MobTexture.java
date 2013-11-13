package net.naprav.wardungeon.graphics;

public class MobTexture {

	private int x, y;
	public final int SIZE;
	private TextureSheet sheet;

	public int[] pixels;

	/**
	 * Constructor for creating a class sprite for each class.
	 * 
	 * @param sheet
	 * @param x
	 * @param y
	 * @param size
	 */
	public MobTexture(TextureSheet sheet, int x, int y, int size) {
		SIZE = size;
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;

		pixels = new int[SIZE * SIZE];
		loadPlayer();
	}

	/**
	 * Method for loading the mob to the pixels[] array.
	 */
	private final void loadPlayer() {
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				pixels[x + (y * SIZE)] = sheet.pixels[(this.x + x) + (this.y + y) * sheet.SIZE];
			}
		}
	}
}
