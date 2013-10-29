package net.naprav.wardungeon.mob;

import net.naprav.wardungeon.graphics.Display;
import net.naprav.wardungeon.graphics.MobSprite;

public abstract class Mob {

	protected final int SPEED;
	protected final int ATTACK;
	protected final int DEFENSE;

	public MobSprite sprite;
	protected int[] pixels;

	/**
	 * Creates a class in the game depending on the stats.
	 * 
	 * @param sprite
	 * @param speed
	 * @param attack
	 * @param defense
	 */
	public Mob(MobSprite sprite, int speed, int attack, int defense) {
		this.sprite = sprite;
		SPEED = speed;
		ATTACK = attack;
		DEFENSE = defense;
	}

	protected abstract void setDirection(char direction);
	
	protected abstract void takesDamage(int damage);

	protected abstract void tick();

	protected abstract void render(int x, int y, Display display);
}
	
