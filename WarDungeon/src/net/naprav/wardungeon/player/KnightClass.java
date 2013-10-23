package net.naprav.wardungeon.player;

import net.naprav.wardungeon.graphics.ClassSprite;
import net.naprav.wardungeon.graphics.Display;

public class KnightClass extends Class {

	public KnightClass(ClassSprite sprite, int speed, int attack, int defense) {
		super(sprite, speed, attack, defense);
	}

	public static KnightClass knight = new KnightClass(ClassSprite.knight, 1, 5, 5);
	
	protected void takesDamage(int damage) {
		
	}
	
	public void tick() {
	}

	public void render(int x, int y, Display display) {
	}
}
