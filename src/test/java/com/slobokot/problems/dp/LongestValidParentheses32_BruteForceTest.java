package com.slobokot.problems.dp;

import com.slobokot.leetcodetestengine.TestRunner;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

class LongestValidParentheses32_BruteForceTest {


    @TestFactory
    public List<DynamicTest> leetCodeTests() throws Exception {
        return new TestRunner().runLeetCodeTests(
                "com/slobokot/problems/dp/LongestValidParentheses32.txt");
    }

}