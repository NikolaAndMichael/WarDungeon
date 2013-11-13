package net.naprav.wardungeon.player;

import net.naprav.wardungeon.graphics.ClassTexture;

public class WizardClass extends PlayerClass {

	public char direction;
	
	/**
	 * Creates a constructor for the WizardClass and uses it in the superclass.
	 * 
	 * @param sprite
	 * @param speed
	 * @param attack
	 * @param defense
	 */
	public WizardClass(ClassTexture sprite, int speed, int attack, int defense) {
		super(sprite, speed, attack, defense);
	}

	public void setDirection(char direct) {
		direction = direct;
		if (direction == 'S') {
			this.sprite = ClassTexture.wizard_south;
		} else if (direction == 'N') {
			this.sprite = ClassTexture.wizard_north;
		} else if (direction == 'W') {
			this.sprite = ClassTexture.wizard_west;
		} else if (direction == 'E') {
			this.sprite = ClassTexture.wizard_east;
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
