package io.piano.collections.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Set {
    public static void main(String[] args) {
        List<String> original =  new ArrayList<>(Arrays.asList("Яблоко", "Апельсин", "Груша", "Мандарин", "Банан", "Яблоко", "Апельсин", "Груша", "Мандарин", "Банан"));
        java.util.Set<String> set = new HashSet<>(original);
        for (String fruit:set) {
            System.out.print(fruit + " ");
        }
        System.out.println();
        java.util.Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        if(set.size() < original.size()){
            System.out.println("В оригинальном списке были дубликаты");
        }
    }
}
