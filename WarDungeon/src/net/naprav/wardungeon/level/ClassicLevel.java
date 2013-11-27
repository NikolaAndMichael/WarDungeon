package net.naprav.wardungeon.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ClassicLevel extends Level {

	public ClassicLevel(String pathway, int width, int height, int xSpawn, int ySpawn) {
		super(pathway, width, height, xSpawn, ySpawn);
	}

	public static Level floor_1 = new ClassicLevel("/level/classic/floor1.png", 160, 160, 79, 159);
	
	public void loadLevel(String pathway) {
		try {
			BufferedImage image = ImageIO.read(Level.class.getResource(pathway));
			blocks = new int[width * width];

			image.getRGB(0, 0, width, height, blocks, 0, width);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}
}
