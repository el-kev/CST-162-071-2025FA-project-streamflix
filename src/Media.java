public abstract class Media {
  private String title; 
  private int year;
  private String genre;

  public Media(String title, int year, String genre) {
    this.title = title;
    this.year = year;
    this.genre = genre
  }

  public String getTitle() {
    return title;
  }

  public int getYear() {
  return year;
  }

  public String getGenre() {
    return genre;
  }

  public abstract String getType();

  @Override
  public String toString() {
    return getType() + ": " + title + " (" + year + ") - " + genre;
  }
}
