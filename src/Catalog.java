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

    public void browseNumbered() {
        if (items.isEmpty()) {
            System.out.println("Catalog is empty.");
            return;
        }

        System.out.println("=== Catalog ===");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ") " + items.get(i));
        }
    }

    public Media getByNumber(int number) {
        int index = number - 1;
        if (index < 0 || index >= items.size()) {
            return null;
        }
        return items.get(index);
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
