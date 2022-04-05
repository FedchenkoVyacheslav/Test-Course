package io.piano.abstractclasses;

import java.util.Scanner;

public class Rectangle extends Shape{
    @Override
    double calculateArea() {
        System.out.println("Enter the length and width of the rectangle");
        Scanner scan = new Scanner(System.in);
        float a = scan.nextInt();
        float b = scan.nextInt();
        return a*b;
    }
}
