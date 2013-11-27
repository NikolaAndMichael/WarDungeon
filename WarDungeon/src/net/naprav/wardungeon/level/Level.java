package net.naprav.wardungeon.level;

import net.naprav.wardungeon.block.AbyssBlock;
import net.naprav.wardungeon.block.Block;
import net.naprav.wardungeon.block.CobbleStoneBlock;
import net.naprav.wardungeon.block.IceBrickBlock;
import net.naprav.wardungeon.block.LavaBlock;
import net.naprav.wardungeon.block.MossBrickBlock;
import net.naprav.wardungeon.block.StoneBlock;
import net.naprav.wardungeon.block.StoneBrickBlock;
import net.naprav.wardungeon.graphics.Display;

public class Level {

	/* Two integers for the width and height of the level and a blocks[] array to store all the block data. */
	protected int width, height;
	protected int xSpawn, ySpawn;

	protected int[] blocks;

	public static int FLOOR_1 = 1;
	public static int FLOOR_2 = 2;
	public static int FLOOR_3 = 3;
	public static int FLOOR_4 = 4;
	public static int FLOOR_5 = 5;
	public static int FLOOR_6 = 6;
	public static int FLOOR_7 = 7;
	
	public static int FLOOR_BOSS = 8;
	
	/**
	 * The default constructor for all levels. It's important because it's needed to access the level's location.
	 * 
	 * @param pathway
	 */
	public Level(String pathway, int width, int height, int xSpawn, int ySpawn) {
		this.width = width;
		this.height = height;

		this.xSpawn = (int) (xSpawn * 29.5);
		this.ySpawn = (int) (ySpawn * 31.15);

		blocks = new int[width * height];

		loadLevel(pathway);
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
		xOffset += xSpawn;
		yOffset += ySpawn;

		display.setBlockOffset(xOffset, yOffset);

		int block_size = 32;

		int x0 = xOffset / block_size;
		int x1 = (xOffset + display.WIDTH + block_size) / block_size;
		int y0 = yOffset / block_size;
		int y1 = (yOffset + display.HEIGHT + block_size) / block_size;

		// Integers for the center block of the screen.
		// int centerBlockX = x1 / 2;
		// int centerBlockY = y1 / 2;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getBlock(x, y).render(x, y, display);

				// if (getBlock(centerBlockX, centerBlockY) == StoneBlock.block) {
				// System.out.println("We got a stoner here!");
				// }
			}
		}
	}

	/**
	 * Method for returning the block at a certain coordinate.
	 * 
	 * @param xPos
	 * @param yPos
	 * @return
	 */
	public Block getBlock(int xPos, int yPos) {
		if (xPos < 0 || xPos >= width || yPos < 0 || yPos >= height) return AbyssBlock.block;

		/* Checks for standard blocks. */
		if ((blocks[xPos + (yPos * width)] & 0xFFFFFF) == 0x7F7F7F) return StoneBlock.block;
		if ((blocks[xPos + (yPos * width)] & 0xFFFFFF) == 0x4C4C4C) return StoneBrickBlock.block;
		if ((blocks[xPos + (yPos * width)] & 0xFFFFFF) == 0xFF6543) return LavaBlock.block;
		if ((blocks[xPos + (yPos * width)] & 0xFFFFFF) == 0xA0A0A0) return CobbleStoneBlock.block;
		if ((blocks[xPos + (yPos * width)] & 0xFFFFFF) == 0x317232) return MossBrickBlock.block;
		if ((blocks[xPos + (yPos * width)] & 0xFFFFFF) == 0xCEF0FF) return IceBrickBlock.block;

		/* */

		return AbyssBlock.block;
	}
}
