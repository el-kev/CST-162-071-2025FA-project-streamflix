public class Series extends Media {

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
}
