package com.slobokot.problems.dp;

import com.slobokot.leetcodetestengine.TestRunner;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

class LongestValidParentheses32_BruteForceTest {

    LongestValidParentheses32_BruteForce x = new LongestValidParentheses32_BruteForce();

    @TestFactory
    public List<DynamicTest> leetCodeTests() throws Exception {
        return new TestRunner().runLeetCodeTests(x,
                "com/slobokot/problems/dp/LongestValidParentheses32.txt");
    }

}