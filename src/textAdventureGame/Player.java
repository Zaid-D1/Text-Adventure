package textAdventureGame;

public class Player {

	//Characteristics of a player
	private String name; 
	static int level; 
	static int health;
	String equipedItem; //the hand of the player

	Player(String n, int l, int h, String e){
		name = n; 
		level = l; 
		health = h; 
		equipedItem = e; 
	}

	//Getting the players name, level, and health. 
	String getName(){return name;}
	int getLevel() {return level;}
	int getHealth() {return health;}

	//A method that allows the player to level up once they have defeated a boss in a specific room. 
	static void levelUp() {

	}
	//Method that shows the damge taken by the player and also exits the program if the player is dead
	public void takeDamage(int damage) {
		health -= damage;
		System.out.println(name + " took " + damage + " damage!");
		if (health <= 0) {
			System.out.println("Game Over" + name + " has been defeated!");
			System.exit(0);
		} else {
			System.out.println(name + " has " + health + " health remaining.");
			if (health <= 50) {
				System.out.println("Your health is getting low! Consider using a potion. Any more damage and you will be in seveare danger");
			}
		}
	}



	public int getDamage() {
		// Get the damage points of the equipped item
		int damage = 0;
		if (equipedItem != null) {
			for (Items item : itemMap.values()) {
				if (item.getItemName().equalsIgnoreCase(equipedItem)) {
					damage = item.getItemDamage();
					break;
				}
			}
		}
		return damage;
	}


	public void setHealth(int remainingPlayerHealth) {
		health = remainingPlayerHealth;
	}






}
