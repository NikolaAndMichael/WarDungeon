package net.naprav.wardungeon;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.ImageIcon;

import net.naprav.wardungeon.input.Key;

public class RunGame extends Canvas implements Runnable {

	private static final long serialVersionUID = 1203994186653691379L;

	private static final int WIDTH = WindowFrame.WIDTH;
	private static final int HEIGHT = WindowFrame.HEIGHT;
	private static final Dimension size = WindowFrame.size;

	private Thread thread;
	public boolean isRunning = false;

	public int FPS = 0; // Frames per second.
	public int TPS = 0; // Ticks per second. (Updates per second)

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] allPixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

	private Key key;
	private RenderSystem system;

	private ImageIcon icon;

	/**
	 * Added the main constructor.
	 */
	public RunGame() {
		this.setVisible(true);
		this.setSize(size);
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setMinimumSize(size);

		key = new Key();
		this.addKeyListener(key);

		// change to bufferedimage.
		icon = new ImageIcon("res/textures/gui/naprav.png");

		system = new RenderSystem(WIDTH, HEIGHT);
	}

	int xMove = 0, yMove = 0;

	/**
	 * Responsible for the logic behind the game.
	 */
	public void tick() {
		key.updateMovement();
		if (key.up == true) {
			yMove--;
		} else if (key.down == true) {
			yMove++;
		} else if (key.left == true) {
			xMove--;
		} else if (key.right == true) {
			xMove++;
		}

		if (key.up == true && key.left == true) {
			yMove--;
			xMove--;
		} else if (key.up == true && key.right == true) {
			yMove--;
			xMove++;
		} else if (key.down == true && key.left == true) {
			yMove++;
			xMove--;
		} else if (key.down == true && key.right == true) {
			yMove++;
			xMove++;
		}
	}

	int timer = 0;

	/*
	 * Responsible for the actual rendering behind the game.
	 */
	public void render() {
		BufferStrategy buffer = this.getBufferStrategy();

		if (buffer != null) {
			// Clearing the screen to make room for the pixels! :D
			system.clearScreen();

			// Rendering the pixels in the RenderMechanism class.
			system.changePixels(xMove, yMove);

			for (int counter = 0; counter < allPixels.length; counter++) {
				// Setting the pixels in this class to the ones in
				// RenderMechanism.java.
				allPixels[counter] = system.allPixels[counter];
			}

			// Graphics setup.
			Graphics gfx = buffer.getDrawGraphics();
			// Draw stuffs between here...
			// /* The code here is for showing the logo! */
			// gfx.drawImage(icon.getImage(), 0, 0, this.getWidth(),
			// this.getHeight(), null);
			gfx.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
			if (key.showFPS == true) {
				// Set it up so that it still works with the "per second" rule.
				key.showPerSeconds(buffer, FPS, TPS);
			}
			// and here.
			gfx.dispose();
			buffer.show();
		} else {
			// Buffer is automatically null, so we can create one to render a
			// number
			// of buffers. (3)
			if (buffer == null) {
				this.createBufferStrategy(2);
			}
		}
	}

	/**
	 * Used to start the thread and make it go! :D
	 */
	public synchronized void begin() {
		thread = new Thread(this);
		thread.start();
		isRunning = true;
	}

	/**
	 * Used to end the thread and make it stop! :/
	 */
	public synchronized void finish() {
		if (isRunning == true) {
			isRunning = false;
			try {
				thread.join();
			} catch (InterruptedException exc) {
				System.out.println("Couldn't join thread! :(");
				exc.printStackTrace();
			}
		}
	}

	/**
	 * The run method is used to run the game itself in the thread.
	 */
	public void run() {
		long previousTime = System.nanoTime();
		long secondTimer = System.currentTimeMillis();

		final double nanoSeconds = 1000000000.0 / 60.0;
		double omega = 0;

		while (isRunning == true) {
			long currentTime = System.nanoTime();
			omega += (currentTime - previousTime) / nanoSeconds;
			previousTime = currentTime;

			while (omega >= 1) {
				this.tick();
				TPS++;
				omega--;
			}

			this.render();
			FPS++;

			if ((System.currentTimeMillis() - secondTimer) > 1000) {
				secondTimer += 1000;
				// Un-comment out below code for console output of frames and
				// updates.
				System.out.println("FPS: " + FPS + ", " + "UPS:" + TPS);
				FPS = 0;
				TPS = 0;
			}
		}
		this.finish();
	}

	/**
	 * The Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		WindowFrame window = new WindowFrame("WarDungeon");
		// Get rid of '//' below to test the login screen!
		// LoginScreen login = new LoginScreen("WarDungeon Login");
	}
}