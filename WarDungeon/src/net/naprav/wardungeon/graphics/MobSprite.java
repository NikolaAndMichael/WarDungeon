package net.naprav.wardungeon.graphics;

public class MobSprite {

	private int x, y;
	public final int SIZE;
	private SpriteSheet sheet;

	public int[] pixels;

	/**
	 * Constructor for creating a class sprite for each class.
	 * 
	 * @param sheet
	 * @param x
	 * @param y
	 * @param size
	 */
	public MobSprite(SpriteSheet sheet, int x, int y, int size) {
		SIZE = size;
		this.x = x * 48;
		this.y = y * 48;
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
