import java.awt.EventQueue;

/*
 * This class starts the application via the command line arguments.
 */

public class Main {
	
	public static void main(String[] args) {
	
		String filename = args[0];
		
		// create reader
		NetflixCSVReader reader = new NetflixCSVReader(filename);
		
		// start the GUI 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HackflixMainGUI window = new HackflixMainGUI(reader);
					window.frmHackflix.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
				
	}
}
