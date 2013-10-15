package net.naprav.wardungeon;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import net.naprav.wardungeon.block.StoneBlock;
import net.naprav.wardungeon.graphics.BlockSprite;
import net.naprav.wardungeon.graphics.Display;

public class WarDungeon extends Canvas implements Runnable {

	private static final long serialVersionUID = 6601282971656374659L;

	public static final int WIDTH = 330;
	public static final int HEIGHT = 205;
	private static final int SCALE = 3;
	private final Dimension size = new Dimension((WIDTH * SCALE), (HEIGHT * SCALE));

	private BufferedImage screen = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	public int[] pixels = ((DataBufferInt) screen.getRaster().getDataBuffer()).getData();

	private Thread thread;
	public static boolean isRunning = false;

	JFrame frame;

	Display display;

	/**
	 * The main constructor. It's responsible for creating the JFrame and adding this canvas to it.
	 */
	private WarDungeon() {
		frame = new JFrame("WarDungeon");
		display = new Display(WIDTH, HEIGHT);

		frame.setVisible(true);

		this.setPreferredSize(size);
		this.setMinimumSize(size);
		frame.add(this);
		frame.pack();

		frame.setMinimumSize(size);

		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Responsible for starting the game, the most important part. It also requests the focus of the Canvas and creates a buffer strategy.
	 */
	private void begin() {
		thread = new Thread(this, "WarDungeon");
		this.createBufferStrategy(3);
		this.requestFocus();
		thread.start();
		isRunning = true;
	}

	/**
	 * Method responsible for stopping the thread that runs the game.
	 * 
	 * @throws InterruptedException
	 */
	public void finish() throws InterruptedException {
		isRunning = false;
		thread.join();
	}

	/**
	 * This method is responsible for updating the logic behind the game, i.e. Mobs, time, AI, etc.
	 */
	private void tick() {

	}

	/**
	 * This method is used to to update anything on the image, i.e. Animations, level explosions :D, etc.
	 */
	private void tickImage() {
		display.clear();
		display.renderBlock(0, 0, new StoneBlock(BlockSprite.stone, false, false));

		for (int a = 0; a < pixels.length; a++) {
			pixels[a] = display.pixels[a];
		}
	}

	/**
	 * Method responsible for rendering the logic in the "update()" method to the screen.
	 */
	private void render() {
		BufferStrategy buffer = this.getBufferStrategy();
		Graphics gfx = buffer.getDrawGraphics();

		tickImage();

		gfx.drawImage(screen, 0, 0, getWidth(), getHeight(), null);

		gfx.dispose();
		buffer.show();
	}

	/**
	 * The main "run()" method; needed for any class that implements the Runnable.java interface.
	 */
	public void run() {
		while (isRunning == true) {
			tick();
			render();
		}
	}

	/**
	 * The "main()" method; needed for every Java program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		WarDungeon dungeon = new WarDungeon();
		dungeon.begin();
	}
}
