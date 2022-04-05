package io.piano.abstractclasses;

import java.util.Scanner;

public class Square extends Shape {
    @Override
    double calculateArea() {
        System.out.println("Enter the length of the side of the square");
        Scanner scan = new Scanner(System.in);
        float a = scan.nextInt();
        return Math.pow(a, 2);
    }
}
