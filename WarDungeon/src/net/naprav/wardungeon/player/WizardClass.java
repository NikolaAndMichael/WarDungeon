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
		animation++;
		direction = direct;
		
		System.out.println(animation);
		
		if (direction == SOUTH) {
			if (animation < 15 && animation > 5) {
				sprite = ClassTexture.wizard_south_walk1;
			} else if (animation > 20){
				sprite = ClassTexture.wizard_south_walk2;
				if (animation >= 30) animation = 0;
			} else {
				sprite = ClassTexture.wizard_south;
			}
		} else if (direction == NORTH) {
			if (animation < 15 && animation > 5) {
				sprite = ClassTexture.wizard_north_walk1;
			} else if (animation > 20){
				sprite = ClassTexture.wizard_north_walk2;
				if (animation > 30) animation = 0;
			} else {
				sprite = ClassTexture.wizard_north;
			}
		} else if (direction == WEST) {
			if (animation < 15 && animation > 5) {
				sprite = ClassTexture.wizard_west_walk1;
			} else if (animation > 20){
				sprite = ClassTexture.wizard_west_walk2;
				if (animation > 30) animation = 0;
			} else {
				sprite = ClassTexture.wizard_west;
			}
		} else if (direction == EAST) {
			if (animation < 15 && animation > 5) {
				sprite = ClassTexture.wizard_east_walk1;
			} else if (animation > 20){
				sprite = ClassTexture.wizard_east_walk2;
				if (animation > 30) animation = 0;
			} else {
				sprite = ClassTexture.wizard_east;
			}
		} else {
			System.out.println("Put in a legit direction!");
		}
	}
	
	public void takesDamage(int damage) {
		HEALTH -= damage;
	}
	
	public int getSpeed() {
		return SPEED;
	}
}
