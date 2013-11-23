package net.naprav.wardungeon.player;

import net.naprav.wardungeon.graphics.ClassTexture;

public abstract class PlayerClass {

	protected final int SPEED;
	protected final int ATTACK;
	protected final int DEFENSE;

	public ClassTexture sprite;
	protected int[] pixels;

	/**
	 * Creates a class in the game depending on the stats.
	 * 
	 * @param sprite
	 * @param speed
	 * @param attack
	 * @param defense
	 */
	public PlayerClass(ClassTexture sprite, int speed, int attack, int defense) {
		this.sprite = sprite;
		SPEED = speed;
		ATTACK = attack;
		DEFENSE = defense;
	}

	protected abstract void takesDamage(int damage);

	protected abstract void tick();

	public abstract void setDirection(char dir);
}
