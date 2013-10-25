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

import net.naprav.wardungeon.block.StoneBlock;
import net.naprav.wardungeon.graphics.Display;
import net.naprav.wardungeon.listen.Keyboard;
import net.naprav.wardungeon.listen.Mouser;
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
	Mouser mouse;

	/**
	 * The main constructor. It's responsible for creating the JFrame and adding this canvas to it.
	 */
	public WarDungeon() {
		frame = new JFrame("WarDungeon");

		display = new Display(WIDTH, HEIGHT);
		key = new Keyboard(200);
		mouse = new Mouser();

		frame.setVisible(true);
		frame.setIconImage(new ImageIcon("res/wardungeon_logo.png").getImage());

		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.addKeyListener(key);
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);

		frame.add(this);
		frame.pack();
		frame.setResizable(false);

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
		int x = mouse.x;
		int y = mouse.y;
		System.out.println(x);
		System.out.println(y);

		if (key.up) yMove++;
		if (key.down) yMove--;
		if (key.left) xMove++;
		if (key.right) xMove--;
	}

	final int centerX = (WIDTH / 2) - (48 / 2);
	final int centerY = (HEIGHT / 2) - (48 / 2);

	/**
	 * This method is used to to update anything on the image, i.e. Animations, level explosions :D, etc.
	 */
	private void tickImage() {
		display.clear();
		display.renderBlock(StoneBlock.block, xMove, yMove);
		display.renderPlayer(KnightClass.knight, centerX, centerY);

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
		gfx.setColor(new Color(125, 125, 125));
		gfx.drawString("Version: 0.1 Indev", 3, 12);

		gfx.dispose();
		buffer.show();
	}

	private final void renderNaprav() {
		display.renderNaprav();

		for (int a = 0; a < pixels.length; a++) {
			pixels[a] = display.pixels[a];
		}

		Graphics gfx = this.getGraphics();

		gfx.drawImage(screen, 0, 0, getWidth(), getHeight(), null);
		gfx.dispose();
	}

	private final void renderOptions() {
		display.renderOptions();

		for (int a = 0; a < pixels.length; a++) {
			pixels[a] = display.pixels[a];
		}

		Graphics gfx = this.getGraphics();

		gfx.drawImage(screen, 0, 0, getWidth(), getHeight(), null);
		gfx.dispose();
	}
	
	private final void renderCredits() {
		display.renderCredits();

		for (int a = 0; a < pixels.length; a++) {
			pixels[a] = display.pixels[a];
		}

		Graphics gfx = this.getGraphics();

		gfx.drawImage(screen, 0, 0, getWidth(), getHeight(), null);
		gfx.dispose();
	}
	
	private final void renderMenu() {
		display.renderMenu();

		for (int a = 0; a < pixels.length; a++) {
			pixels[a] = display.pixels[a];
		}

		Graphics gfx = this.getGraphics();

		gfx.drawImage(screen, 0, 0, getWidth(), getHeight(), null);
		gfx.dispose();
	}

	private final void listenForMouse() {
		int xClick = mouse.xClick;
		int yClick = mouse.yClick;

		if (pixels[10000] == display.pixels[10000]) {
			if ((xClick > 235 && xClick < 427) && (yClick > 225 && yClick < 300)) {
				state++;
				return;
			} else if ((xClick > 516 && xClick < 706) && (yClick > 228 && yClick < 305)) {
				state += 2;
				return;
			} else if ((xClick > 243 && xClick < 432) && (yClick > 434 && yClick < 511)) {
				state += 3;
				return;
			} else if ((xClick > 515 && xClick < 706) && (yClick > 437 && yClick < 513)) {
				state += 4;
				return;
			}
		}
	}

	/**
	 * The main "run()" method; needed for any class that implements the Runnable.java interface.
	 */
	public void run() {
		long pastTime = System.nanoTime(), lastSecond = System.currentTimeMillis();

		final float desig = 1_000_000_000F / 70F;
		float single = 0;

		int frames = 0;

		while (isRunning == true) {
			if (state == 0) {
				renderNaprav();
				if ((System.currentTimeMillis() - lastSecond) > 1750) {
					lastSecond += 1000;
					state++;
				}
			} else if (state == 1) {
				renderMenu();
				listenForMouse();
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
			} else if (state == 3) {
				renderOptions();
			} else if (state == 4) {
				renderCredits();
			} else if (state == 5) {
				System.exit(0);
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
