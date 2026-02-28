package com.gordon.learning.coffeeshop;

import java.util.Iterator;
import java.util.Random;

public class Starbucks implements Generator<Coffee>, Iterable<Coffee> {

    private final Class[] types = {
        Americano.class, Cappuccino.class, Latte.class, Mocha.class
    };

    private static final Random random = new Random(47);

    public Starbucks() {}

    private int size = 0;

    public Starbucks(int size) {
        this.size = size;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[random.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count --;
            return Starbucks.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    public static void main(String[] args) {
        Starbucks starbucks = new Starbucks();
        for(int i = 0; i < 4; i++) {
            System.out.println(starbucks.next());
            for(Coffee coffee:new Starbucks(4)) {
                System.out.println(coffee);
            }
        }
    }
}
