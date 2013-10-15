package net.naprav.wardungeon.level;

import net.naprav.wardungeon.graphics.Display;

public class LevelTemplate {

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
	}
}
