package net.naprav.wardungeon;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class RunGame extends Canvas implements Runnable {
	private static final long serialVersionUID = 1203994186653691379L;

	public static final Dimension size = WindowFrame.size;

	private Thread thread;
	private boolean isRunning = false;
	
	private ImageIcon icon;
	private Image image;
	
	/**
	 * Added the main constructor.
	 */
	public RunGame() {
		this.setSize(size);
		this.setVisible(true);
		this.setBackground(Color.BLACK);
		
		icon = new ImageIcon("res/gui/naprav.png");
		image = icon.getImage();
	}

	public void begin() {
		thread = new Thread(this);
		thread.start();
		isRunning = true;
	}
	
	public void finish() {
		if (isRunning == true) {
			isRunning = false;
		}
	}	
	
	public void run() {
		while (isRunning == true) {
			System.out.println("Yes, this is running! :D");
			try {
				thread.sleep(1000);
			} catch (InterruptedException exc) {
				System.out.println("The thread doth hath been interrupted!");
				exc.printStackTrace();
			}
		}
	}
	
	/**
	 * The Main method.
	 * @param args
	 */
	public static void main(String[] args) {
		RunGame run = new RunGame();
		WindowFrame window = new WindowFrame("WarDungeon");
		//Below code used for testing login!
		//LoginScreen login = new LoginScreen("WarDungeon Login");
	}
}