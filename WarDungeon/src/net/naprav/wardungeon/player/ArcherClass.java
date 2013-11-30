package net.naprav.wardungeon.player;

import java.awt.image.BufferedImage;

import net.naprav.wardungeon.graphics.ClassTexture;

public class ArcherClass extends PlayerClass {

	public ArcherClass(ClassTexture texture, String icon_location, int speed, int attack, int health) {
		super(texture, icon_location, speed, attack, health);
	}

	public static ArcherClass archer = new ArcherClass(ClassTexture.archer_south, "/textures/gui/in-game/icon/archer_icon.png", 3, 8, 20);

	public void setDirection(int direct) {
		animation++;
		direction = direct;
		
		if (direction == SOUTH) {
			if (animation < 15 && animation > 5) {
				texture = ClassTexture.archer_south_walk1;
			} else if (animation > 20){
				texture = ClassTexture.archer_south_walk2;
				if (animation >= 30) animation = 0;
			} else {
				texture = ClassTexture.archer_south;
			}
		} else if (direction == NORTH) {
			if (animation < 15 && animation > 5) {
				texture = ClassTexture.archer_north_walk1;
			} else if (animation > 20){
				texture = ClassTexture.archer_north_walk2;
				if (animation > 30) animation = 0;
			} else {
				texture = ClassTexture.archer_north;
			}
		} else if (direction == WEST) {
			if (animation < 15 && animation > 5) {
				texture = ClassTexture.archer_west_walk1;
			} else if (animation > 20){
				texture = ClassTexture.archer_west_walk2;
				if (animation > 30) animation = 0;
			} else {
				texture = ClassTexture.archer_west;
			}
		} else if (direction == EAST) {
			if (animation < 15 && animation > 5) {
				texture = ClassTexture.archer_east_walk1;
			} else if (animation > 20){
				texture = ClassTexture.archer_east_walk2;
				if (animation > 30) animation = 0;
			} else {
				texture = ClassTexture.archer_east;
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
	
	public BufferedImage getIcon() {
		return icon;
	}
}
