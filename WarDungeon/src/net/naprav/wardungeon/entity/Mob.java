package net.naprav.wardungeon.entity;

public abstract class Mob {

	public boolean isHostile = true;
	public boolean isAlive = true;
	public int health;
	public int attack;
	public int speed;

	/**
	 * Sets if the mob is hostile or not. (Default is true);
	 * @param isHostile
	 */
	public void setIsHostile(boolean isHostile) {
		this.isHostile = isHostile;
	}

	/**
	 * Checks to see if the mob is hostile or not.
	 * @return
	 */
	public boolean getIsHostile() {
		return isHostile;
	}

	/**
	 * Sets if the mob is alive or dead.
	 * @param isAlive
	 */
	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	/**
	 * Checks to see if the mob is alive or not.
	 * @return
	 */
	public boolean getIsAlive() {
		return isAlive;
	}

	/**
	 * Sets the health of the mob.
	 * @param health
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * Checks the health of the mob.
	 * @return
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Sets the attack power of the mob.
	 * @param attack
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/**
	 * Gets the attack power of the mob.
	 * @return
	 */
	public int getAttack() {
		return attack;
	}

	/** 
	 * Sets the speed at how fast the mob moves.
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * Gets the speed of how fast the mob moves.
	 * @return
	 */
	public int getSpeed() {
		return speed;
	}
}