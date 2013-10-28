package net.naprav.wardungeon.graphics;

public class ClassSprite {

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
	public ClassSprite(SpriteSheet sheet, int x, int y, int size) {
		SIZE = size;
		this.x = x * 48;
		this.y = y * 48;
		this.sheet = sheet;

		pixels = new int[SIZE * SIZE];
		loadPlayer();
	}

	public static ClassSprite knight_south = new ClassSprite(SpriteSheet.knight, 0, 0, 64);
	public static ClassSprite knight_north = new ClassSprite(SpriteSheet.knight, 1, 0, 64);
	public static ClassSprite knight_east = new ClassSprite(SpriteSheet.knight, 2, 0, 64);
	public static ClassSprite knight_west = new ClassSprite(SpriteSheet.knight, 3, 0, 64);
	
	public static ClassSprite wizard_south = new ClassSprite(SpriteSheet.wizard, 0, 0, 64);
	public static ClassSprite wizard_north = new ClassSprite(SpriteSheet.wizard, 1, 0, 64);
	public static ClassSprite wizard_east = new ClassSprite(SpriteSheet.wizard, 2, 0, 64);
	public static ClassSprite wizard_west = new ClassSprite(SpriteSheet.wizard, 3, 0, 64);
	
	public static ClassSprite archer_south = new ClassSprite(SpriteSheet.archer, 0, 0, 64);
	public static ClassSprite archer_north = new ClassSprite(SpriteSheet.archer, 1, 0, 64);
	public static ClassSprite archer_east = new ClassSprite(SpriteSheet.archer, 2, 0, 64);
	public static ClassSprite archer_west = new ClassSprite(SpriteSheet.archer, 3, 0, 64);

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
