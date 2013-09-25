package net.naprav.wardungeon;

public class RenderMechanism {

	private int width, height;
	public int[] allPixels;
	
	public RenderMechanism(int width, int height) {
		this.width = width;
		this.height = height;
		allPixels = new int[width * height];
	}
	
	public void renderStuffs() {
		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y++) {
				allPixels[y + (x * height)] = 0x23CF8A;
			} 
		}
	}
}
