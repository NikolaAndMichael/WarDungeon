package net.naprav.wardungeon;

import java.util.Random;

public class RenderSystem {

	private int width, height;
	public int[] allPixels;

	public int[] block = new int[64 * 64];
	public int blockSize = 16;
	private Random random = new Random();

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

		for (int i = 0; i < block.length; i++) {
			block[i] = random.nextInt(0xFFFFFF);
		}
	}

	/**
	 * Setting the pixel data equal to something!
	 */
	public void changePixels(int offsetX, int offsetY) {
		for (int x = 0; x < this.width; x++) {
			int xMove = x + offsetX;
			for (int y = 0; y < this.height; y++) {
				int yMove = y + offsetY;
				// The "& 63" refers to when we get to 63, go back to 0, thus
				// looping.
				int blockIndex = ((xMove / blockSize) & 63)
						+ ((yMove / blockSize) & 63) * 64;
				allPixels[x + (y * width)] = block[blockIndex];
			}
		}
	}

	public void clearScreen() {
		for (int counter = 0; counter < allPixels.length; counter++) {
			allPixels[counter] = 0x000000;
		}
	}
}
