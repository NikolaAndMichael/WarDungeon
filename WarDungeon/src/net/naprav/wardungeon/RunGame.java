package net.naprav.wardungeon;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class RunGame extends Canvas implements Runnable {
	private static final long serialVersionUID = 1203994186653691379L;

	private static final int WIDTH = WindowFrame.WIDTH;
	private static final int HEIGHT = WindowFrame.HEIGHT;
	private static final Dimension size = WindowFrame.size;

	private Thread thread;
	private boolean isRunning = false;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] allPixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	//static Key key;
	RenderMechanism mech;
	
	/**
	 * Added the main constructor.
	 */
	public RunGame() {
		this.setVisible(true);
		this.setSize(size);
		this.setPreferredSize(size);
		this.setMinimumSize(size);
		this.setMinimumSize(size);
		
		mech = new RenderMechanism(WIDTH, HEIGHT);
	}

	/**
	 * Responsible for the logic behind the game.
	 */
	public void tick() {
	
	}
	
	/*
	 * Responsible for the actual rendering behind the game.
	 */
	public void render() {
		BufferStrategy buffer = this.getBufferStrategy();
		
		//Clearing the screen to make room for the pixels! :D
		mech.clearScreen();
		//Rendering the pixels in the RenderMechanism class.
		mech.renderStuffs(20, 50);
		for (int counter = 0; counter < allPixels.length; counter++) {
			//Setting the pixels in this class to the ones in RenderMechanism.java.
			allPixels[counter] = mech.allPixels[counter];
		}
		
		//Buffer is automatically null, so we can create one to render a number of buffers. (3)
		if (buffer == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics gfx = buffer.getDrawGraphics();
		gfx.setColor(new Color(146, 17, 189));
		gfx.fillRect(0, 0, this.getWidth(), this.getHeight());
		//Draw stuffs here.
		gfx.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
		gfx.dispose();
		buffer.show();
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
		while (isRunning == true) {
			this.tick();
			this.render();
			System.out.println("We're running baby! :D");
		}
	}
	
	/**
	 * The Main method.
	 * @param args
	 */
	public static void main(String[] args) {
		//RunGame run = new RunGame();
		WindowFrame window = new WindowFrame("WarDungeon");
		//Below code used for testing login!
		//LoginScreen login = new LoginScreen("WarDungeon Login");
	}
}