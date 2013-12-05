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

	public static MobTexture ogre_south = new MobTexture(TextureSheet.ogre, 0, 0, 64);
	public static MobTexture ogre_north = new MobTexture(TextureSheet.ogre, 1, 0, 64);
	public static MobTexture ogre_east = new MobTexture(TextureSheet.ogre, 2, 0, 64);
	public static MobTexture ogre_west = new MobTexture(TextureSheet.ogre, 3, 0, 64);
	
	public static MobTexture ogre_south_walk1 = new MobTexture(TextureSheet.ogre, 0, 1, 64);
	public static MobTexture ogre_north_walk1 = new MobTexture(TextureSheet.ogre, 1, 1, 64);
	public static MobTexture ogre_east_walk1 = new MobTexture(TextureSheet.ogre, 2, 1, 64);
	public static MobTexture ogre_west_walk1 = new MobTexture(TextureSheet.ogre, 3, 1, 64);
	
	public static MobTexture ogre_south_walk2 = new MobTexture(TextureSheet.ogre, 0, 2, 64);
	public static MobTexture ogre_north_walk2 = new MobTexture(TextureSheet.ogre, 1, 2, 64);
	public static MobTexture ogre_east_walk2 = new MobTexture(TextureSheet.ogre, 2, 2, 64);
	public static MobTexture ogre_west_walk2 = new MobTexture(TextureSheet.ogre, 3, 2, 64);
	
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
