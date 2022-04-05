package io.piano.classesobjects;
import java.util.Scanner;

public class MyName {
    public String askFullName () {
        System.out.println("What's your name?");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.println("What's your surname?");
        String surname = scan.nextLine();
        String fullName = name + " " + surname;
        return fullName;
    }

    public void sayHello (String fullName) {
        System.out.println("Hello " + fullName);
    }
}
