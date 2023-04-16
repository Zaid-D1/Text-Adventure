package textAdventureGame;
import java.util.ArrayList;
/* Zaid and Prayag
 */	
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	// ===GLOBAL VARIABLES===
	static Player p = new Player("Player 1", 0, 100, "");
	static HashMap <String, Enemy> enemiesMap = new HashMap <String, Enemy>();
	static HashMap<String,Room> roomList = new HashMap<String, Room>();
	static HashMap<String, Items> itemMap = new HashMap<String, Items>(); 
	static ArrayList<String> inventory = new ArrayList<String>();
	static String currentRoom;
	static boolean isPlaying = true;

	public static void main(String[] args) {

		System.out.println("Welcome to: ");

		System.out.println();

		//title(); 
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
			case "pickup": case "take":
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
				attackEnemy(words[1]);
				break; 
			}
			if(currentRoom.equals("Shipwreck - Boss Room")) { //Whatever room the final boss is in.
				wonGame(); 
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
		System.out.println("Current Room: " + currentRoom);
		lookAtRoom(false);		
	}

	private static void lookAtRoom(boolean b) {
		Room rm = roomList.get(currentRoom);
		System.out.println("\n== " + rm.getTitle() + " ==");
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
			System.out.println("You acquired " + item); 
		}
		else System.out.println("You can't pickup " + item);
	}

	//A method that allows the player to drop any items from their inventory. 
	private static void dropItem(String item) {
		inventory.remove(inventory.indexOf(item));
		Room.itemList.add(item); 
		System.out.println("You have dropped" + item);
	}

	//A method that will return the name and description of the inspected item. 
	private static void inspectItem(String item) {
		if(inventory.contains(item)) {
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
				+ "about the room\n 6)'inspect' - gives the item name and desciption of the item");
	}

	//A method that shows the player status.
	private static void showPlayerSatus() {
		System.out.println("Name: " + p.getName());
		System.out.println("Level: " + p.getLevel());
		System.out.println("Helath: " + p.getHealth());
		System.out.println("Equiped Item: " + p.equipedItem);
	}

	private static void equipItem(String item) {
		if(inventory.contains(item)) {
			inventory.remove(inventory.indexOf(item)); 
			p.equipedItem = item; 
			System.out.println("You have equiped " + item);
		}
	}

	private static void attackEnemy(String enemy) { // FIXME
	
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
	}
	
	static void wonGame() {
		if(enemiesMap.get("Giant Squid").getHealth() == 0) {
			isPlaying = false; 
			System.out.println("You have overtaken the Ocean Kingdom and deafeted all three oulaws.\n Thank you for playing");
		}
	}

	//	static void title() {
	//		//Used a website that can convert any sentence or words into ASCII Art (pretty cool), here is the 
	//		//URL: https://patorjk.com/software/taag/#p=display&h=1&v=0&f=Big&t=Under%20the%20Sea
	//		String title = "  _    _             _               _    _              _____              \r\n"
	//				+ " | |  | |           | |             | |  | |            / ____|             \r\n"
	//				+ " | |  | | _ __    __| |  ___  _ __  | |_ | |__    ___  | (___    ___   __ _ \r\n"
	//				+ " | |  | || '_ \\  / _` | / _ \\| '__| | __|| '_ \\  / _ \\  \\___ \\  / _ \\ / _` |\r\n"
	//				+ " | |__| || | | || (_| ||  __/| |    | |_ | | | ||  __/  ____) ||  __/| (_| |\r\n"
	//				+ "  \\____/ |_| |_| \\__,_| \\___||_|     \\__||_| |_| \\___| |_____/  \\___| \\__,_|\r\n"
	//				+ "                                                                            \r\n"
	//				+ "                                                                            ";
	//
	//		for(int i = 0; i < title.length(); i++) {
	//			System.out.print(title.charAt(i));
	// 
	//		}
	//		System.out.println();
	//	}

}
