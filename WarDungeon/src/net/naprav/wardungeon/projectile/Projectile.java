package net.naprav.wardungeon.projectile;

public abstract class Projectile {

	public int projectileX;
	public int projectileY;
	public int speed;
	public int damage;
	public boolean isMoving = false;
	
	/**
	 * Sets the projectile's 'X' coordinate.
	 * @param projectileX
	 */
	public void setProjectileX(int projectileX) {
		this.projectileX = projectileX;
	}
	
	/**
	 * Gets the projectile's 'X' coordinate.
	 * @param projectileX
	 */
	public int getProjectileX(int projectileX) {
		this.projectileX = projectileX;
		return projectileX;
	}
	
	/**
	 * Sets the projectile's 'Y' coordinate.
	 * @param projectileX
	 */
	public void setProjectileY(int projectileY) {
		this.projectileX = projectileY;
	}
	
	/**
	 * Gets the projectile's 'Y' coordinate.
	 * @param projectileX
	 */
	public int getProjectileY(int projectileY) {
		this.projectileX = projectileY;
		return projectileY;
	}
	
	/**
	 * Sets the projectile's speed.
	 * @param projectileX
	 */
	public void setProjectileSpeed(int speed) {
		this.speed = speed;
	}
	
	/**
	 * Gets the projectile's speed.
	 * @param projectileX
	 */
	public int getProjectileSpeed(int speed) {
		this.speed = speed;
		return speed;
	}
	
	/**
	 * Sets the projectile's amount of damage.
	 * @param projectileX
	 */
	public void setProjectileDamage(int damage) {
		this.damage = damage;
	}
	
	/**
	 * Gets the projectile's amount of damage.
	 * @param projectileX
	 */
	public int getProjectileDamage(int damage) {
		this.damage = damage;
		return damage;
	}
	
	/**
	 * Fires said projectile.
	 */
	public abstract void fireProjectile();
	
	/**
	 * Sets to see if the projectile is moving.
	 * @param isMoving
	 */
	public abstract void setProjectileIsMoving(boolean isMoving);
	
	/**
	 * Check's if the projectile is moving or not.
	 * @param isMoving
	 * @return
	 */
	public abstract boolean getProjectileIsMoving(boolean isMoving);
}
