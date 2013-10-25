package net.naprav.wardungeon.gui;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Menu {

	private final int WIDTH, HEIGHT;
	public int[] pixels;
	
	public Menu(String pathway, int width, int height) {
		WIDTH = width;
		HEIGHT = height;
		
		pixels = new int[WIDTH * HEIGHT];
		try {
			loadMenu(pathway);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}

	private final void loadMenu(String pathway) throws IOException {
		BufferedImage menu = ImageIO.read(Menu.class.getResource(pathway));
		int width = menu.getWidth(), height = menu.getHeight();
		if (WIDTH == width && HEIGHT == height) {
			menu.getRGB(0, 0, width, height, pixels, 0, width);
		} else {
			System.out.println("Menu is not same size as declared! >:(");
		}
	}
}
