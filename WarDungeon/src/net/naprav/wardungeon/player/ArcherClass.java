package net.naprav.wardungeon.player;

import net.naprav.wardungeon.graphics.ClassTexture;

public class ArcherClass extends PlayerClass {

	public ArcherClass(ClassTexture sprite, int speed, int attack, int health) {
		super(sprite, speed, attack, health);
	}

	public static ArcherClass archer = new ArcherClass(ClassTexture.archer_south, 3, 8, 50);

	public void setDirection(int direct) {
		animation++;
		direction = direct;
		
		System.out.println(animation);
		
		if (direction == SOUTH) {
			if (animation < 15 && animation > 5) {
				sprite = ClassTexture.archer_south_walk1;
			} else if (animation > 20){
				sprite = ClassTexture.archer_south_walk2;
				if (animation >= 30) animation = 0;
			} else {
				sprite = ClassTexture.archer_south;
			}
		} else if (direction == NORTH) {
			if (animation < 15 && animation > 5) {
				sprite = ClassTexture.archer_north_walk1;
			} else if (animation > 20){
				sprite = ClassTexture.archer_north_walk2;
				if (animation > 30) animation = 0;
			} else {
				sprite = ClassTexture.archer_north;
			}
		} else if (direction == WEST) {
			if (animation < 15 && animation > 5) {
				sprite = ClassTexture.archer_west_walk1;
			} else if (animation > 20){
				sprite = ClassTexture.archer_west_walk2;
				if (animation > 30) animation = 0;
			} else {
				sprite = ClassTexture.archer_west;
			}
		} else if (direction == EAST) {
			if (animation < 15 && animation > 5) {
				sprite = ClassTexture.archer_east_walk1;
			} else if (animation > 20){
				sprite = ClassTexture.archer_east_walk2;
				if (animation > 30) animation = 0;
			} else {
				sprite = ClassTexture.archer_east;
			}
		} else {
			System.out.println("Put in a legit direction!");
		}
	}
	
	/**
	 * The method for allowing the class to take damage.
	 */
	public void takesDamage(int damage) {
		HEALTH -= damage;
	}
	
	public int getSpeed() {
		return SPEED;
	}
}
