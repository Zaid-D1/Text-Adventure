package textAdventureGame;

import java.util.ArrayList;
import java.util.HashMap;

class Room {

	private String title;
	private String description;	
	private String N,S,E,W;
	
	Room(String t, String d) {
		title = t;
		description = d;
	}
	

	private void setExits(String N, String S, String W, String E) {
		this.N = N;
		this.S = S;
		this.W = W;
		this.E = E;		
	}
	
	String getExit(char c) {
		switch (c) {
		case 'n': return this.N;
		case 's': return this.S;
		case 'w': return this.W;
		case 'e': return this.E;
		default: return null;
		}
	}
	
	String getTitle() {return title;}
	String getDesc() {return description;}
	
	//ONLY done at the beginning of the game
	static void setupRooms(HashMap<String,Room> roomList) {
		//ROOM #1
		Room r = new Room("Back yard", "The garden is peaceful with flowers, birds");
		//          N S W E
		r.setExits("", "park", "den", "kitchen");
		roomList.put("backyard", r); 
		
		//ROOM #2
		r = new Room("The Kitchen", "You see a fridge, stove, cubpoards. "
				+ "The hallway is to the west, east takes you to the back yard");
		r.setExits("", "", "hall1", "backyard");
		roomList.put("kitchen", r);
		
		//ROOM #3
		r = new Room("Hallway", "The front hallway connects the front door to the kitchen, living room,"
				+ " bedrooms (south) and den (down)"); 
		r.setExits("frontYard", "bedroom1", "livingroom", "kitchen");
		roomList.put("hall1", r);
		
	}
	
	//A method that will setup the items for each room. 
	static void setupItems(ArrayList<String> itemList) {
		//Items for room 1
		itemList.add("notebook"); 
		
		//Items for room 2
		itemList.add("cup");
		
		//Item for room 3
		itemList.add("picture");
		
	}
}
  
