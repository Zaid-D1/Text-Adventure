package textAdventureGame;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static HashMap<String,Room> roomList = new HashMap<String, Room>();
	static String currentRoom = "backyard";
	static boolean isPlaying = true;
	
	public static void main(String[] args) {
		setup();
		
		System.out.println("Welcome");
		lookAtRoom(true);		
		
		while(isPlaying) {
			String command = getCommand().toLowerCase();
			//command = preProcessCommand();
			String word1 = command.split(" ")[0];			
			
			switch(word1) {
			case "n": case "s": case "w": case "e": case "u": case "d":
			case "north": case "south": case "west": case "east": case "up": case "down":
				moveToRoom(word1.charAt(0));
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
		
		if (newRoom.length()==0) {
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

	private static void showInventory() {
		// TODO Auto-generated method stub		
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
		currentRoom = "Middle of the Ocean";  //where you start
	}

}
