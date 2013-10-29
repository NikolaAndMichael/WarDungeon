package net.naprav.wardungeon.mob;

import net.naprav.wardungeon.graphics.ClassSprite;
import net.naprav.wardungeon.graphics.Display;
import net.naprav.wardungeon.graphics.MobSprite;

public class Ogre extends Mob {

	public char direction;
	
	public Ogre(MobSprite sprite, int speed, int attack, int defense) {
		super(sprite, speed, attack, defense);
	}

	public void setDirection(char direct) {
		direction = direct;
		if (direction == 'S') {
			this.sprite = null;
		} else if (direction == 'N') {
			this.sprite = null;
		} else if (direction == 'W') {
			this.sprite = null;
		} else if (direction == 'E') {
			this.sprite = null;
		} else {
			System.out.println("Put in a legit direction!");
		}
	}
	
	protected void takesDamage(int damage) {

	}

	protected void tick() {

	}

	protected void render(int x, int y, Display display) {

	}
}
