package net.naprav.wardungeon.mob;

import net.naprav.wardungeon.graphics.MobTexture;

public class Ogre extends Mob {

	public Ogre(MobTexture texture, int speed, int attack, int health) {
		super(texture, speed, attack, health);
	}

	public static Ogre mob = new Ogre(MobTexture.ogre_south, 3, 5, 4);

	public void setDirection(int direct) {
		animation++;
		direction = direct;
		
		if (direction == SOUTH) {
			if (animation < 15 && animation > 5) {
				texture = MobTexture.ogre_south_walk1;
			} else if (animation > 20){
				texture = MobTexture.ogre_south_walk2;
				if (animation >= 30) animation = 0;
			} else {
				texture = MobTexture.ogre_south;
			}
		} else if (direction == NORTH) {
			if (animation < 15 && animation > 5) {
				texture = MobTexture.ogre_north_walk1;
			} else if (animation > 20){
				texture = MobTexture.ogre_north_walk2;
				if (animation > 30) animation = 0;
			} else {
				texture = MobTexture.ogre_north;
			}
		} else if (direction == WEST) {
			if (animation < 15 && animation > 5) {
				texture = MobTexture.ogre_west_walk1;
			} else if (animation > 20){
				texture = MobTexture.ogre_west_walk2;
				if (animation > 30) animation = 0;
			} else {
				texture = MobTexture.ogre_west;
			}
		} else if (direction == EAST) {
			if (animation < 15 && animation > 5) {
				texture = MobTexture.ogre_east_walk1;
			} else if (animation > 20){
				texture = MobTexture.ogre_east_walk2;
				if (animation > 30) animation = 0;
			} else {
				texture = MobTexture.ogre_east;
			}
		} else {
			System.out.println("Put in a legit direction!");
		}
	}
	
	public void takesDamage(int damage) {
	
	}
}
