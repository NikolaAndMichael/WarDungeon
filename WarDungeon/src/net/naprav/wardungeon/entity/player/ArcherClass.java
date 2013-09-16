package net.naprav.wardungeon.entity.player;

import net.naprav.wardungeon.gui.MessageWindow;

public class ArcherClass extends Player {

	MessageWindow message;	

	public ArcherClass(boolean isAlive, int attack, int health, int speed) {
		this.setIsAlive(isAlive);
		this.setAttack(attack);
		this.setHealth(health);
		this.setSpeed(speed);

		if (!isAlive) {
			message = new MessageWindow();
			message.sendDeathMessage("You have died. :(");
		}
	}
}