
public class Main {
	
	public static void main(String[] args) {
	
		String netflixFilename = args[0];
		NetflixCSVReader parkingViolationReader = new NetflixCSVReader(netflixFilename);
	
		NetflixProcessor processor = new NetflixProcessor(parkingViolationReader);
		NetflixUserInterface ui = new NetflixUserInterface(processor);
		ui.start(); // run the program to interact with user
	}
}
