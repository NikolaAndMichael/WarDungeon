package net.naprav.wardungeon.listen;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouser implements MouseListener, MouseMotionListener {

	public int xClick, yClick;
	public int xPos, yPos;

	public final void resetCoords() {
		xClick = 0;
		yClick = 0;
	}

	public void mouseClicked(MouseEvent mouse) {
		xClick = mouse.getX();
		yClick = mouse.getY();
	}

	public void mouseMoved(MouseEvent mouse) {
		xPos = mouse.getX();
		yPos = mouse.getY();
	}

	public void mouseEntered(MouseEvent mouse) {
	}

	public void mouseExited(MouseEvent mouse) {
	}

	public void mousePressed(MouseEvent mouse) {
	}

	public void mouseReleased(MouseEvent mouse) {
	}

	public void mouseDragged(MouseEvent mouse) {
	}
}