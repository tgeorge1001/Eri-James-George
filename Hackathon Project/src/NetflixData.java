import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a single movie or TV Show on Netflix.
 * @author jamesgrimes
 *
 */
public class NetflixData {
	
	// Instance Variables
	
	/**
	 * A unique ID for this particular content.
	 */
	//int showid;
	
	/**
	 * A string that represents the content's type, either "TV Show" or "Movie"
	 */
	String type;
	
	/**
	 * The title of the movie or tv show.
	 */
	String title;
	
	/**
	 * The directors of this movie or tv show, if any are listed.
	 */
	List<String> director = new ArrayList<String>();;
	
	/**
	 * The cast of this movie or tv show, if any are listed.
	 */
	List<String> cast = new ArrayList<String>();;
	
	/**
	 * The country or countries where the movie or tv show was produced.
	 */
	List<String> country = new ArrayList<String>();;
	
	/**
	 * The year this movie or TV show was released.
	 */
	int releaseyear;
	
	/**
	 * The age-rating given to the movie or TV show.
	 */
	String rating;
	
	/**
	 * The length of the movie or tv show. Units are minutes for movies and seasons for tv shows.
	 */
	int duration;
	
	/**
	 * All the categories this movie or tv show is listed under.
	 */
	List<String> genre = new ArrayList<String>();;
	
	/**
	 * A description of the movie or TV show.
	 */
	String description;
	
	// Constructor method
	
	/**
	 * Creates a NetflixData object using the given type, title, director, cast, country, release year, rating, duration, genre, and description.
	 * @param type of the content.
	 * @param title of the content.
	 * @param director of the content.
	 * @param cast of the content.
	 * @param country the content was produced in.
	 * @param releaseyear the year the content was released.
	 * @param rating of the content.
	 * @param duration of the content (in seasons or minutes)
	 * @param genre of the content.
	 * @param description of the content.
	 */
	public NetflixData(String type, String title, List<String> director, List<String> cast,
			List<String> country, int releaseyear, String rating, int duration, List<String> genre,
			String description) {
		//this.showid = showid;
		this.type = type;
		this.title = title;
		this.director = director;
		this.cast = cast;
		this.country = country;
		this.releaseyear = releaseyear;
		this.rating = rating;
		this.duration = duration;
		this.genre = genre;
		this.description = description;
	}

	// Getter methods

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the showid
	 */
	//public int getShowid() {
		//return showid;
	//}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the director
	 */
	public List<String> getDirector() {
		return director;
	}

	/**
	 * @return the cast
	 */
	public List<String> getCast() {
		return cast;
	}

	/**
	 * @return the country
	 */
	public List<String> getCountry() {
		return country;
	}

	/**
	 * @return the release year
	 */
	public int getReleaseyear() {
		return releaseyear;
	}

	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @return the genre
	 */
	public List<String> getGenre() {
		return genre;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	// Setter methods
	
	/**
	 * @param showid the showid to set
	 */
	//public void setShowid(int showid) {
		//this.showid = showid;
	//}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(List<String> director) {
		this.director = director;
	}

	/**
	 * @param cast the cast to set
	 */
	public void setCast(List<String> cast) {
		this.cast = cast;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(List<String> country) {
		this.country = country;
	}

	/**
	 * @param releaseyear the releaseyear to set
	 */
	public void setReleaseyear(int releaseyear) {
		this.releaseyear = releaseyear;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(List<String> genre) {
		this.genre = genre;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	// toString method
	
	/**
	 * Returns a string the clearly shows all of the values within this Movie or TV Show.
	 */
	@Override
	public String toString() {
		return "NetflixData [type=" + type + ", title=" + title + ", director=" + director
				+ ", cast=" + cast + ", country=" + country + ", releaseyear=" + releaseyear + ", rating=" + rating
				+ ", duration=" + duration + ", genre=" + genre + ", description=" + description + "]";
	}
}
