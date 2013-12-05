package net.naprav.wardungeon.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import net.naprav.wardungeon.graphics.Display;
import net.naprav.wardungeon.login.file.Server;

public class UIRender {

	/**
	 * Method for rendering the company logo!
	 */
	public static void renderNaprav(Canvas canvas) {
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
	public static void renderMenu(Canvas canvas) {
		WButton begin = new WButton("/textures/gui/button/standard/begin.png", 150, 75); // Scaled up by two!
		WButton quit = new WButton("/textures/gui/button/standard/quit.png", 150, 75);
		WButton credits = new WButton("/textures/gui/button/standard/credit.png", 150, 75);
		WButton options = new WButton("/textures/gui/button/standard/option.png", 150, 75);

		WScreen background = new WScreen("/textures/gui/screen/background_title.png", 460, 280);

		int width = begin.WIDTH, height = begin.HEIGHT;

		BufferStrategy buffer = canvas.getBufferStrategy();
		Graphics gfx = buffer.getDrawGraphics();

		// Drawing the title screen.
		gfx.drawImage(background.image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);

		// Drawing begin and quit.
		gfx.drawImage(begin.image, 65, 300, width, height, null);
		gfx.drawImage(quit.image, canvas.getWidth() - (width + 65), 300, width, height, null);

		// Drawing the options and credits.
		gfx.drawImage(options.image, 230, 450, width, height, null);
		gfx.drawImage(credits.image, canvas.getWidth() - (width + 230), 450, width, height, null);

		gfx.dispose();
		buffer.show();
	}

	/**
	 * Method for rendering the credits.
	 */
	public static void renderCredits(Canvas canvas) {
		WButton back = new WButton("/textures/gui/button/standard/return.png", 150, 75);
		WScreen credits = new WScreen("/textures/gui/screen/background.png", 460, 280);

		int width = back.WIDTH, height = back.HEIGHT;

		BufferStrategy buffer = canvas.getBufferStrategy();
		Graphics gfx = buffer.getDrawGraphics();

		// Drawing the background.
		gfx.drawImage(credits.image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		// Drawing return.
		gfx.drawImage(back.image, canvas.getWidth() / 2 - (width / 2), 450, width, height, null);

		gfx.setColor(Color.WHITE);
		gfx.setFont(WarDungeonGUI.warDungeonFontLarge());

		gfx.drawString(Server.credits, 50, 50 + 50);
		gfx.drawString(Server.credits_2, 50, 85 + 50);
		gfx.drawString(Server.credits_3, 50, 120 + 50);
		gfx.drawString(Server.credits_4, 50, 155 + 50);
		gfx.drawString(Server.credits_5, 50, 190 + 50);
		gfx.drawString(Server.credits_6, 50, 225 + 50);
		gfx.drawString(Server.credits_7, 50, 260 + 50);
		gfx.drawString(Server.credits_8, 50, 295 + 50);

		gfx.dispose();
		buffer.show();
	}

	/**
	 * Method for rendering the options.
	 */
	public static void renderOptions(Canvas canvas) {
		WButton apply = new WButton("/textures/gui/button/standard/okay.png", 150, 75); // Scaled up by two!
		WButton back = new WButton("/textures/gui/button/standard/return.png", 150, 75);

		WScreen background = new WScreen("/textures/gui/screen/background.png", 460, 280);

		int width = apply.WIDTH, height = apply.HEIGHT;

		BufferStrategy buffer = canvas.getBufferStrategy();
		Graphics gfx = buffer.getDrawGraphics();

		// Drawing the background.
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
	public static void renderClassSelect(Canvas canvas) {
		WButton okay = new WButton("/textures/gui/button/standard/okay.png", 150, 75); // Scaled up by two!
		WButton back = new WButton("/textures/gui/button/standard/return.png", 150, 75);

		WScreen classes = new WScreen("/textures/gui/screen/background_class.png", 460, 280);

		int width = okay.WIDTH, height = okay.HEIGHT;

		BufferStrategy buffer = canvas.getBufferStrategy();
		Graphics gfx = buffer.getDrawGraphics();

		// Drawing the background.
		gfx.drawImage(classes.image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);

		// Drawing the selection buttons.

		// Drawing begin and return.
		gfx.drawImage(back.image, 65, 450, width, height, null);
		gfx.drawImage(okay.image, canvas.getWidth() - (width + 65), 450, width, height, null);

		gfx.dispose();
		buffer.show();
	}

	/**
	 * Method for rendering the level selection!
	 * 
	 * @param canvas
	 */
	public static void renderLevelSelect(Canvas canvas) {
		WButton okay = new WButton("/textures/gui/button/standard/okay.png", 150, 75); // Scaled up by two!
		WButton back = new WButton("/textures/gui/button/standard/return.png", 150, 75);

		WScreen background = new WScreen("/textures/gui/screen/background_level.png", 460, 280);

		int width = okay.WIDTH, height = okay.HEIGHT;

		BufferStrategy buffer = canvas.getBufferStrategy();
		Graphics gfx = buffer.getDrawGraphics();

		// Drawing the level selection screen.
		gfx.drawImage(background.image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);

		// Drawing okay and return.
		gfx.drawImage(back.image, 65, 450, width, height, null);
		gfx.drawImage(okay.image, canvas.getWidth() - (width + 65), 450, width, height, null);

		gfx.dispose();
		buffer.show();
	}

	public static void renderEscapeMenu(Canvas canvas) {
		WButton back = new WButton("/textures/gui/button/standard/return.png", 150, 75); // Scaled up by two!
		WButton option = new WButton("/textures/gui/button/standard/option.png", 150, 75); // Scaled up by two!
		WButton quit = new WButton("/textures/gui/button/standard/quit.png", 150, 75);

		int width = back.WIDTH, height = back.HEIGHT;

		WScreen menu = new WScreen("/textures/gui/screen/background_ingame.png", 460, 280);

		BufferStrategy buffer = canvas.getBufferStrategy();
		Graphics gfx = buffer.getDrawGraphics();

		// Drawing the ingame menu.
		gfx.drawImage(menu.image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);

		// Drawing the buttons to return, change settings, and quit the game.
		gfx.drawImage(back.image, 250, 100, width, height, null);
		gfx.drawImage(option.image, 250, 200, width, height, null);
		gfx.drawImage(quit.image, 250, 300, width, height, null);

		gfx.dispose();
		buffer.show();
	}

	/**
	 * Too much rage quitting, please work on this junk afterwards.
	 * 
	 * @param canvas
	 */
	public static void renderPlayerBar(int[] screen, Display display) {
		WScreen bar = new WScreen("/textures/gui/in-game/player_bar.png", 100, 50);

		int width = bar.getWidth(), height = bar.getHeight();
		// int yPos = display.HEIGHT - height;

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int index = x + (y * display.WIDTH), barIndex = x + (y * width);
				if (barIndex < 5000) {
					screen[index] = bar.pixels[barIndex];
				}
			}
		}
	}
}
