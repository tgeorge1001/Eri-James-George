
public class Main {
	
	public static void main(String[] args) {
	
		String filename = args[0];
		
		// create reader, processor, and user interface objects
		NetflixCSVReader reader = new NetflixCSVReader(filename);
		NetflixProcessor processor = new NetflixProcessor(reader);
		NetflixUserInterface ui = new NetflixUserInterface(processor);
		
		ui.start(); // run the program to interact with user
	}
}
