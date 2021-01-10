import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.IllegalStateException;
import java.lang.String;


import com.univocity.parsers.common.processor.*;
import com.univocity.parsers.common.record.*;
import com.univocity.parsers.csv.*;
/*
 * This class handles the reading of the Netflix CSV file taken from Kaggle.
 */


public class NetflixCSVReader {
	
	protected String filename;
	
	public List<NetflixData> allNetflixData = new LinkedList<NetflixData>();
	NetflixDataCleanup ndc = new NetflixDataCleanup();

	public NetflixCSVReader(String name) {
		filename = name;	
		
	}
	
	
	public Reader getReader(String relativePath) {
	    try {
	        return new InputStreamReader(new FileInputStream(new File(relativePath)), "UTF-8");
	    } catch (IOException e) {
	        throw new IllegalStateException("Unable to read input", e);
	    } 
	}
	
	public List<NetflixData> parseData(Map<String, String> map) {
		
	    RowListProcessor rowProcessor = new RowListProcessor();
	    CsvParserSettings parserSettings = new CsvParserSettings();

	    boolean first = false;
	    int count = 0;
	    
	    parserSettings.setSkipEmptyLines(true); // skip empty lines
	    parserSettings.selectIndexes(1, 2, 3, 4, 5, 7, 8, 9, 10, 11); // only parse these column numbers
	    parserSettings.setColumnReorderingEnabled(false); // retain csv column order
	    parserSettings.setHeaderExtractionEnabled(true);
	    parserSettings.setLineSeparatorDetectionEnabled(true);
	    parserSettings.setProcessor(rowProcessor);

	    CsvParser parser = new CsvParser(parserSettings);
	    
	    parser.beginParsing(getReader("netflix_titles.csv"));
	    
    	Record record;
    	
    	// iterate through csv line by line using Record class and parser
	    while ((record = parser.parseNextRecord()) != null && count < 25) {
	    	
	    	// ignore storing the first line of the csv file
	    	if (first == false) {
	    		first = true;
	    	}
	    	else {
	    		
	    		boolean match = false;
	    		boolean titlematch = false;
	    		
	    		// remove any non-numerical char from "duration" field
		    	String durationNoChar = record.getString("duration");
		    	durationNoChar = durationNoChar.replaceAll("[^\\d.]", "");	
		    	
		    	// Raw data variables
		    	String directorString = record.getString("director");
		    	String castString = record.getString("cast");
		    	String countryString = record.getString("country");
		    	String listedinString = record.getString(10);
		    	String typeString = record.getString("type");
		    	String titleString = record.getString("title");
		    	String ratingString = record.getString("rating");
		    	String descriptionString = record.getString(11);
		    	int releaseYearInt = Integer.valueOf(record.getString("release_year"));
		    	int durationInt = Integer.valueOf(durationNoChar);
		    	
		    	
		    	List<String> director = new ArrayList<String>();
		    	if (directorString != null) {
			    	director = Arrays.asList(directorString.split(", "));
		    	}
		    	List<String> cast = new ArrayList<String>();
		    	if (castString != null) {
			    	cast = Arrays.asList(castString.split(", "));
		    	}
		    	List<String> country = new ArrayList<String>();
		    	if (countryString != null) {
		    		country = Arrays.asList(countryString.split(", "));
		    	}     	
		    	List<String> genre = new ArrayList<String>();
		    	if (listedinString != null) {
			    	genre = Arrays.asList(listedinString.split(", "));
		    	} 
		    	
				String searchGenre = map.get("Genre");
				List<String> genreList = ndc.convertGenre(searchGenre);
				
				String searchRating = map.get("Rating");
				List<String> ratingList = ndc.convertRating(searchRating);
				
				// check title keyword string
		    	titlematch = false;
		    	if (titleString.contains(map.get("Keyword"))) {
		    		titlematch = true;
				}
		    	
		    	// if keyword search is not used, check the other fields
				if (titlematch == false) {
	
					// check genre match
					if (genreList == null) {
						match = true;
					}
					else if (genre == null) {
						match = false;
					}
					else if (listedinString.equals("---")) {
						match = true;
					}
					else {
						for (String g: genreList) {
							for (String g2: genre) {
								if (g.equals(g2)) {
									match = true;
								}
							}
						}
					}
					if (match == false) {
						continue;
					}
					
					
					// check rating match
					match = false;
					if (ratingList == null) {
						match = true;
					}
					else if (ratingString == null) {
						match = false;
					}
					else if (ratingString.equals("---")) {
						match = true;
					}
					else {
						for (String r: ratingList) {
							if (r.equals(ratingString)) {
								match = true;
								continue;
							}
						}
					}
					if (match == false) {
						continue;
					}
					
					// check type match
					match = false;
					String searchType = map.get("Type");
					if (searchType.equals(typeString)) {
						match = true;
					}
					else if (searchType.equals("Both")) {
						match = true;
					}
					if (match == false) {
						continue;
					}
					
					// check director match
			    	match = false;
			    	if (map.get("Director").equals("---")) {
			    		match = true;
			    	}
			    	else {
						for (String d: director) {
							if (d.equals(map.get("Director"))) {
								match = true;
								continue;
							}
						}
			    	}
					if (match == false) {
						continue;
					}
					
					
					// check cast match
			    	match = false;
			    	if (map.get("Cast").equals("---")) {
			    		match = true;
			    	}
			    	else {
						for (String c: cast) {
							if (c.equals(map.get("Cast"))) {
								match = true;
								continue;
							}
						}
			    	}
					if (match == false) {
						continue;
					}
					
					// check country match
			    	match = false;
			    	if (map.get("Country").equals("---")) {
			    		match = true;
			    	}
			    	else {
						for (String c: country) {
							if (c.equals(map.get("Country"))) {
								match = true;
								continue;
							}
						}
			    	}
					if (match == false) {
						continue;
					}
					
					// check release year
					match = false;
					String searchReleaseYear = map.get("Release Year");
					if (searchReleaseYear.equals("---")) {
						match = true;
					}
					else if (searchReleaseYear.equals("pre-1960s")) {
						if (releaseYearInt < 1970) {
							match = true;
						}
					}
					else if (searchReleaseYear.equals("1970s")) {
						if (1970 <= releaseYearInt && releaseYearInt < 1980) {
							match = true;
						}
					}
					else if (searchReleaseYear.equals("1980s")) {
						if (1980 < releaseYearInt && releaseYearInt < 1990) {
							match = true;
						}
					}
					else if (searchReleaseYear.equals("1990s")) {
						if (1990 <= releaseYearInt && releaseYearInt < 2000) {
							match = true;
						}
					}
					else if (searchReleaseYear.equals("2000s")) {
						if (2000 <= releaseYearInt && releaseYearInt < 2010) {
							match = true;
						}
					}
					else if (searchReleaseYear.equals("2010s")) {
						if (2010 <= releaseYearInt && releaseYearInt < 2020) {
							match = true;
						}
					}
					else if (searchReleaseYear.equals("2020")) {
						if (2020 <= releaseYearInt) {
							match = true;
						}
					}
					if (match == false) {
						continue;
					}
					
					// search duration
					match = false;
					String searchDuration = map.get("Duration");
					if (searchDuration.equals("---")) {
						match = true;
					}
					else if (searchDuration.equals("1 Season (TV-only)")) {
						if (durationInt <= 1) {
							match = true;
						}
					}
					else if (searchDuration.equals("Short Film (<40 min)")) {
						if (1 < durationInt && durationInt < 40) {
							match = true;
						}
					}
					else if (searchDuration.equals("Featurette (40-75 min)")) {
						if (40 <= durationInt && durationInt <= 75) {
							match = true;
						}
					}
					else if (searchDuration.equals("Feature Film (75+ min)")) {
						if (75 < durationInt) {
							match = true;
						}
					}
					if (match == false) {
						continue;
					} 
				}
				
		    	// create NetflixData objects
		    	NetflixData nfd = new NetflixData(typeString, titleString, director, 
		    			cast, country, releaseYearInt, ratingString,
		    			durationInt, genre, descriptionString); 
		    	
		    	//System.out.println(nfd.toString()); // test print
		    	
		    	allNetflixData.add(nfd); // add NetflixData object to list
		    	count++;
	    	}
	    }
	    parser.stopParsing(); 
	    
	    return allNetflixData;
	}
	public void clearNetflixData() {
		allNetflixData.clear();
	}
	
	public List<NetflixData> getAllNetflixData() {
		return allNetflixData;
	}
}