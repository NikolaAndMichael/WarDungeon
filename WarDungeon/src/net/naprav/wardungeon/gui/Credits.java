package net.naprav.wardungeon.gui;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Credits {

	private final int WIDTH, HEIGHT;
	public int[] pixels;

	/**
	 * Main constructor for creating the credits GUI.
	 * 
	 * @param pathway
	 * @param width
	 * @param height
	 */
	public Credits(String pathway, int width, int height) {
		WIDTH = width;
		HEIGHT = height;

		pixels = new int[WIDTH * HEIGHT];
		try {
			loadCredits(pathway);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}

	/**
	 * Method for loading the credits image to the screen.
	 * 
	 * @param pathway
	 * @throws IOException
	 */
	private final void loadCredits(String pathway) throws IOException {
		BufferedImage menu = ImageIO.read(Menu.class.getResource(pathway));
		int width = menu.getWidth(), height = menu.getHeight();
		if (WIDTH == width && HEIGHT == height) {
			menu.getRGB(0, 0, width, height, pixels, 0, width);
		} else {
			System.out.println("Menu is not same size as declared! >:(");
		}
	}
}
