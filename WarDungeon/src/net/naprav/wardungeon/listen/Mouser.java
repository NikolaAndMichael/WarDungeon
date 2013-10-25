package net.naprav.wardungeon.listen;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouser implements MouseListener, MouseMotionListener {

	public int xClick, yClick;
	public int x, y;
	
	public void mouseClicked(MouseEvent mouse) {
		xClick = mouse.getX();
		yClick = mouse.getY();
	}

	public void mouseMoved(MouseEvent mouse) {
		int x = mouse.getX();
		int y = mouse.getY();
	}
	
	public void mouseDragged(MouseEvent mouse) {
	}
	
	public void mouseEntered(MouseEvent mouse) {
	}

	public void mouseExited(MouseEvent mouse) {
	}

	public void mousePressed(MouseEvent mouse) {
	}

	public void mouseReleased(MouseEvent mouse) {
	}
}