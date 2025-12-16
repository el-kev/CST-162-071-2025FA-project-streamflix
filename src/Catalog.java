import java.util.ArrayList;

public class Catalog {
  private ArrayList<Media> items;

  public Catalog() {
    items = new ArrayList<>();
  }

  public void add(Media m) {
    items.add(m);
  }

  public ArrayList<Media> getItems() {
    return items;
  }

  public void browse()  {
    if (items.isEmpty()) {
      System.out.println("Catalog is empty.");
      return;
    }
    for (Media m : items) {
      System.out.println(m);
    }
  }

  public ArrayList<Media> search(String keyword) {
    ArrayList<Media> results = new ArrayList<>();
    String k = keyword.toLowerCase().trim();

    for (Media m : items) {
      if (m.getTitle().toLowerCase().contains(k) ||
          m.getGenre().toLowerCase().contains(k)) {
          results.add(m);
      }
    }
    return results;
  }
}
