package textAdventureGame;

import java.util.HashMap;

public class Enemy {
<<<<<<< HEAD

	static HashMap<String, Enemy> enemyList = new HashMap<String, Enemy>();
=======
>>>>>>> Prayag

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
<<<<<<< HEAD

	static void setupEnemies() {
		Enemy e = new Enemy("Baby Piranha", 20, 2, "Kelp forest");
		enemyList.put("Baby Piranha", e);

		e = new Enemy("Eels", 30, 7, "Cave");
		enemyList.put("Eels", e);

		e = new Enemy("Giant Kraken", 100, 20, "Cave");
		enemyList.put("Gaint Karaken", e);

		e = new Enemy("Skeleton Pirates", 80, 15, "Shipwreck");
		enemyList.put("skeleton pirates", e);

		e = new Enemy("Mother Piranha", 50, 10, "Boss Room - Kelp forrest");
		enemyList.put("Mother Piranha", e);

		e = new Enemy("Giant Kraken", 100, 20, "Boss Room - The Cave");
		enemyList.put("Giant Kraken", e);

		e = new Enemy("Skeleton Pirate Captain", 200, 30, "Boss Room - Shipwreck");
		enemyList.put("skeleton pirate captain", e);
=======

	static void setupEnemies (HashMap<String, Enemy> enemiesMap) {
		Enemy e = new Enemy("Baby Piranha", 20, 2, "Kelp forest");
		enemiesMap.put("Baby Piranha", e);

		e = new Enemy("Eels", 30, 7, "Cave");
		enemiesMap.put("Eels", e);

		e = new Enemy("Giant Kraken", 100, 20, "Cave");
		enemiesMap.put("Gaint Karaken", e);

		e = new Enemy("Skeleton Pirates", 80, 15, "Shipwreck");
		enemiesMap.put("skeleton pirates", e);

		e = new Enemy("Mother Piranha", 50, 10, "Boss Room - Kelp forrest");
		enemiesMap.put("Mother Piranha", e);

		e = new Enemy("Giant Kraken", 100, 20, "Boss Room - The Cave");
		enemiesMap.put("Giant Kraken", e);

		e = new Enemy("Skeleton Pirate Captain", 200, 30, "Boss Room - Shipwreck");
		enemiesMap.put("skeleton pirate captain", e);
>>>>>>> Prayag
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
	
	public void health(int remainingHealth) {
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
<<<<<<< HEAD
	
=======

	public String getRoom() {
		return room;
	}
}
>>>>>>> Prayag
