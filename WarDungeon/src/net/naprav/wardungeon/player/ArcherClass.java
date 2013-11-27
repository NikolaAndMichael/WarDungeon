package net.naprav.wardungeon.player;

import net.naprav.wardungeon.graphics.ClassTexture;

public class ArcherClass extends PlayerClass {

	public ArcherClass(ClassTexture sprite, int speed, int attack, int health) {
		super(sprite, speed, attack, health);
	}

	public static ArcherClass archer = new ArcherClass(ClassTexture.archer_south, 3, 8, 50);

	public void setDirection(int direct) {
		direction = direct;
		
		if (direction == SOUTH) {
			this.sprite = ClassTexture.archer_south;
		} else if (direction == NORTH) {
			this.sprite = ClassTexture.archer_north;
		} else if (direction == WEST) {
			this.sprite = ClassTexture.archer_west;
		} else if (direction == EAST) {
			this.sprite = ClassTexture.archer_east;
		} else {
			System.out.println("Put in a legit direction!");
		}
	}
	/**
	 * The method for allowing the class to take damage.
	 */
	public void takesDamage(int damage) {
		HEALTH -= damage;
		System.out.println(HEALTH);
	}
	
	public int getSpeed() {
		return SPEED;
	}
}
