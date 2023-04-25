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
		Room r = new Room("The Ocean", "The vast, and soundless ocean. There's a forrest to the east, "
				+ "a cave to the West, and a shipwreck all the way at the bottom of the ocean. "
				+ "North is out of water, if you go north the seagulls will eat you because you are small. "
				+ "You see a rock stuck on a coral");
		//          N E S W
		r.setExits("", "Kelp forest", "Shipwreck", "Cave");
		roomList.put("ocean", r);

		r = new Room("The Kelp forrest", "You see giant kelp all around, a water proof notebook, and milk. "
				+ "There are a few baby piranhas that you need to fight, west takes you back to the still waters. There is "
				+ "a path that leads south to a mysterious portal");
		r.setExits("", "", "", "ocean");
		roomList.put("Kelp forest", r);

		r = new Room("Shipwreck", "Scary and somehow still in perfect conditon, the sails are torn but everything else is fine,"
				+ "There are a few skelton pirates on board, You see a door on deck towards the ships kitchen"
				+ "Still waters (North), a path leads west to a mysterious portal"); 
		r.setExits("still waters", "", "", "Cave");
		roomList.put("Shipwreck", r);
		
		r = new Room("The Cave", "dark and gloomy, open your water proof flashlight to look around"
				+ "Becareful, there are a few eels here and there, Still waters (east), Kelp forest (east x2),"
				+ "A path leads north to a mysterious portal"); 
		r.setExits("Shipwreck", "Kelp forrest", "", "");
		roomList.put("Cave", r);
		
		//boss rooms for each main room	
		r = new Room("The Kelp Forest - Boss Room", "A mother piranha awaits you. Brace yourself for an epic battle!");
		r.setExits("", "", "", "");
		roomList.put("Kelp Forest - Boss Room", r);
		
		r = new Room("Cave - Boss Room", "A giant kraken blocks your way. Prepare for a fierce battle!");
		r.setExits("", "", "", "");
		roomList.put("Ocean - Boss Room", r);
		
		r = new Room("Shipwreck - Boss Room", "A deadly pirate captain");
		
	}


	//A method that will setup the items for each room. 
	static void setupItems(HashMap<String,Room> roomList, ArrayList<String> itemList) {
		//All of the items associated with the Ocean room.
		if(Main.currentRoom.equals("ocean")) {
			roomList.get("ocean").itemList.add("rock"); 
		}
		
		//All of the items associated with Kelp Forrest.
		if(Main.currentRoom.equals("Kelp forest")) {
			roomList.get("Kelp forest").itemList.add("milk");
			roomList.get("ocean").itemList.add("notebook");
	
		}
		
		//All of the items associated with The Cave.
		if(Main.currentRoom.equals("The Cave")) {
			roomList.get("The Cave").itemList.add("KoolAid"); 
			
		}
		//All of the items associated with Ship Wreck. 
		if(Main.currentRoom.equals("Ship wreck")) {
			
		}
	}
	 
	 Enemy getEnemy() {
		 switch(Main.currentRoom) {
		 case "Kelp forest":
			 return Main.enemiesMap.get("Baby Piranha");
		 case "Kelp forrest - Boss Room":
			 return Main.enemiesMap.get("Mother Piranha");
		 case "Cave":
			 return Main.enemiesMap.get("Eels");
		 case "Boss Room - The Cave":
			 return Main.enemiesMap.get("Giant Kraken");
		 case "Shipwreck":
			 return Main.enemiesMap.get("skeleton pirates");
		 case "Boss Room - Shipwreck":
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


