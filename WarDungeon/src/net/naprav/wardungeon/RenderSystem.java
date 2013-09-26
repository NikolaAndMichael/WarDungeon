package net.naprav.wardungeon;

public class RenderSystem {

	private int width, height;
	public int[] allPixels;

	/**
	 * The constructor for the RenderMechanism class.
	 * 
	 * @param width
	 * @param height
	 */
	public RenderSystem(int width, int height) {
		this.width = width;
		this.height = height;
		allPixels = new int[width * height];
	}

	/**
	 * Setting the pixel data equal to something!
	 */
	public void changePixels() {
		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y++) {
				allPixels[x + (y * width)] = 0x23CF8A;
			}
		}
	}

	public void clearScreen() {
		for (int counter = 0; counter < allPixels.length; counter++) {
			allPixels[counter] = 0x000000;
		}
	}
}
