package net.naprav.wardungeon.gui;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

public class WarDungeonGUI {

	public final int pixels[];
	public final int WIDTH, HEIGHT;

	public WarDungeonGUI(int width, int height) {
		WIDTH = width;
		HEIGHT = height;
		pixels = new int[WIDTH * HEIGHT];
	}

	public static Font warDungeonFont() throws Exception {
		GraphicsEnvironment enviro = GraphicsEnvironment.getLocalGraphicsEnvironment();
		File fontLocation = new File("res/textures/gui/wardungeon_font.png");

		Font dungeon = Font.createFont(Font.TRUETYPE_FONT, fontLocation);
		enviro.registerFont(dungeon);

		return dungeon.deriveFont(Font.PLAIN, 12);
	}
}
