# Moving DVD Logo 
A recreation of the DVD logo screensaver written in Java with Swing. The logo drifts around the window diagonally and bounces off the window edges, changing to a random color with every bounce.
There's a counter in the corner that keeps track of how many times the logo has hit the corner of the window perfectly.
I made this for fun. The logo itself isn't 1:1 but it's as close as I'll get.

## Running the animation
You'll need the [Java Development Kit (JDK)](https://adoptium.net/) installed.

From the project folder:
```bash
javac *.java
java DVDMain
```

## Project Structure
- `DVDMain.java`: Creates the 500x500 window and adds the animation panel
- `MovingDVD.java`: The animation itself with movement, edge bouncing, color changes, drawing the logo, and corner counter

## Features
- Color change with every bounce
- Counter for corner hits
- Stays within the window bounds
