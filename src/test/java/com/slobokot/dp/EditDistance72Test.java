package com.slobokot.dp;

import com.slobokot.leetcode.TestRunner;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

class EditDistance72Test {
    EditDistance72 x = new EditDistance72();

    @TestFactory
    public List<DynamicTest> leetCodeTests() throws Exception {
        return new TestRunner().runLeetCodeTests(x,
                "com/slobokot/dp/EditDistance72.txt");
    }

    @Test
    public void leetCodeTest1() throws Throwable {
        new TestRunner().runLeetCodeTest(x,
                "com/slobokot/dp/EditDistance72.txt", "test2");
    }
}