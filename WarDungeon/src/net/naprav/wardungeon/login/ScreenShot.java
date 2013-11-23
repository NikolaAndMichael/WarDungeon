package net.naprav.wardungeon.login;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenShot {

	// Default should be 654 x 392px.
	public BufferedImage image;

	/**
	 * Main constructor for the screenshot in the login screen.
	 * 
	 * @param width
	 * @param height
	 * @param pathway
	 */
	public ScreenShot(int width, int height, String pathway) {
		loadScreenShot(pathway);
	}

	/**
	 * Method for rendering the screenshot to the pixels[] array.
	 * 
	 * @param pathway
	 */
	private void loadScreenShot(String pathway) {
		try {
			image = ImageIO.read(ScreenShot.class.getResource(pathway));
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
}
