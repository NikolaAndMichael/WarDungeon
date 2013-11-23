package net.naprav.wardungeon.graphics;

import java.awt.image.BufferedImage;

import net.naprav.wardungeon.block.Block;
import net.naprav.wardungeon.player.PlayerClass;

public class Display {

	public final int WIDTH, HEIGHT;
	public int[] pixels;

	public int xOffset, yOffset;
	public int xMove, yMove;

	/**
	 * Sets the screen's width and height to match the pixels[] array in WarDungeon.java
	 * 
	 * @param width
	 * @param height
	 */
	public Display(BufferedImage image) {
		WIDTH = image.getWidth();
		HEIGHT = image.getHeight();
		pixels = new int[WIDTH * HEIGHT];
	}

	/**
	 * Basic method for rendering blocks to the level.
	 * 
	 * @param block
	 * @param xMove
	 * @param yMove
	 */
	public void renderBlock(Block block, int xMove, int yMove) {
		xMove -= xOffset;
		yMove -= yOffset;

		for (int x = 0; x < block.sprite.SIZE; x++) {
			int xPos = x + xMove;
			for (int y = 0; y < block.sprite.SIZE; y++) {
				int yPos = y + yMove;
				if (xPos < 0 || yPos < 0 || xPos >= WIDTH || yPos >= HEIGHT) continue;

				pixels[xPos + (yPos * WIDTH)] = block.sprite.pixels[x + (y * block.sprite.SIZE)];
			}
		}
	}

	public void setBlockOffset(int xOff, int yOff) {
		xOffset = xOff;
		yOffset = yOff;
	}

	/**
	 * The standard method for rendering the player class to the screen.
	 * 
	 * @param player
	 * @param xMove
	 * @param yMove
	 */
	public void renderPlayer(PlayerClass player, int xMove, int yMove) {
		for (int x = 0; x < 48; x++) {
			int xPos = x + xMove;
			for (int y = 0; y < 48; y++) {
				int yPos = y + yMove;

				int colour = player.sprite.pixels[x + y * 64];
				if (colour != 0x000000) pixels[xPos + yPos * WIDTH] = colour;
			}
		}
	}

	/**
	 * Method for option the pixels in this class to the one in WarDungeon.java.
	 * 
	 * @param screen
	 */
	public void alignPixels(int[] screen) {
		for (int a = 0; a < screen.length; a++) {
			if (screen.length == pixels.length) {
				screen[a] = pixels[a];
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
