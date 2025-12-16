import java.util.Scanner;

public class Main {

    private static Catalog catalog = new Catalog();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        seedCatalog();

        do {
            System.out.println("=== StreamFlix ===");
            System.out.println("1) Select Profile");
            System.out.println("2) Browse Catalog");
            System.out.println("3) Search");
            System.out.println("0) Exit");

            choice = readInt(sc, "Choose >> ", 0, 3);

            if (choice == 1) {
                System.out.println("(Prototype) Profile selected.");
            } 

            else if (choice == 2) {
                catalog.browse();
            }

            System.out.println();
        } while (choice != 0);

        System.out.println("Goodbye!");
    }

    private static void seedCatalog() {
        catalog.add(new Movie("Halloween Remake", 2018, "Horror", 106));
        catalog.add(new Movie("Jaws", 1975, "Horrow", 125));
        catalog.add(new Series("Breaking Bad", 2008, "Crime Drama", 5));
        catalog.add(new Series("Jujutsu Kaisen", 2020, "Shonen Anime", 2));
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
