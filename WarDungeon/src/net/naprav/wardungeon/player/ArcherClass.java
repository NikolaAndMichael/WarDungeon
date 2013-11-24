package net.naprav.wardungeon.player;

import net.naprav.wardungeon.graphics.ClassTexture;

public class ArcherClass extends PlayerClass {

	public ArcherClass(ClassTexture sprite, int speed, int attack, int health) {
		super(sprite, speed, attack, health);
	}

	public char direction;

	public static ArcherClass archer = new ArcherClass(ClassTexture.archer_south, 8, 15, 50);

	public void setDirection(char direct) {
		direction = direct;
		if (direction == 'S') {
			this.sprite = ClassTexture.archer_south;
		} else if (direction == 'N') {
			this.sprite = ClassTexture.archer_north;
		} else if (direction == 'W') {
			this.sprite = ClassTexture.archer_west;
		} else if (direction == 'E') {
			this.sprite = ClassTexture.archer_east;
		} else {
			System.out.println("Put in a legit direction!");
		}
	}

	/**
	 * The method for allowing the class to take damage.
	 */
	public void takesDamage(int damage) {

	}

	/**
	 * Method for updating the class.
	 */
	public void tick() {
	}
}
