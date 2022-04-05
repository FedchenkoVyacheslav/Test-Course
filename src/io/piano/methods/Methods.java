package io.piano.methods;
import java.util.Scanner;

public class Methods {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scan.nextLine();
        System.out.println("Enter the titles of your three favorite movies");
        String[] films = new String[3];
        for(int i=0; i<films.length; i++){
            films[i] = scan.nextLine();
        }
        usersFavoriteMovies(name, films[0], films[1], films[2]);
    }

    static void sayHello (String name) {
        System.out.println("Hello " + name);
    }

    static void movies (String film1, String film2, String film3) {
        System.out.println("Your favorite movies are: " + film1 + ", " + film2 + ", " + film3);
    }

    static void usersFavoriteMovies (String name, String film1, String film2, String film3) {
        sayHello(name);
        movies(film1, film2, film3);
    }
}
