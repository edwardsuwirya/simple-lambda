package com.enigmacamp.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
interface Printable {
    void print(String message);
}

@FunctionalInterface
interface MesinHitung {
    int hitung(int a, int b);
}

public class SimpleLambda {
    public static void main(String[] args) {
//        Printable printable = (message) -> {
//            System.out.println(message);
//        };
//        printable.print("Enigma");
//
//        MesinHitung penjumlahan = (angka1, angka2) -> angka1 + angka2;
//        int hasilPenjumlahan = penjumlahan.hitung(10, 3);
//        printable.print(String.valueOf(hasilPenjumlahan));
//
//        MesinHitung perkalian = (int1, int2) -> int1 * int2;
//        int hasilPerkalian = perkalian.hitung(2, 3);
//        printable.print(String.valueOf(hasilPerkalian));

        Predicate<String> isALongWord = w -> w.length() > 10;
        String word = "EnigmaCamp Ragunan";
        boolean result = isALongWord.test(word);
        System.out.println(result);

        Consumer<Student> updateName = c -> c.setName(c.getName().toUpperCase());
        Student student = new Student();
        student.setName("Fadli");
        updateName.accept(student);
        System.out.println(student);

        int n = 5;
        modifyValue(n, num -> num + 10);
    }

    static void modifyValue(int v, Function<Integer, Integer> function) {
        int result = function.apply(v);
        System.out.println(result);
    }
}
