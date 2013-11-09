package net.naprav.wardungeon.level;

import net.naprav.wardungeon.block.Block;
import net.naprav.wardungeon.block.StoneBlock;
import net.naprav.wardungeon.block.StoneBrickBlock;
import net.naprav.wardungeon.graphics.BlockSprite;
import net.naprav.wardungeon.graphics.Display;

public class LevelTemplate {

	protected int width, height;
	protected int[] blocks;
	
	/**
	 * The default constructor for all levels. It's important because it's needed to access the level's location.
	 * 
	 * @param pathway
	 */
	public LevelTemplate(String pathway) {

	}

	/**
	 * Generation of a random level. (EXPERIMENTAL!)
	 * 
	 * @param width
	 * @param height
	 */
	public LevelTemplate(int width, int height) {
		this.width = width;
		this.height = height;
		blocks = new int[width * height];
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
	protected void generateLevel(int width, int height) {
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
	protected void render(int xOffset, int yOffset, Display display) {
		display.setBlockOffset(xOffset, yOffset);
		
		int x0 = xOffset / 16;
		int x1 = (xOffset - display.WIDTH) / 16;
		int y0 = yOffset / 16;
		int y1 = (yOffset - display.HEIGHT) / 16;
		
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				
			}
		}
	}
	
	public Block getBlock(int xPos, int yPos) {
		if (blocks[xPos + (yPos * this.width)] == 0) return new StoneBrickBlock(BlockSprite.stonebrick, false, false);
		return new StoneBlock(BlockSprite.stone, true, false);
	}
}
