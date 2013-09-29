package net.naprav.wardungeon;

public class SpriteImage {

	public final int SIZE;
	public int x, y;
	public int[] allPixels;
	private ImageSheet sheet;
	
	public static SpriteImage stonebrick = new SpriteImage(ImageSheet.block, 1, 0, 32);
	
	/**
	 * 
	 * @param sheet
	 * @param x
	 * @param y
	 * @param size
	 */
	public SpriteImage(ImageSheet sheet, int x, int y, int size) {
		this.SIZE = size;
		allPixels = new int[SIZE * SIZE];
		
		this.x = x * 32;
		this.y = y * 32;
		
		this.sheet = sheet;
		
		this.loadSpriteToScreen();
	}
	
	public void loadSpriteToScreen() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				allPixels[x + y * SIZE] = sheet.allPixels[(this.x + x) + (this.y + y) * sheet.SIZE]; 
			}
		}
	}
	
}
