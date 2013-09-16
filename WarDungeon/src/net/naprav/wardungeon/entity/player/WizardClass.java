package net.naprav.wardungeon.entity.player;

public class WizardClass extends Player {

	public WizardClass(boolean isAlive, int attack, int health, int speed) {
		this.setIsAlive(isAlive);
		this.setAttack(attack);
		this.setHealth(health);
		this.setSpeed(speed);
	}
}