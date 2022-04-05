package io.piano.loops;

import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String admin = "Bob";
        do {
            System.out.println("Please enter admin name");
        } while (!scan.nextLine().equalsIgnoreCase(admin));
        System.out.println("Correct. Admin name is " + admin);
    }
}
