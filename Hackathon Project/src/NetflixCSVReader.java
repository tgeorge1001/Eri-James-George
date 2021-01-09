import java.io.*;
import java.util.*;
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
	List<NetflixData> allNetflixData = new LinkedList<NetflixData>();

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
	
	public List<NetflixData> parseData() {
		
	    RowListProcessor rowProcessor = new RowListProcessor();
	    CsvParserSettings parserSettings = new CsvParserSettings();

	    boolean first = false;
	    
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
	    while ((record = parser.parseNextRecord()) != null) {
	    	
	    	// ignore storing the first line of the csv file
	    	if (first == false) {
	    		first = true;
	    	}
	    	else {
	    		// remove any non-numerical char from "duration" field
		    	String durationNoChar = record.getString("duration");
		    	durationNoChar = durationNoChar.replaceAll("[^\\d.]", "");	
		    	
		    	String directorString = record.getString("director");
		    	String castString = record.getString("cast");
		    	String countryString = record.getString("country");
		    	String listedinString = record.getString(10);
		    	String genreString = record.getString(11);
		    	
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
		    	if (genreString != null) {
			    	genre = Arrays.asList(genreString.split(", "));
		    	} 
		    		    	
		    	// create NetflixData objects
		    	NetflixData nfd = new NetflixData(record.getString("type"), record.getString("title"), director, 
		    			cast, country, Integer.valueOf(record.getString("release_year")), record.getString("rating"),
		    			Integer.valueOf(durationNoChar), genre, record.getString(11)); 
		    	
		    	System.out.println(nfd.toString()); // test print
		    	
		    	allNetflixData.add(nfd); // add NetflixData object to list
		    	
	    	}
	        
	    }
	    parser.stopParsing(); 
	    
	    return allNetflixData;
	}
	
	public List<NetflixData> getAllNetflixData() {
		return allNetflixData;
	}
}