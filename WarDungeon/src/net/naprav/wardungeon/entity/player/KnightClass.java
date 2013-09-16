package net.naprav.wardungeon.entity.player;

public class KnightClass extends Player {

	public KnightClass(boolean isAlive, int attack, int health, int speed) {
		this.setIsAlive(isAlive);
		this.setAttack(attack);
		this.setHealth(health);
		this.setSpeed(speed);
	}
}