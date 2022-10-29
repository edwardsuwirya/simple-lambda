package com.enigmacamp.lambda;

@FunctionalInterface
interface Sayable {
    String say();
}

public class MethodRef {
    public static void main(String[] args) {
        MethodRef ref = new MethodRef();
        Sayable sayable = ref::saySomething;
        String res = sayable.say();
        System.out.println(res);
    }

    public String saySomething() {
        return "Hello, enigma";
    }
}
