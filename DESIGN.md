Class Design (this is an explanation, this isn't a part of the code)

Media
An abstract base class that stores info such as title, year, and genre.

Movie
Extends Media and represents a single film. Movie includes the duration of the film (in minutes), as well as how long it has been played

Series 
Another extension of Media that represents a Television Show. It stores the number of films and shows how long the the series has been played for.

Catalog
Stores an arraylist of Media objects, its sole purpose is to browse the catalog of shows and movies, by searching by title or genre.

Profile
Represents a user's profile. It stores the user's watch list as well as their viewing progress.

Player
Responsible for playing any type of media that is listed


