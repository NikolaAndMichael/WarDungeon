package net.naprav.wardungeon.login;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {

	public BufferedImage image;
	
	/**
	 * Main constructor for background image of Login.
	 * 
	 * @param width
	 * @param height
	 * @param pathway
	 */
	public Background(int width, int height, String pathway) {
		loadMenuScreen(pathway);
	}

	/**
	 * Method for rendering the menu screen.
	 * 
	 * @param pathway
	 */
	private void loadMenuScreen(String pathway) {
		try {
			image = ImageIO.read(Background.class.getResource(pathway));
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
}