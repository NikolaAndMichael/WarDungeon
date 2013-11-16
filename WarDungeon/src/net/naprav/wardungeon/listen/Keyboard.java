package net.naprav.wardungeon.listen;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	private boolean[] keys;
	public boolean up, down, left, right;

	public boolean show;
	public boolean escape;

	public Keyboard(int arraySize) {
		keys = new boolean[arraySize];
	}

	public void checkForKeys() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];

		show = keys[KeyEvent.VK_F1];
		escape = keys[KeyEvent.VK_ESCAPE];
	}

	public void showInfo(Graphics gfx, int fps, int ups) {
		gfx.drawString("Version: 0.1 Indev", 3, 15);
		gfx.drawString("Frames per Second: " + fps, 3, 30);
		gfx.drawString("Updates per Second: " + ups, 3, 45);
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
