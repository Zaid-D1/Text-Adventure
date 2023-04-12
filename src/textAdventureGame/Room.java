package textAdventureGame;

import java.util.ArrayList;
import java.util.HashMap;

class Room {

	private String title;
	private String description;	
	private String N,E,S,W;

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
		r.setExits("", "Kelp forrest", "Shipwreck", "Cave");
		roomList.put("ocean", r);

		r = new Room("The Kelp forrest", "You see giant kelp all around, water proof notebook. "
				+ "The opeaning to the forrest is to the east, west takes you back to the still waters");
		r.setExits("", "", "still waters", "ocean");
		roomList.put("Kelp forrest", r);

		r = new Room("Shipwreck", "Scary and somehow still in perfect conditon, the sails are torn but everything else is fine,"
				+ "\nYou see a door on deck leading to the captians room, and one more door leading towards the ships kitchen"
				+ "\nStill waters (North)"); 
		r.setExits("still waters", "", "", "");
		roomList.put("Shipwreck", r);
		
		r = new Room("The Cave", "dark and gloomy, open your water proof flashlight to look around"
				+ "Still waters (east), Kelp forrest (east x2)"); 
		r.setExits("still waters", "Kelp forrest", "", "");
		roomList.put("Cave", r);
	}

	//A method that will setup the items for each room. 
	static void setupItems(ArrayList<String> itemList) {
		//Items for room 1
		//roomList.get("ocean").itemList.add("notebook"); 

		//Items for room 2
		itemList.add("cup");

		//Item for room 3
		itemList.add("picture");


	}
}

