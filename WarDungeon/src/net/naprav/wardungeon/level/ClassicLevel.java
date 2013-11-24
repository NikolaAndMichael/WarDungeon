package net.naprav.wardungeon.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ClassicLevel extends Level {

	private int[] pixels;
	
	public ClassicLevel(String pathway, int size) {
		super(pathway, size);
	}

	public void loadLevel(String pathway) {
		try {
			BufferedImage image = ImageIO.read(Level.class.getResource(pathway));
			
			int image_width = image.getWidth();
			int image_height = image.getHeight();
			pixels = new int[image_width * image_height];
			
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
	
	public void generateLevel() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				blocks[x + (y * width)] = pixels[x + (y * width)];
				System.out.println(blocks[x + (y * width)]);
			}
		}
	}
}
