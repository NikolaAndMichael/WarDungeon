package net.naprav.wardungeon.player;

import net.naprav.wardungeon.graphics.ClassTexture;

public class ArcherClass extends PlayerClass {

	public char direction;

	public ArcherClass(ClassTexture sprite, int speed, int attack, int defense) {
		super(sprite, speed, attack, defense);
	}

	public static ArcherClass archer = new ArcherClass(ClassTexture.archer_south, 4, 5, 3);

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
