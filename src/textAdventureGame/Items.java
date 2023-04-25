package textAdventureGame;
import java.util.HashMap;

public class Items {

	//Characteristics of the items.
	private String name; 
	private	String description;  
	private int damagePoints = 0; 
	

	Items (String n, String d, int damage){
		name = n; 
		description = d; 
		damagePoints = damage; 
	}
	
	
	
	String getItemName() {return name; }
	String getItemDesc() {return description;}
	int getItemDamage() {return damagePoints;}
	

	//Setting up all of the items in the game and putting them in a hash map. 
	static void setupItems (HashMap <String, Items> itemMap) {

		//Non-Damage Items
		Items it = new Items("Notebook", "The Ocean Kingdom has been invaded by three outlaws of the kingdom: "
				+ "Mother Piranha, Giant Kraken, who now controls the Caverns, and "
				+ "Skeleton Pirate Captain.", 0); 
		itemMap.put("notebook", it); 

		it = new Items ("Caviar", "", 0);
		itemMap.put("caviar", it);
		
		it = new Items("KoolAid", "A nice cold glass of Kool-Aid.", 0);
		itemMap.put("KoolAid", it);

		//Damage Items
		it = new Items("Rock", "A rock that has some magic aura.", 10); 
		itemMap.put("rock", it);

		it = new Items("Spear", "A strudy and sharp weapon with it's shaft made out of wood and the head made out of "
				+ "the carved rock.", 20); 
		itemMap.put("spear", it);

		it = new Items("Sling", "The bow is forged out of some fishing line and some wood that came of the "
				+ "shipwreck, and the arrow is made out of the Rock.", 30);
		itemMap.put("sling", it);
		

	}



}
