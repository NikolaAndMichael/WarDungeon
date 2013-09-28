package net.naprav.wardungeon.block;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Block {

	public String pathway;
	private final int SIZE;
	public int[] allPixels;

	public boolean isCollidable;
	public boolean doesKill;
	
	public Block(String pathway, int size, boolean isCollidable, boolean doesKill) {
		this.pathway = pathway;
		this.SIZE = size;
		allPixels = new int[SIZE * SIZE];
		
		this.setDoesKill(doesKill);
		this.setIsCollidable(isCollidable);
	}

	public void loadImageToScreen() {
		try {
			BufferedImage image = ImageIO.read(Block.class.getResource(pathway));
			int width = image.getWidth();
			int height = image.getHeight();
			// Code below explained: Gets the x and y start positions, gets the
			// width/height, sets the values in an array, sets the offset and
			// goes in the direction of the scansize.
			image.getRGB(0, 0, width, height, allPixels, 0, width);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}

	/**
	 * Sets if the block is collidable with entities.
	 * 
	 * @param isCollidable
	 */
	public void setIsCollidable(boolean isCollidable) {
		this.isCollidable = isCollidable;
	}

	/**
	 * Checks to see if the block is collidable with entities.
	 * 
	 * @return
	 */
	public boolean getIsCollidable() {
		return isCollidable;
	}

	/**
	 * Sets if the block harms entities.
	 * 
	 * @param doesKill
	 */
	public void setDoesKill(boolean doesKill) {
		this.doesKill = doesKill;
	}

	/**
	 * Checks to see if the block harms entities.
	 * 
	 * @return
	 */
	public boolean getDoesKill() {
		return doesKill;
	}
}