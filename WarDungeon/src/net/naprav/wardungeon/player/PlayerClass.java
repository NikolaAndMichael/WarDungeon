package net.naprav.wardungeon.player;

import net.naprav.wardungeon.graphics.ClassSprite;
import net.naprav.wardungeon.graphics.Display;

public abstract class PlayerClass {

	protected final int SPEED;
	protected final int ATTACK;
	protected final int DEFENSE;

	public ClassSprite sprite;
	protected int[] pixels;

	/**
	 * Creates a class in the game depending on the stats.
	 * 
	 * @param sprite
	 * @param speed
	 * @param attack
	 * @param defense
	 */
	public PlayerClass(ClassSprite sprite, int speed, int attack, int defense) {
		this.sprite = sprite;
		SPEED = speed;
		ATTACK = attack;
		DEFENSE = defense;
	}

	protected abstract void takesDamage(int damage);

	protected abstract void tick();

	protected abstract void render(int x, int y, Display display);
}
