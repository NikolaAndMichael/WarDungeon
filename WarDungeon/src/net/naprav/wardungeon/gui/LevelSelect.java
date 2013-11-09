package net.naprav.wardungeon.gui;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LevelSelect {

	private final int WIDTH, HEIGHT;
	public int[] pixels;
	
	public LevelSelect(String pathway, int width, int height) {
		WIDTH = width;
		HEIGHT = height;
		pixels = new int[WIDTH * HEIGHT];
		
		try {
			loadLevelSelect(pathway);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
	
	private final void loadLevelSelect(String pathway) throws IOException {
		BufferedImage image = ImageIO.read(LevelSelect.class.getResource(pathway));
		int width = image.getWidth(), height = image.getHeight();
		if (WIDTH == width && HEIGHT == height && pathway != null) {
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} else {
			System.out.println("Level Select is either null or not same size as declared!");
		}
	}
}
