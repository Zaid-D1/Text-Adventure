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
		Items it = new Items("Notebook", "The Ocean Kingdom has been invaded by three outlaws of the kingdom:\n"
				+ "the Kelp Queen, who now controls the Kelp Forrest, the Golem, who now controls the Caverns,\n and"
				+ "the Krab, who now controls the Shipwreck.", 0); 
		itemMap.put("notebook", it); 
//dawd
		it = new Items ("Healing Potion", "The potion is made out of phytoplankton", 0);
		itemMap.put("healing potion", it);

		//Damage Items
		it = new Items("Rock", "A rock that has some magic aura.", 10); 
		itemMap.put("rock", it);

		it = new Items("Spear", "A strudy and sharp weapon with it's shaft made out of wood and the head made out of "
				+ "the Rock.", 20); 
		itemMap.put("spear", it);

		it = new Items("Sling", "The bow is forged out of some fishing line and some wood that came of the "
				+ "shipwreck, and the arrow is made out of the Rock.", 30);
		itemMap.put("sling", it);

	}



}
