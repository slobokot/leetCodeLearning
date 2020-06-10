package com.slobokot.dp;

import com.slobokot.leetcode.TestRunner;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

class LongestValidParentheses32Test {
    LongestValidParentheses32 x = new LongestValidParentheses32();

    @TestFactory
    public List<DynamicTest> leetCodeTests() throws Exception {
        return new TestRunner().runLeetCodeTests(x,
                "com/slobokot/dp/LongestValidParentheses32.txt");
    }

    @Test
    public void leetCodeTests1() throws Throwable {
        new TestRunner().runLeetCodeTest(x,
                "com/slobokot/dp/LongestValidParentheses32.txt", "test2");
    }
}