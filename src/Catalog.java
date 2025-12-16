import. java.util.ArrayList;

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
}
