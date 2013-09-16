package net.naprav.wardungeon.entity;

public class KamikazeTroll extends Mob {

	public KamikazeTroll(boolean isHostile, boolean isAlive, int attack, int health, int speed) {
		this.setIsHostile(isHostile);
		this.setIsAlive(isAlive);
		this.setAttack(attack);
		this.setHealth(health);
		this.setSpeed(speed);
	}
}