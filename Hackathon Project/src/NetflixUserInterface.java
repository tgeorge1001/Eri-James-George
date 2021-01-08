import java.util.Scanner;

/* 
 * This class is responsible for interacting with the user and processing data as it relates to displaying it. 
 */

public class NetflixUserInterface {
	
	protected NetflixProcessor processor;
	protected NetflixSearch searcher;
	protected Scanner in;

	public NetflixUserInterface(NetflixProcessor processor, NetflixSearch searcher) {
		this.processor = processor;
		this.searcher = searcher;
	}
	
	// starts the user interface
	public void start() {
		HackflixMainGUI mainGUI = new HackflixMainGUI();
	}
}
