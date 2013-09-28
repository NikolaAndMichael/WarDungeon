package net.naprav.wardungeon.input;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Key implements KeyListener {

	public boolean[] keys = new boolean[128];
	public boolean left, right, down, up;
	public boolean showFPS;
	
	public void updateMovement() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		
		showFPS = keys[KeyEvent.VK_F1];
	}
	
	public void showPerSeconds(BufferStrategy buffer, int FPS, int TPS) {
		Graphics gfx = buffer.getDrawGraphics();
		if (showFPS == true) {
			gfx.setColor(Color.WHITE);
			gfx.setFont(new Font("Tahoma", Font.PLAIN, 16));
			gfx.drawString("FPS: " + FPS + " | UPS: " + TPS , 4, 14);
		}
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