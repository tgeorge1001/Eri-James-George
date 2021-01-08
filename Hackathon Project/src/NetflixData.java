import java.util.ArrayList;

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
	int showid;
	
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
	ArrayList<String> director;
	
	/**
	 * The cast of this movie or tv show, if any are listed.
	 */
	ArrayList<String> cast;
	
	/**
	 * The country or countries where the movie or tv show was produced.
	 */
	ArrayList<String> country;
	
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
	ArrayList<String> genre;
	
	/**
	 * A description of the movie or TV show.
	 */
	String description;
	
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
	public NetflixData(int showid, String type, String title, ArrayList<String> director, ArrayList<String> cast,
			ArrayList<String> country, int releaseyear, String rating, int duration, ArrayList<String> genre,
			String description) {
		this.showid = showid;
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
	String getType() {
		return type;
	}

	/**
	 * @return the showid
	 */
	int getShowid() {
		return showid;
	}

	/**
	 * @return the title
	 */
	String getTitle() {
		return title;
	}

	/**
	 * @return the director
	 */
	ArrayList<String> getDirector() {
		return director;
	}

	/**
	 * @return the cast
	 */
	ArrayList<String> getCast() {
		return cast;
	}

	/**
	 * @return the country
	 */
	ArrayList<String> getCountry() {
		return country;
	}

	/**
	 * @return the release year
	 */
	int getReleaseyear() {
		return releaseyear;
	}

	/**
	 * @return the rating
	 */
	String getRating() {
		return rating;
	}

	/**
	 * @return the duration
	 */
	int getDuration() {
		return duration;
	}

	/**
	 * @return the genre
	 */
	ArrayList<String> getGenre() {
		return genre;
	}

	/**
	 * @return the description
	 */
	String getDescription() {
		return description;
	}
	
	// Setter methods
	
	/**
	 * @param showid the showid to set
	 */
	void setShowid(int showid) {
		this.showid = showid;
	}

	/**
	 * @param type the type to set
	 */
	void setType(String type) {
		this.type = type;
	}

	/**
	 * @param title the title to set
	 */
	void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param director the director to set
	 */
	void setDirector(ArrayList<String> director) {
		this.director = director;
	}

	/**
	 * @param cast the cast to set
	 */
	void setCast(ArrayList<String> cast) {
		this.cast = cast;
	}

	/**
	 * @param country the country to set
	 */
	void setCountry(ArrayList<String> country) {
		this.country = country;
	}

	/**
	 * @param releaseyear the releaseyear to set
	 */
	void setReleaseyear(int releaseyear) {
		this.releaseyear = releaseyear;
	}

	/**
	 * @param rating the rating to set
	 */
	void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * @param duration the duration to set
	 */
	void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @param genre the genre to set
	 */
	void setGenre(ArrayList<String> genre) {
		this.genre = genre;
	}

	/**
	 * @param description the description to set
	 */
	void setDescription(String description) {
		this.description = description;
	}	
}
