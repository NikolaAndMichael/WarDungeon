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
	public KnightClass(ClassTexture sprite, int speed, int attack, int health) {
		super(sprite, speed, attack, health);
	}

	public static KnightClass knight = new KnightClass(ClassTexture.knight_south, 2, 9, 50);
	
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
		HEALTH -= damage;
		System.out.println(HEALTH);
	}

	/**
	 * Returns the speed of the knight.
	 */
	public int getSpeed() {
		return SPEED;
	}
}
