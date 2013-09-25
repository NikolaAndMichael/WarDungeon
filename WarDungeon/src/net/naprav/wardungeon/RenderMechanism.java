package net.naprav.wardungeon;

public class RenderMechanism {

	private int width, height;
	public int[] allPixels;
	
	/**
	 * The constructor for the RenderMechanism class.
	 * @param width
	 * @param height
	 */
	public RenderMechanism(int width, int height) {
		this.width = width;
		this.height = height;
		allPixels = new int[width * height];
	}
	
	/**
	 * Setting the pixel data equal to something!
	 */
	public void renderStuffs(int xCoord, int yCoord) {
		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y++) {
				allPixels[xCoord + (yCoord * width)] = 0x23CF8A;
			} 
		}
	}
	
	public void clearScreen() {
		for (int counter = 0; counter < allPixels.length; counter++) {
			allPixels[counter] = 0x000000;
		}
	}
}
