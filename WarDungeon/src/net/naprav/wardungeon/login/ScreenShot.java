package net.naprav.wardungeon.login;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenShot {

	// Default should be 293 x 162px.
	private final int WIDTH, HEIGHT;
	public int[] splashPixels;
	
	public ScreenShot(int width, int height, String pathway) {
		WIDTH = width;
		HEIGHT = height;
		splashPixels = new int[WIDTH * HEIGHT];
		
		loadScreenShot(pathway);
	}

	private void loadScreenShot(String pathway) {
		try {
			BufferedImage image = ImageIO.read(ScreenShot.class.getResource(pathway));
			int width = image.getWidth();
			int height = image.getHeight();
			if (WIDTH == width && HEIGHT == height) {
				image.getRGB(0, 0, width, height, splashPixels, 0, width);
			} else {
				System.out.println("Screenshot's not the same as declared! >:(");
			}
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
}
