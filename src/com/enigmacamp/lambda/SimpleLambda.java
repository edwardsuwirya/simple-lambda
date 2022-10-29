package com.enigmacamp.lambda;

interface Printable {
    void print(String message);
}

public class SimpleLambda {
    public static void main(String[] args) {
        Printable printable = new SimplePrint();
        printable.print("Enigma");
    }
}

class SimplePrint implements Printable {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
