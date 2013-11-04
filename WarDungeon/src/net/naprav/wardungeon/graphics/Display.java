package net.naprav.wardungeon.graphics;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import net.naprav.wardungeon.block.Block;
import net.naprav.wardungeon.gui.Credits;
import net.naprav.wardungeon.gui.LevelSelect;
import net.naprav.wardungeon.gui.Menu;
import net.naprav.wardungeon.gui.Naprav;
import net.naprav.wardungeon.gui.Option;
import net.naprav.wardungeon.gui.Select;
import net.naprav.wardungeon.player.PlayerClass;

public class Display {

	private final int WIDTH, HEIGHT;
	public int[] pixels;

	private final int BLOCK_SIZE = 32;
	private final int BLOCK_MASK = BLOCK_SIZE - 1;

	Menu menu;
	Naprav naprav;
	Option option;
	Credits credit;
	Select select;
	LevelSelect level_select;

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

		naprav = new Naprav("/textures/gui/naprav.png", 460, 280);
		menu = new Menu("/textures/gui/title_screen.png", 460, 280);
		option = new Option("/textures/gui/options.png", 460, 280);
		credit = new Credits("/textures/gui/credits.png", 460, 280);
		select = new Select("/textures/gui/class_selection.png", 460, 280);
		level_select = new LevelSelect("/textures/gui/level_selection.png", 460, 280);
	}

	/**
	 * Basic method for rendering blocks to the level.
	 * 
	 * @param block
	 * @param xMove
	 * @param yMove
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
				if (xPos < 0 || yPos < 0 || xPos >= WIDTH || yPos >= HEIGHT) continue;
				int colour = player.sprite.pixels[x + y * 64];
                if (colour != 0x000000) pixels[xPos + yPos * WIDTH] = colour;
			}
		}
	}

	/**
	 * Method for rendering the main menu GUI.
	 */
	public final void renderMenu(Canvas canvas, BufferedImage image, int[] screen) {
		for (int a = 0; a < pixels.length; a++) {
			screen[a] = menu.pixels[a];
		}

		Graphics gfx = canvas.getGraphics();

		gfx.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		gfx.dispose();
	}


	/**
	 * Method for rendering the company logo!
	 */
	public final void renderNaprav(Canvas canvas, BufferedImage image, int[] screen) {
		for (int a = 0; a < pixels.length; a++) {
			screen[a] = naprav.pixels[a];
		}

		Graphics gfx = canvas.getGraphics();

		gfx.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		gfx.dispose();
	}


	/**
	 * Method for rendering the credits.
	 */
	public final void renderCredits(Canvas canvas, BufferedImage image, int[] screen) {
		for (int a = 0; a < pixels.length; a++) {
			screen[a] = credit.pixels[a];
		}

		Graphics gfx = canvas.getGraphics();

		gfx.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		gfx.dispose();
	}


	/**
	 * Method for rendering the options.
	 */
	public final void renderOptions(Canvas canvas, BufferedImage image, int[] screen) {
		for (int a = 0; a < pixels.length; a++) {
			screen[a] = option.pixels[a];
		}

		Graphics gfx = canvas.getGraphics();

		gfx.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		gfx.dispose();
	}


	public final void renderSelection(Canvas canvas, BufferedImage image, int[] screen) {
		for (int a = 0; a < pixels.length; a++) {
			screen[a] = select.pixels[a];
		}

		Graphics gfx = canvas.getGraphics();

		gfx.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		gfx.dispose();
	}

	public final void renderLevelSelect(Canvas canvas, BufferedImage image, int[] screen) {
		for (int a = 0; a < pixels.length; a++) {
			screen[a] = level_select.pixels[a];
		}

		Graphics gfx = canvas.getGraphics();

		gfx.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		gfx.dispose();
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
