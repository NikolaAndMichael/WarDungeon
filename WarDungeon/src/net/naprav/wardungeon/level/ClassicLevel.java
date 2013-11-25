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
	
	/**
	 * Method used for generating the level. Should override the one in Level.java
	 */
	public void generateLevel() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				blocks[x + (y * width)] = pixels[x + (y * width)];
				
				if (blocks[x + (y * width)] == -8421505) blocks[x + (y * width)] = 0x7F7F7F; // Stone
				if (blocks[x + (y * width)] == -11776948) blocks[x + (y * width)] = 0x4C4C4C; // StoneBrick
				if (blocks[x + (y * width)] == -39613) blocks[x + (y * width)] = 0xFF6543; // Lava
				if (blocks[x + (y * width)] == -6250336) blocks[x + (y * width)] = 0xA0A0A0; // CobbleStone
				if (blocks[x + (y * width)] == -13536718) blocks[x + (y * width)] = 0x317232; // MossBrick
				if (blocks[x + (y * width)] == -3215105) blocks[x + (y * width)] = 0xCEF0FF; // IceBrick
			}
		}
	}
}
