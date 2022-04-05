package io.piano.collections.list;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class List {
    public static void main(String[] args) {
        java.util.List<String> list = new ArrayList<>(Arrays.asList("Слива", "Грецкий орех", "Инжир", "Груша", "Вишня", "Айва", "Абрикос", "Яблоня"));
        for (String element:list) {
            System.out.print(element + " ");
        }
        System.out.println();
        for(int index = 0; index<list.size(); index++){
            System.out.print(list.get(index) + " ");
        }
        System.out.println();
        System.out.println(list.stream().map(String::valueOf)
                .collect(Collectors.joining(" ")));
        System.out.println();
        System.out.println("Оригинальный массив - " + list);
        list.set(3, "Арбуз");
        System.out.println(list.contains("Арбуз")?"содержимое изменилось":"массив не изменился");
        System.out.println("Измененный массив - " + list);
        System.out.println("Размер списка до очистки - " + list.size());
        list.clear();
        System.out.println(list.isEmpty()?"массив очищен":"массив не пустой");
        System.out.println("Размер списка после очистки - " + list.size());
    }
}
