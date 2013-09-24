package net.naprav.wardungeon.projectile;

public class Orb extends Projectile {

	public int orbX;
	public int orbY;
	public int speed;
	public int damage;
	public boolean isMoving;
	
	public Orb(int orbX, int orbY, int speed, int damage) {
		this.orbX = orbX;
		this.orbY = orbY;
		this.speed = speed;
		this.damage = damage;
		System.out.println(String.format("Arrow Specs - X: %d | Y: %d | Speed: %d | Damage: %d", orbX, orbY, speed, damage));
		
		this.setProjectileX(orbX);
		this.setProjectileY(orbY);
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
