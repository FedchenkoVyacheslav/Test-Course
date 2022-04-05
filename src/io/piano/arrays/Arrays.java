package io.piano.arrays;
import java.util.Collections;

public class Arrays {

    public static void main(String[] args) {
//        Task1
        Double[] numbers = {1.2, 3.6, 1.3, -5.5, 4.8, 8.1, 7.5, 6.5};
        for (int i=0; i<numbers.length; i++) {
            if(i == numbers.length - 1)
                System.out.print(numbers[i]);
            else
            System.out.print(numbers[i] + ", ");
        }
        System.out.println(" ");
        java.util.Arrays.sort(numbers);
        System.out.print(java.util.Arrays.toString(numbers));
        System.out.println(" ");
        java.util.Arrays.sort(numbers, Collections.reverseOrder());
        System.out.print(java.util.Arrays.toString(numbers));

        double min;
        double max;
        min = max = numbers[0];
        for (Double number : numbers) {
            if (min > number)
                min = number;
            if (max < number)
                max = number;
        }
        System.out.println(" ");
        System.out.println("Minimum is " + min);
        System.out.println("Maximum is " + max);
        //        Task2
        int[] numbers2 = {2,1,0,50,30,20,10};
        int[] numbers3 = {2,1,0,30,30,20,40};

        Boolean result = java.util.Arrays.equals(numbers2, numbers3);
        System.out.println(result);
        for (int a : numbers2) {
            for (int i : numbers3) {
                if (a == i) {
                    System.out.print(a + " ");
                    break;
                }
            }
        }
    }
}
