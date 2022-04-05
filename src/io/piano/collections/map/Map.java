package io.piano.collections.map;

import java.util.*;

public class Map {
    public static void main(String[] args) {
        //        Task1
        java.util.Map<Integer, String> map = new HashMap<>();
        List<String> months =  new ArrayList<>(Arrays.asList("Январь","Февраль","Март","Апрель","Май","Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь"));
        for (int i=0; i<months.size(); i++) {
            map.put(i+1, months.get(i));
        }
        System.out.println(map);
        Set<Integer> keys = map.keySet();
        Iterator<Integer> iterator = keys.iterator();
        while (iterator.hasNext()) {
            for (int key:keys) {
                System.out.println(key + " " + map.get(iterator.next()));
            }
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Поиск по ключу. Введите число от 1 до 12");
        int number = scan.nextInt();
        System.out.println(map.get(number));
        //        Task2
        List<String> daysOfWeek = new ArrayList<>(Arrays.asList("Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"));
        List<String> seasons = new ArrayList<>(Arrays.asList("Зима", "Весна", "Лето", "Осень"));

        java.util.Map<String, List<String>>map2 = new HashMap<>();
        map2.put("Day of week", daysOfWeek);
        map2.put("Season", seasons);
        System.out.println("Keys: " + map2.keySet());
        System.out.println();
        Iterator<String> iteratorKeys = map2.keySet().iterator();
        while (iteratorKeys.hasNext()) {
            String key = iteratorKeys.next();
            Iterator<String> iteratorValues = map2.get(key).iterator();
            while (iteratorValues.hasNext()) {
                System.out.println(key + " " + iteratorValues.next());
            }
        }
    }
}
