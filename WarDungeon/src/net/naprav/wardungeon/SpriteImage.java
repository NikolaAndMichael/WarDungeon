package net.naprav.wardungeon;

public class SpriteImage {

	public final int WIDTH;
	public final int HEIGHT;
	public int x, y;
	public int[] allPixels;
	private ImageSheet sheet;
	
	public static SpriteImage stone = new SpriteImage(ImageSheet.block, 0, 0, 32, 32);
	public static SpriteImage stonebrick = new SpriteImage(ImageSheet.block, 1, 0, 32, 32);
	public static SpriteImage mossystonebrick = new SpriteImage(ImageSheet.block, 2, 0, 32, 32);
	public static SpriteImage stonebrick_wall = new SpriteImage(ImageSheet.block, 3, 0, 32, 32);
	public static SpriteImage cobblestone = new SpriteImage(ImageSheet.block, 4, 0, 32, 32);
	
	public static SpriteImage logo = new SpriteImage(ImageSheet.company_logo, 0, 0, 900, 600);

    public SpriteImage(ImageSheet sheet, int x, int y, int width, int height) {
		this.WIDTH = width;
		this.HEIGHT = height;
		allPixels = new int[WIDTH * HEIGHT];
		
		this.x = x * 32;
		this.y = y * 32;
		this.sheet = sheet;
		
		this.loadSpriteToScreen();
	}
	
	public void loadSpriteToScreen() {
		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				allPixels[x + y * WIDTH] = sheet.allPixels[(this.x + x) + (this.y + y) * sheet.WIDTH]; 
			}
		}
	}
}
