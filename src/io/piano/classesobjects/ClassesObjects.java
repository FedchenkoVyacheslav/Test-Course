package io.piano.classesobjects;

public class ClassesObjects {
    public static void main(String[] args) {
        MyName user = new MyName();
        String userName = user.askFullName();
        user.sayHello(userName);
    }
}
