package net.naprav.wardungeon.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	public final int SIZE;
	public int[] pixels;

	/**
	 * Constructor for the SpriteSheet. We must get the path and the size of the SpriteSheet.
	 * 
	 * @param pathway
	 * @param size
	 */
	public SpriteSheet(String pathway, int size) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];

		try {
			loadSpriteSheet(pathway);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}

	public static SpriteSheet block = new SpriteSheet("/textures/block/blocks_sheet.png", 256);
	public static SpriteSheet lava = new SpriteSheet("/textures/block/lava_flow.png", 96);
	
	public static SpriteSheet player = new SpriteSheet("/textures/mob/player/class_sheet.png", 432);
	
	/**
	 * This protected method helps to load the SpriteSheet's data into the pixels[] array.
	 * 
	 * @param pathway
	 * @throws IOException
	 */
	protected void loadSpriteSheet(String pathway) throws IOException {
		BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(pathway));
		int width = image.getWidth();
		int height = image.getHeight();
		
		if (width == SIZE && height == SIZE) {
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} else {
			System.out.println("SpriteSheet is not same size! >:(");
		}
	}
}
