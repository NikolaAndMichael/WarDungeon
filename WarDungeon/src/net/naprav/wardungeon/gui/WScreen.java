package net.naprav.wardungeon.gui;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WScreen extends WarDungeonGUI {

	/* Default size should be 460 x 280 pixels! */
	public BufferedImage image;
	
	public WScreen(String pathway, int width, int height) {
		super(width, height);
		loadScreen(pathway);
	}

	private final void loadScreen(String pathway) {
		try {
			image = ImageIO.read(WScreen.class.getResource(pathway));
			int width = image.getWidth(), height = image.getHeight();
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getHeight() {
		return HEIGHT;
	}
}
