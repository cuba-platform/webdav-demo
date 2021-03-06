[![license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

# WebDAV demo project

This is a demo project for the [CUBA WebDAV addon](https://www.cuba-platform.com/marketplace/webdav/).

## How to Include the WebDAV Trial Version

You can get trial subscription from [CUBA marketplace](https://www.cuba-platform.com/marketplace/webdav/) to run this application on your local environment. After getting trial subscription you'll receive an email with a link for downloading ZIP archive with artifacts.

To install the trial version of WebDAV add-on:

1. Get trial subscription from [CUBA Marketplace](https://www.cuba-platform.com/marketplace/webdav/). You'll get an email with a link and instructions.

2. Download ZIP archive with artifacts at link from the email.

3. Clone the repository of this demo project.

4. Open demo project in CUBA Studio.

5. Create a directory called `repository` in the root directory of the demo project.

6. Unzip the file with artifacts into this directory. You should get the following directory structure:

 ![structure](images/structure.png)

7. Open `build.gradle` file and register a new Maven repository.
 ```
 maven {
     url './repository'
     }
 ```
  ![buildscript](images/buildscript.png)

8. Find a string with add-on coordinates and replace the add-on version with the latest one. Check the latest version on [CUBA Marketplace](https://www.cuba-platform.com/marketplace/webdav/).

 ![version](images/version.png)

9. Then add `.trial` to the end of add-on coordinates.

 ![trial](images/trial.png)

10. Go to *CUBA -> Build Tasks -> Deploy* to check that the add-on was installed successfully.     
