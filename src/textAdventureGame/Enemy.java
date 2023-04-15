package textAdventureGame;

public class Enemy {
	private String name;
	private int health;
	private int damage;
	private String room;

	public Enemy(String name, int health, int damage, String room) {
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.room = room;
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
	
	public String getRoom() {
        return room;
    }
}
