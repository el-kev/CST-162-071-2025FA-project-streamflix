import java.util.ArrayList;
import java.util.HashMap;

public class Profile {
    private String name;
    private ArrayList<Media> myList;
    private HashMap<Media, Integer> progressMinutes;

    public Profile(String name) {
        this.name = name;
        this.myList = new ArrayList<>();
        this.progressMinutes = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Media> getMyList() {
        return myList;
    }

    public boolean addToMyList(Media m) {
        if (myList.contains(m)) return false;
        myList.add(m);
        return true;
    }

    public boolean removeFromMyList(int index) {
        if (index < 0 || index >= myList.size()) return false;
        myList.remove(index);
        return true;
    }

    public void printMyList() {
        if (myList.isEmpty()) {
            System.out.println("My List is empty.");
            return;
        }
        System.out.println("=== My List (" + name + ") ===");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println((i + 1) + ") " + myList.get(i));
        }
    }

    public int getProgress(Media m) {
        return progressMinutes.getOrDefault(m, 0);
    }

    public void setProgress(Media m, int minutes) {
        progressMinutes.put(m, Math.max(0, minutes));
    }

    @Override
    public String toString() {
        return name + " (My List: " + myList.size() + ")";
    }
}
