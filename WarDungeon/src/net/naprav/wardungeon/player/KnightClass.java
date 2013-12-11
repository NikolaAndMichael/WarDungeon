package net.naprav.wardungeon.player;

import java.awt.image.BufferedImage;

import net.naprav.wardungeon.graphics.ClassTexture;

public class KnightClass extends PlayerClass {

	/**
	 * Creates a constructor for the KnightClass and uses it in the superclass.
	 * 
	 * @param texture
	 * @param speed
	 * @param attack
	 * @param defense
	 */
	public KnightClass(ClassTexture texture, String icon_location, int speed, int attack, int health) {
		super(texture, icon_location, speed, attack, health);
	}

	public static KnightClass knight = new KnightClass(ClassTexture.knight_south, "/textures/gui/in-game/icon/knight_icon.png", 2, 9, 20);

	public void setDirection(int direct) {
		animation++;
		direction = direct;

		if (direction == SOUTH) {
			if (animation < 15 && animation > 5) {
				texture = ClassTexture.knight_south_walk1;
			} else if (animation > 20) {
				texture = ClassTexture.knight_south_walk2;
				if (animation >= 30) animation = 0;
			} else {
				texture = ClassTexture.knight_south;
			}
		} else if (direction == NORTH) {
			if (animation < 15 && animation > 5) {
				texture = ClassTexture.knight_north_walk1;
			} else if (animation > 20) {
				texture = ClassTexture.knight_north_walk2;
				if (animation > 30) animation = 0;
			} else {
				texture = ClassTexture.knight_north;
			}
		} else if (direction == WEST) {
			if (animation < 15 && animation > 5) {
				texture = ClassTexture.knight_west_walk1;
			} else if (animation > 20) {
				texture = ClassTexture.knight_west_walk2;
				if (animation > 30) animation = 0;
			} else {
				texture = ClassTexture.knight_west;
			}
		} else if (direction == EAST) {
			if (animation < 15 && animation > 5) {
				texture = ClassTexture.knight_east_walk1;
			} else if (animation > 20) {
				texture = ClassTexture.knight_east_walk2;
				if (animation > 30) animation = 0;
			} else {
				texture = ClassTexture.knight_east;
			}
		} else {
			System.out.println("Put in a legit direction!");
		}
	}

	/**
	 * The method for returning the icon from the superclass.
	 */
	public BufferedImage getIcon() {
		return icon;
	}

	/**
	 * The method from the superclass that kills the player :(
	 */
	public void die() {
	}
}
