package net.naprav.wardungeon.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import net.naprav.wardungeon.block.Block;
import net.naprav.wardungeon.gui.WScreen;
import net.naprav.wardungeon.gui.button.WButton;
import net.naprav.wardungeon.player.PlayerClass;

public class Display {

	public final int WIDTH, HEIGHT;
	public int[] pixels;

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
		xMove += xOffset;
		yMove += yOffset;

		for (int x = 0; x < WIDTH; x++) {
			int xPos = x + xMove;
			for (int y = 0; y < HEIGHT; y++) {
				int yPos = y + yMove;

				if (xPos < 0 || yPos < 0 || xPos >= WIDTH || yPos >= HEIGHT) continue;
				int index = (x & 31) + (y & 31) * 32;
				pixels[xPos + (yPos * WIDTH)] = block.sprite.pixels[index];
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
				if (xPos < 0 || yPos < 0 || xPos >= WIDTH || yPos >= HEIGHT) continue;
				int colour = player.sprite.pixels[x + y * 64];
				if (colour != 0x000000) pixels[xPos + yPos * WIDTH] = colour;
			}
		}
	}

	/**
	 * Method for setting the pixels in this class to the one in WarDungeon.java.
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
	 * Method for rendering the company logo!
	 */
	public final void renderNaprav(Canvas canvas) {
		WScreen naprav = new WScreen("/textures/gui/screen/naprav.png", 460, 280);
		Graphics gfx = canvas.getGraphics();

		gfx.drawImage(naprav.image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		gfx.dispose();
	}

	/**
	 * Method for rendering the menu!
	 * 
	 * @param canvas
	 */
	public final void renderMenu(Canvas canvas) {
		WButton enter = new WButton("/textures/gui/button/standard/enter.png", 150, 75); // Scaled up by two!
		WButton quit = new WButton("/textures/gui/button/standard/quit.png", 150, 75);
		WButton credits = new WButton("/textures/gui/button/standard/credit.png", 150, 75);
		WButton settings = new WButton("/textures/gui/button/standard/setting.png", 150, 75);
		
		WScreen background = new WScreen("/textures/gui/screen/background_title.png", 460, 280);

		int width = enter.WIDTH, height = enter.HEIGHT;
		
		BufferStrategy buffer = canvas.getBufferStrategy();
		Graphics gfx = buffer.getDrawGraphics();

		// Drawing the title screen.
		gfx.drawImage(background.image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		
		// Drawing enter and quit.
		gfx.drawImage(enter.image, 65, 300, width, height, null);
		gfx.drawImage(quit.image, canvas.getWidth() - (width + 65), 300, width, height, null);
	
		// Drawing the options and credits.
		gfx.drawImage(settings.image, 230, 450, width, height, null);
		gfx.drawImage(credits.image, canvas.getWidth() - (width + 230), 450, width, height, null);

		gfx.dispose();
		buffer.show();
	}

	/**
	 * Method for rendering the credits.
	 */
	public final void renderCredits(Canvas canvas) {
		WButton back = new WButton("/textures/gui/button/standard/return.png", 150, 75);
		
		WScreen background = new WScreen("/textures/gui/screen/background.png", 460, 280);

		int width = back.WIDTH, height = back.HEIGHT;
		
		BufferStrategy buffer = canvas.getBufferStrategy();
		Graphics gfx = buffer.getDrawGraphics();

		// Drawing the title screen.
		gfx.drawImage(background.image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		
		// Drawing return.
		gfx.drawImage(back.image, canvas.getWidth() / 2 - (width / 2), 450, width, height, null);
	
		gfx.dispose();
		buffer.show();
	}

	/**
	 * Method for rendering the options.
	 */
	public final void renderOptions(Canvas canvas) {
		WButton apply = new WButton("/textures/gui/button/standard/ok.png", 150, 75); // Scaled up by two!
		WButton back = new WButton("/textures/gui/button/standard/return.png", 150, 75);
		
		WScreen background = new WScreen("/textures/gui/screen/background.png", 460, 280);

		int width = apply.WIDTH, height = apply.HEIGHT;
		
		BufferStrategy buffer = canvas.getBufferStrategy();
		Graphics gfx = buffer.getDrawGraphics();

		// Drawing the title screen.
		gfx.drawImage(background.image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		
		// Drawing apply and return.
		gfx.drawImage(apply.image, 65, 450, width, height, null);
		gfx.drawImage(back.image, canvas.getWidth() - (width + 65), 450, width, height, null);
	
		gfx.dispose();
		buffer.show();
	}

	/**
	 * Method for rendering the class selection screen!
	 * 
	 * @param canvas
	 */
	public final void renderClassSelect(Canvas canvas) {
		WButton enter = new WButton("/textures/gui/button/standard/enter.png", 150, 75); // Scaled up by two!
		WButton quit = new WButton("/textures/gui/button/standard/quit.png", 150, 75);
		WButton credits = new WButton("/textures/gui/button/standard/credit.png", 150, 75);
		WButton settings = new WButton("/textures/gui/button/standard/setting.png", 150, 75);
		
		WScreen background = new WScreen("/textures/gui/screen/background_title.png", 460, 280);

		int width = enter.WIDTH, height = enter.HEIGHT;
		
		BufferStrategy buffer = canvas.getBufferStrategy();
		Graphics gfx = buffer.getDrawGraphics();

		// Drawing the title screen.
		gfx.drawImage(background.image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		
		// Drawing enter and quit.
		gfx.drawImage(enter.image, 65, 300, width, height, null);
		gfx.drawImage(quit.image, canvas.getWidth() - (width + 65), 300, width, height, null);
	
		// Drawing the options and credits.
		gfx.drawImage(settings.image, 230, 450, width, height, null);
		gfx.drawImage(credits.image, canvas.getWidth() - (width + 230), 450, width, height, null);

		gfx.dispose();
		buffer.show();
	}

	/**
	 * Method for rendering the level selection!
	 * 
	 * @param canvas
	 */
	public final void renderLevelSelect(Canvas canvas) {
		WButton enter = new WButton("/textures/gui/button/standard/enter.png", 150, 75); // Scaled up by two!
		WButton quit = new WButton("/textures/gui/button/standard/quit.png", 150, 75);
		WButton credits = new WButton("/textures/gui/button/standard/credit.png", 150, 75);
		WButton settings = new WButton("/textures/gui/button/standard/setting.png", 150, 75);
		
		WScreen background = new WScreen("/textures/gui/screen/background_title.png", 460, 280);

		int width = enter.WIDTH, height = enter.HEIGHT;
		
		BufferStrategy buffer = canvas.getBufferStrategy();
		Graphics gfx = buffer.getDrawGraphics();

		// Drawing the title screen.
		gfx.drawImage(background.image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		
		// Drawing enter and quit.
		gfx.drawImage(enter.image, 65, 300, width, height, null);
		gfx.drawImage(quit.image, canvas.getWidth() - (width + 65), 300, width, height, null);
	
		// Drawing the options and credits.
		gfx.drawImage(settings.image, 230, 450, width, height, null);
		gfx.drawImage(credits.image, canvas.getWidth() - (width + 230), 450, width, height, null);

		gfx.dispose();
		buffer.show();
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
