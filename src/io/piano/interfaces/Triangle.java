package io.piano.interfaces;
import java.util.Scanner;

public class Triangle implements Shape {
    @Override
    public double calculateArea() {
        System.out.println("Enter the lengths of the sides of the triangle");
        Scanner scan = new Scanner(System.in);
        float a = scan.nextInt();
        float b = scan.nextInt();
        float c = scan.nextInt();
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
