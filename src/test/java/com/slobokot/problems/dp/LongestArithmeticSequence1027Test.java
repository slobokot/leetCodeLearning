package com.slobokot.problems.dp;

import com.slobokot.leetcodetestengine.TestRunner;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

class LongestArithmeticSequence1027Test {

    LongestArithmeticSequence1027 x = new LongestArithmeticSequence1027();

    @TestFactory
    List<DynamicTest> leetCodeTests() throws Exception {
        return new TestRunner().runLeetCodeTests(
                        x,
                        "com/slobokot/problems/dp/LongestArithmeticSequence1027.txt");
    }
}