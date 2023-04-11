package textAdventureGame;
import java.util.ArrayList;
/* Zaid and Prayag
 */	
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	// ===GLOBAL VARIABLES===
	static HashMap<String,Room> roomList = new HashMap<String, Room>();
	static ArrayList<String> inventory = new ArrayList<String>();
	static ArrayList<String> itemList = new ArrayList<String>(); 
	static String currentRoom = "backyard";
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
		lookAtRoom(false);		
	}

	private static void lookAtRoom(boolean b) {

		Room rm = roomList.get(currentRoom);
		System.out.println("\n== " + rm.getTitle() + " ==");
		System.out.println(rm.getDesc());	

	}

	//When a player types in "pickup" it calls the addItems method that add elements to the array list.
	private static void addItems(String item) {

		// Room #1 item
		if(currentRoom.equals("backyard") && item.equals(itemList.get(0))) {
			//itemList.remove(itemList.indexOf(item)); 
			inventory.add(item);
			System.out.println("You have accquired a " + item + ".");  
		}

		
		//Room #2 item
		if(currentRoom.equals("kitchen") && item.equals(itemList.get(1))) { 
			//itemList.remove(itemList.indexOf(item)); 
			inventory.add(item);
			System.out.println("You have accquired a " + item + ".");
		}

		//Room #3
		if(currentRoom.equals("hall1") && item.equals(itemList.get(2))) {
			//itemList.remove(itemList.indexOf(item)); 
			inventory.add(item);
			System.out.println("You have accquired a " + item + ".");
		}
	}

	//A method that allows the player to drop any items from their inventory. 
	private static void dropItem(String item) {
		inventory.remove(inventory.indexOf(item)); 
		System.out.println("You have dropped a " + item + ".");
	}

	//A Method that just prints out the array.
	private static void showInventory() {
		System.out.println("Inventory: " + inventory.toString());
	}

	static Scanner sc = new Scanner(System.in);
	static String getCommand() {
		System.out.print("=> ");		
		String text = sc.nextLine();
		if (text.length() == 0) text = "qwerty"; //default command		
		return text;
	}

	static void setup() {
		Room.setupRooms(roomList);
		Room.setupItems(itemList);
		currentRoom = "backyard";  //where you start
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
