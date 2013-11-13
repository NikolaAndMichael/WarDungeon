package net.naprav.wardungeon.graphics;

public class ClassTexture {

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
	public ClassTexture(TextureSheet sheet, int x, int y, int size) {
		SIZE = size;
		this.x = x * 48;
		this.y = y * 48;
		this.sheet = sheet;

		pixels = new int[SIZE * SIZE];
		loadPlayer();
	}

	public static ClassTexture knight_south = new ClassTexture(TextureSheet.knight, 0, 0, 64);
	public static ClassTexture knight_north = new ClassTexture(TextureSheet.knight, 1, 0, 64);
	public static ClassTexture knight_east = new ClassTexture(TextureSheet.knight, 2, 0, 64);
	public static ClassTexture knight_west = new ClassTexture(TextureSheet.knight, 3, 0, 64);
	
	public static ClassTexture wizard_south = new ClassTexture(TextureSheet.wizard, 0, 0, 64);
	public static ClassTexture wizard_north = new ClassTexture(TextureSheet.wizard, 1, 0, 64);
	public static ClassTexture wizard_east = new ClassTexture(TextureSheet.wizard, 2, 0, 64);
	public static ClassTexture wizard_west = new ClassTexture(TextureSheet.wizard, 3, 0, 64);
	
	public static ClassTexture archer_south = new ClassTexture(TextureSheet.archer, 0, 0, 64);
	public static ClassTexture archer_north = new ClassTexture(TextureSheet.archer, 1, 0, 64);
	public static ClassTexture archer_east = new ClassTexture(TextureSheet.archer, 2, 0, 64);
	public static ClassTexture archer_west = new ClassTexture(TextureSheet.archer, 3, 0, 64);

	/**
	 * Method for loading the player to the pixels[] array.
	 */
	private final void loadPlayer() {
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				pixels[x + (y * SIZE)] = sheet.pixels[(this.x + x) + (this.y + y) * sheet.SIZE];
			}
		}
	}
}
