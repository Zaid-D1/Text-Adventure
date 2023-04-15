package textAdventureGame;

public class Enemy {
	private String name;
	private int health;
	private int damage;

	public Enemy(String name, int health, int damage) {
		this.name = name;
		this.health = health;
		this.damage = damage;
	}

	public void attackPlayer(Player player) {
		player.takeDamage(damage);
		System.out.println(name + " attacked you for " + damage + " damage!");
	}

	public boolean isAlive() {
		return health > 0;
	}

	public void takeDamage(int damage) {
		health -= damage;
		if (!isAlive()) {
			System.out.println(name + " has been defeated!");
		}
	}

	public int getHealth() {
		return health;
	}
}
