package textAdventureGame;
import java.util.ArrayList;
/* Zaid and Prayag
 */	
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	// ===GLOBAL VARIABLES===
	static Player p = new Player("Player 1", 100, "");
	static HashMap <String, Enemy> enemiesMap = new HashMap <String, Enemy>();
	static HashMap<String,Room> roomList = new HashMap<String, Room>();
	static HashMap<String, Items> itemMap = new HashMap<String, Items>(); 
	static ArrayList<String> inventory = new ArrayList<String>();
	static String currentRoom;
	static Enemy currentEnemy;
	static boolean isPlaying = true;

	public static void main(String[] args) {

		System.out.println("Welcome to: ");

		System.out.println();

		title(); 
		setup();

		lookAtRoom(true);		

		while(isPlaying) {
			String command = getCommand().toLowerCase();
			//command = preProcessCommand();
			String [] words = command.split(" ");

			switch(words[0]) {
			case "n": case "s": case "w": case "e": case "u": case "d":
			case "north": case "south": case "west": case "east": case "up": case "down":
				moveToRoom(words[0].charAt(0));
				break;
			case "pickup": case "take": case "get":
				addItems(words[1]);
				break;
			case "drop":
				dropItem(words[1]); 
				break;
			case "i": case "inventory":
				showInventory();
				break;	 
			case "look":
				lookAtRoom(true);
				break;
			case "inspect":
				inspectItem(words[1]);
				break;
			case "help":
				helpCommand(words[0]); 
				break;
			case "status":
				showPlayerSatus(); 
				break; 
			case "equip":
				equipItem(words[1]); 
				break; 
			case "attack":
				attackEnemy();
				break; 
			case "quit":
				System.out.println("Thanks for playing.");
				System.exit(0);
				break;
			case "use":
				useItem(words[1]);
				break;
			default:
				System.out.println("Don't understand " + words[0]);
			}

			if(enemiesMap.get("skeleton pirate captain").getHealth() == 0) { //Whatever room the final boss is in.
				System.out.println("You have deafeated all three bosses and have protected the Ocean Kingdom. Thank you for playing.");
				break; 
			}

		}

	}

	//This will crash if you move to a room that does not exist in the hashmap.
	static void moveToRoom(char dir) {
		String newRoom = roomList.get(currentRoom).getExit(dir);

		if (newRoom.length() == 0) {
			System.out.println("You can't go that way");
			return;
		}

		currentRoom = newRoom;	
		lookAtRoom(false);	

		if (currentRoom.equals("Cave") && Room.isCaveLocked) {
			if (enemiesMap.get("Mother Piranha").getHealth() > 0) {
				System.out.println("The door is locked. You need to defeat the Kelp Forest boss to unlock it.");
				return;
			}
			else {
				System.out.println("You have unlocked the door to the Cave.");	
				System.out.println(roomList.get("Cave").getDesc());
				Room.isCaveLocked = false;
			}
		}

		if (currentRoom.equals("Shipwreck") && Room.isShipWreckLocked) {
			if (enemiesMap.get("Giant Kraken").getHealth() > 0) {
				System.out.println("The door is locked. You need to defeat the Cave boss to unlock it.");
				return;
			}
			else {
				System.out.println("You have unlocked the door to the Shipwreck.");
				System.out.println(roomList.get("Shipwreck").getDesc());
				Room.isShipWreckLocked = false;
			}
		}


	}

	private static void lookAtRoom(boolean b) {
		Room rm = roomList.get(currentRoom);
		System.out.println("\n== " + rm.getTitle() + " =="); 

		if (currentRoom.equals("Cave") && Room.isCaveLocked) {
			return;
		}

		if (currentRoom.equals("Shipwreck") && Room.isShipWreckLocked) {
			return;
		}

		System.out.println(rm.getDesc());
	}


	//When a player types in "pickup" it calls the addItems method that add elements to the array list.
	private static void addItems(String item) {
		//Before the item gets added into the inventory, the setUpItems() will map out the specific items to their 
		//corresponding rooms. 
		Room.setupItems(roomList, inventory);

		//Checks to see if the what item the user typed in exist in the itemList
		if(Room.itemList.contains(item)) {
			Room.itemList.remove(Room.itemList.indexOf(item)); 
			inventory.add(item);

			if(itemMap.get(item).getItemDamage() == 0) {
				System.out.println("You acquired " + item);	
			}

			if(itemMap.get(item).getItemDamage() > 0) {
				System.out.println("You acquired " + item + ". Make sure to equip the item when attacking an enemy.");
			}

		}
		else System.out.println("You can't pickup " + item);
	}

	//A method that allows the player to drop any items from their inventory. 
	private static void dropItem(String item) {

		if(!p.equipedItem.equals("")) {
			System.out.println("You have dropped your " + p.equipedItem);
			p.equipedItem = ""; 
		}
		else {
			inventory.remove(inventory.indexOf(item));
			Room.itemList.add(item); 
			System.out.println("You have dropped" + item);
		}
	}

	//A method that will return the name and description of the inspected item. 
	private static void inspectItem(String item) {
		if(inventory.contains(item) || p.equipedItem.equals(item)) {
			System.out.println("Item Name: " + itemMap.get(item).getItemName());
			System.out.println("Item Description: " + itemMap.get(item).getItemDesc());
			System.out.println("Damage: " + itemMap.get(item).getItemDamage());
		}
		else System.out.println("Can't inspect " + item);
	}

	//A method that will show the controls to a player if needed. 
	private static void helpCommand(String n) {
		System.out.println("Controls: \n 1)'n', 's', 'w', 'e' - can move the player North, South, West, and East \n"
				+ " 2)'pickup' or 'take' - put items in the inventory \n 3)'drop' - drops the item from your invenotry\n"
				+ " 4)'i' or 'inventory' - opens the inventory\n 5)'look' - gives the title and a breif description "
				+ "about the room\n 6)'inspect' - gives the item name and desciption of the item\n 7)'equip' - takes the item from the"
				+ "inventory and puts it in the players hand\n 8)'status' - shows the players health, description, the player level and the equiped item."
				+ "\n 9)'use' - allows the player to use the item");
	}

	//A method that shows the player status.
	private static void showPlayerSatus() {
		System.out.println("Name: " + p.getName());
		System.out.println("Health: " + p.getHealth());
		System.out.println("Equiped Item: " + p.equipedItem);
	}

	private static void equipItem(String item) {
		if(inventory.contains(item)) {
			inventory.remove(inventory.indexOf(item)); 
			p.equipedItem = item; 
			System.out.println("You have equiped " + item);
		}
	}


	private static void attackEnemy() { 

		Room currentRoom = roomList.get(Main.currentRoom);

		if(currentRoom.getEnemy() == null) {
			System.out.println("There is no enemy to attack.");
			return;
		}
		
		try {

		Enemy enemy = currentRoom.getEnemy();
		int damage = itemMap.get(p.equipedItem).getItemDamage();
		int health = enemy.getHealth();
		int remainingHealth = health - damage;
		enemy.setEnemyHealth(remainingHealth);
		System.out.println("You attacked the " + enemy.getName() + " and dealt " + damage + " damage.");

		if(remainingHealth <= 0) {
			System.out.println("You defeated the " + enemy.getName() + "!");
			Player.levelUpItem(p.equipedItem);
			currentRoom.setEnemy(null);
			
			
			if (enemiesMap.get("Baby Piranha").getHealth() <= 0) {
				System.out.println("You've unlocked the portal to the kelp forest boss room!, go south and be prepared!");
				
			}
			if (enemiesMap.get("Eels").getHealth() <= 0) {
				System.out.println("You've unlocked the cave boss room!, go north to face the boss");
				
			}
			if (enemiesMap.get("Mother Piranha").getHealth() <= 0) {
				System.out.println("You've unlocked the Cave!, go back to the Ocean and then go west");
				
			}

			if (enemiesMap.get("Giant Kraken").getHealth() <= 0) {
				System.out.println("You've unlocked the final destination, ShipWreck!!, go back to the Ocean(");
				
			}
			
			return;
		}

		System.out.println("The " + enemy.getName() + " has " + remainingHealth + " health remaining.");
		int enemyDamage = enemy.getDamage();
		int playerHealth = p.getHealth();
		int remainingPlayerHealth = playerHealth - enemyDamage;
		p.setHealth(remainingPlayerHealth);
		System.out.println("The " + enemy.getName() + " attacked you and dealt " + enemyDamage + " damage.");

		if(remainingPlayerHealth <= 0) {
			System.out.println("You have been defeated by the " + enemy.getName() + "!");
			isPlaying = false;
		}
	}
	catch(NullPointerException e) {
		System.out.println("You can't attack an enemy without an equiped weapon.");
	}
}

	// A method that allows the player to use the healing items to regenerate their health. 
private static void useItem(String item) {
	if(inventory.contains(item)) {
		if(item.equals("caviar")) {
			int healthHealed = 100; 
			p.setHealth(healthHealed);
			System.out.println("The caviar has regenerated your health.");
		}
		else if(item.equals("KoolAid")) {
			int healthHealed = 100;
			p.setHealth(healthHealed);
			System.out.println("The KoolAid has regerated your health.");
		}
		else {
			System.out.println("Can't use " + item);
		}
	}
}

//A method that just prints out the inventory array list.
private static void showInventory() {
	System.out.println("Inventory: " + inventory);
}

static Scanner sc = new Scanner(System.in);
static String getCommand() {
	System.out.print("=> ");		
	String text = sc.nextLine();
	if (text.length() == 0) text = "qwerty"; //default command		
	return text;
}

static void setup() {
	currentRoom = "ocean"; //where you start
	Room.setupRooms(roomList);
	Items.setupItems(itemMap);
	Enemy.setupEnemies(enemiesMap);
	Room.isCaveLocked = true;
	Room.isShipWreckLocked = true;
}

static void title() {
	//Used a website that can convert any sentence or words into ASCII Art (pretty cool), here is the 
	//URL: https://patorjk.com/software/taag/#p=display&h=1&v=0&f=Big&t=Under%20the%20Sea
	String title = "  ___      _                 _                                __   _   __      _ \r\n"
			+ " / _ \\    | |               | |                              / _| | | / /     (_)\r\n"
			+ "/ /_\\ \\ __| |_   _____ _ __ | |_ _   _ _ __ ___  ___    ___ | |_  | |/ /  __ _ _ \r\n"
			+ "|  _  |/ _` \\ \\ / / _ \\ '_ \\| __| | | | '__/ _ \\/ __|  / _ \\|  _| |    \\ / _` | |\r\n"
			+ "| | | | (_| |\\ V /  __/ | | | |_| |_| | | |  __/\\__ \\ | (_) | |   | |\\  \\ (_| | |\r\n"
			+ "\\_| |_/\\__,_| \\_/ \\___|_| |_|\\__|\\__,_|_|  \\___||___/  \\___/|_|   \\_| \\_/\\__,_|_|\r\n"
			+ "                                                                                 \r\n"
			+ "                                                                                 ";

	for(int i = 0; i < title.length(); i++) {
		System.out.print(title.charAt(i));

	}
	System.out.println();
}

}
