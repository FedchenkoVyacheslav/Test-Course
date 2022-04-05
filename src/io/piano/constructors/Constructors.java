package io.piano.constructors;
import java.util.Scanner;

public class Constructors {
    public static void main(String[] args) {
        System.out.println("What's your name?");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.println("What's your surname?");
        String surname = scan.nextLine();
        MyName user = new MyName(name, surname);
    }
}
