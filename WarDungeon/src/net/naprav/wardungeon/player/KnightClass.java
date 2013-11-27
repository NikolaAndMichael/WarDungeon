package net.naprav.wardungeon.player;

import net.naprav.wardungeon.graphics.ClassTexture;

public class KnightClass extends PlayerClass {

	/**
	 * Creates a constructor for the KnightClass and uses it in the superclass.
	 * 
	 * @param sprite
	 * @param speed
	 * @param attack
	 * @param defense
	 */
	public KnightClass(ClassTexture sprite, int speed, int attack, int health) {
		super(sprite, speed, attack, health);
	}

	public static KnightClass knight = new KnightClass(ClassTexture.knight_south, 2, 9, 50);
	
	public void setDirection(int direct) {
		animation++;
		direction = direct;
		
		System.out.println(animation);
		
		if (direction == SOUTH) {
			if (animation < 15 && animation > 5) {
				sprite = ClassTexture.knight_south_walk1;
			} else if (animation > 20){
				sprite = ClassTexture.knight_south_walk2;
				if (animation >= 30) animation = 0;
			} else {
				sprite = ClassTexture.knight_south;
			}
		} else if (direction == NORTH) {
			if (animation < 15 && animation > 5) {
				sprite = ClassTexture.knight_north_walk1;
			} else if (animation > 20){
				sprite = ClassTexture.knight_north_walk2;
				if (animation > 30) animation = 0;
			} else {
				sprite = ClassTexture.knight_north;
			}
		} else if (direction == WEST) {
			if (animation < 15 && animation > 5) {
				sprite = ClassTexture.knight_west_walk1;
			} else if (animation > 20){
				sprite = ClassTexture.knight_west_walk2;
				if (animation > 30) animation = 0;
			} else {
				sprite = ClassTexture.knight_west;
			}
		} else if (direction == EAST) {
			if (animation < 15 && animation > 5) {
				sprite = ClassTexture.knight_east_walk1;
			} else if (animation > 20){
				sprite = ClassTexture.knight_east_walk2;
				if (animation > 30) animation = 0;
			} else {
				sprite = ClassTexture.knight_east;
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

	/**
	 * Returns the speed of the knight.
	 */
	public int getSpeed() {
		return SPEED;
	}
}
