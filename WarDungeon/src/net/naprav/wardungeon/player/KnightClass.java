package net.naprav.wardungeon.player;

import net.naprav.wardungeon.graphics.ClassTexture;

public class KnightClass extends PlayerClass {

	public char direction;

	/**
	 * Creates a constructor for the KnightClass and uses it in the superclass.
	 * 
	 * @param sprite
	 * @param speed
	 * @param attack
	 * @param defense
	 */
	public KnightClass(ClassTexture sprite, int speed, int attack, int defense) {
		super(sprite, speed, attack, defense);
	}

	public void setDirection(char direct) {
		direction = direct;
		if (direction == 'S') {
			this.sprite = ClassTexture.knight_south;
		} else if (direction == 'N') {
			this.sprite = ClassTexture.knight_north;
		} else if (direction == 'W') {
			this.sprite = ClassTexture.knight_west;
		} else if (direction == 'E') {
			this.sprite = ClassTexture.knight_east;
		} else {
			System.out.println("Put in a legit direction!");
		}
	}

	/**
	 * The method for allowing the class to take damage.
	 */
	public void takesDamage(int damage) {
	}

	
}
