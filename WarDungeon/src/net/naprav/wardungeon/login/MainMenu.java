package net.naprav.wardungeon.login;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MainMenu {

	private final int WIDTH, HEIGHT;
	public int[] pixels;
	
	public MainMenu(int width, int height, String pathway) {
		WIDTH = width;
		HEIGHT = height;
		pixels = new int[WIDTH * HEIGHT];
		
		loadMenuScreen(pathway);
	} 
	
	private void loadMenuScreen(String pathway) {
		try {
			BufferedImage image = ImageIO.read(MainMenu.class.getResource(pathway));
			int width = image.getWidth();
			int height = image.getHeight();
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
}