package net.naprav.wardungeon.entity;

public class Skull extends Mob {

	public Skull(boolean isHostile, boolean isAlive, int attack, int health, int speed) {
		this.setIsHostile(isHostile);
		this.setIsAlive(isAlive);
		this.setAttack(attack);
		this.setHealth(health);
		this.setSpeed(speed);
	}
}