import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=== StreamFlix ===");
            System.out.println("1) Select Profile");
            System.out.println("2) Browse Catalog");
            System.out.println("0) Exit");

            choice = readInt(sc, "Choose >> ", 0, 2);

            if (choice == 1) {
                System.out.println("(Prototype) Profile selected.");
            } else if (choice == 2) {
                System.out.println("(Prototype) Catalog list:");
                System.out.println("M1 - [Movie] Grover Returns (2020) - Comedy");
                System.out.println("S1 - [Series] Stack Adventures (2023) - Comedy");
            }

            System.out.println();
        } while (choice != 0);

        System.out.println("Goodbye!");
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
