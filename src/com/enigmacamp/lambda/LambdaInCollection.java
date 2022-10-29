package com.enigmacamp.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LambdaInCollection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Fajri");
        list.add("Fadli");
        list.add("Agus");

        System.out.println("For Each");
        list.forEach(
                (nama) -> System.out.println(nama)
        );

        System.out.println("Sorting");
        list.sort((nama1, nama2) -> {
            return nama1.compareTo(nama2);
        });
        list.forEach(
                (nama) -> System.out.println(nama)
        );

        System.out.println("Filtering");
        Stream result = list.stream().filter((nama) -> nama.startsWith("A"));
        result.forEach(n -> System.out.println(n));
    }
}
