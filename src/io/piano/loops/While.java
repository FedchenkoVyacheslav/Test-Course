package io.piano.loops;

public class While {
    public static void main(String[] args) {
        String[] num = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int i = 0;
        while (!(num[i].equals("five"))) {
            System.out.println("Ищу элемент five. Имя элемента - " + num[i] + ". Не совпадает.");
            i++;
        }
        System.out.println("Нашел");
    }
}
