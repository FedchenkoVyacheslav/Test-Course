package io.piano.statements;
import java.util.Scanner;

public class Switch {

    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
            if(scan.hasNextInt()){
                int number = scan.nextInt();
                switch (number) {
                    case 1:
                        System.out.println("There are " + days[0] +" days in " + months[0]);
                        break;
                    case 2:
                        System.out.println("There are " + days[1] +" days in " + months[1]);
                        break;
                    case 3:
                        System.out.println("There are " + days[2] +" days in " + months[2]);
                        break;
                    case 4:
                        System.out.println("There are " + days[3] +" days in " + months[3]);
                        break;
                    case 5:
                        System.out.println("There are " + days[4] +" days in " + months[4]);
                        break;
                    case 6:
                        System.out.println("There are " + days[5] +" days in " + months[5]);
                        break;
                    case 7:
                        System.out.println("There are " + days[6] +" days in " + months[6]);
                        break;
                    case 8:
                        System.out.println("There are " + days[7] +" days in " + months[7]);
                        break;
                    case 9:
                        System.out.println("There are " + days[8] +" days in " + months[8]);
                        break;
                    case 10:
                        System.out.println("There are " + days[9] +" days in " + months[9]);
                        break;
                    case 11:
                        System.out.println("There are " + days[10] +" days in " + months[10]);
                        break;
                    case 12:
                        System.out.println("There are " + days[11] +" days in " + months[11]);
                        break;
                    default:
                        System.out.println("Please enter a number from 1 to 12!");
                        break;
                }
            } else {
                System.out.println("Please enter a number!");
            }
        }

}
