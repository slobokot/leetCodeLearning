package com.slobokot.leetcodetestengine.assertion;

import org.junit.jupiter.api.Assertions;

public class LeetAssertions {
    public void assertEquals(Object expected, Object actual) {
        if (expected.getClass().isArray()) {
            if (expected.getClass().getComponentType() == int.class) {
                Assertions.assertArrayEquals((int[])expected, (int[])actual);
            } else if (expected.getClass().getComponentType() == boolean.class) {
                Assertions.assertArrayEquals((boolean[])expected, (boolean[])actual);
            } else {
                throw new RuntimeException("Arrays of " + expected.getClass().getComponentType() + " are not supported");
            }
        } else {
            System.out.println("Expected " + expected);
            Assertions.assertEquals(expected, actual);
        }
    }
}
