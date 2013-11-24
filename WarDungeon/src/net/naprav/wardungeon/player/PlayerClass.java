package net.naprav.wardungeon.player;

import net.naprav.wardungeon.graphics.ClassTexture;

public class PlayerClass {

	protected int SPEED;
	protected int ATTACK;
	protected int HEALTH;

	public ClassTexture sprite;

	/**
	 * Creates a class in the game depending on the stats.
	 * 
	 * @param sprite
	 * @param speed
	 * @param attack
	 * @param defense
	 */
	public PlayerClass(ClassTexture sprite, int speed, int attack, int health) {
		this.sprite = sprite;
		SPEED = speed;
		ATTACK = attack;
		HEALTH = health;
	}

	public void setDirection(char dir) {
	}
	
	public void setAttack(int attack) {
		ATTACK = attack;
	}
	
	public int getAttack() {
		return ATTACK;
	}
	
	public void takesDamage(int damage) {
	}
	
	public int getHealh() {
		return HEALTH;
	}
	
	public void setSpeed(int speed) {
		SPEED = speed;
	}
	
	public int getSpeed() {
		return SPEED;
	}
}
