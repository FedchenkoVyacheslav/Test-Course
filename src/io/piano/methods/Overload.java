package io.piano.methods;
import java.util.*;

public class Overload {
    public static void main(String[] args) {
        List <String> allContinents = new ArrayList<>();
        String continent;

        while (true) {
            System.out.println("Please enter a continent. If you enter the same continent twice, the addition will stop");
            Scanner scan = new Scanner(System.in);
            continent = scan.nextLine();

            if (! allContinents.contains(continent)) {
                allContinents.add(continent);
                System.out.println(allContinents);
            }
            else {
                System.out.println("All continents you're added in alphabetical order: ");
                showAddedContinents (allContinents, continent);
                break;
            }
        }
    }

    static void showAddedContinents (List <String> x, String y) {
        Collections.sort (x);
        System.out.println (x);
    }

    static void showAddedContinents(List<String> x) {
        System.out.println(x);
    }
}
