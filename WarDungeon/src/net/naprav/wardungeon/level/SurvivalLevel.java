package net.naprav.wardungeon.level;

import java.util.Random;

public class SurvivalLevel extends Level {

	private static final Random random = new Random();

	/**
	 * Highly experimental class!
	 * 
	 * @param width
	 * @param height
	 */
	public SurvivalLevel(int width, int height) {
		super(width, height);
	}

	public static Level level = new SurvivalLevel(512, 512);
	
	/**
	 * The overridden method from the superclass to generate a random level using the tiles index.
	 */
	public void generateLevel() {
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				blocks[x + (y * width)] = random.nextInt(4);
			}
		}
	}
}