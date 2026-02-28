package com.gordon.learning.generic;

public class GenericMethods {

    public <T> void toString(T t) {
        System.out.println(t.getClass().getName());
    }

    public static void main(String[] args) {

        GenericMethods gm = new GenericMethods();
        gm.toString("Gordon");
        gm.toString(1.1);
        gm.toString('c');
        gm.toString(4);
        gm.toString(1.7F);

    }

}
