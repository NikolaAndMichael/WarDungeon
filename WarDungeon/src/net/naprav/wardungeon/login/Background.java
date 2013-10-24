package net.naprav.wardungeon.login;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {

	private final int WIDTH, HEIGHT;
	public int[] pixels;
	
	public Background(int width, int height, String pathway) {
		WIDTH = width;
		HEIGHT = height;
		pixels = new int[WIDTH * HEIGHT];
		
		loadMenuScreen(pathway);
	} 
	
	private void loadMenuScreen(String pathway) {
		try {
			BufferedImage image = ImageIO.read(Background.class.getResource(pathway));
			int width = image.getWidth();
			int height = image.getHeight();
			if (WIDTH == width && HEIGHT == height) {
				image.getRGB(0, 0, width, height, pixels, 0, width);
			} else {
				System.out.println("Menu Screen is not the same size as declared! >:(");
			}
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
}