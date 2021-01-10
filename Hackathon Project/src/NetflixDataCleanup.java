import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class provides instance variables and methods to categorize and summarize various fields within the original dataset.
 * This will allow for a more use-able user experience.
 */
public class NetflixDataCleanup {
	// all genre-categories for users to select from when searching
	ArrayList<String> genreCats = new ArrayList<String>(Arrays.asList("Action", "Anime", "British", "Children", "Classic", "Comedy", "Documentary", 
		"Drama", "Horror", "Indie", "International", "Musical", "None", "Reality", "Romance", "Sci-Fi & Fantasy", "Spanish-Language", "Sports", 
		"Thriller"));

	// all years groups into eras / decades for users to select from when searching
	ArrayList<String> yearGrps = new ArrayList<String>(Arrays.asList("pre-1960", "The 1960s", "The 1970s", "The 1980s", "The 1990s", "The 2000s",
		"The 2010s", "The 2020s"));

	// all (movie) duration categories for users to select from when searching
	ArrayList<String> durCats = new ArrayList<String>(Arrays.asList("Short Film (< 40 minutes)", "Featurette (40-75 minutes)", "Feature Film (75+ minutes)"));

	// all raw "listed_in" values that map to each genre category

	// raw "listed_in" values that map to the "Action" genre category
	ArrayList<String> actGenres = new ArrayList<String>(Arrays.asList("Action & Adventure", "TV Action & Adventure"));

	// raw "listed_in" values that map to the "Anime" genre category
	ArrayList<String> aniGenres = new ArrayList<String>(Arrays.asList("Anime Features", "Anime Series"));

	// raw "listed_in" values that map to the "British" genre category
	ArrayList<String> britGenres = new ArrayList<String>(Arrays.asList("British TV Shows"));

	// raw "listed_in" values that map to the "Children" genre category
	ArrayList<String> chiGenres = new ArrayList<String>(Arrays.asList("Children & Family Movies", "Kids' TV"));

	// raw "listed_in" values that map to the "Classic" genre category
	ArrayList<String> clasGenres = new ArrayList<String>(Arrays.asList("Cult Movies", "Classic Movies", "Classic & Cult TV"));

	// raw "listed_in" values that map to the "Comedy" genre category
	ArrayList<String> comGenres = new ArrayList<String>(Arrays.asList("Stand-Up Comedy", "Comedies", "TV Comedies", "Stand-Up Comedy & Talk Shows"));

	// raw "listed_in" values that map to the "Documentary" genre category
	ArrayList<String> docGenres = new ArrayList<String>(Arrays.asList("Docuseries", "Documentaries"));

	// raw "listed_in" values that map to the "Drama" genre category
	ArrayList<String> dramGenres = new ArrayList<String>(Arrays.asList("Crime TV Shows", "Dramas", "TV Dramas"));

	// raw "listed_in" values that map to the "Horror" genre category
	ArrayList<String> horGenres = new ArrayList<String>(Arrays.asList("Horror Movies", "TV Horror"));

	// raw "listed_in" values that map to the "Indie" genre category
	ArrayList<String> indiGenres = new ArrayList<String>(Arrays.asList("Independent Movies"));

	// raw "listed_in" values that map to the "International" genre category
	ArrayList<String> intGenres = new ArrayList<String>(Arrays.asList("International Movies", "International TV Shows"));

	// raw "listed_in" values that map to the "Musical" genre category
	ArrayList<String> musGenres = new ArrayList<String>(Arrays.asList("Music & Musicals"));

	// raw "listed_in" values that map to the "None" genre category
	ArrayList<String> noGenres = new ArrayList<String>(Arrays.asList("Movies", "TV Shows"));

	// raw "listed_in" values that map to the "Reality" genre category
	ArrayList<String> realGenres = new ArrayList<String>(Arrays.asList("Reality TV"));

	// raw "listed_in" values that map to the "Romance" genre category
	ArrayList<String> romGenres = new ArrayList<String>(Arrays.asList("Romantic TV Shows", "Romantic Movies"));

	// raw "listed_in" values that map to the "Sci-Fi & Fantasy" genre category
	ArrayList<String> scifanGenres = new ArrayList<String>(Arrays.asList("Sci-Fi & Fantasy", "TV Sci-Fi & Fantasy"));

	// raw "listed_in" values that map to the "Spanish-Language" genre category
	ArrayList<String> spanGenres = new ArrayList<String>(Arrays.asList("Spanish-Language TV Shows"));

	// raw "listed_in" values that map to the "Sports" genre category
	ArrayList<String> sporGenres = new ArrayList<String>(Arrays.asList("Sports Movies"));

	// raw "listed_in" values that map to the "Thriller" genre category
	ArrayList<String> thrillGenres = new ArrayList<String>(Arrays.asList("Thrillers"));
	
	
	ArrayList<String> Grating = new ArrayList<String>(Arrays.asList("G", "TV-G"));
	ArrayList<String> PGrating = new ArrayList<String>(Arrays.asList("PG", "TV-PG"));
	ArrayList<String> PG13rating = new ArrayList<String>(Arrays.asList("PG-13", "TV-14"));
	ArrayList<String> Rrating = new ArrayList<String>(Arrays.asList("R", "TV-MA"));
	ArrayList<String> NCrating = new ArrayList<String>(Arrays.asList("NC-17"));
	ArrayList<String> NRrating = new ArrayList<String>(Arrays.asList("NR"));



	/**
	 * This method returns all genre categories.
	 * @return a String array list of genre categories
	 */
	public ArrayList<String> getGenreCats() {
		return genreCats;
	}

	/**
	 * This method returns all year groups.
	 * @return a String array list of year groups
	 */
	public ArrayList<String> getYearGrps() {
		return yearGrps;
	}

	/**
	 * This method returns all duration categories.
	 * @return a String array list of duration categories
	 */
	public ArrayList<String> getDurCats() {
		return durCats;
	}

	/**
	 * This method classifies a movie/show as "Action" if its first "listed_in" string matches one of the strings listed in the actGenres Array List 
	 * @return true if the show/movie is "action" and false if it is not
	 */
	public boolean isAction(NetflixData content) {
		boolean isAction = false;
		for (String s : actGenres) {
			if (content.getGenre().get(0).toLowerCase().contains(s.toLowerCase())) {
				isAction = true;
			}
		}
		return isAction;
	}

	/**
	 * This method classifies a movie/show as "Anime" if its first "listed_in" string matches one of the strings listed in the aniGenres Array List 
	 * @return true if the show/movie is "anime" and false if it is not
	 */
	public boolean isAnime(NetflixData content) {
		boolean isAnime = false;
		for (String s : aniGenres) {
			if (content.getGenre().get(0).toLowerCase().contains(s.toLowerCase())) {
				isAnime = true;
			}
		}
		return isAnime;
	}

	/**
	 * This method classifies a movie/show as "British" if its first "listed_in" string matches one of the strings listed in the britGenres Array List 
	 * @return true if the show/movie is "British" and false if it is not
	 */
	public boolean isBrit(NetflixData content) {
		boolean isBrit = false;
		for (String s : britGenres) {
			if (content.getGenre().get(0).toLowerCase().contains(s.toLowerCase())) {
				isBrit = true;
			}
		}
		return isBrit;
	}

	/**
	 * This method classifies a movie/show as "Children" if its first "listed_in" string matches one of the strings listed in the chiGenres Array List 
	 * @return true if the show/movie is "Children" and false if it is not
	 */
	public boolean isChildren(NetflixData content) {
		boolean isChildren = false;
		for (String s : chiGenres) {
			if (content.getGenre().get(0).toLowerCase().contains(s.toLowerCase())) {
				isChildren = true;
			}
		}
		return isChildren;
	}

	/**
	 * This method classifies a movie/show as "Classic" if its first "listed_in" string matches one of the strings listed in the clasGenres Array List 
	 * @return true if the show/movie is "Classic" and false if it is not
	 */
	public boolean isClassic(NetflixData content) {
		boolean isClassic = false;
		for (String s : clasGenres) {
			if (content.getGenre().get(0).toLowerCase().contains(s.toLowerCase())) {
				isClassic = true;
			}
		}
		return isClassic;
	}

	/**
	 * This method classifies a movie/show as "Comedy" if its first "listed_in" string matches one of the strings listed in the comGenres Array List 
	 * @return true if the show/movie is "Comedy" and false if it is not
	 */
	public boolean isComedy(NetflixData content) {
		boolean isComedy = false;
		for (String s : comGenres) {
			if (content.getGenre().get(0).toLowerCase().contains(s.toLowerCase())) {
				isComedy = true;
			}
		}
		return isComedy;
	}

	/**
	 * This method classifies a movie/show as "Documentary" if its first "listed_in" string matches one of the strings listed in the docGenres Array List 
	 * @return true if the show/movie is "Documentary" and false if it is not
	 */
	public boolean isDocumentary(NetflixData content) {
		boolean isDocumentary = false;
		for (String s : docGenres) {
			if (content.getGenre().get(0).toLowerCase().contains(s.toLowerCase())) {
				isDocumentary = true;
			}
		}
		return isDocumentary;
	}

	/**
	 * This method classifies a movie/show as "Drama" if its first "listed_in" string matches one of the strings listed in the dramGenres Array List 
	 * @return true if the show/movie is "Drama" and false if it is not
	 */
	public boolean isDrama(NetflixData content) {
		boolean isDrama = false;
		for (String s : dramGenres) {
			if (content.getGenre().get(0).toLowerCase().contains(s.toLowerCase())) {
				isDrama = true;
			}
		}
		return isDrama;
	}

	/**
	 * This method classifies a movie/show as "Horror" if its first "listed_in" string matches one of the strings listed in the horGenres Array List 
	 * @return true if the show/movie is "Horror" and false if it is not
	 */
	public boolean isHorror(NetflixData content) {
		boolean isHorror = false;
		for (String s : horGenres) {
			if (content.getGenre().get(0).toLowerCase().contains(s.toLowerCase())) {
				isHorror = true;
			}
		}
		return isHorror;
	}

	/**
	 * This method classifies a movie/show as "Indie" if its first "listed_in" string matches one of the strings listed in the indiGenres Array List 
	 * @return true if the show/movie is "Indie" and false if it is not
	 */
	public boolean isIndie(NetflixData content) {
		boolean isIndie = false;
		for (String s : indiGenres) {
			if (content.getGenre().get(0).toLowerCase().contains(s.toLowerCase())) {
				isIndie = true;
			}
		}
		return isIndie;
	}

	/**
	 * This method classifies a movie/show as "International" if its first "listed_in" string matches one of the strings listed in the intGenres Array List 
	 * @return true if the show/movie is "International" and false if it is not
	 */
	public boolean isInternational(NetflixData content) {
		boolean isInternational = false;
		for (String s : intGenres) {
			if (content.getGenre().get(0).toLowerCase().contains(s.toLowerCase())) {
				isInternational = true;
			}
		}
		return isInternational;
	}

	/**
	 * This method classifies a movie/show as "Musical" if its first "listed_in" string matches one of the strings listed in the musGenres Array List 
	 * @return true if the show/movie is "Musical" and false if it is not
	 */
	public boolean isMusical(NetflixData content) {
		boolean isMusical = false;
		for (String s : musGenres) {
			if (content.getGenre().get(0).toLowerCase().contains(s.toLowerCase())) {
				isMusical = true;
			}
		}
		return isMusical;
	}

	/**
	 * This method classifies a movie/show as "None" if its first "listed_in" string matches one of the strings listed in the noGenres Array List 
	 * @return true if the show/movie is "None" and false if it is not
	 */
	public boolean isNoGenre(NetflixData content) {
		boolean isNoGenre = false;
		for (String s : noGenres) {
			if (content.getGenre().get(0).toLowerCase().contains(s.toLowerCase())) {
				isNoGenre = true;
			}
		}
		return isNoGenre;
	}

	/**
	 * This method classifies a movie/show as "Reality" if its first "listed_in" string matches one of the strings listed in the realGenres Array List 
	 * @return true if the show/movie is "Reality" and false if it is not
	 */
	public boolean isReality(NetflixData content) {
		boolean isReality = false;
		for (String s : realGenres) {
			if (content.getGenre().get(0).toLowerCase().contains(s.toLowerCase())) {
				isReality = true;
			}
		}
		return isReality;
	}

	/**
	 * This method classifies a movie/show as "Romance" if its first "listed_in" string matches one of the strings listed in the romGenres Array List 
	 * @return true if the show/movie is "Romance" and false if it is not
	 */
	public boolean isRomance(NetflixData content) {
		boolean isRomance = false;
		for (String s : romGenres) {
			if (content.getGenre().get(0).toLowerCase().contains(s.toLowerCase())) {
				isRomance = true;
			}
		}
		return isRomance;
	}

	/**
	 * This method classifies a movie/show as "Sci-Fi & Fantasy" if its first "listed_in" string matches one of the strings listed in the scifanGenres Array List 
	 * @return true if the show/movie is "Sci-Fi & Fantasy" and false if it is not
	 */
	public boolean isSciFiFantasy(NetflixData content) {
		boolean isSciFiFantasy = false;
		for (String s : scifanGenres) {
			if (content.getGenre().get(0).toLowerCase().contains(s.toLowerCase())) {
				isSciFiFantasy = true;
			}
		}
		return isSciFiFantasy;
	}

	/**
	 * This method classifies a movie/show as "Spanish-Language" if its first "listed_in" string matches one of the strings listed in the spanGenres Array List 
	 * @return true if the show/movie is "Spanish-Language" and false if it is not
	 */
	public boolean isSpanLang(NetflixData content) {
		boolean isSpanLang = false;
		for (String s : spanGenres) {
			if (content.getGenre().get(0).toLowerCase().contains(s.toLowerCase())) {
				isSpanLang = true;
			}
		}
		return isSpanLang;
	}

	/**
	 * This method classifies a movie/show as "Sports" if its first "listed_in" string matches one of the strings listed in the sporGenres Array List 
	 * @return true if the show/movie is "Sports" and false if it is not
	 */
	public boolean isSports(NetflixData content) {
		boolean isSports = false;
		for (String s : sporGenres) {
			if (content.getGenre().get(0).toLowerCase().contains(s.toLowerCase())) {
				isSports = true;
			}
		}
		return isSports;
	}

	/**
	 * This method classifies a movie/show as "Thriller" if its first "listed_in" string matches one of the strings listed in the thrillGenres Array List 
	 * @return true if the show/movie is "Thriller" and false if it is not
	 */
	public boolean isThriller(NetflixData content) {
		boolean isThriller = false;
		for (String s : thrillGenres) {
			if (content.getGenre().get(0).toLowerCase().contains(s.toLowerCase())) {
				isThriller = true;
			}
		}
		return isThriller;
	}

	/**
	 * This method classifies the movie or show to be "Pre-1960" if the release year is lower than 1960.
	 * @return true if the show/movie is classified as "Pre-1960" and false if it is not
	 */
	public boolean isPreSixty(NetflixData content) {
		if (content.getReleaseyear() < 1960) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * This method classifies the movie or show to be "1960s" if the release year is lower than 1970 but higher than or equal to 1960.
	 * @return true if the show/movie is classified as "1960s" and false if it is not
	 */
	public boolean isSixty(NetflixData content) {
		if (content.getReleaseyear() >= 1960 && content.getReleaseyear() < 1970) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * This method classifies the movie or show to be "1970s" if the release year is lower than 1980 but higher than or equal to 1970.
	 * @return true if the show/movie is classified as "1970s" and false if it is not
	 */
	public boolean isSeventy(NetflixData content) {
		if (content.getReleaseyear() >= 1970 && content.getReleaseyear() < 1980) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * This method classifies the movie or show to be "1980s" if the release year is lower than 1990 but higher than or equal to 1980.
	 * @return true if the show/movie is classified as "1980s" and false if it is not
	 */
	public boolean isEighty(NetflixData content) {
		if (content.getReleaseyear() >= 1980 && content.getReleaseyear() < 1990) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * This method classifies the movie or show to be "1990s" if the release year is lower than 2000 but higher than or equal to 1990.
	 * @return true if the show/movie is classified as "1990s" and false if it is not
	 */
	public boolean isNinety(NetflixData content) {
		if (content.getReleaseyear() >= 1990 && content.getReleaseyear() < 2000) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * This method classifies the movie or show to be "2000s" if the release year is lower than 2010 but higher than or equal to 2000.
	 * @return true if the show/movie is classified as "2000s" and false if it is not
	 */
	public boolean isAughts(NetflixData content) {
		if (content.getReleaseyear() >= 2000 && content.getReleaseyear() < 2010) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * This method classifies the movie or show to be "2010s" if the release year is lower than 2020 but higher than or equal to 2010.
	 * @return true if the show/movie is classified as "2010s" and false if it is not
	 */
	public boolean isTens(NetflixData content) {
		if (content.getReleaseyear() >= 2010 && content.getReleaseyear() < 2020) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * This method classifies the movie or show to be "2020s" if the release year is lower than 2030 but higher than or equal to 2020.
	 * @return true if the show/movie is classified as "2020s" and false if it is not.
	 */
	public boolean isTwenties(NetflixData content) {
		if (content.getReleaseyear() >= 2020 && content.getReleaseyear() < 2030) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * This method classifies the MOVIE to be a "Short Film" if the duration is shorter than 40 minutes.
	 * @return true if the MOVIE is classified as a "Short Film" and false if it is not.
	 */
	public boolean isShortFilm(NetflixData content) {
		if (content.getDuration() < 40 && content.getType() == "Movie") {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * This method classifies the MOVIE to be a "Featurette" if the duration is shorter than 75 minutes but longer than 40 minutes.
	 * @return true if the MOVIE is classified as a "Featurette" and false if it is not.
	 */
	public boolean isFeaturette(NetflixData content) {
		if (content.getDuration() >= 40 && content.getDuration() < 75 && content.getType() == "Movie") {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * This method classifies the MOVIE to be a "Feature Film" if the duration is equal to or longer than 75 minutes.
	 * @return true if the MOVIE is classified as a "Featurette" and false if it is not.
	 */
	public boolean isFeatureFilm(NetflixData content) {
		if (content.getDuration() >= 75 && content.getType() == "Movie") {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * This method takes a given genre group name and returns all the possible "listed_in" values from the dataset that can map to that genre group.
	 * @param genreGroup a string thats the name of a genre group
	 * @return an arraylist of "listed_in" values that map to the entered genregroup name, or null if there is no match.
	 */
	public List<String> convertGenre (String genreGroup) {
		if (genreGroup == "Action") {
			return actGenres;
		}
		else if (genreGroup.equals("Anime")) {
			return aniGenres;
		}
		else if (genreGroup.equals("British")) {
			return britGenres;
		}
		else if (genreGroup.equals("Children")) {
			return chiGenres;
		}
		else if (genreGroup.equals("Classic")) {
			return clasGenres;
		}
		else if (genreGroup.equals("Comedy")) {
			return comGenres;
		}
		else if (genreGroup.equals("Documentary")) {
			return docGenres;
		}
		else if (genreGroup.equals("Drama")) {
			return dramGenres;
		}
		else if (genreGroup.equals("Horror")) {
			return horGenres;
		}
		else if (genreGroup.equals("Indie")) {
			return indiGenres;
		}
		else if (genreGroup.equals("International")) {
			return docGenres;
		}
		else if (genreGroup.equals("Musical")) {
			return musGenres;
		}
		else if (genreGroup.equals("None")) {
			return noGenres;
		}
		else if (genreGroup.equals("Reality")) {
			return realGenres;
		}
		else if (genreGroup.equals("Romance")) {
			return romGenres;
		}
		else if (genreGroup.equals("Sci-Fi & Fantasy")) {
			return scifanGenres;
		}
		else if (genreGroup.equals("Spanish-Language")) {
			return spanGenres;
		}
		else if (genreGroup.equals("Sports")) {
			return sporGenres;
		}
		else if (genreGroup.equals("Spanish-Language")) {
			return spanGenres;
		}
		else if (genreGroup.equals("Thriller")) {
			return thrillGenres;
		}
		else {
			return null;
		}
	}
	
	public List<String> convertRating(String ratingGroup) {
		
		if (ratingGroup.equals("G/TV-G or lower")) {
			return Grating;
		}
		else if (ratingGroup.equals("PG/TV-PG")) {
			return PGrating;
		}
		else if (ratingGroup.equals("PG-13/TV-14")) {
			return PG13rating;
		}
		else if (ratingGroup.equals("R/TV-MA")) {
			return Rrating;
		}
		else if (ratingGroup.equals("NC-17")) {
			return NCrating;
		}
		else if (ratingGroup.equals("NR")) {
			return NRrating;
		}
		else {
			return null;
		}
	}
}

