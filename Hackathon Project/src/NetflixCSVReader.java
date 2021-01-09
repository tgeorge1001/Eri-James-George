import java.io.*;
import java.util.*;
import java.lang.IllegalStateException;
import java.lang.String;

//package com.univocity.parsers.*;

import com.univocity.parsers.common.processor.*;
import com.univocity.parsers.common.record.*;
import com.univocity.parsers.csv.*;
//import org.testng.annotations.*;
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
	    
	    /*
	    parserSettings.setRowProcessor(rowProcessor);
	    parserSettings.setHeaderExtractionEnabled(true);
	    parserSettings.setLineSeparatorDetectionEnabled(true);
	    parserSettings.setSkipEmptyLines(true);
	    parserSettings.setNumberOfRowsToSkip(1);

	    // Here we select only certain columns.
	    // The parser just skips the other fields
	    parserSettings.selectFields("type", "title", "director", "cast", "country", "releaseyear", "rating", "duration", "genre", "description");
	     */
	    
	    CsvParser parser = new CsvParser(parserSettings);
	    
	    parser.beginParsing(getReader("netflix_titles.csv"));
	    
	    // Use these ArrayLists to store fields with multiple values
    	ArrayList<String> director = new ArrayList<String>();
    	ArrayList<String> cast = new ArrayList<String>();
    	ArrayList<String> country = new ArrayList<String>();
    	ArrayList<String> genre = new ArrayList<String>();
    	
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
		    	
		    	// create NetflixData objects
		    	NetflixData nfd = new NetflixData(record.getString("type"), record.getString("title"), director, 
		    			cast, country, Integer.valueOf(record.getString("release_year")), record.getString("rating"),
		    			Integer.valueOf(durationNoChar), genre, "duration"); 
		    	
		    	System.out.println(nfd.toString()); // test print
		    	
		    	allNetflixData.add(nfd); // add NetflixData object to list
	    	}
	        
	    }
	    parser.stopParsing();
	    
	    return allNetflixData;
	    
	    /*
	    List<String[]> parsedRows = parser.parseAll(getReader("netflix_titles.csv"));
	    
	    System.out.println(Arrays.toString(parsedRows.get(0)));
	    
	    List<String[]> rows = rowProcessor.getRows();

	    String[] strings = rows.get(0);

	    System.out.println(strings[0]); 
	    */

	}
	
	
	// to-do: here is an example parser, but it's REALLY slow for large files, 
	// so I think we should make this method more efficient
	/*public List<NetflixData> getAllNetflixData() {
		
		List<NetflixData> allNetflixData = new LinkedList<NetflixData>();
		
		Scanner sc = null;

		try {
			sc = new Scanner((new File(filename)));

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] values = line.split(",", -1); // split based on commas

				try {
					// Change this line to match NetflixData object
					 NetflixData nfd = new NetflixData(values[5], values[3], values[0], values[6],
							values[2], Double.parseDouble(values[1]), values[4]); 
	
					/allNetflixData.add(nfd); 
				} catch (NumberFormatException nfe) {
					// ignore and move on
				}
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: " + filename + " file not found or readable.");
			System.exit(1);
		} finally {
			sc.close(); // close scanner
		}

		return allNetflixData;
	}*/
}