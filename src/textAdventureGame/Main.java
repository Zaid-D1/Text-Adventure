package textAdventureGame;
import java.util.ArrayList;
/* Zaid and Prayag
 */	
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	// ===GLOBAL VARIABLES===
	static HashMap<String,Room> roomList = new HashMap<String, Room>();
	static HashMap<String, Item> itemMap = new HashMap<String, Item>(); 
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

	//A Method that just prints out the array.
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
		Item.setUpItems(itemMap);
		
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
