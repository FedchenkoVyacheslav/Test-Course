package io.piano.collections.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Iterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Слива", "Грецкий орех", "Инжир", "Груша", "Вишня", "Айва", "Абрикос", "Яблоня"));
        java.util.Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }
}
