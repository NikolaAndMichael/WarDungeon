package net.naprav.wardungeon.projectile;

public class Arrow extends Projectile {

	public int arrowX;
	public int arrowY;
	public int speed;
	public int damage;
	public boolean isMoving;
	
	public Arrow(int arrowX, int arrowY, int speed, int damage) {
		this.arrowX = arrowX;
		this.arrowY = arrowY;
		this.speed = speed;
		this.damage = damage;
		System.out.println(String.format("Arrow Specs - X: %d | Y: %d | Speed: %d | Damage: %d", arrowX, arrowY, speed, damage));
		
		this.setProjectileX(arrowX);
		this.setProjectileY(arrowY);
		this.setProjectileSpeed(speed);
		this.setProjectileDamage(damage);
	}
	
	/**
	 * Sets to see if the projectile is moving.
	 * @param isMoving
	 */
	public void setProjectileIsMoving(boolean isMoving) {
	
	}

	/**
	 * Check's if the projectile is moving or not.
	 * @param isMoving
	 * @return
	 */
	public boolean getProjectileIsMoving(boolean isMoving) {
		return isMoving;
	}

	/**
	 * Fires said projectile.
	 */
	public void fireProjectile() {
		
	}
}
