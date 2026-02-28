package com.gordon.learning.generic;

public class Manipulator<T extends HasF> {
    private T obj;
    public Manipulator(T x) {
        this.obj = x;
    }
    public void manipulate() {obj.f();}
}
