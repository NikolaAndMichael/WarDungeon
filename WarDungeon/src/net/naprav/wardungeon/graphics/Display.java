package net.naprav.wardungeon.graphics;

import java.awt.image.BufferedImage;

import net.naprav.wardungeon.block.Block;
import net.naprav.wardungeon.gui.UIRender;
import net.naprav.wardungeon.mob.Mob;
import net.naprav.wardungeon.player.PlayerClass;

public class Display {

	/* Basic integers for the game. The pixels[] array is equal to WIDTH * HEIGHT, which should normally be 460 * 280. */
	public final int WIDTH, HEIGHT;
	public int[] pixels;

	/* Integers for the offset at which the level must render. */
	public int xOffset, yOffset;

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

	/**
	 * Method for setting the offset of the level render.
	 * 
	 * @param xOff
	 * @param yOff
	 */
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

				int colour = player.texture.pixels[x + (y * 64)];
				if (colour != 0x000000) pixels[xPos + yPos * WIDTH] = colour;
			}
		}
	}
	
	public void renderMob(Mob mob, int xMove, int yMove) {
		for (int x = 0; x < 48; x++) {
			int xPos = x + xMove;
			for (int y = 0; y < 48; y++) {
				int yPos = y + yMove;
				
				int color = mob.texture.pixels[x + (y * 64)];
				if (color != 0x000000) pixels[xPos + (yPos * WIDTH)] = color;
			}
		}
	}

	public void renderBoss() {
		
	}
	
	/**
	 * Method for setting the pixels in this class to the one in WarDungeon.java.
	 * 
	 * @param screen
	 */
	public void alignPixels(int[] screen) {
		//UIRender.renderPlayerBar(pixels, this);
		
		for (int a = 0; a < screen.length; a++) {
			if (screen.length == pixels.length) {
				screen[a] = pixels[a];
			}
		}
	}

	/**
	 * Clears the screen to update it constantly.
	 */
	public void clear() {
		for (int a = 0; a < pixels.length; a++) {
			pixels[a] = 0x000000;
			// Do note that you can place this method at the top of the render() method, otherwise, run it in WarDungeon.java
		}
	}
}
