package com.modrons.util;

public class Tuple<T> {

    private final T x;
    private final T y;

    public Tuple(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }
}
