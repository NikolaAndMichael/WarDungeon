package net.naprav.wardungeon.entity.player;

public abstract class Player {

	public boolean isAlive = true;
	public int attack;
	public int health;
	public int speed;

	/**
	 * Sets if the player class is alive or not.
	 * @param isAlive
	 */
	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	/**
	 * Checks to see if the player class is alive or not.
	 * @return
	 */
	public boolean getIsAlive() {
		return isAlive;
	}

	/**
	 * Sets the attack of the player class.
	 * @param attack
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/**
	 * Get the attack of the player class.
	 * @return
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * Sets the health of the player class.
	 * @param health
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * Gets the health of the player class.
	 * @return
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Sets the speed of the player class.
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * Gets the speed of the player class.
	 * @return
	 */
	public int getSpeed() {
		return speed;
	}
}