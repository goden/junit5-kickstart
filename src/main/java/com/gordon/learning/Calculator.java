package com.gordon.learning;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int substract(int a, int b) {
        if (a >= b) {
            return a - b;
        }

        return b - a;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("");
        }

        return a / b;

    }


}
