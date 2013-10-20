package net.naprav.wardungeon.graphics;

import net.naprav.wardungeon.block.Block;

public class Display {

	private final int WIDTH, HEIGHT;
	public int[] pixels;

	private final int BLOCK_SIZE = 32;
	private final int BLOCK_MASK = BLOCK_SIZE - 1;
	
	/**
	 * Sets the screen's width and height to match the pixels[] array in WarDungeon.java
	 * 
	 * @param width
	 * @param height
	 */
	public Display(int width, int height) {
		WIDTH = width;
		HEIGHT = height;
		pixels = new int[WIDTH * HEIGHT];

		for (int a = 0; a < pixels.length; a++) {
			pixels[a] = 0x000000;
		}
	}

	/**
	 * Basic model for rendering images to the screen.
	 */
	// public void render() {
	// for (int x = 0; x < WIDTH; x++) {
	// for (int y = 0; y < HEIGHT; y++) {
	// pixels[x + (y * WIDTH)] = 0x123456;
	// }
	// }
	// }

	/**
	 * Basic method for rendering blocks to the level.
	 */
	public void renderBlock(Block block, int xMove, int yMove) {
		for (int x = 0; x < WIDTH; x++) {
			int xPos = x + xMove;
			for (int y = 0; y < HEIGHT; y++) {
				int yPos = y + yMove;
				if (xPos < 0 || yPos < 0 || xPos >= WIDTH || yPos >= HEIGHT) continue;
				
				int index = (x & BLOCK_MASK) + (y & BLOCK_MASK) * BLOCK_SIZE;
				pixels[xPos + (yPos * WIDTH)] = block.sprite.pixels[index];
			}
		}
	}

	/**
	 * Clear's the screen to update it constantly.
	 */
	public void clear() {
		for (int a = 0; a < pixels.length; a++) {
			pixels[a] = 0x000000;
			// Do note that you can place this method at the top of the render() method, otherwise, run it in WarDungeon.java
		}
	}
}
