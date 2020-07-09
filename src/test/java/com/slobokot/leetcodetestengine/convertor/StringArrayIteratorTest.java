package com.slobokot.leetcodetestengine.convertor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringArrayIteratorTest {

    @Test
    public void emptyArray() {
        StringArrayIterator it = new StringArrayIterator("[]");
        Assertions.assertFalse(it.hasNext());
    }

    @Test
    public void blankArray() {
        StringArrayIterator it = new StringArrayIterator("[  ]");
        Assertions.assertFalse(it.hasNext());
    }

    @Test
    public void oneElementArray() {
        StringArrayIterator it = new StringArrayIterator("[1]");
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals("1", it.next());
    }

    @Test
    public void oneElementWithWhitespaceArray() {
        StringArrayIterator it = new StringArrayIterator("[ 1 ]");
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals("1", it.next());
        Assertions.assertFalse(it.hasNext());
    }

    @Test
    public void twoElements() {
        StringArrayIterator it = new StringArrayIterator("[ 1 , 2 ]");
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals("1", it.next());
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals("2", it.next());
        Assertions.assertFalse(it.hasNext());
    }

    @Test
    public void twoElementsWithTrailingComma() {
        StringArrayIterator it = new StringArrayIterator("[ 1 , 2 , ]");
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals("1", it.next());
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals("2", it.next());
        Assertions.assertFalse(it.hasNext());
    }

}