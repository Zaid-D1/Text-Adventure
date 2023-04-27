/* Prayag and Zaid
 * April 25, 2023
 * A class that creates six item for the text adventure and each item having a name, description of the item, and the damage points. 
 */

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
		Items it = new Items("Notebook", "The Ocean Kingdom has been invaded by three outlaws: "
				+ " the Mother Piranha, the Giant Kraken, and the Skeleton Pirate Captain. It's your duty to protect the people of "
				+ "the Ocean Kingdom by slaying the outlaws. ", 0); 
		itemMap.put("notebook", it); 

		it = new Items ("Caviar", "Hmm the rich people food.", 0);
		itemMap.put("caviar", it);
		
		it = new Items("KoolAid", "A nice cold glass of Kool-Aid.", 0);
		itemMap.put("KoolAid", it);

		//Damage Items
		it = new Items("Rock", "A rock that has some magic aura.", 10); 
		itemMap.put("rock", it);

		it = new Items("Spear", "A strudy and sharp weapon with it's shaft made out of wood and the head made out of "
				+ "the magic rock.", 20); 
		itemMap.put("spear", it);

		it = new Items("Sling", "The sling is a deadly weapon made out of rubber bands ", 30);
		itemMap.put("sling", it);	
	}
}