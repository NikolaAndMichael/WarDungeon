package net.naprav.wardungeon.entity;

public class Ogre extends Mob {

	public Ogre(boolean isHostile, boolean isAlive, int attack, int health, int speed) {
		this.setIsHostile(isHostile);
		this.setIsAlive(isAlive);
		this.setAttack(attack);
		this.setHealth(health);
		this.setSpeed(speed);
	}
}
