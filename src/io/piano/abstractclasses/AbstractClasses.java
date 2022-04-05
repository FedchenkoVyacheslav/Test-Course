package io.piano.abstractclasses;
import java.io.IOException;
import java.util.Scanner;

public class AbstractClasses {
    public static void main(String[] args) throws IOException {
        String [] shapes = {"Square", "Triangle", "Rectangle"};
        System.out.println("Select the area of which figure you want to calculate");
        System.out.println("If it a Square enter: 1");
        System.out.println("If it a Triangle enter: 2");
        System.out.println("If it a Rectangle enter: 3");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        double result;
        switch (num) {
            case 1:
                Square square1 = new Square();
                result = square1.calculateArea();
                break;
            case 2:
               Triangle triangle1 = new Triangle();
               result = triangle1.calculateArea();
               break;
            case 3:
                Rectangle rectangle1 = new Rectangle();
                result = rectangle1.calculateArea();
                break;
            default:
                throw new IOException("Please enter a number from 1 to 3!");
        }
        System.out.println("The area of the " + shapes[num - 1] + " is: " + result);
    }
}
