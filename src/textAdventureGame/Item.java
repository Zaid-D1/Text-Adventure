package textAdventureGame;
import java.util.HashMap;

public class Item {

	//Characteristics of the items.
	String name; 
	String description;  
	int damagePoints = 0; 
	
	
	Item (String n, String d, int damage){
		name = n; 
		description = d; 
		damagePoints = damage; 
	}
	
	//Setting up all of the items in the game and putting them in a hash map. 
	static void setUpItems (HashMap <String, Item> itemMap) {
		Item it = new Item("notebook", "A set of instruction for the game", 0); 
		itemMap.put("notebook", it); 
		
		it = new Item("rock", "an ordinary rock", 10); 
		itemMap.put("rock", it);
		
		it = new Item("kelp", "a greenish plant", 0);
		itemMap.put("kelp", it);
		
	}
	
	
	
}
