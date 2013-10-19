package net.naprav.wardungeon.listen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	private boolean[] keys;
	public boolean up, down, left, right;
	
	public Keyboard(int arraySize) {
		keys = new boolean[arraySize];
	}
	
	public void checkForKeys() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
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
