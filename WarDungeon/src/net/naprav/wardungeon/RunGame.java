package net.naprav.wardungeon;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import net.naprav.wardungeon.entity.player.ArcherClass;

public class RunGame extends Canvas {
	private static final long serialVersionUID = 1203994186653691379L;

	public static final Dimension size = WindowFrame.size;

	/**
	 * Added the main constructor.
	 */
	public RunGame() {
		this.setSize(size);
		this.setVisible(true);
		this.setBackground(Color.BLACK);
	}

	/**
	 * The Main method.
	 * @param args
	 */
	public static void main(String[] args) {
		WindowFrame window = new WindowFrame("WarDungeon");
	}
}