package textAdventureGame;
public class Item {

	//Instance Variable.
	static String notebook = ""; 
	static String pearl = ""; 
	
	Item (String item){
		switch (item){
		case "Notebook":
			notebook = item; 
			break;
		}
	}
	
	
	@Override
	public String toString() { 
		String s = "";
		if(notebook.equals("notebook")) s = notebook; 
		if(pearl.equals("pearl")) s = pearl; 
		return s; 
	}
}
