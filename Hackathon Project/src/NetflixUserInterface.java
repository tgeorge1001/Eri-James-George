import java.util.Scanner;

public class NetflixUserInterface {
	
	protected NetflixProcessor processor;
	protected Scanner in;

	public NetflixUserInterface(NetflixProcessor processor) {
		this.processor = processor;
		in = new Scanner(System.in);
	}
	
	// starts the user interface
	public void start() {
	
	}
}
