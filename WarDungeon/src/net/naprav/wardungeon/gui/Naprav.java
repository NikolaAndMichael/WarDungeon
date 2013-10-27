package net.naprav.wardungeon.gui;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Naprav {

	private final int WIDTH, HEIGHT;
	public int[] pixels;
	
	/**
	 * Main constructor for creating the Naprav screen.
	 * 
	 * @param pathway
	 * @param width
	 * @param height
	 */
	public Naprav(String pathway, int width, int height) {
		WIDTH = width;
		HEIGHT = height;
		
		pixels = new int[WIDTH * HEIGHT];
		try {
			loadNaprav(pathway);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
	
	/**
	 * Method for loading the Naprav image to the screen.
	 * 
	 * @param pathway
	 * @throws IOException
	 */
	private final void loadNaprav(String pathway) throws IOException {
		BufferedImage image = ImageIO.read(Naprav.class.getResource(pathway));
		int width = image.getWidth(), height = image.getHeight();
		if (width == WIDTH && height == HEIGHT) {
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} else {
			System.out.println("Logo's not the same size as declared! >:(");
		}
	}
}
