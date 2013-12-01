package net.naprav.wardungeon.listen;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	private boolean[] keys;
	public boolean up, down, left, right, power;

	public boolean show;
	public boolean shot;
	public boolean escape;

	public Keyboard(int arraySize) {
		keys = new boolean[arraySize];
	}

	public void checkForKeys() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		
		power = keys[KeyEvent.VK_SPACE];

		show = keys[KeyEvent.VK_F1];
		shot = keys[KeyEvent.VK_F2];
		escape = keys[KeyEvent.VK_ESCAPE];
	}

	public void showInfo(Graphics gfx, int fps, int ups) {
		gfx.drawString("Created by Gumptastic", 3, 30);
		gfx.drawString("FPS: " + fps, 3, 45);
		gfx.drawString("UPS: " + ups, 3, 60);
	}

	public void keyPressed(KeyEvent key) {
		keys[key.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent key) {
		keys[key.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent key) {
	}
}
