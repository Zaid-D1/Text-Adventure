package textAdventureGame;

import java.util.HashMap;

public class Enemy {


	static HashMap<String, Enemy> enemyList = new HashMap<String, Enemy>();


	private String name;
	private int health;
	private int damage;
	private String room;

	Enemy(String name, int health, int damage, String room) {
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.room = room;
	}

	static void setupEnemies (HashMap<String, Enemy> enemiesMap) {
		Enemy e = new Enemy("Baby Piranha", 20, 2, "Kelp forest");
		enemiesMap.put("Baby Piranha", e);

		e = new Enemy("Eels", 30, 7, "Cave");
		enemiesMap.put("Eels", e);

		e = new Enemy("Skeleton Pirates", 80, 15, "Shipwreck");
		enemiesMap.put("skeleton pirates", e);

		e = new Enemy("Mother Piranha", 50, 10, "Boss Room - Kelp forrest");
		enemiesMap.put("Mother Piranha", e);

		e = new Enemy("Giant Kraken", 100, 20, "Boss Room - The Cave");
		enemiesMap.put("Giant Kraken", e);

		e = new Enemy("Skeleton Pirate Captain", 200, 30, "Boss Room - Shipwreck");
		enemiesMap.put("skeleton pirate captain", e);

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

	public String getRoom() {
		return room;
	}
	
	public void setEnemyHealth(int remainingHealth) {
		health = remainingHealth;
	}	

		public String getName() {
			return name;
		}

		public int getDamage() {
			return damage;
		}

		public int getHealth() {
			return health;
		}

	
}

