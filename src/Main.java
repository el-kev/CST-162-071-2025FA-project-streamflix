import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    private static Catalog catalog = new Catalog();
    private static ArrayList<Profile> profiles = new ArrayList<>();
    private static Profile activeProfile = null;
    private static Player player = new Player();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        seedCatalog();

        profiles.add(new Profile("Default"));
        activeProfile = profiles.get(0);

        int choice;
        do {
            System.out.println("=== StreamFlix ===");
            System.out.println("Active Profile: " + (activeProfile == null ? "(none)" : activeProfile.getName()));
            System.out.println("1) Select/Create Profile");
            System.out.println("2) Browse Catalog");
            System.out.println("3) Search");
            System.out.println("4) My List");
            System.out.println("5) Play Title");
            System.out.println("0) Exit");

            choice = readInt(sc, "Choose >> ", 0, 5);

            if (choice == 1) {
                selectOrCreateProfile(sc);
            } else if (choice == 2) {
                catalog.browseNumbered();
            } else if (choice == 3) {
                runSearch(sc);
            } else if (choice == 4) {
                myListMenu(sc);
            } else if (choice == 5) {
                playTitle(sc);
            }

            System.out.println();
        } while (choice != 0);

        System.out.println("Goodbye!");
    }

    private static void seedCatalog() {
        catalog.add(new Movie("Halloween Remake", 2018, "Horror", 106));
        catalog.add(new Movie("Jaws", 1975, "Horror", 124));
        catalog.add(new Series("Breaking Bad", 2008, "Crime", 5));
        catalog.add(new Series("Jujutsu Kaisen", 2020, "Anime", 2));
    }

    private static void selectOrCreateProfile(Scanner sc) {
        System.out.println("=== Profiles ===");
        for (int i = 0; i < profiles.size(); i++) {
            System.out.println((i + 1) + ") " + profiles.get(i));
        }
        System.out.println("0) Create new profile");

        int pick = readInt(sc, "Choose profile number >> ", 0, profiles.size());

        if (pick == 0) {
            System.out.print("New profile name >> ");
            String name = sc.nextLine().trim();
            if (name.isEmpty()) name = "User" + (profiles.size() + 1);

            Profile p = new Profile(name);
            profiles.add(p);
            activeProfile = p;
            System.out.println("Selected: " + activeProfile.getName());
        } else {
            activeProfile = profiles.get(pick - 1);
            System.out.println("Selected: " + activeProfile.getName());
        }
    }

    private static void runSearch(Scanner sc) {
        System.out.print("Search title or genre >> ");
        String key = sc.nextLine();

        ArrayList<Media> results = catalog.search(key);

        if (results.isEmpty()) {
            System.out.println("No results.");
        } else {
            System.out.println("Results:");
            for (Media m : results) {
                System.out.println(m);
            }
        }
    }

    private static void myListMenu(Scanner sc) {
        if (activeProfile == null) {
            System.out.println("Select a profile first.");
            return;
        }

        System.out.println("1) View My List");
        System.out.println("2) Add from Catalog");
        System.out.println("3) Remove from My List");

        int c = readInt(sc, "Choose >> ", 1, 3);

        if (c == 1) {
            activeProfile.printMyList();
        } else if (c == 2) {
            catalog.browseNumbered();
            if (catalog.getItems().isEmpty()) return;

            int num = readInt(sc, "Enter catalog number to add >> ", 1, catalog.getItems().size());
            Media m = catalog.getByNumber(num);

            boolean added = activeProfile.addToMyList(m);
            System.out.println(added ? "Added." : "Already in My List.");
        } else {
            activeProfile.printMyList();
            if (activeProfile.getMyList().isEmpty()) return;

            int num = readInt(sc, "Enter My List number to remove >> ", 1, activeProfile.getMyList().size());
            boolean removed = activeProfile.removeFromMyList(num - 1);
            System.out.println(removed ? "Removed." : "Invalid choice.");
        }
    }

    private static void playTitle(Scanner sc) {
        if (activeProfile == null) {
            System.out.println("Select a profile first.");
            return;
        }

        catalog.browseNumbered();
        if (catalog.getItems().isEmpty()) return;

        int num = readInt(sc, "Enter catalog number to play >> ", 1, catalog.getItems().size());
        Media m = catalog.getByNumber(num);

        if (m instanceof Playable) {
            Playable p = (Playable) m;
            player.play(p, activeProfile);
        } else {
            System.out.println("That item is not playable.");
        }
    }

    private static int readInt(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(line);
                if (v < min || v > max) {
                    System.out.println("Enter " + min + " to " + max + ".");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }
}
