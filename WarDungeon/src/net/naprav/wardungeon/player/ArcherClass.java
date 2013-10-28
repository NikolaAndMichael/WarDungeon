package net.naprav.wardungeon.player;

import net.naprav.wardungeon.graphics.ClassSprite;
import net.naprav.wardungeon.graphics.Display;

public class ArcherClass extends Class {

	public char direction;
	
	public ArcherClass(ClassSprite sprite, int speed, int attack, int defense) {
		super(sprite, speed, attack, defense);
	}

	public static ArcherClass archer = new ArcherClass(ClassSprite.archer_south, 4, 5, 3);
	
	public void setDirection(char direct) {
		direction = direct;
		if (direction == 'S') {
			this.sprite = ClassSprite.archer_south;
		} else if (direction == 'N') {
			this.sprite = ClassSprite.archer_north;
		} else if (direction == 'W') {
			this.sprite = ClassSprite.archer_west;
		} else if (direction == 'E') {
			this.sprite = ClassSprite.archer_east;
		} else {
			System.out.println("Put in a legit direction!");
		}
	}
	
	public void takesDamage(int damage) {
	}

	public void tick() {
	}

	public void render(int x, int y, Display display) {
	}
}
