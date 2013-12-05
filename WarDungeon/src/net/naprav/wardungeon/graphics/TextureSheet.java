package net.naprav.wardungeon.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TextureSheet {

	public final int SIZE;
	public int[] pixels;

	/**
	 * Constructor for the TextureSheet. We must get the path and the size of the TextureSheet.
	 * 
	 * @param pathway
	 * @param size
	 */
	public TextureSheet(String pathway, int size) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];

		try {
			loadTextureSheet(pathway);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}

	public static TextureSheet block = new TextureSheet("/textures/block/blocks_sheet.png", 256);
	public static TextureSheet wall = new TextureSheet("/textures/block/wall_sheet.png", 256);
	public static TextureSheet lava = new TextureSheet("/textures/block/lava_flow.png", 96);
	
	public static TextureSheet knight = new TextureSheet("/textures/mob/player/knight_sheet.png", 384);
	public static TextureSheet wizard = new TextureSheet("/textures/mob/player/wizard_sheet.png", 384);
	public static TextureSheet archer = new TextureSheet("/textures/mob/player/archer_sheet.png", 384);
	
	public static TextureSheet ogre = new TextureSheet("/textures/mob/ogre_sheet.png", 384);
	
	/**
	 * This protected method helps to load the TextureSheet's data into the pixels[] array.
	 * 
	 * @param pathway
	 * @throws IOException
	 */
	protected void loadTextureSheet(String pathway) throws IOException {
		BufferedImage image = ImageIO.read(TextureSheet.class.getResource(pathway));
		int width = image.getWidth();
		int height = image.getHeight();
		
		if (width == SIZE && height == SIZE) {
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} else {
			System.out.println("TextureSheet is not same size! >:(");
		}
	}
}
