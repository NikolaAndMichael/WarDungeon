package net.naprav.wardungeon.player;

import net.naprav.wardungeon.graphics.ClassSprite;
import net.naprav.wardungeon.graphics.Display;

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
	public WizardClass(ClassSprite sprite, int speed, int attack, int defense) {
		super(sprite, speed, attack, defense);
	}

	public void setDirection(char direct) {
		direction = direct;
		if (direction == 'S') {
			this.sprite = ClassSprite.wizard_south;
		} else if (direction == 'N') {
			this.sprite = ClassSprite.wizard_north;
		} else if (direction == 'W') {
			this.sprite = ClassSprite.wizard_west;
		} else if (direction == 'E') {
			this.sprite = ClassSprite.wizard_east;
		} else {
			System.out.println("Put in a legit direction!");
		}
	}
	
	public void takesDamage(int damage) {
	}

	public void tick() {
	}

	public void render(int x, int y, Display display) {
	}
}
