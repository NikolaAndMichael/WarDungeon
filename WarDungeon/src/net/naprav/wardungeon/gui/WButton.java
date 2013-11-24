package net.naprav.wardungeon.gui;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WButton extends WarDungeonGUI {

	/* Default WButton size should by 150 x 75 pixels! */
	public BufferedImage image;
	
	public WButton(String pathway, int width, int height) {
		super(width, height);
		loadButton(pathway);
	}
	
	private final void loadButton(String pathway) {
		try {
			image = ImageIO.read(WarDungeonGUI.class.getResource(pathway));
			int width = image.getWidth(), height = image.getHeight();
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
}
