package net.naprav.wardungeon.level;

import java.util.Random;

public class SurvivalLevel extends Level {

	private static final Random random = new Random();
	private int randomBlock = 0;

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
				randomBlock = 1 + random.nextInt(3);
				if (randomBlock == 1) {
					randomBlock = 0xFF7F7F7F;
				} else if (randomBlock == 2) {
					randomBlock = 0xFF4C4C4C;
				} else if (randomBlock == 3) {
					randomBlock = 0xFFFF6543;
				}

				blocks[x + (y * width)] = randomBlock;
			}
		}
	}
}