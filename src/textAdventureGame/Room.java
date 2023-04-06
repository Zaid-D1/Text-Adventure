package textAdventureGame;

import java.util.ArrayList;
import java.util.HashMap;

class Room {

	private String title;
	private String description;	
	private String N,S,E,W;
	
	// items in this room FIXME (should this be private?)
	ArrayList<Item> itemList = new ArrayList<Item>();
	
	Room(String t, String d) {
		title = t;
		description = d;
	}
	
	//FIXME should this be private?
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
		Room r = new Room("The Ocean", "The vast, and soundless ocean");
		//          N S W E
		r.setExits("", "Kelp forrest", "cave", "Shipwreck");
		roomList.put("The Ocean", r);
		
		r = new Room("The Kelp forrest", "You see giant kelp all around, a fish skeleton, water proof notebook. "
				+ "The opeaning to the forrest is to the east, west takes you back to the still waters");
		r.setExits("", "", "still waters", "The Ocean");
		roomList.put("Kelp forrest", r);
		
		r = new Room("Hallwa", "The front hallway connects the front door to the kitchen, living room,"
				+ " bedrooms (south) and den (down)"); 
		r.setExits("frontYard", "bedroom1", "livingroom", "kitchen");
		roomList.put("hall1", r);
	}
}
  
