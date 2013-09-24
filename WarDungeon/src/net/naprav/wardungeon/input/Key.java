package net.naprav.wardungeon.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener {

	public boolean left, right, down, up;
	
	public void keyPressed(KeyEvent key) {
		if (key.getID() == key.VK_W) {
			up = true;
		}
		
		if (key.getID() == key.VK_S) {
			down = true;
		}
		
		if (key.getID() == key.VK_A) {
			left = true;
		}
		
		if (key.getID() == key.VK_D) {
			right = true;
		}
	}

	public void keyReleased(KeyEvent key) {
		
	}

	public void keyTyped(KeyEvent key) {
		
	}		
}