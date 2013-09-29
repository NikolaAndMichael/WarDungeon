package net.naprav.wardungeon;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageSheet {

	public String pathway;
	public final int WIDTH;
	public final int HEIGHT;
	public int[] allPixels;
	
	public static ImageSheet block = new ImageSheet("/textures/blocks.png", 256, 256);
	public static ImageSheet company_logo = new ImageSheet("/textures/gui/naprav.png", 990, 600);
	
	/**
	 * Sets the path for the image and the size of it too.
	 * @param path
	 * @param size
	 */
	public ImageSheet(String path, int width, int height) {
		this.pathway = path;
		this.WIDTH = width;
		this.HEIGHT = height;
		allPixels = new int[WIDTH * HEIGHT];
		
		this.loadImageToScreen(path, WIDTH, HEIGHT);
	}
	
	/**
	 * Loads the image to the screen using a pathway and the size of the image.
	 * @param pathway
	 * @param size
	 */
	public void loadImageToScreen(String pathway, int width, int height) {
		try {
			BufferedImage image = ImageIO.read(ImageSheet.class.getResource(pathway));
			int w = image.getWidth();
			int h = image.getHeight();
			// Code below explained: Gets the x and y start positions, gets the
			// width/height, sets the values in an array, sets the offset and
			// goes in the direction of the scansize.
			image.getRGB(0, 0, w, h, allPixels, 0, w);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
}
