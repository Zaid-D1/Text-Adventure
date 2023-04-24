package textAdventureGame;

import java.util.HashMap;

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

	//A method that allows the player to level up once they have defeated a boss or a common enemy in a specific room. 
	static void levelUp(String item) {
		//Updates the player level
		int playerLevel = Main.p.getLevel(); 
		int newPlayerLevel = 0; 

		playerLevel = newPlayerLevel + 1; 
		Main.p.setLevel(playerLevel);
		System.out.println("You have leveled up to level " + playerLevel);

		//Lets the rock evolve into a new weapon depending on what room the player is in. 
		if(Main.currentRoom.equals("Kelp Forest - Boss Room")) {

			if(Main.p.equipedItem.equals("rock")) {
				Main.p.equipedItem = "spear"; 
				System.out.println("The magic rock in your hand has evolved into a spear.");
			}
			else {
				Main.inventory.remove(Main.inventory.indexOf("rock")); 
				Main.inventory.add("spear"); 
				System.out.println("Your rock has evolved into a spear. CHeck your inventory!"); 
			} 
		}

		if(Main.currentRoom.equals("Ocean - Boss Room")) {
			if(Main.p.equipedItem.equals("spear")) {
				Main.p.equipedItem = "sling"; 
				System.out.println("The magic rock in your hand has evolved into a sling.");
			}
			else {
				Main.inventory.remove(Main.inventory.indexOf("spear")); 
				Main.inventory.add("sling"); 
				System.out.println("Your spear has evolved into a sling. Check your inventory!");
			}
		}
	}


	//Method that shows the damage taken by the player and also exits the program if the player is dead
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
			for (Items item : Main.itemMap.values()) {
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
	
	public void setLevel(int playerNewLevel) {
		level = playerNewLevel; 
	}

	public void setLevel(int playerNewLevel) {
		level = playerNewLevel;
	}



}
