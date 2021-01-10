# Hackflix 🎬

## Overview

### Project Summary

Hackflix is an app that helps you decide what to watch on Netflix. You provide Hackflix with your preferences and it filters the 4000+ movies and TV shows to match those preferences as best as possible. Kiss Netflix-related-decision-paralysis goodbye, because Hackflix is here to cut down the insurmountable amount of content Netflix has to offer into a manageable selection based on what you actually want to watch.

#### Devpost project page
https://devpost.com/software/hackflix

#### GitHub Repository :octocat: 
https://github.com/tgeorge1001/Eri-James-George.git

### Authors

* **Eri Arai** - eriarai – eriarai@seas.upenn.edu – [GitHub](https://github.com/eri-arai)
* **Thumpasery Joseph George** - tjgeorge – tjgeorge@seas.upenn.edu – [GitHub](https://github.com/tgeorge1001)
* **James Grimes** - jdgrimes – jdgrimes@seas.upenn.edu – [GitHub](https://github.com/phewf)

## Usage

### Prerequisites

The primary prerequisite is the [Eclipse IDE for Java Developers](https://www.eclipse.org/downloads/packages/release/2020-12/r/eclipse-ide-java-developers). Install it by downloading the file for your particular operating system. Launch the downloaded file, and follow the prompts.

Once Eclipse is installed, you must also install [WindowBuilder Pro](https://www.eclipse.org/windowbuilder/download.php). Dragging the install image from the website to your open Eclipse window should trigger the installation. Follow the proceeding prompts to install.

Lastly you must install [Univocity](https://www.univocity.com/pages/univocity_parsers_download). Download the most recent release zip file, and unzip it. Take note of its location on your computer's file path.

### Installation

1. Clone our repository locally and open it in Eclipse, with WindowsBuilder Pro installed.
2. Right click the cloned project in Eclipse's package explorer.
3. Navigate to Build Path, and click on Add External Archives. (This should cause a window to appear where you can navigate your file system.)
4. In this window navigate to the location where you unzipped univocity, and find the .jar file that has a name that begins with "univocity_parsers", select it, and click on the "Open" button.


## Deployment
To launch the Hackflix app, run the Main.java file from Eclipse to view the main Hackflix application page.

<a href="url"><img src="Screenshots/main_page.png" align="center" height="400" width="600" ></a>

There are two primary features to this application: quick keyword search and advanced search.

### 1.	Quick Search
The quick search function can be used if the user knows what movie or TV show they are looking for. For example, maybe you want to see if any of the *Transformer* series are on Netflix. To conduct a quick search, simply type in the full name or a keyword from the movie or TV show you are looking for and hit Enter.

<a href="url"><img src="Screenshots/quick_search_example.png" align="center" height="400" width="600" ></a>

The search results page will be automatically launched with the results. If there is more than one result, the results will be sorted by random. The users can change the order in which results are displayed by selecting from the drop-down menu to display results alphabetically (ascending or descending) or by release year (ascending or descending). There is a maximum of 25 results displayed so the user will have a not-too-overwhelming, sizeable selection to browse through.

<a href="url"><img src="Screenshots/search_results_example.png" align="center" height="530" width="400" ></a>

### 2.	Advanced Search
The advanced search function can be used to browse and find Netflix movie and/or TV show recommendations based on the preferences they select. To get started, the user can press one of the three buttons on the main screen depending on which type of show they would like to browse: "Movies", "TV Shows", or "Both" (Movies & TV shows).

<a href="url"><img src="Screenshots/main_page.png" align="center" height="400" width="600" ></a>

If the user selects "Movies", then the application will switch to a query-building window to search for Netflix Movies.

<a href="url"><img src="Screenshots/movies_page.png" align="center" height="400" width="600" ></a>

Likewise, if the user selects "TV Shows", then the application will switch to a query-building window to search for Netflix Movies.

<a href="url"><img src="Screenshots/tv_shows_page.png" align="center" height="400" width="600" ></a>

Finally, if the user selects "Both", then the application will switch to a query-building window to search for Netflix Movies.

<a href="url"><img src="Screenshots/both_page.png" align="center" height="400" width="600" ></a>


## Additional information

### Tools used

* [Univocity](https://www.univocity.com/pages/about_univocity) - Data manipulation used for CSV parsing.
* [WindowBuilder Pro](https://www.eclipse.org/windowbuilder/) - Used for building the GUI.
* [Kaggle's Netflix Movies and TV Shows Data Set](https://www.kaggle.com/shivamb/netflix-shows) - Underlying Netflix data that we use to filter and be filtered.

### Acknowledgments

* Inspired by Eri Arai's Fall 2019 CIT 591 final project: Virtual Sommelier Application 🍷.

### License

>This package is licensed under the [MIT License](https://github.com/tgeorge1001/Eri-James-George/blob/master/LICENSE.txt).
