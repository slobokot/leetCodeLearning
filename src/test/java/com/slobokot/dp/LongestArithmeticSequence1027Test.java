package com.slobokot.dp;

import com.slobokot.JarResources;
import com.slobokot.leetcode.TestRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;

class LongestArithmeticSequence1027Test {

    LongestArithmeticSequence1027 x = new LongestArithmeticSequence1027();

    @TestFactory
    List<DynamicTest> leetCodeTests() throws Exception {
        return new TestRunner().runLeetCodeTests(
                        x,
                        "com/slobokot/dp/LongestArithmeticSequence1027.txt");
    }
}