package io.piano.oop;
import java.util.Scanner;

public class Encapsulation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter x and y of point 1");
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        System.out.println("Enter x and y of point 2");
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();

        DistanceCalc calc = new DistanceCalc(x1,y1,x2,y2);
        System.out.println("Distance between points is: " + calc.getDistance());
    }
}
