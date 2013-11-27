package net.naprav.wardungeon.player;

import net.naprav.wardungeon.graphics.ClassTexture;

public class WizardClass extends PlayerClass {

	/**
	 * Creates a constructor for the WizardClass and uses it in the superclass.
	 * 
	 * @param sprite
	 * @param speed
	 * @param attack
	 * @param defense
	 */
	public WizardClass(ClassTexture sprite, int speed, int attack, int health) {
		super(sprite, speed, attack, health);
	}

	public static WizardClass wizard = new WizardClass(ClassTexture.wizard_south, 2, 7, 50);
	
	public void setDirection(int direct) {
		direction = direct;
		
		if (direction == SOUTH) {
			this.sprite = ClassTexture.wizard_south;
		} else if (direction == NORTH) {
			this.sprite = ClassTexture.wizard_north;
		} else if (direction == WEST) {
			this.sprite = ClassTexture.wizard_west;
		} else if (direction == EAST) {
			this.sprite = ClassTexture.wizard_east;
		} else {
			System.out.println("Put in a legit direction!");
		}
	}
	
	public void takesDamage(int damage) {
		HEALTH -= damage;
		System.out.println(HEALTH);
	}
	
	public int getSpeed() {
		return SPEED;
	}
}
