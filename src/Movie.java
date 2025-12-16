public class Movie extends Media {
  private int durationMinutes;

  public Movie(String title, int year, String genre, int durationMinutes) {
    super(title, year, genre);
    this.durationMinutes = durationMinutes;
  }

  public int getDurationMinutes() {
    return durationMinutes;
  }

  @Override
  public String getType() {
    return "Movie";
  }
}
