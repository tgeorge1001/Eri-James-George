import java.util.List;

/*
 * This class provides search functionality that takes in the user's selection(s) and returns the result(s).
 */

public class NetflixSearch {
	
	protected NetflixProcessor processor;
	
	protected List<NetflixData> allNetflixData;
	
	public NetflixSearch(NetflixProcessor processor) {
		this.processor = processor;
		this.allNetflixData = processor.getAllNetflixData();
	}
	
	/* Add methods for search function */
}
