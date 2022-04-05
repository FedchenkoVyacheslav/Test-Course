package io.piano.interfaces;
import java.util.Scanner;

public class Rectangle implements Shape  {
    @Override
    public double calculateArea() {
        System.out.println("Enter the length and width of the rectangle");
        Scanner scan = new Scanner(System.in);
        float a = scan.nextInt();
        float b = scan.nextInt();
        return a*b;
    }
}
