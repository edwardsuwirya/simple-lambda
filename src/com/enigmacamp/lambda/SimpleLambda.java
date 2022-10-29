package com.enigmacamp.lambda;

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
        Printable printable = (message) -> {
            System.out.println(message);
        };
        printable.print("Enigma");

        MesinHitung penjumlahan = (angka1, angka2) -> angka1 + angka2;
        int hasilPenjumlahan = penjumlahan.hitung(10, 3);
        printable.print(String.valueOf(hasilPenjumlahan));

        MesinHitung perkalian = (int1, int2) -> int1 * int2;
        int hasilPerkalian = perkalian.hitung(2, 3);
        printable.print(String.valueOf(hasilPerkalian));
    }
}
