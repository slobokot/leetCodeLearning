package com.slobokot.leetcodetestengine.parser;

import java.util.Iterator;

public class PeekingIterator<T> implements Iterator<T> {

    private final Iterator<T> it;
    private boolean hasNextWasPeeked;
    private boolean hasNextValue;
    private boolean nextWasPeeked;
    private T nextValue;

    public PeekingIterator(Iterator<T> it) {
        this.it = it;
    }

    @Override
    public boolean hasNext() {
        if (hasNextWasPeeked) {
            hasNextWasPeeked = false;
            return hasNextValue;
        }

        return it.hasNext();
    }

    @Override
    public T next() {
        if (nextWasPeeked) {
            nextWasPeeked = false;
            return nextValue;
        }

        return it.next();
    }

    public boolean canPeek() {
        if (hasNextWasPeeked) {
            return hasNextValue;
        }
        hasNextWasPeeked = true;
        hasNextValue = it.hasNext();
        return hasNextValue;
    }

    public T peek() {
        if (nextWasPeeked) {
            return nextValue;
        }
        nextWasPeeked = true;
        nextValue = it.next();
        return nextValue;
    }

    public Iterator<T> delegate() {
        return it;
    }

    @Override
    public String toString() {
        return "PeekingIterator{" +
                "it=" + it +
                '}';
    }
}
