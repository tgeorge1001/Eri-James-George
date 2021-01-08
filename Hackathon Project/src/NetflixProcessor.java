import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* 
 * This class is responsible for processing data (e.g. title, director, cast, etc.) 
 * obtained by the NetflixDataCSVReader class.
 */

public class NetflixProcessor {

	protected NetflixCSVReader reader;
	protected List<NetflixData> allNetflixData;
	
	/*
	 * Declare private lists to store Hackflix search results
	 */
	private List<NetflixData> searchResults = new ArrayList<NetflixData>();
	
	/* 
	 * HashSet stores all choices for each feature of a Netflix show 
	 * */
	private HashSet<Integer> showIDSet = new HashSet<Integer>();
	private HashSet<String> typeSet = new HashSet<String>();
	private HashSet<String> titleSet = new HashSet<String>();
	private HashSet<String> directorSet = new HashSet<String>();
	private HashSet<String> castSet = new HashSet<String>();
	private HashSet<String> countrySet = new HashSet<String>();
	private HashSet<Integer> releaseYearSet = new HashSet<Integer>();
	private HashSet<String> ratingSet = new HashSet<String>();
	private HashSet<Integer> durationSet = new HashSet<Integer>();
	private HashSet<String> genreSet = new HashSet<String>();
	private HashSet<String> descriptionSet = new HashSet<String>();
	
	/* 
	 * Constructor sorts information from all available Netflix data to HashSets
	 */
	public NetflixProcessor(NetflixCSVReader reader) {
		this.reader = reader;
		this.allNetflixData = reader.getAllNetflixData();
		
		for (NetflixData data : allNetflixData) {
			showIDSet.add(data.getShowid());
			typeSet.add(data.getType());
			titleSet.add(data.getTitle());
			directorSet.addAll(data.getDirector());
			castSet.addAll(data.getCast());
			countrySet.addAll(data.getCountry());
			releaseYearSet.add(data.getReleaseyear());
			ratingSet.add(data.getRating());
			durationSet.add(data.getDuration());
			genreSet.addAll(data.getGenre());
			descriptionSet.add(data.getDescription());
		}
	}
	
	/*
	 * Getters for HashSets with NetflixData field
	 */
	public List<NetflixData> getSearchResults() {
		return searchResults;
	}

	public HashSet<Integer> getShowIDSet() {
		return showIDSet;
	}

	public HashSet<String> getTypeSet() {
		return typeSet;
	}

	public HashSet<String> getTitleSet() {
		return titleSet;
	}

	public HashSet<String> getDirectorSet() {
		return directorSet;
	}

	public HashSet<String> getCastSet() {
		return castSet;
	}

	public HashSet<String> getCountrySet() {
		return countrySet;
	}

	public HashSet<Integer> getReleaseYearSet() {
		return releaseYearSet;
	}

	public HashSet<String> getRatingSet() {
		return ratingSet;
	}

	public HashSet<Integer> getDurationSet() {
		return durationSet;
	}

	public HashSet<String> getGenreSet() {
		return genreSet;
	}

	public HashSet<String> getDescriptionSet() {
		return descriptionSet;
	}

	public List<NetflixData> getAllNetflixData() {
		return allNetflixData;
	}
	
	
}
