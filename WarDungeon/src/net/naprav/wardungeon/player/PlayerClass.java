package net.naprav.wardungeon.player;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.naprav.wardungeon.graphics.ClassTexture;

public class PlayerClass {

	/* Basic stats for said player. */
	protected int SPEED;
	protected int ATTACK;
	protected int HEALTH;

	/* Basic integer for determining directions/ */
	protected int direction;

	/* The four directions. */
	public static int NORTH = 1;
	public static int EAST = 2;
	public static int SOUTH = 3;
	public static int WEST = 4;

	/* A protected integer for marking the animations and static integers for selecting classes. */
	protected int animation;
	public static int KNIGHT = 1, WIZARD = 2, ARCHER = 3;

	/* The sprite that we draw pixels from. */
	public ClassTexture texture;

	/* The icon used for getting the said player icon. */
	public BufferedImage icon;
	
	/**
	 * Creates a class in the game depending on the stats.
	 * 
	 * @param sprite
	 * @param speed
	 * @param attack
	 * @param defense
	 */
	public PlayerClass(ClassTexture texture, String icon_location, int speed, int attack, int health) {
		try {
			this.icon = ImageIO.read(PlayerClass.class.getResource(icon_location));
			this.texture = texture;
			SPEED = speed;
			ATTACK = attack;
			HEALTH = health;
		} catch (IOException exc) {
			exc.printStackTrace();
		}
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

	public BufferedImage getIcon() {
		return icon;
	}
}
