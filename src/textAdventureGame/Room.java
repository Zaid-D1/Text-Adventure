/* Prayag and Zaid
 * April 25, 2023.
 * A class where the rooms of the text adventure game is created as well as setting up specific enemies and items in the rooms. 
 */

package textAdventureGame;
import java.util.ArrayList;
import java.util.HashMap;

class Room {

	//Instance Variables for Rooms
	private String title;
	private String description;	
	private String N,E,S,W;
	public static boolean isCaveLocked;
	public static boolean isShipWreckLocked;


	static ArrayList<String> itemList = new ArrayList<String>();

	Room(String t, String d) {
		title = t;
		description = d;
	}

	private void setExits(String N, String E, String S, String W) {
		this.N = N;
		this.E = E;
		this.S = S;
		this.W = W;		
	}

	String getExit(char c) {
		switch (c) {
		case 'n': return this.N;
		case 'e': return this.E;
		case 's': return this.S;
		case 'w': return this.W;
		default: return null;
		}
	}

	String getTitle() {return title;}
	String getDesc() {return description;}
	boolean isCavelocked() {return isCaveLocked;}
	boolean isShipwrecklocked() {return isShipWreckLocked;}

	//ONLY done at the beginning of the game
	static void setupRooms(HashMap<String,Room> roomList) {
		Room r = new Room("The Ocean", "The vast, and soundless ocean. There's a Kelp Forest to the east, "
				+ "and if you go north the seagulls will eat you because you are small. "
				+ "You see a rock stuck on a coral. ");
		//          N E S W
		r.setExits("", "Kelp forest", "Shipwreck", "Cave");
		roomList.put("ocean", r);

		r = new Room("The Kelp Forest", "You see giant kelp all around, a water proof notebook, and caviar. "
				+ "There is a baby piranhas that's gaurding the notebook. West takes you back to the Ocean.");
		r.setExits("", "", "Kelp Forest - Boss Room", "ocean");
		roomList.put("Kelp forest", r);

		r = new Room("Shipwreck", "Scary and somehow still in perfect conditon, the sails are torn but everything else is fine. "
				+ "There is skelton pirates on board. You see a door on deck towards the ships kitchen. The Ocean is north. "); 
		r.setExits("ocean", "Shipwreck - Boss Room", "", "");
		roomList.put("Shipwreck", r);

		r = new Room("The Cave", "Dark and gloomy, open your water proof flashlight to look around "
				+ "becareful, there is an eel. Ocean(east)"); 
		r.setExits("Cave - Boss Room", "ocean", "", "");
		roomList.put("Cave", r);

		//boss rooms for each main room	
		r = new Room("The Kelp Forest - Boss Room", "The Mother Piranha awaits for you. Brace yourself for an epic battle!");
		r.setExits("Kelp forest", "", "", "");
		roomList.put("Kelp Forest - Boss Room", r);

		r = new Room("Cave - Boss Room", "The Giant Kraken blocks your way. Prepare for a fierce battle!");
		r.setExits("", "", "", "");
		roomList.put("Cave - Boss Room", r);

		r = new Room("Shipwreck - Boss Room", "The captain of the Skeleton Pirates, the most treacherous out of the three outlaws.");


	}


	//A method that will setup the items for each room. 
	static void setupItems(HashMap<String,Room> roomList, ArrayList<String> itemList) {
		//All of the items associated with the Ocean room.
		if(Main.currentRoom.equals("ocean")) {
			roomList.get("ocean").itemList.add("rock"); 
		}

		//All of the items associated with Kelp Forrest.
		if(Main.currentRoom.equals("Kelp forest")) {
			roomList.get("Kelp forest").itemList.add("caviar");
			roomList.get("Kelp forest").itemList.add("notebook");
		}

		//All of the items associated with The Cave.
		if(Main.currentRoom.equals("The Cave")) {
			roomList.get("The Cave").itemList.add("KoolAid"); 

		}
		//All of the items associated with Ship Wreck. 
		if(Main.currentRoom.equals("Ship wreck")) {

		}
	}

	// Gets the enemy from the enemiesMap depending in what room the player is currently present in. 
	Enemy getEnemy() {
		switch(Main.currentRoom) {
			case "Kelp forest":
				return Main.enemiesMap.get("Baby Piranha");
			case "Kelp Forest - Boss Room":
				return Main.enemiesMap.get("Mother Piranha");
			case "Cave":
				return Main.enemiesMap.get("Eels");
			case "Cave - Boss Room":
				return Main.enemiesMap.get("Giant Kraken");
			case "Shipwreck":
				return Main.enemiesMap.get("skeleton pirates");
			case "Shipwreck - Boss Room":
				return Main.enemiesMap.get("skeleton pirate captain");
			default: 
				return null; 
		}
	}

	public void setEnemy(Object object) {
		if(Main.currentRoom.equals("Kelp forrest - Boss Room") || Main.currentRoom.equals("Cave - Boss Room") || Main.currentRoom.equals("Shipwreck - Boss Room")) {
			Main.currentEnemy = (Enemy) object;
		}
	}

}


