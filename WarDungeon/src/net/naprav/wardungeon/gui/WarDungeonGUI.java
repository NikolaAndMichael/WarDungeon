package net.naprav.wardungeon.gui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class WarDungeonGUI {

	public final int pixels[];
	public final int WIDTH, HEIGHT;

	public static Font dungeon;
	
	public WarDungeonGUI(int width, int height) {
		WIDTH = width;
		HEIGHT = height;
		pixels = new int[WIDTH * HEIGHT];
	}

	public static Font warDungeonFont() {
		GraphicsEnvironment enviro = GraphicsEnvironment.getLocalGraphicsEnvironment();
		File fontLocation = new File("res/textures/gui/wardungeon_font.ttf");
		
		try {
			dungeon= Font.createFont(Font.TRUETYPE_FONT, fontLocation);
			enviro.registerFont(dungeon);
		} catch (FontFormatException | IOException exc) {
			exc.printStackTrace();
			System.out.println("Could not load font!");
		}
		
		return dungeon.deriveFont(Font.PLAIN, 16);
	}
	
	public static Font warDungeonFontLarge() {
		GraphicsEnvironment enviro = GraphicsEnvironment.getLocalGraphicsEnvironment();
		File fontLocation = new File("res/textures/gui/wardungeon_font.ttf");
		
		try {
			dungeon= Font.createFont(Font.TRUETYPE_FONT, fontLocation);
			enviro.registerFont(dungeon);
		} catch (FontFormatException | IOException exc) {
			exc.printStackTrace();
			System.out.println("Could not load font!");
		}
		
		return dungeon.deriveFont(Font.PLAIN, 26);
	}
}
