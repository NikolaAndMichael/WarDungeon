package net.naprav.wardungeon;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class WindowFrame extends JFrame {
	private static final long serialVersionUID = 1203994186653691379L;

	public static final int WIDTH = 992;
	public static final int HEIGHT = WIDTH / 16 * 10;
	public static final Dimension size = new Dimension(WIDTH, HEIGHT);

	private ImageIcon image;

	RunGame game;

	public WindowFrame(String title) {
		this.setTitle(title);
		this.setSize(size);
		this.setVisible(true);
		this.setResizable(true);
		this.setLocationRelativeTo(null);

		image = new ImageIcon("res/wardungeon_logo.png");
		this.setIconImage(image.getImage());

		game = new RunGame();
		this.add(game);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}