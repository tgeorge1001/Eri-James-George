import java.util.Collections;
import java.util.Comparator;
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

	/**
	 * This method sorts by alphabetical order ascending
	 * @param "input" data set to search from
	 */
	Comparator<NetflixData> compareByTitle = new Comparator<NetflixData>() {
		@Override
		public int compare(NetflixData nf1, NetflixData nf2) {
			return nf1.getTitle().compareTo(nf2.getTitle());
		}
	};

	public List<NetflixData> sortByAlphabetAscend(List<NetflixData> input) {
		Collections.sort(input, compareByTitle);
		return input;
	};

	/**
	 * This method sorts by alphabetical order descending
	 * @param "input" data set to search from
	 */
	public List<NetflixData> sortByAlphabetDescend(List<NetflixData> input) {
		Collections.sort(input, compareByTitle.reversed());
		return input;
	};

	/**
	 * This method sorts by year in ascending order
	 * @param "input" data set to search from
	 */
	Comparator<NetflixData> compareByYear = new Comparator<NetflixData>() {
		@Override
		public int compare(NetflixData nfd1, NetflixData nfd2) {
			Integer nf1 = nfd1.getReleaseyear();
			Integer nf2 = nfd2.getReleaseyear();
			return nf1.compareTo(nf2);
		}
	};

	public List<NetflixData> sortByPriceAscend(List<NetflixData> input) {
		Collections.sort(input, compareByYear);
		return input;
	};

	/**
	 * This method sorts by year in descending order
	 * @param "input" data set to search from
	 */
	public List<NetflixData> sortByPriceDescend(List<NetflixData> input) {
		Collections.sort(input, compareByYear.reversed());
		return input;
	};

}
