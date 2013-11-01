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

import net.naprav.wardungeon.block.StoneBrickBlock;
import net.naprav.wardungeon.graphics.ClassSprite;
import net.naprav.wardungeon.graphics.Display;
import net.naprav.wardungeon.listen.Keyboard;
import net.naprav.wardungeon.listen.Mouser;
import net.naprav.wardungeon.player.ArcherClass;
import net.naprav.wardungeon.player.KnightClass;
import net.naprav.wardungeon.player.PlayerClass;
import net.naprav.wardungeon.player.WizardClass;
import net.naprav.wardungeon.sound.Music;
import net.naprav.wardungeon.sound.Sound;

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

	public byte state = 0;
	public byte player_select = 0;

	JFrame frame;
	Display display;
	Keyboard key;
	Mouser mouse;
	Sound sound;
	Music music;

	KnightClass knight;
	WizardClass wizard;
	ArcherClass archer;
	
	/**
	 * The main constructor. It's responsible for creating the JFrame and adding this canvas to it.
	 */
	public WarDungeon() {
		frame = new JFrame("WarDungeon");

		display = new Display(WIDTH, HEIGHT);
		sound = new Sound("res/noise/sound/selection.wav");
		music = new Music("res/noise/music/menu.wav");
		key = new Keyboard(200);
		mouse = new Mouser();
		
		frame.setVisible(true);
		frame.setIconImage(new ImageIcon("res/wardungeon_logo.png").getImage());

		knight = new KnightClass(ClassSprite.knight_south, 2, 5, 5);
		wizard = new WizardClass(ClassSprite.wizard_south, 2, 6, 4);
		archer = new ArcherClass(ClassSprite.archer_south, 4, 5, 3);
		
		knight.setDirection('S');
		wizard.setDirection('S');
		archer.setDirection('S');
		
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.addKeyListener(key);
		this.addMouseListener(mouse);

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

		if (key.up) {
			yMove++;
			knight.setDirection('N');
			wizard.setDirection('N');
			archer.setDirection('N');
		}

		if (key.down) {
			yMove--;
			knight.setDirection('S');
			wizard.setDirection('S');
			archer.setDirection('S');
		}

		if (key.left) {
			xMove++;
			knight.setDirection('W');
			wizard.setDirection('W');
			archer.setDirection('W');
		}

		if (key.right) {
			xMove--;
			knight.setDirection('E');
			wizard.setDirection('E');
			archer.setDirection('E');
		}
	}

	/**
	 * This method is used to to update anything on the image, i.e. Animations, level explosions :D, etc.
	 */
	private void tickImage() {

		final int centerY = (HEIGHT / 2) - (48 / 2);
		final int centerX = (WIDTH / 2) - (48 / 2);

		display.clear();
		display.renderBlock(StoneBrickBlock.block, xMove, yMove);

		display.renderPlayer(getPlayer(), centerX, centerY);

		for (int x = 0; x < screen.getWidth(); ++x) {
			for (int y = 0; y < screen.getHeight(); ++y) {
				if ((screen.getRGB(x, y) & 0) == 0) {
					screen.setRGB(x, y, 0);
				}
			}
		}

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

	/**
	 * Method for rendering the Naprav logo to the screen.
	 */
	private final void renderNaprav() {
		display.renderNaprav();

		for (int a = 0; a < pixels.length; a++) {
			pixels[a] = display.pixels[a];
		}

		Graphics gfx = this.getGraphics();

		gfx.drawImage(screen, 0, 0, getWidth(), getHeight(), null);
		gfx.dispose();
	}

	/**
	 * Method for rendering the options GUI.
	 */
	private final void renderOptions() {
		display.renderOptions();

		for (int a = 0; a < pixels.length; a++) {
			pixels[a] = display.pixels[a];
		}

		Graphics gfx = this.getGraphics();

		gfx.drawImage(screen, 0, 0, getWidth(), getHeight(), null);
		gfx.dispose();
	}

	/**
	 * Method for rendering the credits GUI.
	 */
	private final void renderCredits() {
		display.renderCredits();

		for (int a = 0; a < pixels.length; a++) {
			pixels[a] = display.pixels[a];
		}

		Graphics gfx = this.getGraphics();

		gfx.drawImage(screen, 0, 0, getWidth(), getHeight(), null);
		gfx.dispose();
	}

	/**
	 * Method for rendering the main menu GUI.
	 */
	private final void renderMenu() {
		display.renderMenu();

		for (int a = 0; a < pixels.length; a++) {
			pixels[a] = display.pixels[a];
		}

		Graphics gfx = this.getGraphics();

		gfx.drawImage(screen, 0, 0, getWidth(), getHeight(), null);
		gfx.dispose();
	}

	private final void renderSelection() {
		display.renderSelection();

		for (int a = 0; a < pixels.length; a++) {
			pixels[a] = display.pixels[a];
		}

		Graphics gfx = this.getGraphics();

		gfx.drawImage(screen, 0, 0, getWidth(), getHeight(), null);
		gfx.dispose();
	}

	/**
	 * The method for listening for mouse clicks in the main menu.
	 */
	private final void listenForMouseClickInMenu() {
		int xClick = mouse.xClick;
		int yClick = mouse.yClick;

		System.out.println(xClick + ", " + yClick);
		
		if ((xClick > 23 && xClick < 215) && (yClick > 322 && yClick < 401)) {
			// Goes to selection screen.
			sound.playSound();
			state = 4;
			return;
		} else if ((xClick > 718 && xClick < 907) && (yClick > 328 && yClick < 403)) {
			// Goes to options.
			sound.playSound();
			state = 2;
			return;
		} else if ((xClick > 243 && xClick < 432) && (yClick > 434 && yClick < 511)) {
			// Goes to credits.
			sound.playSound();
			state = 3;
			return;
		} else if ((xClick > 515 && xClick < 706) && (yClick > 437 && yClick < 513)) {
			sound.playSound();
			System.exit(0);
		}
	}

	/**
	 * The method for listening for mouse clicks in options.
	 */
	private final void listenForMouseClickInOptions() {
		int xClick = mouse.xClick;
		int yClick = mouse.yClick;

		if ((xClick > 23 && xClick < 211) && (yClick > 470 && yClick < 548)) {
			// Applies settings and returns to menu.
			sound.playSound();
			applySettings();
			state = 1;
			return;
		} else if ((xClick > 715 && xClick < 905) && (yClick > 470 && yClick < 548)) {
			// Returns to menu.
			sound.playSound();
			state = 1;
			return;
		}
	}

	/**
	 * The method for listening to mouse clicks in the credits.
	 */
	private final void listenForMouseClickInCredits() {
		int xClick = mouse.xClick;
		int yClick = mouse.yClick;

		if ((xClick > 717 && xClick < 907) && (yClick > 464 && yClick < 542)) {
			// Returns to menu.
			sound.playSound();
			state = 1;
			return;
		}
	}

	private final PlayerClass getPlayer() {
		if (player_select == 1) return knight;
		if (player_select == 2) return wizard;
		if (player_select == 3) return archer;
		return knight;
	}
	
	private final void listenForMouseClickInSelection() {
		int xClick = mouse.xClick;
		int yClick = mouse.yClick;

		if ((xClick > 402 && xClick < 536) && (yClick > 48 && yClick < 311)) {
			// Enters game with knight.
			player_select = 1;
			sound.playSound();
			state = 50;
			return;
		} if ((xClick > 252 && xClick < 381) && (yClick > 41 && yClick < 303)) {
			// Enters game with wizard.
			player_select = 2;
			sound.playSound();
			state = 50;
			return;
		} if ((xClick > 545 && xClick < 674) && (yClick > 52 && yClick < 307)) {
			// Enters game with archer.
			player_select = 3;
			sound.playSound();
			state = 50;
			return;
		}
	}

	/**
	 * The method for applying the settings to the game.
	 */
	private void applySettings() {

	}

	/**
	 * The main "run()" method; needed for any class that implements the Runnable.java interface.
	 */
	public void run() {
		long pastTime = System.nanoTime(), lastSecond = System.currentTimeMillis();

		final float desig = 1_000_000_000F / 70F;
		float single = 0;

		int frames = 0;

		// Remove for actual game itself.
		// state = 50;

		//music.playMusic();

		while (isRunning == true) {
			if (state == 0) {
				renderNaprav();
				if ((System.currentTimeMillis() - lastSecond) > 2000) {
					// Wait 2 seconds and then go to the menu.
					lastSecond += 1000;
					state = 1;
				}
			} else if (state == 1) {
				renderMenu();
				listenForMouseClickInMenu();
			} else if (state == 2) {
				renderOptions();
				listenForMouseClickInOptions();
			} else if (state == 3) {
				renderCredits();
				listenForMouseClickInCredits();
			} else if (state == 4) {
				renderSelection();
				listenForMouseClickInSelection();
			} else {
				music.stopMusic();

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
