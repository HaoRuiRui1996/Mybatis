package com.rui.test.Dynamicproxy.test;

public class SimpleCalculator implements Calculator {
    @Override
    public int add(int a, int b) {
        System.out.println("a + b");
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("a - b");
        return a - b;
    }
}
