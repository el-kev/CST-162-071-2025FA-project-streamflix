public class Series extends Media implements Playable {
    private int seasons;

    public Series(String title, int year, String genre, int seasons) {
        super(title, year, genre);
        this.seasons = seasons;
    }

    public int getSeasons() {
        return seasons;
    }

    @Override
    public String getType() {
        return "Series";
    }

    @Override
    public void play(Profile profile) {
        int current = profile.getProgress(this);
        int watch = 20;
        int updated = current + watch

        profile.setProgress(this, updated);

        System.out.println("Now playing: " + getTitle());
        System.out.println("Watched " + watch + " minutes (total : " + updated + ")");
    }

    @Override
    public String toString() {
        return super.toString() + " | " + seasons + " seasons";
    }
}
