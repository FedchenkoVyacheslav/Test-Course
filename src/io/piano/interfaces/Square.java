package io.piano.interfaces;
import java.util.Scanner;

public class Square implements Shape {
    @Override
    public double calculateArea() {
        System.out.println("Enter the length of the side of the square");
        Scanner scan = new Scanner(System.in);
        float a = scan.nextInt();
        return Math.pow(a, 2);
    }
}
