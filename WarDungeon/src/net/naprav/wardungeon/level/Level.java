package net.naprav.wardungeon.level;

import net.naprav.wardungeon.block.Block;
import net.naprav.wardungeon.block.EmptyBlock;
import net.naprav.wardungeon.block.IceStoneBrickBlock;
import net.naprav.wardungeon.block.LavaBlock;
import net.naprav.wardungeon.block.StoneBlock;
import net.naprav.wardungeon.block.StoneBrickBlock;
import net.naprav.wardungeon.graphics.Display;

public class Level {

	protected int width, height;
	protected int[] blocks;

	/**
	 * The default constructor for all levels. It's important because it's needed to access the level's location.
	 * 
	 * @param pathway
	 */
	public Level(String pathway, int size) {
		width = size;
		height = size;
		blocks = new int[width * height];
		
		loadLevel(pathway);
		generateLevel();
	}

	/**
	 * Generation of a random level. (EXPERIMENTAL!)
	 * 
	 * @param width
	 * @param height
	 */
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		blocks = new int[width * height];
		
		generateLevel();
	}

	public static Level classic = new ClassicLevel("/level/classic/floor1.png", 64);
	public static Level survival = new SurvivalLevel(256, 256);

	/**
	 * Loads the level from a file.
	 * 
	 * @param pathway
	 */
	protected void loadLevel(String pathway) {
	}

	/**
	 * Generates the level, (free open-roam for future!)
	 * 
	 * @param width
	 * @param height
	 */
	protected void generateLevel() {
	}

	/**
	 * Setting the time of the level can affect how well and how fun it is. This method does that.
	 */
	protected void setTime() {
	}

	/**
	 * Responsible for updating the logic behind the level. Any things that occur are done here.
	 */
	protected void tick() {
	}

	/**
	 * Responsible for rendering the level to Display.java, the class in charge of all rendering.
	 * 
	 * @param xOffset
	 * @param yOffset
	 * @param display
	 */
	public void render(int xOffset, int yOffset, Display display) {
		display.setBlockOffset(xOffset, yOffset);

		int block_size = 32;

		int x0 = xOffset / block_size;
		int x1 = (xOffset + display.WIDTH + block_size) / block_size;
		int y0 = yOffset / block_size;
		int y1 = (yOffset + display.HEIGHT + block_size) / block_size;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				if (blocks[x + (y * width)] == -16777216) System.out.println("Ice!");
				if (blocks[x + (y * width)] == -6361601) System.out.println("StoneBrick!");
				getBlock(x, y).render(x, y, display);
			}
		}
	}

	public Block getBlock(int xPos, int yPos) {
		if (xPos < 0 || xPos >= width || yPos < 0 || yPos >= height) return EmptyBlock.block;

		if (blocks[xPos + (yPos * width)] == -6361601) return StoneBrickBlock.block;
		//if (blocks[xPos + (yPos * width)] == 0x9EEDFF) return StoneBlock.block;
		//if (blocks[xPos + (yPos * width)] == 2) return LavaBlock.block;
		if (blocks[xPos + (yPos * width)] == -16777216) return IceStoneBrickBlock.block;

		return EmptyBlock.block;
	}
}
