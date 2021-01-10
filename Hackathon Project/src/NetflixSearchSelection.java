import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This class creates the map used to store the user's search selection.
 */

public class NetflixSearchSelection {
	
	private Map<String, String> searchSelection;

	public NetflixSearchSelection() {
		initializeMap();
	}
	
	public void initializeMap() {
		searchSelection = new HashMap<String, String>();
		searchSelection.put("Genre", "---");
		searchSelection.put("Release Year", "---");
		searchSelection.put("Rating", "---");
		searchSelection.put("Director", "---");
		searchSelection.put("Cast", "---");
		searchSelection.put("Duration", "---");
		searchSelection.put("Country", "---");
		searchSelection.put("Type", "---");
		searchSelection.put("Keyword", "---");
	}
	
	public Map<String, String> getInitializedMap() {
		initializeMap();
		return searchSelection;
	}
	
	public void printMap(Map<String, String> map) {
		System.out.println("You selected the following:");
		for (String key: map.keySet()){
            String value = map.get(key);  
            System.out.println(key + ": " + value);  
		} 
	}

	
}
