package net.naprav.wardungeon.listen;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouser implements MouseListener {

	public int xClick, yClick;

	public void mouseClicked(MouseEvent mouse) {
		xClick = mouse.getX();
		yClick = mouse.getY();
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