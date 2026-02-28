package com.gordon.learning;

public class Holder<T> {
    private T t;
    public Holder(T t) {
        this.t = t;
    }

    public Holder() {

    }

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        Holder<Automobile> holder = new Holder<Automobile>();

    }
}
