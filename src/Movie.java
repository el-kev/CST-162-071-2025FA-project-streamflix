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

  @Override
  public void play(Profile profile) {
    int current = profile.getProgress(this);
    int watch = 25;
    int updated = Math.min(current + watch, durationMinutes);

    profile.setProgress(this, updated);

    System.out.println("Now playing: " + getTitle());
    System.out.println("Progress: " + updated + "/" + durationMinutes + " minutes");
    if (updated >= durationMinutes) {
      System.out.println("Finished!");
    } 
  }

  @Override
  public String toString() {
    return super.toString() + " | " + durationMinutes + " min";
  }
}
