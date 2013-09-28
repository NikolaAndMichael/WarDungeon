package net.naprav.wardungeon;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageSheet {

	public String pathway;
	private final int SIZE;
	public int[] allPixels;
	
	public ImageSheet(String path, int size) {
		this.pathway = path;
		this.SIZE = size;
		allPixels = new int[SIZE * SIZE];
	}
	
	public void loadImageToScreen(String pathway, int size) {
		try {
			BufferedImage image = ImageIO.read(ImageSheet.class.getResource(pathway));
			int width = image.getWidth();
			int height = image.getHeight();
			// Code below explained: Gets the x and y start positions, gets the
			// width/height, sets the values in an array, sets the offset and
			// goes in the direction of the scansize.
			image.getRGB(0, 0, width, height, allPixels, 0, width);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
}
