package com.rui.test.Dynamicproxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理对象
 */
public class CalculatorInvocationHandler implements InvocationHandler {
    private Object calculator;

    public CalculatorInvocationHandler(Object calculator) {
        this.calculator = calculator;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---方法执行前---");
        Object result = method.invoke(calculator, args);
        System.out.println(result);
        System.out.println("---方法执行后---");
        return result;
    }
}
