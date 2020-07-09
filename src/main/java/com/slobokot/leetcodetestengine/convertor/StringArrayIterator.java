package com.slobokot.leetcodetestengine.convertor;

import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.Iterator;

public class StringArrayIterator  implements Iterator<String> {
    Iterator<String> iterator;
    public StringArrayIterator(String s) {
        int i = s.indexOf("[");
        if (i < 0) throw new RuntimeException(s);
        i++;
        int e = s.indexOf("]", i);
        if (e < 0) throw new RuntimeException(s);
        String[] split = s.substring(i, e).split(",", 0);
        iterator = Arrays.stream(split).filter(StringUtils::isNotBlank).iterator();
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
