package net.naprav.wardungeon.player;

import net.naprav.wardungeon.graphics.ClassSprite;
import net.naprav.wardungeon.graphics.Display;

public abstract class Class {
	
	protected final int SPEED;
	protected final int ATTACK;
	protected final int DEFENSE;
	
	public ClassSprite sprite;
	protected int[] pixels;
	
	public Class(ClassSprite sprite, int speed, int attack, int defense) {
		this.sprite = sprite;
		SPEED = speed;
		ATTACK = attack;
		DEFENSE = defense;
	}
	
	protected abstract void takesDamage(int damage);
	
	protected abstract void tick(); 
	
	protected abstract void render(int x, int y, Display display);
 }