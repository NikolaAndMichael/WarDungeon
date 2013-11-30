package net.naprav.wardungeon.player;

import java.awt.image.BufferedImage;

import net.naprav.wardungeon.graphics.ClassTexture;

public class WizardClass extends PlayerClass {

	/**
	 * Creates a constructor for the WizardClass and uses it in the superclass.
	 * 
	 * @param texture
	 * @param speed
	 * @param attack
	 * @param defense
	 */
	public WizardClass(ClassTexture texture, String icon_location, int speed, int attack, int health) {
		super(texture, icon_location, speed, attack, health);
	}

	public static WizardClass wizard = new WizardClass(ClassTexture.wizard_south, "/textures/gui/in-game/icon/wizard_icon.png", 2, 7, 20);
	
	public void setDirection(int direct) {
		animation++;
		direction = direct;
		
		if (direction == SOUTH) {
			if (animation < 15 && animation > 5) {
				texture = ClassTexture.wizard_south_walk1;
			} else if (animation > 20){
				texture = ClassTexture.wizard_south_walk2;
				if (animation >= 30) animation = 0;
			} else {
				texture = ClassTexture.wizard_south;
			}
		} else if (direction == NORTH) {
			if (animation < 15 && animation > 5) {
				texture = ClassTexture.wizard_north_walk1;
			} else if (animation > 20){
				texture = ClassTexture.wizard_north_walk2;
				if (animation > 30) animation = 0;
			} else {
				texture = ClassTexture.wizard_north;
			}
		} else if (direction == WEST) {
			if (animation < 15 && animation > 5) {
				texture = ClassTexture.wizard_west_walk1;
			} else if (animation > 20){
				texture = ClassTexture.wizard_west_walk2;
				if (animation > 30) animation = 0;
			} else {
				texture = ClassTexture.wizard_west;
			}
		} else if (direction == EAST) {
			if (animation < 15 && animation > 5) {
				texture = ClassTexture.wizard_east_walk1;
			} else if (animation > 20){
				texture = ClassTexture.wizard_east_walk2;
				if (animation > 30) animation = 0;
			} else {
				texture = ClassTexture.wizard_east;
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
	
	public BufferedImage getIcon() {
		return icon;
	}
}
