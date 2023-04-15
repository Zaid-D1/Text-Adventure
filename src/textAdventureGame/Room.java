package textAdventureGame;
import java.util.ArrayList;
import java.util.HashMap;

class Room {

	private String title;
	private String description;	
	private String N,E,S,W;

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

	//ONLY done at the beginning of the game
	static void setupRooms(HashMap<String,Room> roomList) {
	    Room r = new Room("The Ocean", "The vast, and soundless ocean. There's a forrest to east,"
	            + "\nA Cave to the West, and A Shipwreck all the way at the bottom of the ocean"
	            + "\nNorth is out of water, if you go north the seagulls will eat you because you are small");
	    //          N E S W
	    r.setExits("", "Kelp forest", "Shipwreck", "Cave");
	    roomList.put("ocean", r);

	    r = new Room("The Kelp forrest", "You see giant kelp all around, water proof notebook. "
	            + "The opening to the forest is to the east, south leads to the Boss Room, west takes you back to the still waters");
	    r.setExits("", "Boss Room", "still waters", "ocean");
	    roomList.put("Kelp forest", r);

	    r = new Room("Shipwreck", "Scary and somehow still in perfect conditon, the sails are torn but everything else is fine,"
	            + "\nYou see a door on deck leading to the captians room, and one more door leading towards the ships kitchen"
	            + "\nNorth leads to the Boss Room");
	    r.setExits("Boss Room", "", "", "still waters");
	    roomList.put("Shipwreck", r);

	    r = new Room("The Cave", "dark and gloomy, open your water proof flashlight to look around"
	            + "North leads to the Boss Room, east takes you to the Kelp Forest"); 
	    r.setExits("Boss Room", "Kelp forrest", "", "");
	    roomList.put("Cave", r);

	    r = new Room("Boss Room", "A large room with an enemy waiting for you");
	    r.setExits("Cave", "Shipwreck", "Kelp forest", "");
	    roomList.put("Boss Room", r);
	}


	//A method that will setup the items for each room. 
	static void setupItems(HashMap<String,Room> roomList, ArrayList<String> itemList) {
		//All of the items associated with the Ocean room.
		if(Main.currentRoom.equals("ocean")) {
			roomList.get("ocean").itemList.add("notebook");
			roomList.get("ocean").itemList.add("rock"); 
		}
		
		//All of the items associated with Kelp Forrest.
		if(Main.currentRoom.equals("Kelp forrest")) {
			roomList.get("Kelp forrest").itemList.add("healing potion"); 
		}
		
		//All of the items associated with The Cave.
		if(Main.currentRoom.equals("The Cave")) {
			
		}
		//All of the items associated with Ship Wreck. 
		if(Main.currentRoom.equals("Ship wreck")) {
			
		}
	}
}


