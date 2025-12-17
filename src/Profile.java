import java.util.ArrayList;

public class Profile {
  private String name;
  private ArrayList<Media> myList;

  public Profile(String name) {
    this.name = name;
    this.myList = new ArrayList<>();
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
    return true;
  }

  public void printMyList() {
    if (myList.isEmpty()) {
      System.out.println("My list is empty.");
      return;
    }
    System.out.println("=== My List (" + name + ") ===");
    for (int i = 0; i < myList.size(); i++) {
      System.out.println((i + 1) + ") " + myList.get(i));
    }
  }
  @Override
  public String toString() {
    return name + " (My List: " + myList.size() + ")";
  }
}
