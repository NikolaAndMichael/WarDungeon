package net.naprav.wardungeon;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import net.naprav.wardungeon.graphics.Display;
import net.naprav.wardungeon.listen.Keyboard;
import net.naprav.wardungeon.player.KnightClass;

public class WarDungeon extends Canvas implements Runnable {

	private static final long serialVersionUID = 6601282971656374659L;

	public static final int WIDTH = 460;
	public static final int HEIGHT = 280;
	private static final int SCALE = 2;
	private final Dimension size = new Dimension((WIDTH * SCALE), (HEIGHT * SCALE));

	private BufferedImage screen = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	public int[] pixels = ((DataBufferInt) screen.getRaster().getDataBuffer()).getData();

	private Thread thread;
	public static volatile boolean isRunning = false;

	public int state = 0;

	JFrame frame;

	Display display;
	Keyboard key;
	Naprav naprav;

	/**
	 * The main constructor. It's responsible for creating the JFrame and adding this canvas to it.
	 */
	public WarDungeon() {
		frame = new JFrame("WarDungeon");

		naprav = new Naprav("/textures/gui/naprav.png", WIDTH, HEIGHT);
		display = new Display(WIDTH, HEIGHT);
		key = new Keyboard(200);

		frame.setVisible(true);
		frame.setIconImage(new ImageIcon("res/wardungeon_logo.png").getImage());

		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.addKeyListener(key);
		frame.add(this);
		frame.pack();

		frame.setMinimumSize(size);

		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Responsible for starting the game, the most important part. It also requests the focus of the Canvas and creates a buffer strategy.
	 */
	public void begin() {
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

	int xMove = 0, yMove = 0;

	/**
	 * This method is responsible for updating the logic behind the game, i.e. Mobs, time, AI, etc.
	 */
	private void tick() {
		key.checkForKeys();

		if (key.up) yMove++;
		if (key.down) yMove--;
		if (key.left) xMove++;
		if (key.right) xMove--;
	}

	/**
	 * This method is used to to update anything on the image, i.e. Animations, level explosions :D, etc.
	 */
	private void tickImage() {
		display.clear();
		// display.renderBlock(StoneBlock.block, xMove, yMove);
		display.renderPlayer(KnightClass.knight, xMove, yMove);

		for (int a = 0; a < pixels.length; a++) {
			pixels[a] = display.pixels[a];
		}
	}

	/**
	 * Setting the pixels of the array in Naprav.java to the ones in this class.
	 */
	private void setUpNaprav() {
		display.renderNaprav();
		
		for (int a = 0; a < pixels.length; a++) {
			pixels[a] = display.pixels[a];
		}
	}

	private void setUpMenu() {
		display.renderMenu();

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

		gfx.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gfx.setColor(Color.WHITE);
		gfx.drawString("Version: 0.1 Indev", 3, 12);

		gfx.dispose();
		buffer.show();
	}

	private void renderNaprav() {
		Graphics gfx = this.getGraphics();

		gfx.drawImage(screen, 0, 0, getWidth(), getHeight(), null);
		gfx.dispose();
	}
	
	private void renderMenu() {
		Graphics gfx = this.getGraphics();

		gfx.drawImage(screen, 0, 0, getWidth(), getHeight(), null);
		gfx.dispose();
	}

	/**
	 * The main "run()" method; needed for any class that implements the Runnable.java interface.
	 */
	public void run() {
		long pastTime = System.nanoTime();
		long lastSecond = System.currentTimeMillis();

		final float desig = 1_000_000_000F / 70F;
		double single = 0;

		int frames = 0;

		while (isRunning == true) {
			if (state == 0) {
				setUpNaprav();
				renderNaprav();
				if ((System.currentTimeMillis() - lastSecond) > 3000) {
					lastSecond += 1000;
					state++;
				}
			} else if (state == 1) {
				setUpMenu();
				renderMenu();
			} else if (state == 2) {
				long currentTime = System.nanoTime();
				single += (currentTime - pastTime) / desig;

				pastTime = currentTime;

				while (single >= 1) {
					tick();
					single--;
				}

				frames++;
				render();

				if ((System.currentTimeMillis() - lastSecond) > 1000) {
					lastSecond += 1000;

					frame.setTitle("WarDungeon | FPS: " + frames);

					frames = 0;
				}

			}
		}
	}

	/**
	 * The "main()" method; needed for every Java program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// new Login();
		new WarDungeon().begin();
	}
}
