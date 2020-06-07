package com.slobokot.leetcode.convertor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StringArrayIterator  implements Iterator<String> {
    Iterator<String> iterator;
    public StringArrayIterator(String s) {
        int i = s.indexOf("[");
        if (i < 0) throw new RuntimeException(s);
        i++;
        int e = s.indexOf("]", i);
        if (e < 0) throw new RuntimeException(s);
        String[] split = s.substring(i, e).split(",", -1);
        iterator = Arrays.asList(split).iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public String next() {
        return iterator.next().trim();
    }
}
