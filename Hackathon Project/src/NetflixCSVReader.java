import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.*;

import java.lang.IllegalStateException;
import java.lang.String;

//package com.univocity.parsers.*;

import com.univocity.parsers.common.*;
import com.univocity.parsers.common.processor.*;
import com.univocity.parsers.common.record.*;
import com.univocity.parsers.conversions.*;
import com.univocity.parsers.csv.*;
//import org.testng.annotations.*;
/*
 * This class handles the reading of the Netflix CSV file taken from Kaggle.
 */

public class NetflixCSVReader {
	
	protected String filename;

	public NetflixCSVReader(String name) {
		filename = name;
	}
	
	public Reader getReader(String relativePath) {
	    try {
	        return new InputStreamReader(this.getClass().getResourceAsStream(relativePath), "Windows-1252");
	    } catch (UnsupportedEncodingException e) {
	        throw new IllegalStateException("Unable to read input", e);
	    }
	}
	
	public void columnSelection() {
	    RowListProcessor rowProcessor = new RowListProcessor();
	    CsvParserSettings parserSettings = new CsvParserSettings();

	    parserSettings.setRowProcessor(rowProcessor);
	    parserSettings.setHeaderExtractionEnabled(true);
	    parserSettings.setLineSeparatorDetectionEnabled(true);
	    parserSettings.setSkipEmptyLines(true);
	    parserSettings.setNumberOfRowsToSkip(1);

	    // Here we select only certain columns.
	    // The parser just skips the other fields
	    parserSettings.selectFields("type", "title", "director", "cast", "country", "releaseyear", "rating", "duration", "genre", "description");

	    CsvParser parser = new CsvParser(parserSettings);
	    parser.parse(getReader("netflix_titles.csv"));

	    List<String[]> rows = rowProcessor.getRows();

	    String[] strings = rows.get(0);

	    System.out.print(strings[0]);

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