import java.util.List;

public class NetflixProcessor {

	protected NetflixCSVReader netflixCSVReader;
	protected List<NetflixData> allNetflixData;

	public NetflixProcessor(NetflixCSVReader netflixCSVReader) {
		this.netflixCSVReader = netflixCSVReader;
		this.allNetflixData = netflixCSVReader.getAllNetflixData();
	}

	/*
	 *  Add methods that return values from dataset
	 */

}
