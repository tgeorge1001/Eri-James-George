import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NetflixCSVReader {
	
	protected String filename;

	public NetflixCSVReader(String name) {
		filename = name;
	}
	
	// to-do: here is an example parser, but it's REALLY slow for large files, 
	// so I think we should make this method more efficient
	public List<NetflixData> getAllNetflixData() {
		
		List<NetflixData> allNetflixData = new LinkedList<NetflixData>();
		
		Scanner sc = null;

		try {
			sc = new Scanner((new File(filename)));

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] values = line.split(",", -1); // split based on commas

				try {
					// Change this line to match NetflixData object
					/* NetflixData nfd = new NetflixData(values[5], values[3], values[0], values[6],
							values[2], Double.parseDouble(values[1]), values[4]); 
	
					/allNetflixData.add(nfd); */
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
	}
}