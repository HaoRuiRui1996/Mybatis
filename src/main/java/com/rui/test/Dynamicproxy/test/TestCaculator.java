package com.rui.test.Dynamicproxy.test;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestCaculator {
    public static void main(String[] args) {
        Calculator simpleCalculator = new SimpleCalculator();
        InvocationHandler handler = new CalculatorInvocationHandler(simpleCalculator);
        Calculator calculator = (Calculator) Proxy.newProxyInstance(Calculator.class.getClassLoader(),
                SimpleCalculator.class.getInterfaces(), handler);
        calculator.sub(1, 2);
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", SimpleCalculator.class.getInterfaces());
        String path = "Q:/test/Calculator.class";
        try(FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (Exception e) {
            System.out.println("写文件错误");
        }
    }
}
