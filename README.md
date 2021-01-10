# Hackflix 🎬

## Overview

### Project summary

Hackflix is an app that helps you decide what to watch on Netflix. You provide Hackflix with your preferences and it filters the 4000+ movies and TV shows to match those preferences as best as possible. Kiss Netflix-related-decision-paralysis goodbye, because Hackflix is here to cut down the insurmountable amount of content Netflix has to offer into a manageable selection based on what you actually want to watch.

Include the link to your Devpost project page here: [Devpost](https://...)

### Authors

* **Eri Arai** - eriarai – eriarai@seas.upenn.edu – [GitHub](https://github.com/eri-arai)
* **Thumpasery Joseph George** - Devpost ID – tjgeorge@seas.upenn.edu – [GitHub](https://github.com/tgeorge1001)
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

### Deployment

1. To start the Hackflix app, run the Main.java file from Eclipse.

...

## Additional information

### Tools used

* [Univocity](https://www.univocity.com/pages/about_univocity) - Data manipulation used for CSV parsing.
* [WindowBuilder Pro](https://www.eclipse.org/windowbuilder/) - Used for building the GUI.
* [Kaggle's Netflix Movies and TV Shows Data Set](https://www.kaggle.com/shivamb/netflix-shows) - Underlying Netflix data that we use to filter and be filtered.

### Acknowledgments

* Inspired by Eri Arai's Fall 2019 CIT 591 final project: Virtual Sommelier Application 🍷.

### License

>This package is licensed under the [MIT License](https://github.com/tgeorge1001/Eri-James-George/blob/master/LICENSE.txt).
