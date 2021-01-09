import java.awt.EventQueue;

/*
 * This class starts the application via the command line arguments.
 */

public class Main {
	
	public static void main(String[] args) {
	
		String filename = args[0];
		
		// create reader, processor, and user interface objects
		NetflixCSVReader reader = new NetflixCSVReader(filename);
		NetflixProcessor processor = new NetflixProcessor(reader);
		NetflixSearch searcher = new NetflixSearch(processor);		
		
		// start the GUI
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HackflixMainGUI window = new HackflixMainGUI(searcher);
					window.frmHackflix.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
				
	}
}
