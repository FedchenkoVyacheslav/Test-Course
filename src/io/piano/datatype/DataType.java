package io.piano.datatype;

public class DataType {

    public static void main(String[] args) {
        String a = "123";
        byte b =  Byte.valueOf(a);
        short c =  Short.valueOf(a);
        int d =  Integer.valueOf(a);
        long e =  Long.valueOf(a);
        float f =  Float.valueOf(a);
        double g =  Double.valueOf(a);
        boolean h = Boolean.valueOf(a);

        int a1 = 123;
        double b1 = 123.2;
        long c1 = 123456789;
        float d1 = 123.0f;
        String e1 = String.valueOf(a1);
        String e2 = String.valueOf(b1);
        String e3 = String.valueOf(c1);
        String e4 = String.valueOf(d1);

        char a2 = 'a';
        char[] a3 = {'a', 'b', 'c'};
        String b2 = String.valueOf(a2);
        String b3 = String.valueOf(a3);
    }
}
