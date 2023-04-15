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

}
