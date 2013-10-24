package net.naprav.wardungeon;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Naprav {

	private final int WIDTH, HEIGHT;
	public int[] pixels;
	
	public Naprav(String pathway, int width, int height) {
		WIDTH = width;
		HEIGHT = height;
		
		pixels = new int[WIDTH * HEIGHT];
		try {
			loadLogo(pathway);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
	
	private final void loadLogo(String pathway) throws IOException {
		BufferedImage image = ImageIO.read(Naprav.class.getResource(pathway));
		int width = image.getWidth(), height = image.getHeight();
		if (width == WIDTH && height == HEIGHT) {
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} else {
			System.out.println("Logo's not the same size as declared! >:(");
		}
	}
}
