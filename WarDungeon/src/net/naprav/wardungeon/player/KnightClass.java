package net.naprav.wardungeon.player;

import net.naprav.wardungeon.graphics.ClassSprite;
import net.naprav.wardungeon.graphics.Display;

public class KnightClass extends Class {

	/**
	 * Creates a constructor for the KnightClass and uses it in the superclass.
	 * 
	 * @param sprite
	 * @param speed
	 * @param attack
	 * @param defense
	 */
	public KnightClass(ClassSprite sprite, int speed, int attack, int defense) {
		super(sprite, speed, attack, defense);
	}

	public static KnightClass knight = new KnightClass(ClassSprite.knight, 1, 5, 5);

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

	/**
	 * Method for rendering the class.
	 */
	public void render(int x, int y, Display display) {
	}
}
