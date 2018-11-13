package com.rui.test.Dynamicproxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestCaculator {
    public static void main(String[] args) {
        Calculator simpleCalculator = new SimpleCalculator();
        InvocationHandler handler = new CalculatorInvocationHandler(simpleCalculator);
        Calculator calculator = (Calculator) Proxy.newProxyInstance(Calculator.class.getClassLoader(),
                SimpleCalculator.class.getInterfaces(), handler);
        calculator.sub(1, 2);
    }
}
