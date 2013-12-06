package net.naprav.wardungeon.mob;

import net.naprav.wardungeon.graphics.MobTexture;

public class Mob {

	/* The integers for the speed, attack and defense. */
	protected int SPEED;
	protected int ATTACK;
	protected int HEALTH;

	/* The four directions. */
	public static int NORTH = 1;
	public static int EAST = 2;
	public static int SOUTH = 3;
	public static int WEST = 4;

	/* A protected integer for marking the animations and the direction of the mob. */
	protected int direction;
	protected int animation;

	/* Static integers used for selecting certain mobs. */
	public static int OGRE = 1;

	/* The actual mobtexture and the pixels that go along with it. */
	public MobTexture texture;

	/**
	 * Creates a class in the game depending on the stats.
	 * 
	 * @param sprite
	 * @param speed
	 * @param attack
	 * @param defense
	 */
	public Mob(MobTexture texture, int speed, int attack, int health) {
		this.texture = texture;
		SPEED = speed;
		ATTACK = attack;
		HEALTH = health;
	}

	/**
	 * The method for setting the direction of the player.
	 * 
	 * @param direction
	 */
	public void setDirection(int direction) {
	}

	/**
	 * The method for setting the attack of the player.
	 * 
	 * @param attack
	 */
	public void setAttack(int attack) {
		ATTACK = attack;
	}

	/**
	 * The method for returning the attack of the player. Can be used to subtract health from a mob.
	 * 
	 * @return
	 */
	public int getAttack() {
		return ATTACK;
	}

	/**
	 * Method to show the player takes damage.
	 * 
	 * @param damage
	 */
	public void takesDamage(int damage) {
		HEALTH -= damage;
	}

	/**
	 * Method for returning the health of the player.
	 * 
	 * @return
	 */
	public int getHealth() {
		return HEALTH;
	}

	/**
	 * Method for setting the speed of the player. Can be used with the sugar bag item.
	 * 
	 * @param speed
	 */
	public void setSpeed(int speed) {
		SPEED = speed;
	}

	/**
	 * The method for returning the speed of said player.
	 * 
	 * @return
	 */
	public int getSpeed() {
		return SPEED;
	}
}
