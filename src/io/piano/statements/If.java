package io.piano.statements;
import java.util.Scanner;

public class If {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        if(scan.hasNextInt()){
            int number = scan.nextInt();
            if (number > 0 && number <= 12) {
                for (int i = 0; i < months.length; i++) {
                    if (number == i + 1)
                        System.out.println(months[i]);
                }
            } else {
            System.out.println("Please enter a number from 1 to 12!");
            }
        } else {
            System.out.println("Please enter a number!");
        }
    }
}
