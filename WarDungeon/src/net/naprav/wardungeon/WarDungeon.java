package net.naprav.wardungeon;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import net.naprav.wardungeon.graphics.Display;
import net.naprav.wardungeon.gui.UIRender;
import net.naprav.wardungeon.gui.WarDungeonGUI;
import net.naprav.wardungeon.level.ClassicLevel;
import net.naprav.wardungeon.level.Level;
import net.naprav.wardungeon.level.SurvivalLevel;
import net.naprav.wardungeon.listen.Keyboard;
import net.naprav.wardungeon.listen.Mouser;
import net.naprav.wardungeon.listen.UIListener;
import net.naprav.wardungeon.player.ArcherClass;
import net.naprav.wardungeon.player.KnightClass;
import net.naprav.wardungeon.player.PlayerClass;
import net.naprav.wardungeon.player.WizardClass;
import net.naprav.wardungeon.sound.Music;

public class WarDungeon extends Canvas implements Runnable {

	private static final long serialVersionUID = 6601282971656374659L;

	/* The version of the game, will be updates with annotation later! It also has the location to the game path! */
	public static final String version = "Version: 0.1 Alpha";
	private static final String GAME_PATH = System.getProperty("user.home") + "\\AppData\\Roaming\\[WarDungeon]";

	/* Basic integers and Dimensions for the JFrame and Canvas */
	public static final int WIDTH = 460;
	public static final int HEIGHT = 280;
	private static final int SCALE = 2;
	private final Dimension size = new Dimension((WIDTH * SCALE), (HEIGHT * SCALE));

	/* BufferedImage below is the one thing that is drawn to the screen. The pixels[] array holds the pixel data of said image. */
	private BufferedImage screen = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	public int[] pixels = ((DataBufferInt) screen.getRaster().getDataBuffer()).getData();

	/* A Thread for running the game and two Booleans for being either in-game or in-menu. Also, there is a boolean for if the health of the player has changed. */
	private Thread thread;
	public static volatile boolean isRunning = false;
	public static volatile boolean inGame = false;
	public static volatile boolean hasChanged = false;

	/* Characters for determining what state the player is in, and what level is selected. (MAY CHANGE TO INT LATER!) */
	public static char state = 'N';
	public static int player_select = 0;
	public static int level_select = 0;

	/* The only non-local reference in this class. Used for creating the window. */
	JFrame frame;

	/* Imports having to do with the logic behind the game and then rendering. */
	Display display;
	UIListener listen;
	Keyboard key;
	Mouser mouse;
	Music music;

	/* The three main classes. */

	/**
	 * The main constructor. It's responsible for creating the JFrame and adding this canvas to it. It also sets the level to a default selection.
	 */
	public WarDungeon() {
		frame = new JFrame("WarDungeon");

		display = new Display(screen);
		key = new Keyboard(200);
		mouse = new Mouser();
		listen = new UIListener(mouse);

		setPlayer(PlayerClass.KNIGHT);
		setLevel(ClassicLevel.FLOOR_1);

		if (getLevel() == ClassicLevel.floor_1) {
			getPlayer().setDirection(PlayerClass.NORTH);
		}

		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
		addKeyListener(key);
		addMouseListener(mouse);

		frame.setLayout(new BorderLayout());
		frame.add(this, BorderLayout.CENTER);
		frame.pack();

		frame.setIconImage(new ImageIcon("res/wardungeon_logo.png").getImage());
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Responsible for starting the game, the most important part. It also requests the focus of the Canvas and creates a buffer strategy.
	 */
	public synchronized void begin() {
		thread = new Thread(this, "WarDungeon");
		createBufferStrategy(3);
		requestFocus();

		thread.start();
		isRunning = true;
	}

	/**
	 * Method responsible for stopping the thread that runs the game.
	 * 
	 * @throws InterruptedException
	 */
	public synchronized void finish() throws InterruptedException {
		isRunning = false;
		thread.join();
	}

	/* Integers that reflect the Keyboard's movements. Should not be removed. */
	private int xMove = 0, yMove = 0;

	/**
	 * This method is responsible for updating the logic behind the game, i.e. Mobs, time, AI, etc.
	 */
	private synchronized void tick(int health) {
		key.checkForKeys();

		int speed = getPlayer().getSpeed();

		if (key.up) {
			yMove -= speed;
			getPlayer().setDirection(PlayerClass.NORTH);
		}

		if (key.down) {
			yMove += speed;
			getPlayer().setDirection(PlayerClass.SOUTH);
		}

		if (key.left) {
			xMove -= speed;
			getPlayer().setDirection(PlayerClass.WEST);
		}

		if (key.right) {
			xMove += speed;
			getPlayer().setDirection(PlayerClass.EAST);
		}

		if (key.power) {
			getPlayer().takesDamage(3);
		}

		if (getPlayer().getHealth() != health) hasChanged = true;
	}

	/* Integers responsible for the FPS and UPS. */
	public int frames = 0, updates = 0;

	/**
	 * Method responsible for rendering the logic in the "update()" method to the screen.
	 */
	private synchronized void render() {
		BufferStrategy buffer = this.getBufferStrategy();
		Graphics gfx = buffer.getDrawGraphics();

		final int centerY = (HEIGHT / 2) - (48 / 2);
		final int centerX = (WIDTH / 2) - (48 / 2);

		display.clear();
		getLevel().render(xMove, yMove, display);
		display.renderPlayer(getPlayer(), centerX, centerY);
		display.alignPixels(pixels);

		gfx.drawImage(screen, 0, 0, getWidth(), getHeight(), null);

		gfx.setFont(WarDungeonGUI.warDungeonFont());
		gfx.setColor(new Color(220, 220, 220));
		gfx.drawString(version, 3, 15);

		if (key.show) {
			key.showInfo(gfx, frames, updates);
		} else if (key.escape) {
			UIRender.renderEscapeMenu(this);
		}

		gfx.dispose();
		buffer.show();
	}

	public final void screenShot(String filename) throws Exception {
		Robot robot = new Robot();
		Rectangle window = new Rectangle(frame.getX(), frame.getY(), WIDTH * SCALE, HEIGHT * SCALE);
		BufferedImage image = robot.createScreenCapture(window);
		ImageIO.write(image, "png", new File(GAME_PATH + filename));
	}

	/**
	 * Method responsible for setting the state of the game. (i.e. in options, in credits, etc.)
	 * 
	 * @param setState
	 */
	public static void setState(char setState) {
		state = setState;
	}

	/**
	 * Sets the desired player for the game.
	 * 
	 * @param selection
	 */
	public static void setPlayer(int selection) {
		player_select = selection;
	}

	/**
	 * Method for returning the player that the user has selected while in the class select.
	 * 
	 * @return
	 */
	public static PlayerClass getPlayer() {
		if (player_select == 1) return KnightClass.knight;
		if (player_select == 2) return WizardClass.wizard;
		if (player_select == 3) return ArcherClass.archer;

		return KnightClass.knight;
	}

	/**
	 * Method responsible for setting the desired level of the user.
	 * 
	 * @param selection
	 */
	public static void setLevel(int selection) {
		level_select = selection;
	}

	/**
	 * Method used for getting the level that the user picked.
	 * 
	 * @return
	 */
	private final Level getLevel() {
		if (level_select == ClassicLevel.FLOOR_1) return ClassicLevel.floor_1;
		return SurvivalLevel.level;
	}

	/**
	 * The main "run()" method; needed for any class that implements the Runnable.java interface.
	 */
	public void run() {
		long pastTime = System.nanoTime(), lastSecond = System.currentTimeMillis();

		final float desig = 1_000_000_000F / 50F;
		float single = 0;

		// Remove to play actual game.
		// state = 50;

		if (state != 50) {
			Music.playTitleMusic();
		}

		while (isRunning == true) {
			if (state == 'N') {
				UIRender.renderNaprav(this);
				if ((System.currentTimeMillis() - lastSecond) > 2000) {
					// Wait 2 seconds and then go to the menu.
					lastSecond += 1000;
					state = 'M';
				}
			} else if (state == 'M') {
				UIRender.renderMenu(this);
				listen.listenInMenu();
			} else if (state == 'O') {
				UIRender.renderOptions(this);
				listen.listenInOptions();
			} else if (state == 'C') {
				UIRender.renderCredits(this);
				listen.listenInCredits();
			} else if (state == 'S') {
				UIRender.renderClassSelect(this);
				listen.listenInClassSelection();
			} else if (state == 'L') {
				UIRender.renderLevelSelect(this);
				listen.listenInLevelSelection();
			} else if (state == 'Q') {
				System.exit(0);
			} else {
				inGame = true;
				// Remember to comment out the code below when state is auto-equal to 50.
				Music.stopTitleMusic();
				break;
			}
		}

		while (inGame == true) {
			long currentTime = System.nanoTime();
			single += (currentTime - pastTime) / desig;

			pastTime = currentTime;
			while (single >= 1) {
				tick(getPlayer().getHealth());
				updates++;
				single--;
			}

			frames++;
			render();

			if ((System.currentTimeMillis() - lastSecond) > 1000) {
				lastSecond += 1000;
				frame.setTitle("WarDungeon | FPS: " + frames + ", UPS: " + updates);

				frames = 0;
				updates = 0;
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
		WarDungeon dungeon = new WarDungeon();
		dungeon.begin();
	}
}
