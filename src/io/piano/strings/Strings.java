package io.piano.strings;

public class Strings {

    public static void main(String[] args) {
        String string1 = " Добро%пожаловать%на%курс%автоматизации ";
        String string2 = new String("ДОБРО ПОЖАЛОВАТЬ НА КУРС АВТОМАТИЗАЦИИ ");
        String string3 = string1.replace('%', ' ').trim();
        String string4 = string2.trim();

        System.out.println(string3);
        System.out.println(string4);
        System.out.println(string3.equalsIgnoreCase(string4));
        System.out.println(string1.contains("Добро"));
        System.out.println(string2.contains("курс"));
        System.out.println(string2.contains("КУРС"));
    }
}
