package net.naprav.wardungeon.level;

import net.naprav.wardungeon.RenderSystem;

public class Level {

	private int width, height;
	private int[] blocks;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		blocks = new int[width * height];
		this.generateRandomLevel();
	}
	
	public Level(String pathway) {
		this.loadLevelToGame(pathway);
	}
	
	public void generateRandomLevel() {
		
	}
	
	public void loadLevelToGame(String pathway) {
		
	}
	
	public void setTimeOfLevel() {
		
	}
	
	public void updateLevel() {
		
	}
	
	public void renderLevel(int scrollX, int scrollY, RenderSystem mech) {
		int x0 = scrollX / 32;
		int x1 = scrollX + mech.width / 32;
		int y0 = scrollY / 32;
		int y1 = scrollY + mech.width / 32;
	}
}
